package com.emothermo;

import java.util.Date;

public class EmoRecord {
    private Date timestamp;
    String email;
    int emo1;
    int emo2;
    int emo3;
    int emo4;
    String description;

    public EmoRecord(Date timestamp, String email, int emo1, int emo2, int emo3, int emo4, String description) {
        this.timestamp = timestamp;
        this.email = email;
        this.emo1 = emo1;
        this.emo2 = emo2;
        this.emo3 = emo3;
        this.emo4 = emo4;
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmo1() {
        return emo1;
    }

    public void setEmo1(int emo1) {
        this.emo1 = emo1;
    }

    public int getEmo2() {
        return emo2;
    }

    public void setEmo2(int emo2) {
        this.emo2 = emo2;
    }

    public int getEmo3() {
        return emo3;
    }

    public void setEmo3(int emo3) {
        this.emo3 = emo3;
    }

    public int getEmo4() {
        return emo4;
    }

    public void setEmo4(int emo4) {
        this.emo4 = emo4;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "EmoRecord{" +
                "timestamp=" + timestamp +
                ", email='" + email + '\'' +
                ", emo1=" + emo1 +
                ", emo2=" + emo2 +
                ", emo3=" + emo3 +
                ", emo4=" + emo4 +
                ", description='" + description + '\'' +
                '}';
    }
}
