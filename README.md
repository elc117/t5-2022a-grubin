# Estudo de Design Patterns
## Os Design Patterns
Design Patterns são soluções abstratas para problemas em projetos de software. Seu uso é muito útil, uma vez que se tratam de soluções já testadas para problemas corriqueiros no desenvolvimento de software.

Assim, o objetivo desse trabalho é explicar e exemplificar alguns desses Design Patterns (ou Padrões de Projeto) do tipo Criacional. Design Patterns Criacionais ajudam a tornar um sistema independente à medida em que abstraem a instanciação de um objeto de determinada classe.
Os padrões estudados serão o Prototype e o Singleton.

### Prototype
O padrão Prototype é utilizado quando se deseja fazer cópias de objetos existentes.
A idéia aqui é que o próprio objeto possua um método que retorna um novo objeto com os mesmos campos. 
Dessa forma, a atribuição das informações do objeto original para o novo objeto permanecem abstraídas, de forma que o usuário final da classe não precise atribuir os campos individualmente.

#### Implementação
A implementação do Prototype consiste em criar um método responsável pela clonagem na classe que irá gerar os protótipos. Esse método chamará o construtor da classe passando uma referência para o objeto original.
Um exemplo de uso para esse padrão é quando se têm documentos de texto e se deseja criar cópias deles. Assim, um documento pode ser copiado para um novo sem que os atributos sejam acessados pelo cliente.

No exemplo a seguir, temos um código que simula arquivos de texto. Temos uma classe abstrata Document que é estendida pela classe TextDocument.

```java
public class TextDocument extends Document {
    public TextDocument(TextDocument document) {
        super(document);
        this.pags = document.pags;
        this.text = document.text;
    }

    public TextDocument() {

    }

    @Override
    Document clonar() {
        return new TextDocument(this);
    }

    public TextDocument(String text, int pags) {
        super(text, pags);
    }
}
```
Como podemos perceber, o método 'clonar()' chama o construtor da classe 'TextDocument' passando uma referência para o objeto original, e retorna o novo objeto contendo a cópia dos atributos originais.

Exemplo de uso:
```java
public class Main {
    public static void main(String[] args) {
        TextDocument text1 = new TextDocument("Texto 1", 7);

        TextDocument textcopy = (TextDocument) text1.clonar();
        System.out.println(textcopy.text); // Imprime "Texto 1"
        System.out.println(textcopy.pags); // Imprime 7
    }
}
```
Como pode ser visto, o objeto 'text1' foi copiado para o objeto 'textcopy' sem que seus atributos fossem acessados pelo cliente. 

Em outras linguagens de programação, como C++, o uso de Prototype é ainda mais importante, visto que o usuário não tem informações sobre os tipos durante a execução do programa.

### Singleton
O padrão Singleton é utilizado quando se tem uma classe e se deseja que ela seja instanciada uma única vez, não permitindo que vários objetos sejam criados. Além disso, esse objeto único deve ser acessado facilmente em todo o sistema.

Mais uma vez, esse controle não deve ser realizado pelo usuário final da aplicação. Em vez disso, a própria classe deve controlar a criação e acesso ao objeto único.

#### Implementação
O primeiro passo na implementação do Singleton é tornar o construtor da classe privado, dessa forma quem acessar a classe externamente não poderá criar instâncias deliberadamente.

Mas se o construtor for privado, como pode ser criado um objeto?

Para isso, a própria classe deve possuir um método que verifique se ela já foi instanciada. Se não foi, o construtor é chamado e um novo objeto é retornado. Se já existir um objeto, então ele próprio é retornado.

Um exemplo em que o Singleton pode ser usado é em um jogo que possui um boss. Existe uma classe 'Boss' mas só deve existir um chefe no jogo inteiro. Dessa forma, pode-se utilizar o Singleton para controlar a criação desse chefe.

```java
public class Boss {
    private static Boss boss;
    private int hp;

    public Boss getBoss() {
        return boss;
    }

    public int getHp() {
        return hp;
    }

    private Boss(int hp) {
        this.hp = hp;
    }

    static Boss getInstance(int hp) {
        if (boss == null) {
            boss = new Boss(hp);
        }
        return boss;
    }
}
```

Logo de início, podemos notar que o atributo 'boss' e o método 'getInstance()' são do tipo 'static'. Isso significa que eles são informações compartilhadas por toda a classe e não por um objeto, que é exatamente o que se deseja.

A mágica do processo está no método 'getInstance'. Ele verifica se o atributo 'boss' é nulo. Se for nulo, retorna uma chamada para o construtor, que retorna um novo objeto. Se não for nulo, retorna o próprio objeto. Assim, esse método serve tanto como construtor da classe quanto como um meio de acessar o objeto criado.

Exemplo de uso:
```java
public class Main {
    public static void main(String[] args) {
        Boss b1 = Boss.getInstance(100);
        Boss b2 = Boss.getInstance(200);

        System.out.println("Boss 1: " + b1.getHp()); // Imprime 100
        System.out.println("Boss 2: " + b2.getHp()); // Imprime 100

        // Boss b = new Boss(125);
        // System.out.println("Boss 3: " + b3.getHp());
    }

}
```
No código acima, é instanciado um Boss b1 com 100 pontos de HP. Logo em seguida, ocorre uma tentativa de instanciar um novo Boss, b2. Ao imprimir os campos HP dos dois Boss, podemos perceber que ambos possuem HP igual a 100, justamente porque a segunda tentativa de instanciar um Boss retornou o primeiro Boss instanciado.

## Referências
- Padrões de projeto [recurso eletrônico] : soluções reutilizáveis de software orientado a objetos / Erich Gamma ... [et al.] ; tradução Luiz A. Meirelles Salgado. – Dados eletrônicos. – Porto Alegre: Bookman, 2007.
- [Padrões de Projeto | Refactoring Guru](https://refactoring.guru/pt-br/design-patterns/java)
- [Design Patterns // Dicionário do Programador | Código Fonte TV](https://www.youtube.com/watch?v=J-lHpiu-Twk&t=329s&ab_channel=C%C3%B3digoFonteTV)
- [Java Design Patterns](https://java-design-patterns.com/patterns/)

Os códigos de exemplo desenvolvidos estão neste repositório
