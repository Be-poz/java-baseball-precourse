package baseball;

import java.util.Scanner;

public class Game {
    public static void gameStart(int tartgetValue, Scanner scanner){
        boolean flag = true;
        do{
            int input = valueInsert(scanner);
            if (checking(tartgetValue, input)) {
                flag = gameContinue(scanner);
            } else {
                hint(tartgetValue, input);
            }
        } while(flag);
    }

    private static void hint(int targetValue, int input) {
        char[] target = String.valueOf(targetValue).toCharArray();
        char[] guess = String.valueOf(input).toCharArray();
        int ball = 0 ;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (target[i] == guess[i]) {
                strike++;
            }

            if (String.valueOf(targetValue).contains(String.valueOf(guess[i]))) {
                ball++;
            }
        }

        resultPrint();
    }

    private static boolean gameContinue(Scanner scanner) {
        int input;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        input = scanner.nextInt();
        if (input == 1) {
            return true;
        } else if (input == 2) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static boolean checking(int tartgetValue, int input) {
        return tartgetValue == input;
    }

    private static int valueInsert(Scanner scanner) {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextInt();
    }
}
