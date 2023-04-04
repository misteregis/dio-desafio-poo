package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Mentoria extends Conteudo {

    private LocalDate data;

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    public Mentoria(String titulo, String descricao) {
        this.data = LocalDate.now();

        setDescricao(titulo);
        setTitulo(titulo);
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return new ClassToString(this).toString();
    }
}
