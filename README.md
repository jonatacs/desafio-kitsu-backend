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

	- [http://localhost:8080/searches](http://localhost:8080/searches)
		```
		/**
		* Caminho utilizado para retornar as buscas realizadas
		*/
		```

#### Buscas
- A cada busca realizada, será automaticamente atualizado o banco de dados com a busca efetuada.
- Para consultar as buscas mais populares, acesse o banco de dados e execute o código abaixo:
		SELECT s.id, s.type, s.action, s.slug, (SELECT COUNT(se.id) FROM searches AS se WHERE (CASE WHEN se.type IS NOT NULL THEN s.type = se.type ELSE s.type IS NULL END) AND (CASE WHEN se.action IS NOT NULL THEN s.action = se.action ELSE s.action IS NULL END) AND (CASE WHEN se.slug IS NOT NULL THEN s.slug = se.slug ELSE s.slug IS NULL END)) AS counter, (SELECT COUNT(sc.id) FROM searches AS sc) AS max FROM searches AS s GROUP BY s.type, s.action, s.slug ORDER BY counter DESC

- OBS.: Por falta de conhecimento sobre o funcionamento correto do conjunto entre a linguagem, banco de dados e spring boot, não foi possível realizar a busca dentro do projeto, porém ainda estou em busca de como incluir esta busca!

#### Agradecimentos
Agradeço à Firedev pela oportunidade em realizar este projeto, e aprimorar meus conhecimentos na linguagem.
Apesar de ter finalizado somente a parte principal do desafio, ainda pretendo realizar o plus para concluir o desafio total nesta linguagem! 😎.