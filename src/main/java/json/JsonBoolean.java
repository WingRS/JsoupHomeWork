package json;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */
public class JsonBoolean extends Json {

    private final boolean state;

    public JsonBoolean(Boolean bool) {
        this.state = bool;
    }

    @Override
    public String toString() {
        return String.valueOf(state);
    }


    @Override
    public String toJson() {
        return this.toString();
    }

    public static void main(String[] args) {
        JsonBoolean jsonBoolean = new JsonBoolean(true);
        System.out.printf(jsonBoolean.toJson());
    }
}
