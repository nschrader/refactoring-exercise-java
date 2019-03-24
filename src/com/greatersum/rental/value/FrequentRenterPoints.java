package com.greatersum.rental.value;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class FrequentRenterPoints {
    private int value;

    public FrequentRenterPoints add(FrequentRenterPoints points) {
        return new FrequentRenterPoints(this.value + points.getValue());
    }
}
