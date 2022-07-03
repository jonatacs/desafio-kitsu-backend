package Application.Configs;

public class Config {
	// Define a url para as requests na API Kitsu
	public static final String kitsuUrl = "https://kitsu.io/api/edge";

	// Define a página padrão exibida em tela ao entrar na API sem nenhum tipo de filtro
	public static final String defaultBody = "<div style=\"display: flex; justify-content: center; align-items: center;\">" +
												"Leia o arquivo Readme.md para informações sobre os caminhos utilizados para o retorno de dados." +
											"</div>";
}
