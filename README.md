# JUnit_Tests

Bem-vindo ao repositório `JUnit_Tests`! Este repositório é voltado para desenvolvedores que utilizam a JUnit Jupiter API para escrever testes unitários em Java.

## Índice

- [Introdução](#introdução)
- [Instalação](#instalação)
- [Uso](#uso)
- [Contribuições](#contribuições)
- [Licença](#licença)

## Introdução

Este repositório contém exemplos e templates de testes unitários utilizando a JUnit Jupiter API. JUnit é uma biblioteca de testes para Java que permite a criação de testes repetíveis e automatizados para melhorar a qualidade do seu código.

## Instalação

Para usar os exemplos deste repositório, siga os passos abaixo:

1. Clone o repositório:

    ```sh
    git clone https://github.com/seu_usuario/JUnit_Tests.git
    ```

2. Importe o projeto na sua IDE favorita (IntelliJ, Eclipse, etc.).

3. Adicione a dependência do JUnit ao seu `pom.xml` (se você estiver usando Maven):

    ```xml
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.8.2</version>
        <scope>test</scope>
    </dependency>
    ```

## Uso

Os exemplos estão organizados em diretórios com base nas funcionalidades testadas. Você pode executar os testes diretamente da sua IDE ou usando a linha de comando com o Maven:

```sh
mvn test
