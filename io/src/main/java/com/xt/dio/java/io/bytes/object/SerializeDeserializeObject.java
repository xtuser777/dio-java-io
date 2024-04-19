package com.xt.dio.java.io.bytes.object;

import java.io.*;

public class SerializeDeserializeObject {

    public static void serialize(File f) {
        Cat c = new Cat("Simba", 6, "amarelado", true);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f.getName()));

            oos.writeObject(c);

            PrintStream ps = new PrintStream(System.out);
            ps.printf("Arquivo \"%s\" criado com sucesso! Tamanho '%d' bytes." , f.getName(), f.length());

            oos.close();
            ps.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserialize(File f) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            Cat c = (Cat) ois.readObject();

            System.out.printf("\nNome..................: %s\n", c.getName());
            System.out.printf("Idade...................: %d\n", c.getAge());
            System.out.printf("Cor.....................: %s\n", c.getColor());
            System.out.printf("Castrado................: %s\n", c.isCastrated());
            System.out.println(c);

            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void execute() {
        File f = new File("cats");
        //serialize(f);
        deserialize(f);
    }

    public static void main(String[] args) {
        execute();
    }
}
