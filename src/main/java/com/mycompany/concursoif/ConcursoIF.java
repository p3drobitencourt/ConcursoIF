/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.concursoif;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author pedro
 */
public class ConcursoIF {

    public static void main(String[] args) {
        String arquivoCSV = "caminho/do/seu/arquivo.csv"; // Defina o caminho do seu arquivo CSV
        String linha;
        List<Candidato> candidatos = new ArrayList<>();

        // Leitura do arquivo CSV
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split("\t"); // Assumindo que o separador seja TAB
                int identificador = Integer.parseInt(dados[0]);
                String nome = dados[1];
                String dataNascimento = dados[2];
                int nota = Integer.parseInt(dados[3]);

                Candidato candidato = new Candidato(identificador, nome, dataNascimento, nota);
                candidatos.add(candidato);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ordena a lista de candidatos
        Collections.sort(candidatos);

        // Imprime os candidatos ordenados
        for (Candidato candidato : candidatos) {
            System.out.println(candidato);
        }
    }
}
