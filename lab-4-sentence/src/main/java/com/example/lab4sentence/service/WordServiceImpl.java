package com.example.lab4sentence.service;

import com.example.lab4sentence.domain.Word;
import com.example.lab4sentence.repository.*;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl implements WordService {

    @Autowired
    AdjectiveClient adjectiveClient;
    @Autowired
    ArticleClient articleClient;
    @Autowired
    NounClient nounClient;
    @Autowired
    SubjectClient subjectClient;
    @Autowired
    VerbClient verbClient;

    @Override
    @HystrixCommand(fallbackMethod = "getFallbackSubject")
    public Word getSubject() {
        return subjectClient.getWord();
    }

    public Word getFallbackSubject() {
        return new Word("-");
    }

    @Override
    @HystrixCommand(fallbackMethod = "getVerbFallback")
    public Word getVerb() {
        return verbClient.getWord();
    }

    public Word getVerbFallback() {
        return new Word("-");
    }

    @Override
    @HystrixCommand(fallbackMethod = "getFallbackArticle")
    public Word getArticle() {
        return articleClient.getWord();
    }

    public Word getFallbackArticle() {
        return new Word("-");
    }

    @Override
    @HystrixCommand(fallbackMethod = "getFallbackAdjective")
    public Word getAdjective() {
        return adjectiveClient.getWord();
    }

    public Word getFallbackAdjective() {
        return new Word("-");
    }

    @Override
    @HystrixCommand(fallbackMethod = "getFallbackNoun")
    public Word getNoun() {
        return nounClient.getWord();
    }

    public Word getFallbackNoun() {
        return new Word("-");
    }
}
