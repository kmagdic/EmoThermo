package com.emothermo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmoRecordDaoSqlLite {
    private Connection conn;

    /*

    CREATE TABLE IF NOT EXISTS emo_record (id integer PRIMARY KEY AUTOINCREMENT,
    timestamp datetime,
    email text,
    emo1_joy integer,
    emo2_sad integer,
    emo3_anger integer,
    emo4_fear integer,
    desc text);

    */

    public void connectToDB(String fileName) {

        String sql = "CREATE TABLE IF NOT EXISTS emo_record (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + " timestamp datetime, \n"
                + "	email text,\n"
                + "	emo1_joy integer,\n"
                + "	emo2_sad integer,\n"
                + "	emo3_anger integer,\n"
                + "	emo4_fear integer,\n"
                + "	desc text,\n"
                + ");";

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + fileName);
            Statement stmt = conn.createStatement();
            // create a new table if it doesn't exist
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void insertToDB(EmoRecord emoRecord) {

        String sql = "INSERT INTO emo_record (timestamp, email, emo1_joy, emo2_sad, emo3_anger, emo4_fear, desc) VALUES(?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement s = conn.prepareStatement(sql)) {
            s.setDate(1, new Date(emoRecord.getTimestamp().getTime()));
            s.setString(2, emoRecord.getEmail());
            s.setInt(3, emoRecord.getEmo1());
            s.setInt(4, emoRecord.getEmo1());
            s.setInt(5, emoRecord.getEmo1());
            s.setInt(6, emoRecord.getEmo1());
            s.setString(7, emoRecord.getDescription());

            s.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<EmoRecord> getAll() {
        List<EmoRecord> students = new ArrayList<>();
        String sql = "SELECT * FROM student";

        try (Statement statement = conn.createStatement()) {


            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                EmoRecord s = new EmoRecord();
                s.setEmail(resultSet.getString("email"));
                s.setTimestamp(new java.util.Date(resultSet.getDate("timestamp").getTime()) );
                s.setEmo1(resultSet.getInt("emo1_joy"));
                s.setEmo2(resultSet.getInt("emo1_sad"));
                s.setEmo3(resultSet.getInt("emo1_anger"));
                s.setEmo4(resultSet.getInt("emo1_fear"));
                s.setDescription(resultSet.getString("description"));

                students.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return students;
    }


    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
