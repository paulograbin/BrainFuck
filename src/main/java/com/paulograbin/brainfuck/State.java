package com.paulograbin.brainfuck;


public class State {

    private int counter;
    private Memory memory;

    public State() {
        this.counter = 0;
        this.memory = new Memory();
    }

    private State(Memory memory, int counter) {
        this.memory = memory;
        this.counter = counter;
    }

    public Byte getCurrentValue() {
        return memory.getByteAt(counter);
    }

    public State setCurrentValue(byte currentValue) {
        this.memory.setByteAt(counter, currentValue);
        System.out.println("Setting value " + currentValue + " to position " + counter);

        return new State(memory, counter);
    }

    public State incrementPointer() {
        int newValue = counter + 1;
        System.out.println("Counter now pointing to " + newValue);

        return new State(memory, newValue);
    }

    public State decrementPointer() {
        int newValue = counter - 1;

        if (newValue < 0)
            newValue = 0;

        System.out.println("Counter now pointing to " + newValue);

        return new State(memory, newValue);
    }

    public State incrementCurrentValue() {
        byte newValue = (byte) (memory.getByteAt(counter) + 1);

        memory.setByteAt(counter, newValue);
        System.out.printf("Incrementing value at %d to %d", counter, newValue);
        System.out.println();

        return new State(memory, counter);
    }

    public State decrementCurrentValue() {
        byte newValue = (byte) (memory.getByteAt(counter) - 1);

        memory.setByteAt(counter, newValue);
        System.out.printf("Decrementing value at %d to %d", counter, newValue);
        System.out.println();

        return new State(memory, counter);
    }

}
