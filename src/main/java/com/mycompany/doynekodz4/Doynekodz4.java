/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.doynekodz4;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author yulia
 */
public class Doynekodz4 {

   
   public static void main(String[] args) {
        System.out.println("Дойнеко Юлия Антоновна . Вариант 1.");
      
        Scanner scanner = new Scanner(System.in);
        
        Car car = new Car();

        try {
            System.out.println("Создание нового объекта класса Car для дальнейшего сохранения в файл.");
            System.out.println("Введите марку машины:");
            car.brand = scanner.nextLine();

            System.out.println("Введите модель машины:");
            car.model = scanner.nextLine();

            int yearInput;
            do {
                System.out.println("Введите год выпуска машины:");
                yearInput = scanner.nextInt();
                if (yearInput < 1900 || yearInput > 2024) {
                    System.out.println("Некорректный ввод. Попробуйте заново.");
                }
            } while (yearInput < 1900 || yearInput > 2024);
            car.year = yearInput;

            System.out.println("Введите цену машины:");
            car.price = scanner.nextDouble();

            System.out.println("Машина с автоматической коробкой передач? (true/false):");
            car.isAutomatic = scanner.nextBoolean();
        } catch (InputMismatchException e) {
            System.out.println("Некорректный ввод. Попробуйте заново.");
            return;
        }
           String filePath = "C:\\car_new.ser";  

        Thread serializeThread = new Thread(() -> {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
                oos.writeObject(car);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        serializeThread.start();

        System.out.println("Объект класса Car создан и добавлен в : " + filePath);

        scanner.close();
   }
}


       