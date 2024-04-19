package com.xt.dio.java.io.bytes.data;

import java.io.*;
import java.util.Scanner;

public class CreateWriteExample {

    public static void create() {
        try {
            File f = new File("/home/lucas/Documentos/clothes.bin");

            PrintStream ps = new PrintStream(System.out);
            ps.flush();

            DataOutputStream dos = new DataOutputStream(new FileOutputStream(f.getPath()));

            Scanner scan = new Scanner(System.in);

            ps.print("Nome da peça: ");
            String name = scan.nextLine();
            dos.writeUTF(name);

            ps.print("Tamanho da peça (P/M/G/U): ");
            char size = (char) System.in.read();
            dos.writeChar(size);

            ps.print("Quantidade: ");
            int quant = scan.nextInt();
            dos.writeInt(quant);

            ps.print("Preço unitário: ");
            double price = scan.nextDouble();
            dos.writeDouble(price);

            ps.printf("O arquivo %s foi criado com %d bytes no diretório '%s'.\n",
                    f.getName(), f.length(), f.getAbsolutePath());

            read(f);

            dos.close();
            scan.close();
            ps.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read(File f) {
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(f.getPath()));

            String name = dis.readUTF();
            char size = dis.readChar();
            int quantity = dis.readInt();
            double price = dis.readDouble();

            System.out.printf("\nNome..................: %s\n", name);
            System.out.printf("Quantidade............: %d\n", quantity);
            System.out.printf("Tamanho...............: %s\n", size);
            System.out.printf("Preço.................: %f\n", price);
            System.out.print("Total valor das peças: " + (quantity * price));

            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void execute() {
        create();
    }

    public static void main(String[] args) {
        execute();
    }
}
