package com.greatersum.rental.value;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Title {
    private String value;

    @Override
    public String toString() {
        return value;
    }
}
