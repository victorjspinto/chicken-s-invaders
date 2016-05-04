[![Build Status](https://travis-ci.org/lordviktor/chicken-s-invaders.svg?branch=master)](https://travis-ci.org/lordviktor/chicken-s-invaders)

# chicken-s-invaders

Trabalho que desenvolvi no primeiro semestra na UFF na disciplina de Prog1. Esse projeto utiliza o framework [JPlay](http://www2.ic.uff.br/jplay/index.html) que a UFF usa para ensinar o desenvolvimento de m primeiro joguinho, que é o trabalho de conclusão desta disciplina. 



### Estrutura do projeto

O legal deste projeto foi subir o nível de abstração no momento de desenvolver um jogo. O layout dessas classes foram feitas seguindo como exemplo o XNA GameStudio. Assim, operações comuns como atualizar posição dos objetos na tela, implementar o gameloop controlando a quantidade de FPS e outras... são feitas automáticamente pelo framework. Assim o trabalho final do desenvolvedor é somente implementar essas classes providas por esse framework customizado, que chamei de **Custom JPlay**.

A estrutura de projeto hoje é a seguinte.

> custom-jplay

Contém todos as classes que implementei extendendo o comportamento do JPlay. Assim, lógicas que podem ser reaproveitadas entre projetos ficam aqui.

> chickens-invaders-java

Projeto contendo o chickens invaders, jogo que utiliza o framework que implementei =)


### Como rodar o projeto

Para rodar o projeto pode ser usado o seguinte comando abaixo na pasta ```chickens-invaders-java```.

```
mvn exec:java
```
Ou rodar o comando abaixo com o jar gerado.
```
java -jar chickens-invaders-jar/target/chickens-invaders-jar-1.0.0-SNAPSHOT.jar
```
