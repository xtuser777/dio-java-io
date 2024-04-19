package com.xt.dio.java.io.bytes;

import java.io.*;

public class CopyExample {

    public static void execute() {
        try {
            File f = new File("/home/lucas/github/dio-java-io/io/recomendations-copy.txt");
            String filename = f.getName();

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f.getName()));

            String filenameCopy = filename.substring(0, filename.indexOf("-")).concat("-copy2.txt");
            File fcopy = new File(filenameCopy);

            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filenameCopy));

            int line = 0;
            while((line = bis.read()) != -1) {
                bos.write((char) line);
                bos.flush();
            }

            bis.close();
            bos.close();

            PrintStream ps = new PrintStream(System.out);
            ps.printf(
                "Arquivo %s copiado com sucesso e está no diretório %s com %d bytes ",
                fcopy.getName(), fcopy.getPath(), fcopy.length()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        execute();
    }
}
