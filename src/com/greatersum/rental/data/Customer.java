package com.greatersum.rental.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Customer {
    private final String name;
    private final List<MovieRental> rentals;
}
