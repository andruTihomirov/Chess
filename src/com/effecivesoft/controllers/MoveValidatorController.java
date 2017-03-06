package com.effecivesoft.controllers;

import com.effecivesoft.model.Move;
import com.effecivesoft.services.MoveService;
import com.effecivesoft.services.impl.MoveServiceImpl;

import java.util.List;

/**
 * Created by andrei.tihomirov on 06.03.2017.
 */
public class MoveValidatorController {

    private MoveService moveService;

    public MoveValidatorController() {
        this.moveService = new MoveServiceImpl();
    }

    public void validateMoves() throws Exception {
        List<Move> moves = moveService.findAllMoves();
        moveService.sendMoveStatusesToOutput(moves);
    }

}
