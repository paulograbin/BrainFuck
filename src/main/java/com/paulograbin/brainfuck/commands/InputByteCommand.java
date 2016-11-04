package com.paulograbin.brainfuck.commands;

import com.paulograbin.brainfuck.State;
import java.util.Scanner;


public class InputByteCommand implements Command {

    @Override
    public State execute(State programState) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        byte scannedByte = input.getBytes()[0];

        System.out.println("Input " + input + " converted to " + scannedByte);
        return programState.setCurrentValue(scannedByte);
    }
}
