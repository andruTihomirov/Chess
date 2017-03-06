package com.effecivesoft.services;

import com.effecivesoft.model.Move;

import java.util.List;

/**
 * Created by andrei.tihomirov on 06.03.2017.
 */
public interface MoveService {

    List<Move> findAllMoves() throws Exception;

    void sendMoveStatusesToOutput(List<Move> moves);
}
