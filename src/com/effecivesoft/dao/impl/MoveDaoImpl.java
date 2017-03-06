package com.effecivesoft.dao.impl;

import com.effecivesoft.Util;
import com.effecivesoft.model.Move;
import com.effecivesoft.model.Point;
import com.effecivesoft.dao.MoveDao;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrei.tihomirov on 06.03.2017.
 */
public class MoveDaoImpl implements MoveDao {

    public static final String FILE_NAME = "input.txt";
    public static final String CHARSET_NAME = "UTF-8";
    public static final String STRING_PATTERN = "([a-zA-Z])([0-9])-([a-zA-Z])([0-9])";
    public static final int START_SYMBOL_INDEX = 0;
    public static final int START_NUMBER_INDEX = 1;
    public static final int END_SYMBOL_INDEX = 3;
    public static final int END_NUMBER_INDEX = 4;
    public static final String STATUS_YES = "YES";
    public static final String STATUS_NO = "NO";
    public static final String STATUS_ERROR = "ERROR";

    // cache
    private List<String> rawLines;

    @Override
    public List<Move> findAllMoves() throws IOException {
        List<Move> moves = new ArrayList<>();
        rawLines = extractRawLinesFromFile(FILE_NAME, CHARSET_NAME);

        if (!rawLines.isEmpty()) {
            Move move;
            for (String rawLine : rawLines) {
                move = convertRawLineToMove(rawLine);
                moves.add(move);
            }
        }

        return moves;
    }

    @Override
    public void sendMoveStatusesToOutput(List<Move> moves) {
        List<String> statuses = prepareStatuses(moves);
        //TODO: output data to out.txt
    }

    private List<String> prepareStatuses(List<Move> moves) {
        List<String> statuses = new ArrayList<>();
        for(Move move : moves) {
            if (move != null) {
                boolean isValidMove = Util.isValidMove(move);
                if (isValidMove) {
                    statuses.add(STATUS_YES);
                } else if (!isValidMove) {
                    statuses.add(STATUS_NO);
                }
            } else {
                statuses.add(STATUS_ERROR);
            }
        }
        return statuses;
    }

    private Move convertRawLineToMove(String rawLine) {
        Move move = null;

        if (rawLine.matches(STRING_PATTERN)) {
            Point startPoint = createPoint(rawLine, START_SYMBOL_INDEX, START_NUMBER_INDEX);
            Point endPoint = createPoint(rawLine, END_SYMBOL_INDEX, END_NUMBER_INDEX);
            move = new Move(startPoint, endPoint);
        }

        return move;
    }

    private Point createPoint(String rawLine, int symbolIndex, int numberIndex) {
        Point point = new Point();
        point.setSymbol(rawLine.charAt(symbolIndex));
        point.setNumber(Character.getNumericValue(rawLine.codePointAt(numberIndex)));
        return point;
    }

    private List<String> extractRawLinesFromFile(String fileName, String charsetName) throws IOException {
        if (rawLines == null) {
            rawLines = Files.readAllLines(Paths.get(fileName), Charset.forName(charsetName));
        }
        return rawLines;
    }
}
