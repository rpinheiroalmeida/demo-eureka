package com.example.lab4sentence.repository;

import com.example.lab4sentence.domain.Word;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("ADJECTIVE")
public interface AdjectiveClient {

    @GetMapping("/")
    Word getWord();

    static class HystrixClientFallback implements AdjectiveClient {

        @Override

        public Word getWord() {

            return new Word();

        }
    }
}
