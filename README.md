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
- Após o início do Debug, em seu navegador acesse as seguintes rotas para o retorno das informações:
	- [http://localhost:8080/{type}](http://localhost:8080/{type})
		```
		/**
		* Caminho utilizado para retornar todos os animes ou mangás
		* 
		* @param String type = Tipo de retorno esperado ( anime / mangá )
		*/
		```

	- [http://localhost:8080/{type}/{id}](http://localhost:8080/{type}/{id})
		```
		/**
		* Caminho utilizado para retornar um anime ou manga específico
		* 
		* @param String type   = Tipo de retorno esperado ( anime / mangá )
		* @param Integer id    = ID do anime/mangá
		*/
		```

	- [http://localhost:8080/{type}/trending](http://localhost:8080/{type}/trending)
		```
		/**
		* Caminho utilizado para retornar os animes ou mangás mais populares
		* 
		* @param String type   = Tipo de retorno esperado ( anime / mangá )
		*/
		```

	- [http://localhost:8080/{type}/{filtering}/{slug}](http://localhost:8080/{type}/{filtering}/{slug})
		```
		/**
		* Caminho utilizado para retornar os animes ou mangás com a utilização de filtros
		* 
		* @param String type       = Tipo de retorno esperado ( anime / mangá )
		* @param String filtering  = Tipo de filtro ( categories / text)
		* @param String slug       = Filtro a ser utilizado
		*/
		```

	- [http://localhost:8080/anime/{id}/episodes](http://localhost:8080/anime/{id}/episodes)
		```
		/**
		* Caminho utilizado para retornar os episódios de um anime
		* 
		* @param Integer id    = ID do anime
		*/
		```

	- [http://localhost:8080/manga/{id}/chapters](http://localhost:8080/manga/{id}/chapters)
		```
		/**
		* Caminho utilizado para retornar os capítulos de um mangá
		* 
		* @param Integer id    = ID do mangá
		*/
		```

#### Agradecimentos
Agradeço à Firedev pela oportunidade em realizar este projeto, e aprimorar meus conhecimentos na linguagem.
Apesar de ter finalizado somente a parte principal do desafio, ainda pretendo realizar o plus para concluir o desafio total nesta linguagem! 😎.