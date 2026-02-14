package com.myPackage;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OllamaController {

    private OllamaChatModel ollamaChatModel;

    public OllamaController(OllamaChatModel ollamaChatModel) {
        this.ollamaChatModel = ollamaChatModel;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello Ollama";
    }

    @GetMapping("/ollama/{prompt}")
    public String getResponseFromOllama(@PathVariable String prompt){
        // Here you would implement the logic to call the Ollama API with the given prompt
        // and return the response. This is just a placeholder implementation.
        String response = ollamaChatModel.call(prompt);
        return response;
    }
}
