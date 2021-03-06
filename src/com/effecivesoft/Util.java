package com.effecivesoft;

import com.effecivesoft.model.Move;

/**
 * Created by andrei.tihomirov on 03.03.2017.
 */
public class Util {

    public static final char MIN_CHESSBOARD_SYMBOL = 'A';
    public static final char MAX_CHESSBOARD_SYMBOL = 'H';
    public static final int MIN_CHESSBOARD_NUMBER = 1;
    public static final int MAX_CHESSBOARD_NUMBER = 8;

    private Util() {}

    public static boolean isValidMove(Move move) {
        char[] symbols = {move.getStartPoint().getSymbol(), move.getEndPoint().getSymbol()};
        int[] numbers = {move.getStartPoint().getNumber(), move.getEndPoint().getNumber()};

        boolean isOutsideChessboard = isOutsideChessboard(symbols, numbers);
        if(!isOutsideChessboard) {
            return false;
        }

        int symbolsDiff = Math.abs(symbols[0] - symbols[1]);
        int numbersDiff = Math.abs(numbers[0] - numbers[1]);

        if(isAllowableDistance(symbolsDiff, numbersDiff)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isAllowableDistance(int symbolsDiff, int numbersDiff) {
        if((symbolsDiff == 1 && numbersDiff == 2) || (symbolsDiff == 1 && numbersDiff == 2)) {
            return true;
        }
        return false;
    }

    private static boolean isOutsideChessboard(char[] symbols, int[] numbers) {
        boolean isSymbolsChessboard = isSymbolsChessboard(symbols);
        boolean isNumbersChessboard = isNumbersChessboard(numbers);

        if(isSymbolsChessboard && isNumbersChessboard) {
            return true;
        }

        return false;
    }

    private static boolean isNumbersChessboard(int[] numbers) {
        for(int i = 0; i < numbers.length; i++) {
            if((numbers[i] < MIN_CHESSBOARD_NUMBER) || (numbers[i] > MAX_CHESSBOARD_NUMBER)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSymbolsChessboard(char[] symbols) {
        for(int i = 0; i < symbols.length; i++) {
            if((symbols[i] < MIN_CHESSBOARD_SYMBOL) || (symbols[i] > MAX_CHESSBOARD_SYMBOL)) {
                return false;
            }
        }
        return true;
    }

}
