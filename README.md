## Projeto de Agenda de Contatos

O projeto consiste em uma agenda de contatos implementada em Java, seguindo os princípios da Programação Orientada a Objetos (POO). A agenda permite adicionar, remover, buscar e atualizar contatos, além de listar todos os contatos armazenados.

### Encapsulamento

- A classe `Pessoa` representa uma entidade genérica com atributos como nome, telefone, idade e endereço.
- Foram utilizados métodos getters e setters para acessar e modificar os valores dos atributos.
- O conceito de encapsulamento foi aplicado, mantendo os atributos como privados e fornecendo métodos públicos para acessá-los.

### Herança

- A classe `Contato` herda da classe `Pessoa`, estabelecendo uma relação de herança.
- A herança permite que a classe `Contato` tenha os mesmos atributos e métodos da classe `Pessoa`, além de adicionar funcionalidades específicas, se necessário.

### Composição

- A classe `Agenda` é responsável por gerenciar a lista de contatos.
- Foi utilizada uma lista de objetos `Contato` como atributo da classe.
- Os contatos podem ser adicionados, removidos, buscados e atualizados na agenda.
- Métodos como `listarContatos` permitem exibir todos os contatos da agenda.
- A agenda é serializada, permitindo que os contatos sejam salvos em um arquivo e posteriormente carregados.

### Métodos de Acesso (Getters e Setters)

- Métodos de acesso (getters e setters) foram utilizados para manipular os atributos das classes `Pessoa` e `Contato`.

### Construtores

- Construtores foram implementados para inicializar os objetos com valores específicos.

### Serialização

- A funcionalidade de serialização foi utilizada para salvar e carregar os contatos da agenda em um arquivo.

O uso dessas teorias e conceitos de POO no projeto permitiu uma estrutura organizada e modular, promovendo a reutilização de código, facilitando a manutenção e oferecendo uma interface simples para interagir com a agenda de contatos.
