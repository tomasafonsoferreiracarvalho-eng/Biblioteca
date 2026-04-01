import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Livro> livros;
    private Scanner keyb;

    public Biblioteca() {
        livros = new ArrayList<>();
        usuarios = new ArrayList<>();
        keyb = new Scanner(System.in);
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("----- MENU -----");
            System.out.println("1 - Criar usuário");
            System.out.println("2 - Adicionar livro");
            System.out.println("3 - Listar livros");
            System.out.println("4 - Emprestar livro");
            System.out.println("5 - Devolver livro");
            System.out.println("6 - Mostrar informações de um livro");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = keyb.nextInt();
            keyb.nextLine(); // limpar ENTER
            switch (opcao) {
                case 1:
                    criarUsuario();
                    break;
                case 2:
                    adicionarLivro();
                    break;
                case 3:
                    listarLivros();
                    break;
                case 4:
                    emprestarLivro();
                    break;
                case 5:
                    devolverLivro();
                    break;
                case 6:
                    mostrarInfoLivro();
                    break;
                case 0:
                    System.out.println("A sair...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }

    public void criarUsuario() {
        System.out.println("Digite seu nome: ");
        String nome = keyb.nextLine();
        Usuario u = new Usuario(nome);
        usuarios.add(u);
        u.apresentar();
    }

    public void adicionarLivro() {
        System.out.println("-----Adicionar livro-----");
        System.out.println("Nome do Livro: ");
        String nomeDoLivro = keyb.nextLine();
        System.out.println("Ano do Livro: ");
        int anoDoLivro = keyb.nextInt();
        keyb.nextLine();
        System.out.println("Autor do Livro: ");
        String autorDoLivro = keyb.nextLine();
        Livro l1 = new Livro(nomeDoLivro, anoDoLivro, autorDoLivro);
        livros.add(l1);
        System.out.println("Livro adicionado com sucesso!");
    }

    public void listarLivros() {
        System.out.println("----- Lista de Livros -----");
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        for (int i = 0; i < livros.size(); i++) {
            Livro l = livros.get(i);
            System.out.println((i + 1) + " - " + l.getNomeDoLivro()
                    + " (" + l.getAno() + ") - " + l.getAutor()
                    + " - " + (l.isDisponivel() ? "Disponível" : "Emprestado"));

        }
    }

    public void emprestarLivro() {
        listarLivros();
        if (livros.isEmpty()) return;
        System.out.println("Escolha o número do livro para emprestar:");
        int escolha = keyb.nextInt();
        keyb.nextLine();
        if (escolha < 1 || escolha > livros.size()) {
            System.out.println("Opção inválida.");
            return;
        }
        Livro l = livros.get(escolha - 1);
        if (l.emprestar()) {
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Este livro já está emprestado.");
        }
    }

    public void devolverLivro() {
        listarLivros();
        if (livros.isEmpty()) return;
        System.out.println("Escolha o número do livro para devolver:");
        int escolha = keyb.nextInt();
        keyb.nextLine();
        if (escolha < 1 || escolha > livros.size()) {
            System.out.println("Opção inválida.");
            return;
        }
        Livro l = livros.get(escolha - 1);
        if (l.isDisponivel()) {
            System.out.println("Este livro já está disponível.");
        } else {
            l.devolver();
            System.out.println("Livro devolvido com sucesso!");
        }
    }

    public void mostrarInfoLivro() {
        listarLivros();
        if (livros.isEmpty()) return;
        System.out.println("Escolha o número do livro para ver detalhes:");
        int escolha = keyb.nextInt();
        keyb.nextLine();
        if (escolha < 1 || escolha > livros.size()) {
            System.out.println("Opção inválida.");
            return;
        }
        Livro l = livros.get(escolha - 1);
        l.mostrarInfo();
    }

}

