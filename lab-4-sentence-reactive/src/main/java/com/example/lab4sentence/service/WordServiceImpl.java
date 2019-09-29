package com.example.lab4sentence.service;

import com.example.lab4sentence.domain.Word;
import com.example.lab4sentence.repository.*;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.Executor;

@Service
public class WordServiceImpl implements WordService {

    @Autowired AdjectiveClient adjectiveClient;
    @Autowired ArticleClient articleClient;
    @Autowired NounClient nounClient;
    @Autowired SubjectClient subjectClient;
    @Autowired VerbClient verbClient;

    @Autowired Executor executor;	//	Source of threads


    @Override
    @HystrixCommand(fallbackMethod = "getFallbackSubject")
    public Observable<Word> getSubject() {
        //	This 'reactive' observable is backed by a regular Java Callable, which can run in a different thread:
        return Observable.fromCallable(
                () -> new Word(subjectClient.getWord().getWord(), Word.Role.subject)
        ).subscribeOn(Schedulers.from(executor));
    }

    public Word getFallbackSubject() {
        return new Word("Someone", Word.Role.subject);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getVerbFallback")
    public Observable<Word> getVerb() {
        return Observable.fromCallable(
                () -> new Word(verbClient.getWord().getWord(), Word.Role.verb)
        ).subscribeOn(Schedulers.from(executor));
    }

    public Word getVerbFallback() {
        return new Word("does", Word.Role.verb);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getFallbackArticle")
    public Observable<Word> getArticle() {
        return Observable.fromCallable(
                () -> new Word(articleClient.getWord().getWord(), Word.Role.article)
        ).subscribeOn(Schedulers.from(executor));
    }

    public Word getFallbackArticle() {
        return new Word("", Word.Role.article);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getFallbackAdjective")
    public Observable<Word> getAdjective() {
        return Observable.fromCallable(
                () -> new Word(adjectiveClient.getWord().getWord(), Word.Role.article)
        ).subscribeOn(Schedulers.from(executor));
    }

    public Word getFallbackAdjective() {
        return new Word("-", Word.Role.adjective);

    }

    @Override
    @HystrixCommand(fallbackMethod = "getFallbackNoun")
    public Observable<Word> getNoun() {
        return Observable.fromCallable(
                () -> new Word(nounClient.getWord().getWord(), Word.Role.noun)
        ).subscribeOn(Schedulers.from(executor));
    }

    public Word getFallbackNoun() {
        return new Word("something", Word.Role.noun);
    }
}
