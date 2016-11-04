package com.paulograbin.brainfuck.commands;

import com.paulograbin.brainfuck.State;


public class OutputByteCommand implements Command {

    @Override
    public State execute(State programState) {
        byte currentValue[] = new byte[1];
        currentValue[0] = programState.getCurrentValue();
        String convertedOutput = new String(currentValue);

        System.out.println("Output value " + currentValue[0] + " converted to " + convertedOutput);

        System.out.println(convertedOutput);

        return programState;
    }
}
