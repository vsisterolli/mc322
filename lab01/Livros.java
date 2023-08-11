public class Livros {
    private String nome;
    private String autor;
    private String[] generos;
    private String idioma;
    private int edicao;
    private int quantidadeDisponivel;

    public Livros(String nome, String autor, String[] generos, String idioma, int edicao, int quantidadeDisponivel) {
        this.nome = nome;
        this.autor = autor;
        this.generos = generos;
        this.idioma = idioma;
        this.edicao = edicao;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Boolean disponivelParaAlugar() {
        return this.quantidadeDisponivel > 0;
    }

    public void registrarAluguel() throws Exception {
        if(!this.disponivelParaAlugar()) {
            throw new Exception("Esse livro não está disponível para ser alugado");
        }

        this.quantidadeDisponivel--;
    }

    public void devolverLivro() {
        this.quantidadeDisponivel++;
    }

    @Override
    public String toString() {
        return nome + " - " + edicao + " " + autor;
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public String[] getGeneros() {
        return generos;
    }

    public String getIdioma() {
        return idioma;
    }

    public int getEdicao() {
        return edicao;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setGeneros(String[] generos) {
        this.generos = generos;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) throws Exception {
        if(quantidadeDisponivel < 0) {
            throw new Exception("A quantidade disponível não pode ser negativa.");
        }
        this.quantidadeDisponivel = quantidadeDisponivel;
    }
}
