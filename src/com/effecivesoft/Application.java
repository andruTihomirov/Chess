package com.effecivesoft;

import com.effecivesoft.controllers.MoveValidatorController;

public class Application {

    public static void main(String[] args) throws Exception {

        MoveValidatorController moveValidatorController = new MoveValidatorController();
        moveValidatorController.validateMoves();

    }


}
