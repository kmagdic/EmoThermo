package com.emothermo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class EmoController {
    List<EmoRecord> emoRecordList = new ArrayList<EmoRecord>();

    @Autowired
    EmoRecordDaoSqlLite emoRecordDaoSqlLite;

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
                "Radost: " + emo1 + "\n" +
                "Tuga: " + emo2 + "\n" +
                "Ljutnja: " + emo3 + "\n" +
                "Strah: " + emo4 + "\n" +
                "Description: " + description);

        EmoRecord record = new EmoRecord(new Date(), email, emo1, emo2, emo3, emo4, description);
        System.out.printf("Emo received: " + record);
        emoRecordDaoSqlLite.insertToDB(record);


        return "done";
    }


}
