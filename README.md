# BrainFuck

This is an implementation of a BrainFuck interpreter in Java. 
Its made with the intention of understanding Turing completeness and, of course, the BrainFuck language itself.

It started out with a slightly robust design, some would call it over engineered, but ended up very simple with only one class.
I plan to in the future separate the concerns (memory, parsing, executing, etc...) and make use of the Command pattern.

## Requirements

- Java 17+

## Run

From a file:

```bash
java src/main/java/com/paulograbin/brainfuck/Machine.java hello.bf
```

With inline code:

```bash
java src/main/java/com/paulograbin/brainfuck/Machine.java -e '++++++[>++++++++++<-]>+++++.'
```

## Future Work

- **Nested loops** — The `[` and `]` commands scan linearly for the matching bracket, so nested loops (e.g. `[>[+]]`) will match the wrong bracket. Needs a depth counter or pre-computed jump table.
- **Input command** — The `,` command does not advance the instruction pointer after reading, causing an infinite loop.
- **Memory bounds checking** — Moving the pointer past 0 or 29999 will throw an `ArrayIndexOutOfBoundsException`. Should wrap around or grow dynamically.
- **Bracket validation** — Unmatched `[` or `]` are not detected before execution, leading to runtime errors.
- **Separate concerns** — Split parsing, memory management, and execution into separate classes using the Command pattern.
