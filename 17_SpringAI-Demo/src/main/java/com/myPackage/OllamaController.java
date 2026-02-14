package com.myPackage;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OllamaController {

    private ChatClient chatClient;

    public OllamaController(OllamaChatModel ollamaChatModel) {
        this.chatClient = ChatClient.create(ollamaChatModel);
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello Ollama";
    }

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
}
