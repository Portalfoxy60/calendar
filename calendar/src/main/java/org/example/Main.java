package org.example;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[][] temperatures = new int[12][];
        for (int month = 0; month < temperatures.length; month++) {
            temperatures[month] = new int[daysInMonth[month]];
            for (int day = 0; day < temperatures[month].length; day++) {
                if (month == 11 || month == 0 || month == 1) {
                    temperatures[month][day] = random.nextInt(26) - 20;
                } else if (month == 2 || month == 3 || month == 4) {
                    temperatures[month][day] = random.nextInt(16);
                } else if (month == 5 || month == 6 || month == 7) {
                    temperatures[month][day] = random.nextInt(26) + 10;
                } else {
                    temperatures[month][day] = random.nextInt(26) - 5;
                }
            }
        }
        System.out.print("Введите месяц (1-12): ");
        int monthInput = scanner.nextInt() - 1;
        System.out.print("Введите день: ");
        int dayInput = scanner.nextInt() - 1;
        if (monthInput >= 0 && monthInput < 12 && dayInput >= 0 && dayInput < temperatures[monthInput].length) {
            System.out.println("Температура на выбранную дату: " + temperatures[monthInput][dayInput] + "°C");
        } else {
            System.out.println("Некорректная дата.");
        }
        int maxTemp = Integer.MIN_VALUE;
        int minTemp = Integer.MAX_VALUE;
        String hottestDay = "";
        String coldestDay = "";
        for (int month = 0; month < temperatures.length; month++) {
            for (int day = 0; day < temperatures[month].length; day++) {
                if (temperatures[month][day] > maxTemp) {
                    maxTemp = temperatures[month][day];
                    hottestDay = (month + 1) + "/" + (day + 1);
                }
                if (temperatures[month][day] < minTemp) {
                    minTemp = temperatures[month][day];
                    coldestDay = (month + 1) + "/" + (day + 1);
                }
            }
        }
        System.out.println("Самая теплая температура была " + maxTemp + "°C в день: " + hottestDay);
        System.out.println("Самая холодная температура была " + minTemp + "°C в день: " + coldestDay);
        for (int month = 0; month < temperatures.length; month++) {
            int sum = 0;
            for (int day = 0; day < temperatures[month].length; day++) {
                sum += temperatures[month][day];
            }
            double average = (double) sum / temperatures[month].length;
            System.out.printf("Средняя температура за месяц %d: %.2f°C%n", (month + 1), average);
        }
    }
}
