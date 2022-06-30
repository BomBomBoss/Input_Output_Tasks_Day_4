package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        //task 1
        File file = new File("C:\\Users\\Vladjuha\\Desktop\\Java_Test\\someFolder");
        String [] listOfFile = file.list();
        System.out.println(Arrays.toString(listOfFile));

        //task 2
        for (String s : listOfFile) {
            if (s.endsWith(".zip")) System.out.println(s);
        }
        //task 3
        Path someFile = Paths.get("C:\\Users\\Vladjuha\\Desktop\\Java_Test\\someFolder");
        System.out.println(Files.exists(someFile));

        //task 4
        if (Files.isReadable(someFile)) System.out.println(someFile.getFileName() + " is readable");
        else System.out.println(someFile.getFileName() + " isn't readable");

        if (Files.isWritable(someFile)) System.out.println(someFile.getFileName() + " is writable");
        else System.out.println(someFile.getFileName() + " isn't writable");

        //task 5
        System.out.println(someFile.getFileName() + " is Directory? - " + Files.isDirectory(someFile));
        System.out.println(someFile.getFileName() + " is File? - " + Files.isRegularFile(someFile));

        //task 6
        Path secondFile = Paths.get("C:\\Users\\Vladjuha\\Desktop\\Java_Test\\someFolder\\file1.txt");
        System.out.println("These two files have same name? - "+ someFile.getFileName().equals(secondFile.getFileName()));

        //task 7
        System.out.println("Last modified time of " + secondFile.getFileName() + " is " + Files.getLastModifiedTime(secondFile));

        //task 8
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String input;
//        while(!(input= reader.readLine()).equalsIgnoreCase("stop")) {
//            System.out.println("You've entered - " + input);
//        }

        //task 9
        long bytes = Files.size(secondFile);
        long kb = bytes/1000;
        long mb = kb/1000;
        System.out.printf(secondFile.getFileName() + " size in bytes %d, in kb %d and in mb %d.",bytes,kb,mb);

        //task 10
        byte [] content = Files.readAllBytes(secondFile);
        System.out.println(Arrays.toString(content));

        //task 11
        System.out.println(Files.readAllLines(secondFile));

        //task 12
        BufferedReader reader = new BufferedReader(new FileReader(secondFile.toAbsolutePath().toString()));
        StringBuilder sb = new StringBuilder();
        while (reader.ready())sb.append(reader.readLine() + " ");
        System.out.println(sb);

        //task 13
        List<String> fileContent = Files.readAllLines(secondFile);
        String result = fileContent.toString();
        System.out.println(result);

        //task 14
        String [] arrayContent = fileContent.toArray(new String[0]);
        System.out.println(Arrays.toString(arrayContent));

        //task 15
        File file1 = new File("C:\\Users\\Vladjuha\\Desktop\\Java_Test\\someFolder\\While_she_sleeps.txt");
        File file2 = new File("C:\\Users\\Vladjuha\\Desktop\\Java_Test\\someFolder\\file1.txt");
        try(BufferedReader fileReader = new BufferedReader(new FileReader(file1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2,true))) {
            int counter = 0;
            while (fileReader.ready() && counter<3) {
                fileWriter.write(fileReader.readLine());
                fileWriter.write(System.lineSeparator());
                counter++;
            }
        }
        //task 16
        // Done in task 15 with argument "TRUE" in File Writer

        //task 17
        // done in task 15 with counter

        //task 18
        //took resulted StringBuilder from task 12--> StringBuilder sb = new StringBuilder()
        String [] longestWord = sb.toString().split(" ");
        System.out.println(Arrays.toString(longestWord));
        TreeMap<Integer,String> treeMap = new TreeMap<>();
        for (String s : longestWord) treeMap.put(s.length(),s);
        System.out.println(treeMap.lastEntry().getValue());
        }





    }

