package com.effecivesoft.services.impl;

import com.effecivesoft.dao.impl.MoveDaoImpl;
import com.effecivesoft.model.Move;
import com.effecivesoft.dao.MoveDao;
import com.effecivesoft.services.MoveService;

import java.io.IOException;
import java.util.List;

/**
 * Created by andrei.tihomirov on 06.03.2017.
 */
public class MoveServiceImpl implements MoveService {

    private MoveDao moveDao;

    public MoveServiceImpl() {
        this.moveDao = new MoveDaoImpl();
    }

    @Override
    public List<Move> findAllMoves() throws IOException {
        return moveDao.findAllMoves();
    }

    @Override
    public void sendMoveStatusesToOutput(List<Move> moves) {
        moveDao.sendMoveStatusesToOutput(moves);
    }
}
