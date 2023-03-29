import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MainMutant2Test {

    /*

        1. Equivalence partitioning:

            a, b si c trebuie sa fie intre 10 si 10000:


                N_1 = {n | n < 10}
                N_2 = {n | n >= 10 && n <= 10000}
                N_3 = {n | n > 10000}

            Iesiri:

            I_1 = {
                    [
                        "Numerele {a} si {b} sunt prime intre ele",
                        "Suma cifrelor lui {a}, adunata cu suma cifrelor lui {b}, este mai mare decat {c}"
                    ]
                  }
            I_2 = {
                    [
                        "Numerele {a} si {b} nu sunt prime intre ele",
                        "Suma cifrelor lui {a}, adunata cu suma cifrelor lui {b}, este mai mare decat {c}"
                    ]
                  }
            I_3 = {
                    [
                        "Numerele {a} si {b} sunt prime intre ele",
                        "Suma cifrelor lui {a}, adunata cu suma cifrelor lui {b}, nu este mai mare decat {c}"
                    ]
                  }
            I_4 = {
                    [
                        "Numerele {a} si {b} nu sunt prime intre ele",
                        "Suma cifrelor lui {a}, adunata cu suma cifrelor lui {b}, nu este mai mare decat {c}"
                    ]
                  }
            I_5 = {
                    [
                        "Cel putin unul dintre numere nu face parte din intervalul dat"
                    ]
                  }

            Clasele finale:
            C_1 = { (a, b, c) | a in N_1 si iesirea I5} ---> a = 0
            C_2 = { (a, b, c) | b in N_1 si iesirea I5} ---> b = 0
            C_3 = { (a, b, c) | c in N_1 si iesirea I5} ---> c = 0
            C_41 = { (a, b, c) | a, b, c in N2 si iesirea I1} ---> a = 15, b = 17 si c = 11
            C_42 = { (a, b, c) | a, b, c in N2 si iesirea I2} ---> a = 14, b = 18 si c = 11
            C_43 = { (a, b, c) | a, b, c in N2 si iesirea I3} ---> a = 12, b = 11 si c = 11
            C_44 = { (a, b, c) | a, b, c in N2 si iesirea I4} ---> a = 14, b = 12 si c = 11
            C_5 = { (a, b, c) | a in N_3 si iesirea I5} ---> c = 12345
            C_6 = { (a, b, c) | b in N_3 si iesirea I5} ---> c = 12345
            C_7 = { (a, b, c) | c in N_3 si iesirea I5} ---> c = 12345

     */

    private static final String messageNotValid = "Cel putin unul dintre numere nu face parte din intervalul dat";
    private static final String messageCoPrime = "Numerele %d si %d sunt prime intre ele";
    private static final String messageNotCoPrime = "Numerele %d si %d nu sunt prime intre ele";
    private static final String messageSumIsGreater =
            "Suma cifrelor numarului %d, adunata cu suma cifrelor numarului %d, este mai mare decat %d";
    private static final String messageSumIsNotGreater =
            "Suma cifrelor numarului %d, adunata cu suma cifrelor numarului %d, nu este mai mare decat %d";


    @Test
    void equivalence() {
        assertArrayEquals(new String[]{messageNotValid}, MainMutant2.calculate(0, 1000, 1000));
        assertArrayEquals(new String[]{messageNotValid}, MainMutant2.calculate(1000, 0, 1000));
        assertArrayEquals(new String[]{messageNotValid}, MainMutant2.calculate(1000, 1000, 0));
        assertArrayEquals(
                new String[]{String.format(messageCoPrime, 15, 17), String.format(messageSumIsGreater, 15, 17, 11)},
                MainMutant2.calculate(15, 17, 11));
        assertArrayEquals(
                new String[]{String.format(messageNotCoPrime, 14, 18), String.format(messageSumIsGreater, 14, 18, 11)},
                MainMutant2.calculate(14, 18, 11));
        assertArrayEquals(
                new String[]{String.format(messageCoPrime, 12, 11), String.format(messageSumIsNotGreater, 12, 11, 11)},
                MainMutant2.calculate(12, 11, 11));
        assertArrayEquals(
                new String[]{String.format(messageNotCoPrime, 14, 12), String.format(messageSumIsNotGreater, 14, 12, 11)},
                MainMutant2.calculate(14, 12, 11));
        assertArrayEquals(new String[]{messageNotValid}, MainMutant2.calculate(12345, 1000, 1000));
        assertArrayEquals(new String[]{messageNotValid}, MainMutant2.calculate(1000, 12345, 1000));
        assertArrayEquals(new String[]{messageNotValid}, MainMutant2.calculate(1000, 1000, 12345));
    }

    /*

        2. Boundary value analysis:



     */

    @Test
    void boundaries() {

    }

    @Test
    void gce() {
        assertArrayEquals(new String[]{messageNotValid}, MainMutant2.calculate(1000, 1000, 0));
        assertArrayEquals(
                new String[]{String.format(messageCoPrime, 15, 17), String.format(messageSumIsGreater, 15, 17, 11)},
                MainMutant2.calculate(15, 17, 11));
        assertArrayEquals(
                new String[]{String.format(messageNotCoPrime, 14, 18), String.format(messageSumIsGreater, 14, 18, 11)},
                MainMutant2.calculate(14, 18, 11));
        assertArrayEquals(
                new String[]{String.format(messageCoPrime, 12, 11), String.format(messageSumIsNotGreater, 12, 11, 11)},
                MainMutant2.calculate(12, 11, 11));
        assertArrayEquals(
                new String[]{String.format(messageNotCoPrime, 14, 12), String.format(messageSumIsNotGreater, 14, 12, 11)},
                MainMutant2.calculate(14, 12, 11));
    }

}