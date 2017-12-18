package json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {

    ArrayList<JsonPair> jsonPairs = new ArrayList<>();

    public JsonObject(JsonPair... jsonPairs) {
        this.addAll(jsonPairs);
    }

    @Override
    public String toJson() {
        String res = "{";
        if (jsonPairs.size() == 0) {
            return "{}";
        }
        Iterator<JsonPair> iterator = jsonPairs.iterator();
        while (iterator.hasNext()) {
            JsonPair curPair = iterator.next();
            res += " '" + curPair.key + "': " + curPair.value.toJson();
            if (iterator.hasNext()) {
                res += ", ";
            }
        }
        return res + "}";
    }

    public void addAll(JsonPair... jsonPairs) {
        for (JsonPair jsonPair : jsonPairs) {
            if (!this.jsonPairs.contains(jsonPair)) {
                this.jsonPairs.add(jsonPair);
            }
        }
    }


    public void add(JsonPair jsonPair) {
        if (!this.jsonPairs.contains(jsonPair)) {
            this.jsonPairs.add(jsonPair);
        }
    }

    public Json find(String name) {
        for (JsonPair jsonPair : jsonPairs) {
            if (jsonPair.key.equals(name)) {
                return jsonPair.value;
            }
        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject jsonObject = new JsonObject();
        for (String name : names) {
            Iterator<JsonPair> iterator = jsonPairs.iterator();
            while(iterator.hasNext()) {
                JsonPair curPair = iterator.next();
                if(curPair.key.equals(name)) {
                    jsonObject.add(curPair);
                }
            }
        }
        return jsonObject;
    }
}
