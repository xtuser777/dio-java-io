package com.xt.dio.java.io.character;

import java.io.*;

public class Exercise1 {

    public static void execute() {
        System.out.println("Recomende 3 filmes:");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            do {
                bw.write(line);
                bw.newLine();
                line = br.readLine();
            } while (!(line.isEmpty()));

            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        execute();
    }
}
