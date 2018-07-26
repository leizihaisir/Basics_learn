package lambda;

/**
 * @Author zihailei
 * @Date 2018/7/26
 * @Description
 */
public class ComputerMath {

    // 类型声明
    static final MathOperation addition = (int a, int b) -> a + b;

    // 不用类型声明
    static final MathOperation subtraction = (int a, int b) -> a - b;

    // 大括号中的返回语句
    static final MathOperation multiplication = (int a, int b) -> a * b;

    // 没有大括号及返回语句
    static final MathOperation division = (int a, int b) -> a / b;

    private void operate(int a, int b, MathOperation mathOperation) {
        System.out.println(mathOperation.operation(a, b));
    }

    public static void main(String[] args) {
        ComputerMath computerMath = new ComputerMath();
        computerMath.operate(8, 2, addition);
        computerMath.operate(8, 2, subtraction);
        computerMath.operate(8, 2, multiplication);
        computerMath.operate(8, 2, division);
    }

}

interface MathOperation {
    int operation(int a, int b);
}