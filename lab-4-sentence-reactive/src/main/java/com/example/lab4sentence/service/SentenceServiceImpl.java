package com.example.lab4sentence.service;

import com.example.lab4sentence.domain.Sentence;
import com.example.lab4sentence.domain.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;
import java.util.concurrent.CountDownLatch;

@Service
public class SentenceServiceImpl implements SentenceService {

    @Autowired
    WordService wordService;

    @Override
    public String buildSentence() {
        Sentence sentence = new Sentence();

        //	Launch calls to all child services, using Observables
        //	to handle the responses from each one:
        Observable<Word>[] observables = createObservables();

        //	Use a CountDownLatch to detect when ALL of the calls are complete:
        CountDownLatch latch = new CountDownLatch(observables.length);

        //	Merge the 5 observables into one, so we can add a common subscriber:
        Observable.merge(observables)
                .subscribe(
                        //	(Lambda) When each service call is complete, contribute its word
                        //	to the sentence, and decrement the CountDownLatch:
                        (word) -> {
                            sentence.addWord(word);
                            latch.countDown();
                        });

        //	This code will wait until the LAST service call is complete:
        waitForAll(latch);

        return sentence.toString();
    }

    /**
     * Ultimately, we will need to wait for all 5 calls to
     * be completed before the sentence can be assembled.
     * This code waits for the last call to come back:
     */
    private void waitForAll(CountDownLatch latch) {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Observable<Word>[] createObservables() {
        return new Observable[]{
                wordService.getSubject(),
                wordService.getVerb(),
                wordService.getArticle(),
                wordService.getAdjective(),
                wordService.getNoun()
        };
    }

}
