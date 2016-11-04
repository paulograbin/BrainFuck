package com.paulograbin.brainfuck.commands;

import com.paulograbin.brainfuck.State;


public class AddByteCommand implements Command {

    @Override
    public State execute(State programState) {
        return programState.incrementCurrentValue();
    }
}
