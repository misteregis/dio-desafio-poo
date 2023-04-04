package br.com.dio.desafio.dominio;

public class Curso extends Conteudo {

    private int cargaHoraria;

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    public Curso(String titulo, String descricao, int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;

        setDescricao(descricao);
        setTitulo(titulo);
    }


    public int getCargaHoraria() {
        return cargaHoraria;
    }

    @Override
    public String toString() {
        return new ClassToString(this).toString();
    }
}
