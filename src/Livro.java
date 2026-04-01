public class Livro {
    private String nomeDoLivro;
    private int ano;
    private String autor;
    private boolean disponivel;

    public Livro(String nomeDoLivro, int ano, String autor) {
        this.nomeDoLivro = nomeDoLivro;
        this.ano = ano;
        this.autor = autor;
        this.disponivel = true;
    }

    public String getNomeDoLivro() {
        return nomeDoLivro;
    }

    public int getAno() {
        return ano;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void mostrarInfo() {
        System.out.println("Livro: " + getNomeDoLivro() + "\nAutor: " + getAutor() + "\nAno: " + getAno() + "\nDisponivel: " + isDisponivel());
    }

    public boolean emprestar() {
        if (disponivel) {
            disponivel = false;
            return true;
        }
        return false;
    }

    public void devolver() {
        disponivel = true;
    }
}
