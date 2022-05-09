package GoRest;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GorestouterPojo {
     
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
