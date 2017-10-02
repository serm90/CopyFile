package com.company;

import java.io.*;
import java.io.File;
import java.nio.file.Files;
import java.io.IOException;

import java.nio.file.StandardCopyOption;


public class Main {

    public static void main(String[] args) throws IOException {
        //первоначальные проверки
        File source = new File("C://Users//serg-qa//Downloads/tor.txt");

        System.out.println("Имя файла, что копируем: " + source.getName() + ";");
        System.out.println("Расположение файла: " + source.getParent() + ";");

        if (source.exists())
            System.out.println(source.getName() + ": существует;");
        else
            System.out.println(source.getName() + ": не существует;");

        System.out.println("Размер копируемого файла: " + source.length() + " байт;");
        if (source.canRead())
            System.out.println(source.getName() + ": доступен для чтения;");
        else
            System.out.println(source.getName() + " : не доступен для чтения;");

        if (source.canWrite())
            System.out.println(source.getName() + ": доступен для записи;");
        else
            System.out.println(source.getName() + ": доступен для записи;");

        File newFile = new File("C://Users//serg-qa//Downloads/New/tor12.txt");
         // копироване файла
        Files.copy(source.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Файл успешно скопирован;");
        // проверка после копирования
        try {

            FileReader frSource = new FileReader(source);
            FileReader frNew = new FileReader(newFile);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader readerSource = new BufferedReader(frSource);
            BufferedReader readerNew = new BufferedReader(frNew);
            // считаем сначала первую строку
            String lineNew = "";
            String lineSource = "";



            while (lineSource != null) {

                // считываем остальные строки в цикле
                lineSource = readerSource.readLine();
                lineNew = readerNew.readLine();

                if (lineSource == null && lineNew == null) {
                break;
                }else {
                    if (lineSource.equals(lineNew)) {
                        //System.out.println(lineNew + " " + lineSource);
                    } else {
                        System.out.println("Строка не совпадает: " + lineNew);
                    }
                }

                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Построчное сравнение фалов успешно выполнено.");


    }
}





