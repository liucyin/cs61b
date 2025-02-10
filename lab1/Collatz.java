public class Collatz {

    /** Correct implementation of nextNumber! */
    public static int nextNumber(int n) {
        if (n % 2 == 0) { // 如果是偶数
            return n / 2;
        } else {          // 如果是奇数
            return 3 * n + 1;
        }
    }

    public static void main(String[] args) {
        int n = 5; // 可以更改为任何正整数
        System.out.print(n + " ");
        while (n != 1) { // Collatz 猜想的循环条件
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
