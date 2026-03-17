package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RedesController {

    private String os() {
        return System.getProperty("os.name");
    }

    public void ip() {

        String sistema = os();

        try {

            Process processo;

            if (sistema.contains("Windows")) {
                processo = Runtime.getRuntime().exec("ipconfig");
            } else {
                processo = Runtime.getRuntime().exec("ip addr");
            }

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(processo.getInputStream())
            );

            String linha;
            String adaptador = "";

            while ((linha = reader.readLine()) != null) {

                if (sistema.contains("Windows")) {

                    if (linha.contains("Adaptador")) {
                        adaptador = linha;
                    }

                    if (linha.contains("IPv4")) {
                        System.out.println(adaptador);
                        System.out.println(linha);
                        System.out.println();
                    }

                } else {

                    if (linha.contains(": ")) {
                        adaptador = linha.split(": ")[1];
                    }

                    if (linha.contains("inet ")) {
                        String[] partes = linha.trim().split(" ");
                        System.out.println("Adaptador: " + adaptador);
                        System.out.println("IPv4: " + partes[1]);
                        System.out.println();
                    }

                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void ping() {

        String sistema = os();

        try {

            Process processo;

            if (sistema.contains("Windows")) {
                processo = Runtime.getRuntime().exec("ping -4 -n 10 www.google.com.br");
            } else {
                processo = Runtime.getRuntime().exec("ping -4 -c 10 www.google.com.br");
            }

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(processo.getInputStream())
            );

            String linha;

            while ((linha = reader.readLine()) != null) {

                if (sistema.contains("Windows")) {

                    if (linha.contains("Média")) {
                        System.out.println(linha);
                    }

                } else {

                    if (linha.contains("avg")) {
                        String[] partes = linha.split("=");
                        String[] valores = partes[1].split("/");
                        System.out.println("Tempo médio: " + valores[1] + " ms");
                    }

                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
