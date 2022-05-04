package GoRest;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GorestouterPojo {
           /*
    1)create private variable for every keys
    2) create constructor with all parameters without any parameters
    3) create getters and setters
    4)create toString() method
    5)@JsonIgnoreProperties(ignoreUnknown = true)

               {
                    "meta": null,
                    "data": {
                        "id": 13,
                        "name": "Archan Adiga II",
                        "email": "archan_adiga_ii@murray.org",
                        "gender": "male",
                        "status": "inactive"
                    }
                }

        */
    private Object meta;
    private GorestinnerPojo data;

    public GorestouterPojo(Object meta, GorestinnerPojo data) {
        this.meta = meta;
        this.data = data;
    }

    public GorestouterPojo() {
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public GorestinnerPojo getData() {
        return data;
    }

    public void setData(GorestinnerPojo data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GorestouterPojo{" +
                "meta=" + meta +
                ", data=" + data +
                '}';
    }
}
