package com.paulograbin.brainfuck;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MachineTest {

    private String run(String sourceCode) {
        var machine = new Machine();
        var program = new Program(sourceCode);
        machine.execute(program);
        return program.getOutput().toString();
    }

    private Machine runAndGetMachine(String sourceCode) {
        var machine = new Machine();
        var program = new Program(sourceCode);
        machine.execute(program);
        return machine;
    }

    @Test
    void increment() {
        var machine = runAndGetMachine("+++");
        assertEquals(3, machine.getMemory()[0]);
    }

    @Test
    void decrement() {
        var machine = runAndGetMachine("+++--");
        assertEquals(1, machine.getMemory()[0]);
    }

    @Test
    void moveRight() {
        var machine = runAndGetMachine("+>++");
        assertEquals(1, machine.getMemory()[0]);
        assertEquals(2, machine.getMemory()[1]);
        assertEquals(1, machine.getMemoryPointer());
    }

    @Test
    void moveLeft() {
        var machine = runAndGetMachine("+>++<");
        assertEquals(0, machine.getMemoryPointer());
        assertEquals(1, machine.getMemory()[0]);
    }

    @Test
    void output() {
        // 'A' is ASCII 65 = 60 + 5
        String result = run("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.");
        assertEquals("B", result);
    }

    @Test
    void simpleLoop() {
        // Cell 0 = 3, then loop: move value from cell 0 to cell 1
        var machine = runAndGetMachine("+++[>+<-]");
        assertEquals(0, machine.getMemory()[0]);
        assertEquals(3, machine.getMemory()[1]);
    }

    @Test
    void outputWithLoop() {
        // 8 * 9 = 72 = 'H'
        String result = run("++++++++[>+++++++++<-]>.");
        assertEquals("H", result);
    }

    @Test
    void helloWorld() {
        String sourceCode = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.";
        String result = run(sourceCode);
        assertEquals("Hello World!\n", result);
    }

    @Test
    void emptyProgram() {
        var machine = runAndGetMachine("");
        assertEquals(0, machine.getMemory()[0]);
        assertEquals(0, machine.getMemoryPointer());
    }

    @Test
    void skipLoopWhenZero() {
        // Cell is 0, so the loop body should be skipped entirely
        var machine = runAndGetMachine("[>+<]+++");
        assertEquals(3, machine.getMemory()[0]);
        assertEquals(0, machine.getMemory()[1]);
    }
}
