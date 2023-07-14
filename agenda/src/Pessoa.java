public class Pessoa {
    protected String nome;
    protected String telefone;
    protected int idade;
    protected String endereco;

    public Pessoa(String nome, String telefone, int idade, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.idade = idade;
        this.endereco = endereco;
    }

   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
