package com.example.lab4sentence.service;

import com.example.lab4sentence.domain.Word;

public interface WordService {
    Word getSubject();

    Word getVerb();

    Word getArticle();

    Word getAdjective();

    Word getNoun();
}
