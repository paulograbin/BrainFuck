package com.paulograbin.brainfuck;

import com.paulograbin.brainfuck.commands.BranchEndCommand;
import com.paulograbin.brainfuck.commands.Command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Program {

    private State state;
    private Parser parser;
    private String sourceCode;
    private int commandCounter;
    private List<Command> commands;

    public Program(String sourceCode) {
        this.sourceCode = sourceCode;

        this.state = new State();
        this.parser = new Parser();
    }

    private void execute() {
        commands = parser.parse(sourceCode);
        commandCounter = 0;

        while(commandCounter < commands.size()) {
            this.state = commands.get(commandCounter).execute(state);

            commandCounter += 1;
        }
    }

    private int fetchNextBranchEnd() {
        for(int i = commandCounter; i < commands.size(); i++) {
            if(commands.get(i).equals(new BranchEndCommand()))
                return i;
        }

        return 0;
    }

    public static void main(String... args) {
        String sourceCode = "++++";

        Program aSimpleProgram = new Program(sourceCode);

        aSimpleProgram.execute();
    }
}
