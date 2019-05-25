package com.doumiaotech.chapter5;

public class E21_PaperCurrencyTypesEnum {
    public static void main(String[] args) {
        for(PaperCurrencyTypes s : PaperCurrencyTypes.values())
            System.out.println(s + ", ordinal " + s.ordinal());
    }
}

enum PaperCurrencyTypes {
    ONE, TWO, FIVE, TEN, TWENTY, FIFTY
}
/* output
 * ONE, ordinal 0
 * TWO, ordinal 1
 * FIVE, ordinal 2
 * TEN, ordinal 3
 * TWENTY, ordinal 4
 * FIFTY, ordinal 5
 */