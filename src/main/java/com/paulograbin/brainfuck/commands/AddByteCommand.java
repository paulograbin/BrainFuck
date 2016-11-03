package com.paulograbin.brainfuck.commands;

import com.paulograbin.brainfuck.State;

/**
 * Created by paulograbin on 03/11/16.
 */
public class AddByteCommand implements Command {

    @Override
    public State execute(State programState) {
        return programState.incrementCurrentValue();
    }
}
