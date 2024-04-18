package com.xt.dio.java.io.character;

import java.io.*;
import java.util.Scanner;

public class Exercise2 {

    public static void execute() {
        try {
            PrintWriter pw = new PrintWriter(System.out);
            pw.println("Digite 3 recomendações de filmes:");
            pw.flush();

            Scanner s = new Scanner(System.in);
            String line = s.nextLine();

            File f = new File("recomendations.txt");

            BufferedWriter bw = new BufferedWriter(new FileWriter(f.getName()));

            do {
                bw.write(line);
                bw.newLine();
                bw.flush();
                line = s.nextLine();
            } while (!(line.equalsIgnoreCase("fim")));

            pw.printf("Arquivo \"%s\" criado com sucesso!", f.getName());

            pw.close();
            s.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        execute();
    }
}
