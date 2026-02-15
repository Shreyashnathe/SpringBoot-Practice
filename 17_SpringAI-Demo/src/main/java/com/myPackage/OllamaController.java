package com.myPackage;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class OllamaController {

    @Autowired
    private EmbeddingModel embeddingModel;

    private ChatClient chatClient;

    public OllamaController(OllamaChatModel ollamaChatModel) {
        this.chatClient = ChatClient.create(ollamaChatModel);
    }

    //Use ChatClient.Builder for only one model of AI
    //Use Advisors to add memory to the chat client, so that it can remember the previous conversations and provide better responses
//    ChatMemory chatMemory = MessageWindowChatMemory.builder().build();
//
//    public OllamaController(ChatClient.Builder builder) {
//        this.chatClient = builder
//                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
//                .build();
//    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello Ollama";
    }

//    ==============================================================================

//    @GetMapping("/ollama/{prompt}")
//    public ResponseEntity<String> getResponseFromOllama(@PathVariable String prompt){
//        // Here you would implement the logic to call the Ollama API with the given prompt
//        // and return the response. This is just a placeholder implementation.
//        String response = chatClient
//                .prompt(prompt)
//                .call()
//                .content();
//        return ResponseEntity.ok(response);
//    }

//    =============================================================================

    //Using ChatResponse to get more details about the response from Ollama
    @GetMapping("/ollama/{prompt}")
    public ResponseEntity<String> getResponseFromOllama(@PathVariable String prompt){
        ChatResponse chatResponse = chatClient
                .prompt(prompt)
                .call()
                .chatResponse();

        System.out.println(chatResponse.getMetadata().getModel());

        String response = chatResponse
                .getResult()
                .getOutput()
                .getText();

        return ResponseEntity.ok(response);
    }

    //Create an Template for the Movie Prompt
    @PostMapping("/api/recommend")
    public String recommend(@RequestParam String type, @RequestParam String year, @RequestParam String lang){
        String temp = """
                    I want to watch a {type} movie tonight with good rating.
                    Looking for movie around this year {year}.
                    The Language im looking for is {lang}.
                    Suggest one specific movie and tell me the cast and length of the movie.
                    
                    response format should be:
                    Movie Name:
                    Basic plot: 
                    Cast:
                    Length (in Minutes):
                    IMDB Rating:
                 """;

        PromptTemplate promptTemplate = new PromptTemplate(temp);

        Prompt prompt = promptTemplate.create(Map.of(
                "type", type,
                "year", year,
                "lang", lang
        ));

        String response = chatClient
                .prompt(prompt)
                .call()
                .content();

        return response;
    }

    //Create Embeddings for an text using the embedding model, which can be used for various applications like text similarity, clustering, etc.
    @PostMapping("/api/embedding")
    public float[] createEmbedding(@RequestParam String text){
        return embeddingModel.embed(text);
    }

    //check the similarity between two texts using the embedding model
    @PostMapping("/api/similarity")
    public double checkSimilarity(@RequestParam String text1, @RequestParam String text2) {
        float[] embedding1 = embeddingModel.embed(text1);
        float[] embedding2 = embeddingModel.embed(text2);

        // Calculate cosine similarity
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        for (int i = 0; i < embedding1.length; i++) {
            dotProduct += embedding1[i] * embedding2[i];
            normA += Math.pow(embedding1[i], 2);
            normB += Math.pow(embedding2[i], 2);
        }
        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }


    //Search Products using AI from the database ie our txt file product_details in the resources folder
    @PostMapping("/api/product")
    public String getProducts(@RequestParam String text){


        return "";
    }
}
