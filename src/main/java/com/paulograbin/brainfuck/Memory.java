package com.paulograbin.brainfuck;


import java.util.ArrayList;
import java.util.List;

public class Memory {

    private byte[] mem;


    public Memory() {
        mem = new byte[30000];
    }

    public Byte getByteAt(int index) {
        return mem[index];
    }

    public void setByteAt(int index, byte value) {
        mem[index] = value;
    }
}