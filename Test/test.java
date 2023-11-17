import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        int[] target = generateRandomNumber();
        int[] guess = new int[target.length];
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        System.out.println("歡迎來到猜數字遊戲！");

        while (!Arrays.equals(guess, target)) {
            System.out.println("請輸入一組不重複的數字: ");
            readUserInput(guess, scanner);

            int[] result = checkGuess(target, guess);
            System.out.println("結果: A" + result[0] + "B" + result[1]);
            attempts++;

            if (attempts >= 10) {
                System.out.println("超過10次，遊戲結束。正確答案是：" + Arrays.toString(target));
                break;
            }
        }

        System.out.println("恭喜你猜對了！共猜了 " + attempts + " 次。");
    }

    private static int[] generateRandomNumber() {
        int[] number = new int[4];
        Random random = new Random();

        for (int i = 0; i < number.length; i++) {
            int digit;
            do {
                digit = random.nextInt(10);
            } while (contains(number, digit));

            number[i] = digit;
        }

        return number;
    }

    private static boolean contains(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }

    private static void readUserInput(int[] guess, Scanner scanner) {
        while (true) {
            try {
                String input = scanner.nextLine();
                if (input.length() != 4) {
                    throw new IllegalArgumentException("請輸入4位數字");
                }

                for (int i = 0; i < 4; i++) {
                    guess[i] = Character.getNumericValue(input.charAt(i));
                }

                if (!isValidInput(guess)) {
                    throw new IllegalArgumentException("輸入數字重複，請重新輸入");
                }

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.print("請重新輸入: ");
            }
        }
    }

    private static boolean isValidInput(int[] guess) {
        for (int i = 0; i < guess.length; i++) {
            for (int j = i + 1; j < guess.length; j++) {
                if (guess[i] == guess[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[] checkGuess(int[] target, int[] guess) {
        int[] result = new int[2]; // result[0] for A, result[1] for B

        for (int i = 0; i < target.length; i++) {
            if (target[i] == guess[i]) {
                result[0]++;
            } else if (contains(target, guess[i])) {
                result[1]++;
            }
        }

        return result;
    }
}
