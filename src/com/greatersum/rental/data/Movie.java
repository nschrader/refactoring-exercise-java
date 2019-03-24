package com.greatersum.rental.data;

import com.greatersum.rental.value.Title;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {
    private final Title title;
    private final MovieCode code;
}
