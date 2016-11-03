package com.paulograbin.brainfuck.commands;

import com.paulograbin.brainfuck.State;


public class DecrementPointerCommand implements Command {

    public State execute(State programState) {
        return programState.decrementPointer();
    }
}
