package com.example.lab4sentence.domain;

import java.util.Map;
import java.util.TreeMap;

public class Sentence {

    private Map<Word.Role, String> words = new TreeMap<>();

    public void addWord(Word word) {
        words.put(word.getRole(), word.getWord());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Word.Role role: words.keySet()){
            sb.append(words.get(role)).append(' ');
        }
        return sb.toString();
    }
}
