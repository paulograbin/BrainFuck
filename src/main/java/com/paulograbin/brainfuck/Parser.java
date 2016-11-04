package com.paulograbin.brainfuck;

import com.paulograbin.brainfuck.commands.*;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;


public class Parser {

    public List<Command> parse(String sourceCode) {
        ArrayList<Command> commands = new ArrayList<Command>();

        for(Character c : sourceCode.toCharArray()) {
            if(c == '>')
                commands.add(new IncrementPointerCommand());
            else if(c == '<')
                commands.add(new DecrementPointerCommand());
            else if(c == '+')
                commands.add(new AddByteCommand());
            else if(c == '-')
                commands.add(new DecrementByteCommand());
            else if(c == '.')
                commands.add(new OutputByteCommand());
            else if(c == ',')
                commands.add(new InputByteCommand());
            else
                throw new InvalidParameterException("Invalid command");
        }

        return commands;
    }

}
