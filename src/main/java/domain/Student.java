package domain;

import json.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {


    private Tuple<String, Integer>[] examList;


    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name,surname,year);
        examList = exams;
    }

    public JsonObject toJsonObject() {
        JsonPair name = new JsonPair("name", new JsonString(this.name));
        JsonPair surname = new JsonPair("surname", new JsonString(this.surname));
        JsonPair year = new JsonPair("year", new JsonNumber(this.year));
        JsonObject[] exams = new JsonObject[this.examList.length];

        for (int i = 0; i < exams.length; i++) {
            exams[i] = new JsonObject(new JsonPair(examList[i].key, new JsonNumber(examList[i].value)));
        }

        return new JsonObject(name,surname,year, new JsonPair("exams", new JsonArray(exams)));
    }
}
