package substr;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String input = getInput();
        int largetNoRepeatStringLength = getSubStringLength(input);
        System.out.println(largetNoRepeatStringLength);
    }

    private static int getSubStringLength(String input) {

        int largestLength = 0;
        int startIndex = 0;
        int endIndex = 0;
        int tempLength;

        int[] indexArray = new int[256];
        for (int i = 0; i < indexArray.length; i++) {
            indexArray[i] = -1;
        }

        char[] chars = input.toCharArray();
        while(endIndex < input.length()) {

            char aChar = chars[endIndex];
            if (indexArray[aChar] == -1 || indexArray[aChar] != -1 && indexArray[aChar] < startIndex) {
                indexArray[aChar] = endIndex;
            } else {
                tempLength = Math.max(endIndex - indexArray[aChar] + 1, endIndex - startIndex);
                largestLength = Math.max(largestLength, tempLength);
                startIndex = indexArray[aChar] + 1;
                indexArray[aChar] = endIndex;
            }

            if (endIndex == input.length() - 1) {
                largestLength = Math.max(largestLength, endIndex - startIndex + 1);
            }
            endIndex++;
        }

        return largestLength;
    }

    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }


}
