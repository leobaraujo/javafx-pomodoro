![JavaFX](https://upload.wikimedia.org/wikipedia/en/c/cc/JavaFX_Logo.png)

# JavaFX Pomodoro

_javafx-pomodoro_ é uma aplicação __desktop__ criada com a linguagem de programação Java e com a ferramenta Scene Builder.

O software permite que o usuário alterne entre dois modos: Foco e descanso. O modo foco tem a duração de 25 minutos, e o modo descanso 5 minutos.

[![License](https://img.shields.io/npm/l/react)](https://github.com/leobaraujo/javafx-pomodoro/blob/main/LICENSE) 

## Tecnologias

- Java 17
- JavaFX
- Scene Builder
- Maven

## Funcionalidades

- Técnica Pomodoro com os modos foco e descanso

## Execução

### Git

> Requisitos: Git e Java 17

```shell
# Clonar o repositório git
git clone https://github.com/leobaraujo/javafx-pomodoro.git

# Entrar na pasta do repositório
cd javafx-pomodoro

# Instalar dependências
mvn clean install

# Build
mvn clean compile package

# Iniciar a aplicação
mvn javafx:run

# Afim de parar a aplicação pressione a tecla CTRL+C no console
```
## Preview

![javafx-pomodoro preview](https://i.ibb.co/WxxcKMv/tinypomodoro.png)
