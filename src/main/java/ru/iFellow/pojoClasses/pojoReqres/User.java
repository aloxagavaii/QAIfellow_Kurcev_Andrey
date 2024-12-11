package ru.iFellow.pojoClasses.pojoReqres;

import lombok.Data;

@Data
public class User {
    private String name;
    private String job;

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
