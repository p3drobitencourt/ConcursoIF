/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
class Candidato implements Comparable<Candidato> {
    private int identificador;
    private String nome;
    private LocalDate dataNascimento;
    private int nota;

    public Candidato(int identificador, String nome, String dataNascimento, int nota) {
        this.identificador = identificador;
        this.nome = nome;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataNascimento = LocalDate.parse(dataNascimento, formatter);
        this.nota = nota;
    }

    public int getNota() {
        return nota;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public int compareTo(Candidato outro) {
        // Primeiro, compara as notas
        if (this.nota != outro.nota) {
            return Integer.compare(outro.nota, this.nota); // Ordem decrescente das notas
        }
        // Em caso de empate, compara a idade (mais velho vem primeiro)
        return this.dataNascimento.compareTo(outro.dataNascimento); // Mais velho -> menor data
    }

    @Override
    public String toString() {
        return identificador + " - " + nome + " - " + dataNascimento + " - " + nota;
    }
}
