package com.paulograbin.brainfuck;

public class Program {

    private final String sourceCode;
    private StringBuilder output;

    public Program(String sourceCode) {
        this.sourceCode = sourceCode;
        this.output = new StringBuilder();
    }

    public void appendToOutput(byte b) {
        System.out.println("Appending " + b);
        output.append((char) b);
    }

    public StringBuilder getOutput() {
        return output;
    }

    public void setOutput(StringBuilder output) {
        this.output = output;
    }

    public String getSourceCode() {
        return sourceCode;
    }
}
