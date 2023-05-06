// 1. Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n).
// ===============================================================================================

package seminar_1;

import java.util.Scanner;

public class program_1_1 {
    public static void main(String[] args) {
        System.out.printf("Введите число n: ");
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();
        int sum = 0;
        int mult = 1;
        for (int i = 1; i <= n; i++) {
            sum += i;
            mult *= i;
        }
        System.out.printf("Сумма чисел от 1 до : %d%n", n, sum);
        System.out.printf("Произведение чисел от 1 до %d: %d%n", n, mult);
        num.close();
    }
}
