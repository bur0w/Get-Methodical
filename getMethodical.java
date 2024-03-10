import java.util.Scanner;

public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; // Set this to zero length. Loop runs until it isn’t
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int value = 0;
        boolean isValid = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                pipe.next(); // consume invalid input
            }
        } while (!isValid);
        pipe.nextLine(); // clear the newline character from the buffer
        return value;
    }
    public static void prettyHeader(String msg) {
        int totalWidth = 60;
        int msgWidth = msg.length();
        int sideStars = (totalWidth - msgWidth - 4) / 2; // 4 stars total (2 on each side)
        StringBuilder header = new StringBuilder();
        for (int i = 0; i < totalWidth; i++) {
            header.append("*");
        }
        header.append("\n*** ");
        for (int i = 0; i < sideStars; i++) {
            header.append(" ");
        }
        header.append(msg);
        for (int i = 0; i < sideStars; i++) {
            header.append(" ");
        }
        if (msgWidth % 2 != 0) {
            header.append(" ");
        }
        header.append("***\n");
        for (int i = 0; i < totalWidth; i++) {
            header.append("*");
        }
        System.out.println(header.toString());
    }
}
