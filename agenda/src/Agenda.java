import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public void removerContato(Contato contato) {
        contatos.remove(contato);
    }

    public Contato buscarContato(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equals(nome)) {
                return contato;
            }
        }
        return null; 
    }

    public void atualizarContato(Contato contato, String novoTelefone, int novaIdade, String novoEndereco) {
        contato.setTelefone(novoTelefone);
        contato.setIdade(novaIdade);
        contato.setEndereco(novoEndereco);
    }

    public void listarContatos() {
        for (Contato contato : contatos) {
            System.out.println("Nome: " + contato.getNome());
            System.out.println("Telefone: " + contato.getTelefone());
            System.out.println("Idade: " + contato.getIdade());
            System.out.println("Endereço: " + contato.getEndereco());
            System.out.println("-----------------------------");
        }
    }

   
}
