abstract class ItemBibliotecaDigital {
    protected String titulo;
    protected String autor;

    public ItemBibliotecaDigital(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public abstract String descricao();
}

interface Baixavel {
    void baixar();
}

interface Visualizavel {
    void visualizar();
}

class Ebook extends ItemBibliotecaDigital implements Baixavel {
    private String formato;

    public Ebook(String titulo, String autor, String formato) {
        super(titulo, autor);
        this.formato = formato;
    }

    @Override
    public String descricao() {
        return "Ebook: " + titulo + " - Autor: " + autor + " - Formato: " + formato;
    }

    @Override
    public void baixar() {
        System.out.println("Baixando o ebook " + titulo + "...");
        // Implementação do download
        System.out.println("Download do ebook " + titulo + " concluido!");
    }
}

class VideoDigital extends ItemBibliotecaDigital implements Baixavel, Visualizavel {
    private String qualidade;

    public VideoDigital(String titulo, String autor, String qualidade) {
        super(titulo, autor);
        this.qualidade = qualidade;
    }

    @Override
    public String descricao() {
        return "Vídeo: " + titulo + " - Autor: " + autor + " - Qualidade: " + qualidade;
    }

    @Override
    public void baixar() {
        System.out.println("Baixando o video " + titulo + "...");
        // Implementação do download
        System.out.println("Download do video " + titulo + " concluido!");
    }

    @Override
    public void visualizar() {
        System.out.println("Visualizando o video " + titulo + "...");
        // Implementação da visualização
        System.out.println("Visualização do video " + titulo + " concluida!");
    }
}

public class Main {
    public static void main(String[] args) {
        Ebook ebook1 = new Ebook("Livro1", "Autor1", "PDF");
        VideoDigital video1 = new VideoDigital("Video1", "Autor2", "MP4");
        Ebook ebook2 = new Ebook("Livro2", "Autor3", "PDF");

        System.out.println(ebook1.descricao());
        System.out.println(video1.descricao());
        System.out.println(ebook2.descricao());

        ebook1.baixar();
        ebook2.baixar();

        video1.visualizar();
    }
}
