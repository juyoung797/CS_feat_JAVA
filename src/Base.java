public class Base {
    int number =  12345678;
    public void run() {
        String binaryString = Integer.toBinaryString(number); //2진수
        String octalString = Integer.toOctalString(number); //8진수
        String hexString = Integer.toHexString(number); //16진수
        String decimalString = Integer.toString(number); //10진수
        System.out.println("Integer to Binary: " + binaryString);
        System.out.println("Integer to Octal: " + octalString);
        System.out.println("Integer to Hex: " + hexString);
        System.out.println("Integer to Decimal: " + decimalString);
    }
}
