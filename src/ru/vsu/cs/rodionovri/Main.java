package ru.vsu.cs.rodionovri;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static double getFullS(double r) {
        return Math.PI * r * r;
    }

    public static double getFirstS(double smallRadius, int cnt) {
        return getFullS(smallRadius) / cnt;
    }

    public static double getSecondS(double mediumRadius, double smallRadius, int cnt) {
        return (getFullS(mediumRadius) - getFullS(smallRadius)) / cnt;
    }

    public static double getThirdS(double bigRadius, double mediumRadius, int cnt) {
        return (getFullS(bigRadius) - getFullS(mediumRadius)) / cnt;
    }

    public static double getFourthS(double bigRadius, int cnt) {
        return (bigRadius * bigRadius - getFullS(bigRadius)) / cnt;
    }

    public static double getS(double smallRadius, double mediumRadius, double bigRadius) {
        return getFirstS(smallRadius, 2) + getSecondS(mediumRadius, smallRadius, 3) + getThirdS(bigRadius, mediumRadius, 4) + getFourthS(bigRadius, 5);
    }


    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first radius: smallRadius = ");
        double smallRadius = scanner.nextDouble();

        System.out.print("Enter second radius: mediumRadius = ");
        double mediumRadius = scanner.nextDouble();

        System.out.print("Enter third radius: bigRadius = ");
        double bigRadius = scanner.nextDouble();

        System.out.printf(
                "The area of the desired figure with the given r1 = %1$.3f, r2 = %2$.3f, r3 = %3$.3f equals %4$.3f%n",
                smallRadius, mediumRadius, bigRadius, getS(smallRadius, mediumRadius, bigRadius)
        );
    }
}
