package com.example.lab4sentence.service;

import com.example.lab4sentence.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentenceServiceImpl implements SentenceService {

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
    public String buildSentence() {
        String sentence = "There was a problem assembling the sentence!";
        sentence =
                String.format("%s %s %s %s %s.",
                        subjectClient.getWord().getString(),
                        verbClient.getWord().getString(),
                        articleClient.getWord().getString(),
                        adjectiveClient.getWord().getString(),
                        nounClient.getWord().getString() );
        return sentence;
    }

}
