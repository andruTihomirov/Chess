package com.effecivesoft.dao;

import com.effecivesoft.model.Move;

import java.io.IOException;
import java.util.List;

/**
 * Created by andrei.tihomirov on 06.03.2017.
 */
public interface MoveDao {

    List<Move> findAllMoves() throws IOException;

    void sendMoveStatusesToOutput(List<Move> moves);

}
