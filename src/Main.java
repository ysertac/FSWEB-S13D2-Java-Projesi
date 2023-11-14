public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-1221));
        System.out.println(isPalindrome(707));
        System.out.println(isPalindrome(11212));
        System.out.println("***************************");
        System.out.println(isPalindrome2(-1221));
        System.out.println(isPalindrome2(707));
        System.out.println(isPalindrome2(11212));
        System.out.println("***************************");
        System.out.println(isPerfectNumber(6));
        System.out.println(isPerfectNumber(28));
        System.out.println(isPerfectNumber(5));
        System.out.println(isPerfectNumber(-1));
        System.out.println("***************************");
        System.out.println(numberToWords(123));
        System.out.println(numberToWords(1010));
        System.out.println(numberToWords(-12));
        System.out.println("***************************");
        System.out.println(getEvenDigitSum(123456));
        System.out.println(getEvenDigitSum(478255));
        System.out.println("***************************");
        System.out.println(getSumFirstAndLastDigit(147896));
        System.out.println(getSumFirstAndLastDigit(123456789));
        System.out.println("***************************");
        System.out.println(hasSameLastDigit(13, 50, 42, 25, 63));
        System.out.println(hasSameLastDigit(13, 50, 42, 25, 69));
    }

    public static boolean isPalindrome(int number) {
        number = Math.abs(number);
        char[] digits = String.valueOf(number).toCharArray();
        String reversed = "";
        for (int i = digits.length - 1; i >= 0; i--) {
            reversed += digits[i];
        }
        return reversed.equals(String.valueOf(number));
    }

    public static boolean isPalindrome2(int number) {
        number = Math.abs(number);
        int originalNumber = number;
        int reversedNumber = 0;

        while (number > 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number = number / 10;
        }
        return originalNumber == reversedNumber;
    }

    public static boolean isPerfectNumber(int number) {
        if (number < 1) {
            return false;
        } else {
            int divisorTotal = 0;
            for (int i = 1; i <= number/2; i++) {
                if (number % i == 0) {
                    divisorTotal += i;
                }
            }
            return divisorTotal == number;
        }
    }

    public static String numberToWords(int number) {
        if (number < 0) {
            return "Invalid Value";
        } else {
            char[] digits = String.valueOf(number).toCharArray();
            String numToText = "";
            for (char digit : digits) {
                switch (digit) {
                    case '0':
                        numToText += "Zero ";
                        break;
                    case '1':
                        numToText += "One ";
                        break;
                    case '2':
                        numToText += "Two ";
                        break;
                    case '3':
                        numToText += "Three ";
                        break;
                    case '4':
                        numToText += "Four ";
                        break;
                    case '5':
                        numToText += "Five ";
                        break;
                    case '6':
                        numToText += "Six ";
                        break;
                    case '7':
                        numToText += "Seven ";
                        break;
                    case '8':
                        numToText += "Eight ";
                        break;
                    case '9':
                        numToText += "Nine ";
                        break;
                }
            }
            return numToText.trim();
        }
    }

    public static int getEvenDigitSum(int number) {
        number = Math.abs(number);
        int sum = 0;
        char[] digits = String.valueOf(number).toCharArray();
        for (char digit : digits) {
            int parsedDigit = Integer.parseInt(String.valueOf(digit));
            if (parsedDigit % 2 == 0) {
                sum += parsedDigit;
            }
        }
        return sum;
    }

    public static int getSumFirstAndLastDigit(int number) {
        int lastDigit = number % 10;
        int firstDigit = Integer.parseInt(String.valueOf(number).substring(0, 1));
        return firstDigit + lastDigit;
    }

    public static boolean hasSameLastDigit(int... numbers) {
        int[] lastDigits = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            lastDigits[i] = numbers[i] % 10;
        }
        for (int i = 0; i < lastDigits.length - 1; i++) {
            for (int j = i + 1; j < lastDigits.length; j++) {
                if (lastDigits[i] == lastDigits[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}