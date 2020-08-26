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