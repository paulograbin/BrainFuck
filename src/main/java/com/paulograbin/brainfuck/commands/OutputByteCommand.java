package com.paulograbin.brainfuck.commands;

import com.paulograbin.brainfuck.State;


public class OutputByteCommand implements Command {

    @Override
    public State execute(State programState) {
        System.out.println(programState.getCurrentValue());

        return programState;
    }
}
