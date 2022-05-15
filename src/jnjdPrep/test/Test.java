package jnjdPrep.test;

import java.io.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Test {
    public static void main(String[] args) throws IOException {
        generatePerfectWordTest();
    }

    public static void generatePerfectWordTest() throws IOException {
        int n = 40;
        for (int test = 0; test < n; test++) {
            FileOutputStream fos = new FileOutputStream(new File("pref_out" + test + ".txt"));
            BufferedWriter bufferedWritter = new BufferedWriter(new OutputStreamWriter(fos));
            int randomSize = 0;
            if (test == 38) randomSize = 100;
            else randomSize = new Random().nextInt(100) + 1;
            bufferedWritter.write(String.valueOf(randomSize));
            bufferedWritter.newLine();
            StringBuffer str = new StringBuffer();
            for (int i = 0; i < randomSize; i++) {
                if (test == 38) {
                    str.append("1");
                } else str.append(new Random().nextInt(2));
            }
            bufferedWritter.write(str.toString());
            bufferedWritter.newLine();
            bufferedWritter.close();
        }
    }

    public static void generateGamesOnArrays() throws IOException {
        int numTest = 37;
        int maxLength = 31;
        Set<String> visited = new HashSet<>();
        for (int test = 0; test < numTest; test++) {
            FileOutputStream fos = new FileOutputStream(new File("split_array_" + test + ".txt"));
            BufferedWriter bufferedWritter = new BufferedWriter(new OutputStreamWriter(fos));

            int arrayLength = new Random().nextInt(31) + 1;
            StringBuffer str = new StringBuffer();

            for (int i = 0; i < arrayLength; i++) {
                str.append(new Random().nextInt(10000 + 1));
                if (i < arrayLength - 1) str.append(" ");
            }

            if (!visited.contains(str.toString())) {
                visited.add(str.toString());
                bufferedWritter.write(String.valueOf(arrayLength));
                bufferedWritter.newLine();

                bufferedWritter.write(str.toString());
                bufferedWritter.newLine();
                bufferedWritter.close();

            }

        }
    }


    public static void generateAtmQueueTest() throws IOException {
        int n = 2;
        int maxLength = 10;//1000000000 + 1;
        for (int test = 0; test < n; test++) {
            FileOutputStream fos = new FileOutputStream(new File("atm_queue_" + test + ".txt"));
            BufferedWriter bufferedWritter = new BufferedWriter(new OutputStreamWriter(fos));
            int numberPeopleStandInQueue = new Random().nextInt(5 + 1) + 1;
            ;//new Random().nextInt(100000 + 1) + 1;
            int maxAmountCanGet = new Random().nextInt(maxLength) + 1;
            StringBuffer str = new StringBuffer();
            for (int i = 0; i < numberPeopleStandInQueue; i++) {
                str.append(new Random().nextInt(maxLength));
                if (i < numberPeopleStandInQueue - 1) str.append(" ");
            }
            bufferedWritter.write(str.toString());
            bufferedWritter.newLine();
            bufferedWritter.close();
        }
    }


    public static void generateVestigiumRandomTest() throws IOException {

        int n = 200;
        for (int test = 0; test < n; test++) {

            FileOutputStream fos = new FileOutputStream(new File("out" + test + ".txt"));
            BufferedWriter bufferedWritter = new BufferedWriter(new OutputStreamWriter(fos));

            int randomSize = new Random().nextInt(10);
            if (test >= 198) randomSize = 300 + randomSize;
            bufferedWritter.write(String.valueOf(randomSize));
            bufferedWritter.newLine();

            for (int i = 0; i < randomSize; i++) {
                StringBuffer str = new StringBuffer();
                for (int j = 0; j < randomSize; j++) {
                    str.append(new Random().nextInt(randomSize) + 1);
                    if (j < randomSize - 1) str.append(" ");
                }
                //    System.out.println(str.toString());
                bufferedWritter.write(str.toString());
                bufferedWritter.newLine();
            }
            bufferedWritter.close();
        }
    }


}
