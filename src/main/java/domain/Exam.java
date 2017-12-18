package domain;

import json.*;

/**
 * Created by StasMaster on 18.12.17.
 */
public class Exam extends Json {

    private String course;
    private int mark;
    private boolean passed;

    public Exam(Tuple<String, Integer> exam) {
        this.course = exam.key;
        this.mark = exam.value;
        this.passed = false;
        if( this.mark > 2 ) {
            this.passed = true;
        }
    }


    @Override
    public String toJson() {
        JsonPair course = new JsonPair("course", new JsonString(this.course));
        JsonPair mark = new JsonPair("mark", new JsonNumber(this.mark));
        JsonPair passed = new JsonPair("passed", new JsonBoolean(this.passed));
        return new JsonObject(course,mark, passed).toJson();
    }


}
