package org.karane.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Item {
    @NotNull
    private Integer id;

    @NotBlank
    private String value;
    
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
}