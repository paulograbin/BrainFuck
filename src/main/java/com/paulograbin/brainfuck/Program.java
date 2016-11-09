package com.paulograbin.brainfuck;

import java.util.Scanner;


public class Program {

    public static final char RIGHT = '>';
    public static final char LEFT = '<';
    public static final char PLUS = '+';
    public static final char MINUS = '-';
    public static final char OUTPUT = '.';
    public static final char INPUT = ',';
    public static final char BRANCH_START = '[';
    public static final char BRANCH_END = ']';

    private String sourceCode;
    private int commandCounter;
    private int memoryPointer;
    private byte[] memory;

    public Program(String sourceCode) {
        this.memoryPointer = 0;
        this.memory = new byte[30000];

        this.sourceCode = sourceCode;
    }

    private void execute() {
        char currentCommand;

        while(commandCounter < sourceCode.length()) {
            currentCommand = sourceCode.charAt(commandCounter);

            if (currentCommand == PLUS) {
                memory[memoryPointer]++;
                commandCounter++;
            } else if (currentCommand == MINUS) {
                memory[memoryPointer]--;
                commandCounter++;
            } else if (currentCommand == RIGHT) {
                memoryPointer += 1;
                commandCounter++;
            }
            else if (currentCommand == LEFT) {
                memoryPointer -= 1;
                commandCounter++;
            }
            else if (currentCommand == OUTPUT) {
                byte currentValue[] = new byte[1];
                currentValue[0] = memory[memoryPointer];

                System.out.println("Output value: " + new String(currentValue));

                commandCounter++;
            }
            else if (currentCommand == INPUT) {
                Scanner s = new Scanner(System.in);
                System.out.print("Input value: ");
                String input = s.nextLine();

                memory[memoryPointer] = input.getBytes()[0];
            }
            else if (currentCommand == BRANCH_START) {
                if(memory[memoryPointer] == 0) {
                    while(sourceCode.charAt(commandCounter) != ']') {
                        commandCounter += 1;
                    }
                } else {
                    commandCounter++;
                }
            }
            else if (currentCommand == BRANCH_END) {
                if(memory[memoryPointer] == 0) {
                    commandCounter++;
                }
                else {
                    while(sourceCode.charAt(commandCounter) != '[') {
                        commandCounter -= 1;
                    }
                }
            }
        }

        System.out.println("Over!");
    }



    public static void main(String... args) {
        String sourceCode = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.";

        Program aSimpleProgram = new Program(sourceCode);

        aSimpleProgram.execute();
    }
}
