package com.ust.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Book( long id, int stock) {
    public int getStock() {

        return this.stock;
    }

    public long getId() {

        return this.id;
    }
}
