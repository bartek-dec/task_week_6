package com.example.mail.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class Movie {

    private Long id;

    @NotBlank
    @Size(min = 2)
    private String name;

    @NotNull
    @Past
    private LocalDate productionDate;

    public Movie() {
    }

    public Movie(Long id, String name, LocalDate productionDate) {
        this.id = id;
        this.name = name;
        this.productionDate = productionDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }
}
