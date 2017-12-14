package gov.dvla.osl.Repository.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Driver extends Entity {

    private String name;

    public Driver() {
        this("Test");
    }

    public Driver(String name) {
        this.name = name;
    }


    @JsonProperty
    public String getName() {
        return name;
    }
}
