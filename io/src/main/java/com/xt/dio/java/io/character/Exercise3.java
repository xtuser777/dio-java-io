package com.xt.dio.java.io.character;

import java.io.*;

public class Exercise3 {

    public static File copyFile() {
        try {
            File f = new File("/home/lucas/github/dio-java-io/io/recomendations.txt");
            String fileName = f.getName();

            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();

            String fileNameCopy = fileName.substring(0, fileName.indexOf(".")).concat("-copy.txt");
            File fc = new File(fileNameCopy);

            BufferedWriter bw = new BufferedWriter(new FileWriter(fc.getName()));
            do {
                bw.write(line);
                bw.newLine();
                bw.flush();
                line = br.readLine();
            } while (!(line == null));

            br.close();
            bw.close();

            return fc;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean writeFile(File f) {
        try {
            PrintWriter pw = new PrintWriter(System.out);
            pw.println("Recomende 3 livros: ");
            pw.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();

            BufferedWriter bw = new BufferedWriter(new FileWriter(f.getName(), true));

            do {
                bw.write(line);
                bw.newLine();
                line = br.readLine();
            } while (!(line.equalsIgnoreCase("fim")));

            br.close();
            bw.close();
            pw.close();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void execute() {
        File f = copyFile();
        if (f != null) {
            if (!writeFile(f)) System.err.println("erro");
        }
        else System.err.println("erro");
    }

    public static void main(String[] args) {
        execute();
    }
}
