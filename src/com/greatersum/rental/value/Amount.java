package com.greatersum.rental.value;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

@Value
@AllArgsConstructor
public class Amount {
    private double value;

    public Amount add(Amount more) {
        return new Amount(this.value + more.getValue());
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
        DecimalFormat df = (DecimalFormat) nf;
        df.applyPattern("#.##");
        return df.format(this.value);
    }
}
