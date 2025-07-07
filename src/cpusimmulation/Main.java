package cpusimmulation;

class CPU {
    public int register = 0; // register 장치
    public int[] memory = {4, 5, 6}; // memory
    int pc = 0;
    private static final int LOAD = 1;
    private static final int SAVE = 2;
    private static final int ADD = 3;
    private static final int SUB = 4;
    private static final int HALT = 5;
    // assembly
    private int[][] program = { // { operator , memory location }
            { LOAD, 0 },         // register = memory[0]
            { ADD, 1 },          // register = register + memory[1]
            { SAVE, 2 },         // memory[2] = register
            { HALT, 0 }          // stop program execution
    };
    public void executeProgram() {
        while(true) {
            int opcode = program[pc][0];  // {LOAD, ADD, SAVE, HALT}
            int operand = program[pc][1]; // {0, 1, 2, 0}
            switch (opcode) {
                case LOAD:
                    register = memory[operand];
                    System.out.println("MOV: Loading memory[" + operand + "] (" + memory[operand] + ") to Register.");
                    System.out.println("Register : " + register);
                    break;
                case SAVE:
                    memory[operand] = register;
                    System.out.println("MOV: Saving memory[" + operand + "] (" + memory[operand] + ") to Register.");
                    System.out.println("Register : " + register);
                    break;
                case ADD:
                    register += memory[operand];
                    System.out.println("MOV: Adding memory[" + operand + "] (" + memory[operand] + ") to Register.");
                    System.out.println("Register : " + register);
                    break;
                case SUB:
                    register -= memory[operand];
                    System.out.println("MOV: Subtracting memory[" + operand + "] (" + memory[operand] + ") from Register.");
                    System.out.println("Register : " + register);
                    break;
                case HALT:
                    System.out.println("MOV: Stopping program.");
                    return;
                default:
                    System.out.println("Unknown instruction. Halting... opcode : " + opcode);
                    return;
            }
            pc++;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CPU cpu = new CPU();
        cpu.executeProgram();
        System.out.println("Final memory state: memory[" + (cpu.pc-1) + "] = " + cpu.memory[cpu.pc-1]);
    }
}
