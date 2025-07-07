package TIL250707.exeption_example;

public class Main {
    public static int divide(int a, int b) throws ArithmeticException {
        if (b ==0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
        return a /b;
    }
    public static void main(String[] args) {
        try {
            System.out.println(divide(10, 2));
            System.out.println(divide(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("예외 발생: " + e.getMessage());
        } finally {
            System.out.println("처리 완료.");
        }
    }
}
