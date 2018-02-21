package com.UGrow.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Todo {

    @Id
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String description;

}
