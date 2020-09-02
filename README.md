
# LAB3 - SPRING INTRODUCTION

### Descripción

En este repositorio se encontrará la solución al laboratiorio 3 de ARSW,
encontraremos dos proyectos maven con la solución, estos proyectos
tienen como objetivo dar una introducción a Spring. A continuación se darán
las instrucciones de instalación y las respuestas a los ejercicios.

### Pre requisitos

Para correr el proyecto debe tener instalados los siguientes programas
en su computador:

- Java SE Development Kit 8
- Java SE Runtime Environment 8
- Maven para poder construir el proyecto.
- Git para clonar el repositorio. 

### Instrucciones de instalación

Desde la terminal ejecutar los siguientes comandos:
```
 git clone https://github.com/AlejandroBohal/LAB3-SPRING
 #Para la parte 1 de la implementación#
 cd "CINEMA I" 
 #Para la parte 2 de la implementación#
 cd GRAMMAR-CHECKER
```
compilar el proyecto con el siguiente comando:
```
 mvn package
```
Para correr la solución del problema CINEMA I:
```
mvn exec:java -Dexec.mainClass="edu.eci.arsw.cinema.ui.Main"
```
Para correr la solución al problema GRAMMAR-CHECKER:
```
mvn exec:java -Dexec.mainClass="edu.eci.arsw.springdemo.ui.Main";
```
### Pruebas

Para correr las pruebas usar el siguiente comando.
```
mvn test;
```

# Introduction to Spring and Configuration using annotations

## Part I - Basic workshop 
To illustrate the use of the Spring framework, and the development environment for its use through Maven (and NetBeans), the configuration of a text analysis application will be made, which makes use of a grammar verifier that requires a spelling checker. The grammar checker will be injected, at the time of execution, with the spelling checker required (for now, there are two available: English and Spanish).

1. Open the project sources in NetBeans.

2. Review the Spring configuration file already included in the project (src / main / resources). It indicates that Spring will automatically search for the 'Beans' available in the indicated package.

3. Making use of the Spring configuration based on annotations mark with the annotations @Autowired and @Service the dependencies that must be injected, and the 'beans' candidates to be injected -respectively-:

    * GrammarChecker will be a bean, which depends on something like 'SpellChecker'.
    ![img1](https://media.discordapp.net/attachments/497217237258600449/748245825507033188/unknown.png)

    * EnglishSpellChecker and SpanishSpellChecker are the two possible candidates to be injected. One must be selected, or another, but NOT both (there would be dependency resolution conflict). For now, have EnglishSpellChecker used.
    ![img2](https://media.discordapp.net/attachments/497217237258600449/748245955211427840/unknown.png)
    ![img3](https://media.discordapp.net/attachments/497217237258600449/748246152314486795/unknown.png)
    ![img4](https://media.discordapp.net/attachments/497217237258600449/748246227082280991/unknown.png)

4. Make a test program, where an instance of GrammarChecker is created by Spring, and use it:
  
	La prueba se encuentra en la implementación del proyecto maven en la carpeta test.
