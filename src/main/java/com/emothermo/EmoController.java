package com.emothermo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
public class EmoController {

    @GetMapping("/emothermo/save_emo")
    String save (
            @RequestParam String email,
            @RequestParam int emo1,
            @RequestParam int emo2,
            @RequestParam int emo3,
            @RequestParam int emo4,
            @RequestParam String description,
            HttpServletResponse response) throws IOException {
        System.out.println("You entered:\nEmail: " + email + "\n" +
                "Emo1: " + emo1 + "\n" +
                "Emo2: " + emo2 + "\n" +
                "Emo3: " + emo3 + "\n" +
                "Emo4: " + emo4 + "\n" +
                "Description: " + description);

        EmoRecord record = new EmoRecord(new Date(), email, emo1, emo2, emo3, emo4, description);
        System.out.printf("Emo received: " + record);

        return "done";
    }


}
