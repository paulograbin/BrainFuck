package com.paulograbin.brainfuck.commands;

import com.paulograbin.brainfuck.State;


public class DecrementByteCommand implements Command {

    @Override
    public State execute(State programState) {
        return programState.decrementCurrentValue();
    }
}
