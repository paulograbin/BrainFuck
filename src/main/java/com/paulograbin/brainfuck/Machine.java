package com.paulograbin.brainfuck;

import java.util.Scanner;


public class Machine {

    public static final char RIGHT = '>';
    public static final char LEFT = '<';
    public static final char PLUS = '+';
    public static final char MINUS = '-';
    public static final char OUTPUT = '.';
    public static final char INPUT = ',';
    public static final char BRANCH_START = '[';
    public static final char BRANCH_END = ']';


    private final byte[] memory;
    private int commandCounter;
    private int memoryPointer;

    public Machine() {
        this.memory = new byte[30000];
        this.memoryPointer = 0;
    }

    byte[] getMemory() {
        return memory;
    }

    int getMemoryPointer() {
        return memoryPointer;
    }

    void execute(Program program) {
        char currentCommand;

        String sourceCode = program.getSourceCode();

        while(commandCounter < sourceCode.length()) {
            currentCommand = sourceCode.charAt(commandCounter);

            switch (currentCommand) {
                case PLUS -> {
                    memory[memoryPointer]++;
                    commandCounter++;
                }
                case MINUS -> {
                    memory[memoryPointer]--;
                    commandCounter++;
                }
                case RIGHT -> {
                    memoryPointer += 1;
                    commandCounter++;
                }
                case LEFT -> {
                    memoryPointer -= 1;
                    commandCounter++;
                }
                case OUTPUT -> {
                    var currentValue = memory[memoryPointer];
                    program.appendToOutput(currentValue);
                    commandCounter++;
                }
                case INPUT -> {
                    Scanner s = new Scanner(System.in);
                    System.out.print("Input value: ");
                    String input = s.nextLine();
                    memory[memoryPointer] = input.getBytes()[0];
                }
                case BRANCH_START -> {
                    if (memory[memoryPointer] == 0) {
                        while (sourceCode.charAt(commandCounter) != ']') {
                            commandCounter += 1;
                        }
                    } else {
                        commandCounter++;
                    }
                }
                case BRANCH_END -> {
                    if (memory[memoryPointer] == 0) {
                        commandCounter++;
                    } else {
                        while (sourceCode.charAt(commandCounter) != '[') {
                            commandCounter -= 1;
                        }
                    }
                }
                default -> commandCounter++; //skips invalid chars
            }
        }
    }



    public static void main(String... args) {
        if (args.length == 0) {
            System.err.println("Usage: brainfuck <file.bf> or brainfuck -e '<code>'");
            System.exit(1);
        }

        String sourceCode;
        if (args[0].equals("-e") && args.length > 1) {
            sourceCode = args[1];
        } else {
            try {
                sourceCode = new String(java.nio.file.Files.readAllBytes(java.nio.file.Path.of(args[0])));
            } catch (java.io.IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
                System.exit(1);
                return;
            }
        }

        var p = new Program(sourceCode);
        var machine = new Machine();
        machine.execute(p);
        System.out.println(p.getOutput().toString());
    }
}
