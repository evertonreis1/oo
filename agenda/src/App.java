import java.io.*;
import java.util.List;
import java.util.Scanner;

/* O Botafogo é enorme*/
/* O public static void main ta lá embaixo do código */

public class App {
    private Scanner scanner;
    private Agenda agenda;

    public App() {
        scanner = new Scanner(System.in);
        agenda = new Agenda();
        carregarContatos();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> salvarContatos()));
    }

    public void run() {
        int opcao = 0;
        while (opcao != 6) {
            System.out.println("========= MENU =========");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Remover contat");
            System.out.println("3. Buscar contato");
            System.out.println("4. Atualizar contato");
            System.out.println("5. Listar contatos");
            System.out.println("6. Sair");
            System.out.println("========================");

            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    adicionarContato();
                    break;

                case 2:
                    removerContato();
                    break;

                case 3:
                    buscarContato();
                    break;

                case 4:
                    atualizarContato();
                    break;

                case 5:
                    listarContatos();
                    break;

                case 6:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, digite novamente.");
                    break;
            }

            System.out.println();
        }
    }

    private void adicionarContato() {
        System.out.print("Digite o nome do contato: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o telefone do contato: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite a idade do contato: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Digite o endereço do contato: ");
        String endereco = scanner.nextLine();

        Contato novoContato = new Contato(nome, telefone, idade, endereco);
        agenda.adicionarContato(novoContato);
        System.out.println("Contato adicionado com sucesso!");
    }

    private void removerContato() {
        System.out.print("Digite o nome do contato que deseja remover: ");
        String nomeRemover = scanner.nextLine();
        Contato contatoRemover = agenda.buscarContato(nomeRemover);
        if (contatoRemover != null) {
            agenda.removerContato(contatoRemover);
            System.out.println("Contato removido com sucesso!");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    private void buscarContato() {
        System.out.print("Digite o nome do contato que deseja buscar: ");
        String nomeBuscar = scanner.nextLine();
        Contato contatoEncontrado = agenda.buscarContato(nomeBuscar);
        if (contatoEncontrado != null) {
            System.out.println("Contato encontrado:");
            System.out.println("Nome: " + contatoEncontrado.getNome());
            System.out.println("Telefone: " + contatoEncontrado.getTelefone());
            System.out.println("Idade: " + contatoEncontrado.getIdade());
            System.out.println("Endereço: " + contatoEncontrado.getEndereco());
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    private void atualizarContato() {
        System.out.print("Digite o nome do contato que deseja atualizar: ");
        String nomeAtualizar = scanner.nextLine();
        Contato contatoAtualizar = agenda.buscarContato(nomeAtualizar);
        if (contatoAtualizar != null) {
            System.out.print("Digite o novo telefone do contato: ");
            String novoTelefone = scanner.nextLine();
            System.out.print("Digite a nova idade do contato: ");
            int novaIdade = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Digite o novo endereço do contato: ");
            String novoEndereco = scanner.nextLine();

            agenda.atualizarContato(contatoAtualizar, novoTelefone, novaIdade, novoEndereco);
            System.out.println("Contato atualizado com sucesso!");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    private void listarContatos() {
        System.out.println("====== LISTA DE CONTATOS ======");
        List<Contato> contatos = agenda.getContatos();
        if (contatos.isEmpty()) {
            System.out.println("A agenda está vazia.");
        } else {
            for (Contato contato : contatos) {
                System.out.println("Nome: " + contato.getNome());
                System.out.println("Telefone: " + contato.getTelefone());
                System.out.println("Idade: " + contato.getIdade());
                System.out.println("Endereço: " + contato.getEndereco());
                System.out.println("-----------------------------");
            }
        }
    }

    private void carregarContatos() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("contatos.dat"))) {
            List<Contato> contatos = (List<Contato>) inputStream.readObject();
            agenda.setContatos(contatos);
            System.out.println("Contatos carregados do arquivo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Não foi possível carregar os contatos do arquivo.");
        }
    }

    /* nao sei o porqueê de nao estar salvando no documento contatos.dat mas tudo bem */
    private void salvarContatos() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("contatos.dat"))) {
            outputStream.writeObject(agenda.getContatos());
            System.out.println("Contatos salvos no arquivo.");
        } catch (IOException e) {
            System.out.println("Não foi possível salvar os contatos no arquivo.");
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
