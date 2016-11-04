package com.paulograbin.brainfuck;

import com.paulograbin.brainfuck.commands.Command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


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
        List<Command> commands = new ArrayList(parser.parse(sourceCode));

        Iterator<Command> i = commands.iterator();
        while(i.hasNext())
            i.next().execute(state);
    }

    public static void main(String... args) {
        String sourceCode = ",";

        Program aSimpleProgram = new Program(sourceCode);

        aSimpleProgram.execute();
    }


}
