package Exam_Advance_2;

import java.util.Scanner;
import java.util.Stack;

public class CheckISBN {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int sum = 0;
        String isbn;
        int begin = 1;

        while (true) {
            Stack<Integer> stack = new Stack<>();

            System.out.println("Enter the ISBN number:");
            isbn = sc.nextLine();

            boolean isValid = true;

            if (isbn.length() == 10) {
                try {
                    for (int i = isbn.length() - 1; i >= 0; i--) {
                        char ch = isbn.charAt(i);
                        if (Character.isDigit(ch)) {
                            stack.push(Character.getNumericValue(ch));
                        } else {
                            throw new NumberFormatException();
                        }
                    }

                    while (!stack.isEmpty()) {
                        sum += begin * stack.pop();
                        begin++;
                    }

                } catch (NumberFormatException e) {
                    isValid = false;
                }

                if (isValid) {
                    break;
                } else {
                    System.err.println("The number must not have any letters.");
                }
            } else {
                System.err.println("ISBN must have 10 digits.");
            }
        }

        System.out.println("Sum = " + sum);

        ////        8175257660

        if (sum % 11 == 0) {
            System.out.println(isbn + " is a valid ISBN number.");
        } else {
            System.out.println(isbn + " is not a valid ISBN number.");
        }
    }
}
