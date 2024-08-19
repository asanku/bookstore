package com.ust.DTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

public record BookDto(

        Long id,

        @NotNull(message = "Title not empty")
        @Length(min = 1,max = 255)
        String title,

        @NotNull(message = "Name not empty")
        @Length(min = 1,max = 255)
        String author,

        @NotNull(message = "price not empty")
        @DecimalMin(value = "0.01", message = "value must be greater than 0")
        @Digits(integer = 10, fraction = 2)
        Float price,

        @NotNull(message = "stock not null")
        @Size(min = 1)
        int stock

        ) {
}
