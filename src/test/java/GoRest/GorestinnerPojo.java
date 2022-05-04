package GoRest;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GorestinnerPojo {
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

    private Integer id ;
    private String name;
    private String email;
    private String gender;
    private String status;

    public GorestinnerPojo(Integer id, String name, String email, String gender, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }

    public GorestinnerPojo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GorestinnerPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
