import java.util.Scanner;

public class MainMutant3 {

    /*

    Se dau trei numere a, b si c, cuprinse in intervalul [10, 10000]. Sa se verifice daca primele doua numere sunt prime
    intre ele si daca suma cifrelor lui a, adunata cu suma cifrelor lui b, este mai mare decat al treilea numar.
    Programul va intoarce un vector de string-uri astfel:
    - Daca cel putin unul dintre numere nu face parte din intervalul dat, prima pozitie din vector va contine mesajul
    de eroare "Cel putin unul dintre numere nu face parte din intervalul dat"
    - Daca toate numerele fac parte din intervalul dat, vectorul va fi creat dupa cum urmeaza:
        * Prima pozitie din vector va contine mesajul:
                "Numerele {a} si {b} sunt/nu sunt prime intre ele"
        * A doua pozitie din vector va contine mesajul:
                "Suma cifrelor numarului {a}, adunata cu suma cifrelor numarului {b}, este/nu este mai mare decat {c}"

    */

    private static boolean isNumberInvalid(int number) {
        return number < 10 || number > 10000;
    }

    private static int computeSumOfDigits(int number) {
        int numberCopy = number, sum = 0, digit;
        while (numberCopy > 0){
            digit = numberCopy % 10;
            numberCopy /= 10;
            sum += digit;
        }
        return sum;
    }

    private static int getGreatestCommonDivisor(int a, int b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

    private static boolean areNumbersCoPrime(int a, int b) {
        return getGreatestCommonDivisor(a, b) == 1;
    }

    static String[] calculate(int a, int b, int c) {
        if (isNumberInvalid(a) || isNumberInvalid(b) || isNumberInvalid(c)) {
            return new String[] {"Cel putin unul dintre numere nu face parte din intervalul dat"};
        }
        String[] responses = new String[2];

        if (areNumbersCoPrime(a, b)) {
            responses[0] = String.format("Numerele %d si %d sunt prime intre ele", a, b);
        } else {
            responses[0] = String.format("Numerele %d si %d nu sunt prime intre ele", a, b);
        }

        if (computeSumOfDigits(a) - computeSumOfDigits(b) > c) { // + a fost inlocuit cu -
            responses[1] = String.format(
                    "Suma cifrelor numarului %d, adunata cu suma cifrelor numarului %d, este mai mare decat %d", a, b, c);
        } else {
            responses[1] = String.format(
                    "Suma cifrelor numarului %d, adunata cu suma cifrelor numarului %d, nu este mai mare decat %d", a, b, c);
        }

        return responses;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
        scanner.close();

        System.out.printf("a = %d, b = %d, c = %d%n", a, b, c);
        System.out.printf("The result is:\n" + String.join("\n", calculate(a, b, c)));
    }
}
