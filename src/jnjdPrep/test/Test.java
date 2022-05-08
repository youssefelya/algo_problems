package jnjdPrep.test;

import java.io.*;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws IOException {
        generateAtmQueueTest();
    }

    public static void generateAtmQueueTest() {
        int numTest = 2;
        int maxLength = 10;
        for (int test = 0; test < numTest; test++) {
            FileOutputStream fos = new FileOutputStream(new File("split_array_" + test + ".txt"));
            BufferedWriter bufferedWritter = new BufferedWriter(new OutputStreamWriter(fos));
            int arrayLength = new Random().nextInt(5 + 1) + 1;;//new Random().nextInt(100000 + 1) + 1;
            StringBuffer str = new StringBuffer();
            for (int i = 0; i < arrayLength; i++) {
                str.append(new Random().nextInt(maxLength));
                if (i < arrayLength - 1) str.appeng(" ");
            }
            bufferedWritter.write(str.toString());
            bufferedWritter.newLine();
            bufferedWritter.close();

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


    public static void generatePerfectWordTest() throws IOException {
        int n = 200;
        for (int test = 0; test < n; test++) {
            FileOutputStream fos = new FileOutputStream(new File("pref_out" + test + ".txt"));
            BufferedWriter bufferedWritter = new BufferedWriter(new OutputStreamWriter(fos));
            int randomSize = new Random().nextInt(500) + 1;
            if (test >= 198) randomSize = 100 * +randomSize;
            bufferedWritter.write(String.valueOf(randomSize));
            bufferedWritter.newLine();
            StringBuffer str = new StringBuffer();
            for (int i = 0; i < randomSize; i++) {
                str.append(new Random().nextInt(2));
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
