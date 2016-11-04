package com.paulograbin.brainfuck.commands;

import com.paulograbin.brainfuck.State;
import java.util.Scanner;


public class InputByteCommand implements Command {

    @Override
    public State execute(State programState) {
        Scanner s = new Scanner(System.in);
        byte scannerByte = s.nextLine().getBytes()[0];

        return programState.setCurrentValue(scannerByte);
    }
}
