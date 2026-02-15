package com.myPackage;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class OllamaController {

    private ChatClient chatClient;

//    public OllamaController(OllamaChatModel ollamaChatModel) {
//        this.chatClient = ChatClient.create(ollamaChatModel);
//    }

    //Use ChatClient.Builder for only one model of AI
    //Use Advisors to add memory to the chat client, so that it can remember the previous conversations and provide better responses
    ChatMemory chatMemory = MessageWindowChatMemory.builder().build();

    public OllamaController(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();
    }

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
}
