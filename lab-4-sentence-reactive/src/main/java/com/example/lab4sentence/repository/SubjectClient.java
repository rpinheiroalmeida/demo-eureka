package com.example.lab4sentence.repository;

import com.example.lab4sentence.domain.Word;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("SUBJECT")
public interface SubjectClient {

    @GetMapping("/")
    Word getWord();
}
