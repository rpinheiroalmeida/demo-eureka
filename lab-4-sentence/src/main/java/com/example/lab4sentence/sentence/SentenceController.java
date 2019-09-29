package com.example.lab4sentence.sentence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SentenceController {

    //	This is referencing the RestTemplate we defined earlier:
    @Autowired  RestTemplate template;

    @GetMapping("/sentence")
    public @ResponseBody String getSentence() {
        return
//                getWord("LAB-4-SUBJECT") + " "
//                        + getWord("LAB-4-VERB") + " "
//                        + getWord("LAB-4-ARTICLE") + " "
//                        + getWord("LAB-4-ADJECTIVE") + " "
//                        + getWord("LAB-4-NOUN") + "."

                    getWord("SUBJECT") + " "
                        + getWord("VERB") + " "
                        + getWord("ARTICLE") + " "
                        + getWord("ADJECTIVE") + " "
                        + getWord("NOUN") + "."
                ;
    }

    public String getWord(String service) {
        return template.getForObject("http://" + service, String.class);
    }
}
