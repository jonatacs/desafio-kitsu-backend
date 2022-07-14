# Desafio Kitsu - Firedev
#### Recursos utilizados
- [Liberica JDK 18](https://bell-sw.com/pages/downloads/)
- [Spring Boot](https://spring.io/projects/spring-boot)

#### Passo a passo para a solução
- Para iniciar o projeto foi utilizado o padrão disponibilizado pelo Spring Boot;
- Após as configurações iniciais, foi construida a estrutura para realizar a comunicação com a API Kitsu;
- Após construída a estrutura, e a comunicação pronta, foi iniciada a construção dos caminhos para busca e retorno dos dados;

#### Estrutura
- A estrutura foi dividida em algumas categorias para facilitar o acesso conforme a necessidade, e estão divididas da seguinte forma:
	- Configs: Contém os arquivos referentes às configurações;
	- Controllers: Contém os arquivos para controle dos dados (Mapeamento das rotas e busca e retorno dos modelos);
	- Models: Contém os arquivos para modelagem dos dados;
	- Services: Contém os arquivos para controle dos serviços executados (Comunicação com a API)

#### Execução do projeto
- Navegue até a pasta src > main > java > Application, abra o arquivo Main.java e inicie o Debug;
- Após o início do Debug, em seu navegador acesse o Swagger UI através deste [link](http://localhost:8080/swagger-ui.html) para ver exemplos e realizar testes das rotas que podem ser utilizadas para retorno de dados;

#### Buscas
- A cada busca realizada, será automaticamente atualizado o banco de dados com a busca efetuada, que podem ser acessadas pela rota correspondente.

#### Agradecimentos
Agradeço à Firedev pela oportunidade em realizar este projeto, e aprimorar meus conhecimentos na linguagem! 😎.