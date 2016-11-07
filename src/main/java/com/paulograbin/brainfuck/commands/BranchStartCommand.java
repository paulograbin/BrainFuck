package com.paulograbin.brainfuck.commands;

import com.paulograbin.brainfuck.State;


public class BranchStartCommand implements Command {

    @Override
    public State execute(State programState) {
        System.out.println("branch start");

        if (programState.getCurrentValue() == 0)
            System.out.println("jump to next ]");
        else
            System.out.println("move forward");

        return programState;
    }
}
