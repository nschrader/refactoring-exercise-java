package com.greatersum.rental;

import com.greatersum.rental.data.Customer;
import com.greatersum.rental.value.Amount;
import com.greatersum.rental.value.FrequentRenterPoints;
import com.greatersum.rental.value.Title;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.LinkedHashMap;

@RequiredArgsConstructor
public class RentalRecords {
    @NonNull
    private Customer customer;

    private Amount amount = new Amount(0);
    private FrequentRenterPoints points = new FrequentRenterPoints(0);
    private HashMap<Title, Amount> records = new LinkedHashMap<>();

    private String header() {
        return "Rental Record for " + this.customer.getName() + "\n";
    }

    private String amount() {
        return "Amount owed is " + this.amount.getValue() + "\n";
    }

    private String frequentRenterPoints() {
        return "You earned " + this.points.getValue() + " frequent renter points\n";
    }

    private String movies() {
        StringBuilder b = new StringBuilder();
        this.records.entrySet().stream().forEach((e) -> {
            b.append("\t" + e.getKey() + "\t" + e.getValue() + "\n");
        });
        return b.toString();
    }

    public void addAmount(Amount more) {
        this.amount = this.amount.add(more);
    }

    public void addFrequentRenterPoints(FrequentRenterPoints more) {
        this.points = this.points.add(more);
    }

    public void addRecord(Title title, Amount amount) {
        records.put(title, amount);
    }

    @Override
    public String toString() {
        return header() + movies() + amount() + frequentRenterPoints();
    }
}
