package ulbra.br.APIap2.models;

public class Jogo {
    private long id;
    private int ano;
    private String genero;
    private String estudio;

    public Jogo(long id, int ano, String genero, String estudio) {
        this.id = id;
        this.ano = ano;
        this.genero = genero;
        this.estudio = estudio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }
}
