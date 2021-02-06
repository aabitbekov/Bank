package com.example.demo.utils;


import com.example.demo.enums.Currency;
import static com.example.demo.enums.Currency.*;

public class CurrencyUtils {

    public static Currency convertStringToCurrency (String currency) {
        switch (currency.toLowerCase()) {
            case "euro":
                return EURO;
            case "dollars":
                return DOLLAR;
            default:
                return KZT;

        }
    }
}
