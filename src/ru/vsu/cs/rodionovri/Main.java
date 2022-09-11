package ru.vsu.cs.rodionovri;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        double smallRadius, mediumRadius, bigRadius;
        smallRadius = inputRadius("smallRadius");
        mediumRadius = inputRadius("mediumRadius");
        bigRadius = inputRadius("bigRadius");

        System.out.printf(
                "The area of the desired figure with the given r1 = %1$.3f, r2 = %2$.3f, r3 = %3$.3f equals %4$.3f%n",
                smallRadius, mediumRadius, bigRadius, getS(smallRadius, mediumRadius, bigRadius)
        );
    }

    public static double inputRadius(String radius){
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter %s = ", radius);
        return scanner.nextDouble();

    }
    public static double getFullS(double radius) {
        return Math.PI * radius * radius;
    }

    public static double getFirstS(double smallRadius, int count) {
        return getFullS(smallRadius) / count;
    }

    public static double getSecondS(double mediumRadius, double smallRadius, int count) {
        return (getFullS(mediumRadius) - getFullS(smallRadius)) / count;
    }

    public static double getThirdS(double bigRadius, double mediumRadius, int count) {
        return (getFullS(bigRadius) - getFullS(mediumRadius)) / count;
    }

    public static double getFourthS(double bigRadius, int count) {
        return (bigRadius * bigRadius - getFullS(bigRadius)) / count;
    }

    public static double getS(double smallRadius, double mediumRadius, double bigRadius) {
        return getFirstS(smallRadius, 2) + getSecondS(mediumRadius, smallRadius, 3) + getThirdS(bigRadius, mediumRadius, 4) + getFourthS(bigRadius, 5);
    }
}
