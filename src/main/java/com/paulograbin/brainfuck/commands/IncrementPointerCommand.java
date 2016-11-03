package com.paulograbin.brainfuck.commands;

import com.paulograbin.brainfuck.State;


public class IncrementPointerCommand implements Command {

    public State execute(State programState) {
        return programState.incrementPointer();
    }
}
