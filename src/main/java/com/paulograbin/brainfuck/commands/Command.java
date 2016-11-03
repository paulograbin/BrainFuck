package com.paulograbin.brainfuck.commands;


import com.paulograbin.brainfuck.State;

public interface Command {

    State execute(State programState);

}
