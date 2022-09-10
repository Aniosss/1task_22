package ru.vsu.cs.rodionovri;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static double getFirstFullS(double r1) {
        return Math.PI * r1 * r1;
    }

    public static double getFirstS(double r1, int cnt) {
        return getFirstFullS(r1) / cnt;
    }

    public static double getSecondFullS(double r2) {
        return Math.PI * r2 * r2;
    }

    public static double getSecondS(double r2, double r1, int cnt) {
        return (getSecondFullS(r2) - getFirstFullS(r1)) / cnt;
    }

    public static double getThirdFullS(double r3) {
        return Math.PI * r3 * r3;
    }

    public static double getThirdS(double r3, double r2, int cnt) {
        return (getThirdFullS(r3) - getSecondFullS(r2)) / cnt;
    }

    public static double getFourthS(double r3, int cnt) {
        return (r3 * r3 - getThirdFullS(r3)) / cnt;
    }

    public static double getS(double r1, double r2, double r3) {
        return getFirstS(r1, 2) + getSecondS(r2, r1, 3) + getThirdS(r3, r2, 4) + getFourthS(r3, 5);
    }


    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first radius: r1 = ");
        double r1 = scanner.nextDouble();

        System.out.print("Enter second radius: r2 = ");
        double r2 = scanner.nextDouble();

        System.out.print("Enter third radius: r3 = ");
        double r3 = scanner.nextDouble();

        System.out.printf(
                "The area of the desired figure with the given r1 = %1$.3f, r2 = %2$.3f, r3 = %3$.3f equals %4$.3f%n",
                r1, r2, r3, getS(r1, r2, r3)
        );
    }
}
