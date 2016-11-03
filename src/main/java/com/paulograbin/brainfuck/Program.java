package com.paulograbin.brainfuck;

import com.paulograbin.brainfuck.commands.Command;

import java.util.ArrayList;


public class Program {

    private State state;
    private Parser parser;
    private String sourceCode;

    public Program(String sourceCode) {
        this.sourceCode = sourceCode;

        this.state = new State();
        this.parser = new Parser();
    }

    private void execute() {
        ArrayList<Command> commands = new ArrayList(parser.parse(sourceCode));

        for(Command c : commands) {
            state = c.execute(state);
        }
    }

    public static void main(String... args) {
        String sourceCode = "+";

        Program aSimpleProgram = new Program(sourceCode);

        aSimpleProgram.execute();
    }


}
