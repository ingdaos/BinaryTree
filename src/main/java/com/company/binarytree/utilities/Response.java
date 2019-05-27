package com.company.binarytree.utilities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

/**
 *
 * @author PERSONAL
 */
public class Response {

    private final String ERROR_MESSAGE = "errorMessage";

    private Map<String, Object> data;
    private Map<String, String> error;

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Map<String, String> getError() {
        return error;
    }

    public void setError(Map<String, String> error) {
        this.error = error;
    }

    @JsonIgnore
    public String getErrorMessage() {
        return this.error.get(ERROR_MESSAGE);
    }

    @JsonIgnore
    public void setErrorMessage(String errorMessage) {
        this.error.put(ERROR_MESSAGE, errorMessage);
    }

    @Override
    public String toString() {
        String json = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(this);
        } catch (JsonProcessingException ex) {
            System.err.println(ex.toString());
        }
        return json;
    }

}
