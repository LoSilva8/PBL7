import java.util.Scanner;

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
        System.out.println("Download do ebook " + titulo + " concluído!");
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
        System.out.println("Baixando o vídeo " + titulo + "...");
        System.out.println("Download do vídeo " + titulo + " concluído!");
    }

    @Override
    public void visualizar() {
        System.out.println("Visualizando o vídeo " + titulo + "...");
        System.out.println("Visualização do vídeo " + titulo + " concluída!");
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

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEscolha uma opção para o ebook1:");
        System.out.println("1. Baixar");
        System.out.println("2. Visualizar");
        int opcao = scanner.nextInt();

        if (opcao == 1) {
            ebook1.baixar();
        }

        System.out.println("\nEscolha uma opção para o ebook2:");
        System.out.println("1. Baixar");
        System.out.println("2. Visualizar");
        opcao = scanner.nextInt();

        if (opcao == 1) {
            ebook2.baixar();
        }

        System.out.println("\nEscolha uma opção para o vídeo1:");
        System.out.println("1. Baixar");
        System.out.println("2. Visualizar");
        opcao = scanner.nextInt();

        if (opcao == 1) {
            video1.baixar();
        } else if (opcao == 2) {
            video1.visualizar();
        }
    }
}
