package com.paulograbin.brainfuck;

import java.util.Scanner;


public class Program {

    public static final char RIGHT = '>';
    public static final char LEFT = '<';
    public static final char PLUS = '+';
    public static final char MINUS = '-';

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

        for(commandCounter = 0; commandCounter < sourceCode.length(); commandCounter++) {
            currentCommand = sourceCode.charAt(commandCounter);
//            System.out.println("Char at " + commandCounter);

            if(currentCommand == PLUS)
                memory[memoryPointer]++;

            else if (currentCommand == MINUS)
                memory[memoryPointer]--;

            else  if (currentCommand == RIGHT)
                memoryPointer += 1;

            else if (currentCommand == LEFT)
                memoryPointer -= 1;

            else if (currentCommand == '.') {
                byte currentValue[] = new byte[1];
                currentValue[0] = memory[memoryPointer];

                System.out.println("Output value: " + new String(currentValue));
            }
            else if (currentCommand == ',') {
                Scanner s = new Scanner(System.in);
                System.out.print("Input value: ");
                String input = s.nextLine();

                memory[memoryPointer] = input.getBytes()[0];
            }
            else if (currentCommand == '[') {
                if(memory[memoryPointer] == 0) {
                    int localOffset = commandCounter;
                    while(sourceCode.charAt(localOffset) != ']') {
                        localOffset += 1;
                    }

                    commandCounter = commandCounter + (localOffset-1);
                } else {
                }
            }
            else if (currentCommand == ']') {
                if(memory[memoryPointer] == 0) {
                }
                else {
                    int localOffset = commandCounter;
                    while(sourceCode.charAt(localOffset) != '[') {
                        localOffset -= 1;
                    }

                    commandCounter = commandCounter - (localOffset-1);
                }
            }
        }
    }



    public static void main(String... args) {
        String sourceCode = ",>++[<----->-]<[----------------------.,----------],";

        Program aSimpleProgram = new Program(sourceCode);

        aSimpleProgram.execute();
    }
}
