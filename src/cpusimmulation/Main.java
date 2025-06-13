package cpusimmulation;

class CPU {
    public int register = 0;
    public int[] memory = {4, 5, 6};
    private static final int LOAD = 1;
    private static final int SAVE = 2;
    private static final int ADD = 3;
    private static final int SUB = 4;
    private static final int HALT = 5;

    private int[][] program = {
            { LOAD, 0 },         // register = memory[0]
            { ADD, 1 },         // register = register + memory[1]
            { SAVE, 2 },         // memory[2] = register
            { HALT, 0 }         // stop program execution
    };
    public void executeProgram() {
        int pc = 0;
        while(true) {
            int opcode = program[pc][0];
            int operand = program[pc][1];
            switch (opcode) {
                case LOAD:
                    register = memory[operand];
                    System.out.println("MOV: Loading memory[" + memory[pc] + "] to Register. Register: " + register);
                    break;
                case SAVE:
                    memory[pc] = register;
                    System.out.println("MOV: Saving memory " + memory[pc] + " to Register. Register: " + register);
                    break;
                case ADD:
                    register = register + operand;
                    System.out.println("MOV: Adding " +operand+ " to Register. Register: " + register);
                    break;
                case SUB:
                    register = register - operand;
                    System.out.println("MOV: Subtracting " + operand + " from Register. Register: " + register);
                    break;
                case HALT:
                    return;

            }
            pc = pc + 1;
        }
    }


}

public class Main {
    public static void main(String[] args) {
        CPU cpu = new CPU();
        cpu.executeProgram();
    }
}
