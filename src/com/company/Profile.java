package com.company;

import java.io.*;

public class Profile {

    // первоначальные проверки;

    public void checkFile(File sourceFile){
        System.out.println("Имя файла, что копируем: " + sourceFile.getName() + ";");
        System.out.println("Расположение файла: " + sourceFile.getParent() + ";");

        if (sourceFile.exists())
            System.out.println(sourceFile.getName() + ": существует;");
        else
            System.out.println(sourceFile.getName() + ": не существует;");

        System.out.println("Размер копируемого файла: " + sourceFile.length() + " байт;");
        if (sourceFile.canRead())
            System.out.println(sourceFile.getName() + ": доступен для чтения;");
        else
            System.out.println(sourceFile.getName() + " : не доступен для чтения;");

        if (sourceFile.canWrite())
            System.out.println(sourceFile.getName() + ": доступен для записи;");
        else
            System.out.println(sourceFile.getName() + ": не доступен для записи;");
    }

    // построчная проверка исходного файла с копией;

    public void comparisonFile(File source, File newFile){
        try {

            FileReader frSource = new FileReader(source);
            FileReader frNew = new FileReader(newFile);

            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader readerSource = new BufferedReader(frSource);
            BufferedReader readerNew = new BufferedReader(frNew);

            // считаем сначала первую строку
            String lineNew = "";
            String lineSource = "";

            while (true) {

                // считываем остальные строки в цикле
                lineSource = readerSource.readLine();
                lineNew = readerNew.readLine();

                if (lineSource == null && lineNew == null) {
                    break;
                }else {
                    if (!lineSource.equals(lineNew)) {
                        System.out.println("Строки не совпадают\n"
                                + "Expected: " + lineSource + " Actual: " + lineNew);
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
