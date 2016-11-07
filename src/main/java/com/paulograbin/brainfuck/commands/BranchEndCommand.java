package com.paulograbin.brainfuck.commands;

import com.paulograbin.brainfuck.State;


public class BranchEndCommand implements Command {

    @Override
    public State execute(State programState) {
        System.out.println("branch end");

        if (programState.getCurrentValue() == 0)
            System.out.println("move forward");
        else
            System.out.println("jump back");

        return programState;
    }
}
