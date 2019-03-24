package com.greatersum.rental;

import com.greatersum.rental.data.Customer;
import com.greatersum.rental.data.Movie;
import com.greatersum.rental.data.MovieCode;
import com.greatersum.rental.data.MovieRental;
import com.greatersum.rental.value.Amount;
import com.greatersum.rental.value.Days;
import com.greatersum.rental.value.FrequentRenterPoints;

public class RentalInfo {

    private FrequentRenterPoints calculateFrequentRenterPoints(MovieCode code, Days days) {
        final double NEW_BONUS_DAYS = 2;
        boolean hasBonousPoints = (code == MovieCode.NEW && days.getValue() > NEW_BONUS_DAYS);
        return new FrequentRenterPoints(hasBonousPoints ? 2 : 1);
    }

    private Amount calculateRegularAmount(Days days) {
        final double REGULAR_PRICE = 2;
        final double REGULAR_DAY_PRICE = 1.5;
        final double REGULAR_FREE_DAYS = 2;
        if (days.getValue() > REGULAR_FREE_DAYS) {
            return new Amount((days.getValue() - REGULAR_FREE_DAYS) * REGULAR_DAY_PRICE + REGULAR_PRICE);
        } else {
            return new Amount(REGULAR_PRICE);
        }
    }

    private Amount calculateNewAmount(Days days) {
        final double NEW_DAY_PRICE = 3;
        return new Amount(days.getValue() * NEW_DAY_PRICE);
    }

    private Amount calculateChildrenAmount(Days days) {
        final double CHILDREN_PRICE = 1.5;
        final double CHILDREN_FREE_DAYS = 3;
        final double CHILDREN_DAY_PRICE = 1.5;
        if (days.getValue() > CHILDREN_FREE_DAYS) {
            return new Amount(CHILDREN_PRICE);
        } else {
            return new Amount((days.getValue() - CHILDREN_FREE_DAYS) * CHILDREN_DAY_PRICE + CHILDREN_PRICE);
        }
    }

    private Amount calculateAmount(MovieCode code, Days days) {
        switch (code) {
            case REGULAR:
                return calculateRegularAmount(days);
            case NEW:
                return calculateNewAmount(days);
            case CHILDREN:
                return calculateChildrenAmount(days);
            default:
                return null;
        }
    }

    public String statement(Customer customer) {
        RentalRecords records = new RentalRecords(customer);

        for (MovieRental r : customer.getRentals()) {
            Movie movie = r.getMovie();
            Days days = r.getDays();
            Amount amount = calculateAmount(movie.getCode(), days);
            FrequentRenterPoints points = calculateFrequentRenterPoints(movie.getCode(), days);
            records.addFrequentRenterPoints(points);
            records.addRecord(movie.getTitle(), amount);
            records.addAmount(amount);
        }

        return records.toString();
    }
}
