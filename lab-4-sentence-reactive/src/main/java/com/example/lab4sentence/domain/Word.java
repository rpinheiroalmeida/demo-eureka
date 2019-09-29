package com.example.lab4sentence.domain;

public class Word {

    private String word;
    private Role role;

    public Word() {}

    public Word(String word, Role role) {
        this.word = word;
        this.role = role;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getString() {
        return word;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public static enum Role {
        subject, verb, article, adjective, noun;
    }
}
