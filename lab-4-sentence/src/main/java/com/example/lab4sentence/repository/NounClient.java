package com.example.lab4sentence.repository;

import com.example.lab4sentence.domain.Word;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("NOUN")
public interface NounClient {

    @GetMapping("/")
    Word getWord();
}
