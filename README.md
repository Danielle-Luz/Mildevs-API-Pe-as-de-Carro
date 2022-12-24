<h1 align="center">API REST de peças de carro</h1>

<p align="center">
    <img alt="Badge indicando que o projeto foi criado em dezembro de 2022" src="https://img.shields.io/badge/Data%20de%20cria%C3%A7%C3%A3o-Dezembro%2F2022-blue">
    <img alt="Badge indicando que o status do projeto é 'concluído'" src="https://img.shields.io/badge/Status-Concluído-yellow">
</p>

<p align="center">
    • <a href="#descricao">Descrição</a>
    • <a href="#Como acessar">Como acessar?</a>
    • <a href="#endpoints">Endpoints</a>
    • <a href="#tecnologias">Tecnologias</a>
    • <a href="#Desenvolvedora">Desenvolvedora</a>
</p>


<h2 id="descricao">:pencil2: Descrição</h2>
Essa é uma API REST genérica desenvolvida como exercício da academia de programação 1000devs visando a prática de conhecimentos acerca de spring, maven, JPA, API's REST e banco de dados, ela permite o cadastramento, atualização e busca por peças de carro.

<h2 id="Como acessar"> :computer_mouse: Como acessar?</h2>

### Instalação
Para rodar o sistema é preciso instalar as dependências do projeto e rodar o projeto.

### Requisitos

* Git bash.
  * <a href="https://git-scm.com/book/pt-br/v2/Come%C3%A7ando-Instalando-o-Git">Como instalar o git bash</a>
* Apache maven
  * <a href="https://maven.apache.org/download.cgi">Como instalar o Maven</a>

### Instruções para executar a API localmente

1. Copiar URL ou chave SSH do repositório.
2. Obter uma cópia do repositório na sua máquina.

```
git clone https://github.com/Danielle-Luz/Mildevs-API-Pecas-de-Carro.git
```
3. Abrir o git bash na pasta clonada e executar o comando a seguir para instalar as dependências do projeto:

```
mvn install
```
4. Executar a aplicação por meio do botão de execução da sua IDE ou por meio do comando:

```
mvn spring-boot:run
```

### Qual a base URL pra fazer as requisições?
Faça requisições para a API por meio da base URL do projeto: http://localhost:8080/pecas/

<h2 id="endpoints">:hammer: Endpoints</h2>

### Criação de peças (POST)
O cadastramento de uma peça é feito por meio de uma requisição `POST` na base URL.

#### Formato da requisição
```
{
	"nome": "Chassi",
	"modeloCarro": "Sedan",
	"fabricante": "Júlio Carros",
	"precoCusto": 500,
	"precoVenda": 1000,
	"quantidadeEstoque": 400,
	"categoria": "FUNILARIA"
}
```

### Atualização de peças (PATCH)
A atualização de uma peça é feita por meio de uma requisição `PATCH` na base URL junto com o id da peça a ser atualizada ao fim. No corpo da requisição vão os novos dados.
Apenas o custo, o preço de venda e a quantidade em estoque podem ser atualizados.

#### Rota
Nesse exemplo, a peça com id cujo valor é 1 é atualizada.
```
http://localhost:8080/pecas/{id}
http://localhost:8080/pecas/1
```

#### Formato da requisição
```
{
	"precoCusto": 200,
	"precoVenda": 500,
	"quantidadeEstoque": 100
}
```

### Listagem de peças (GET)

#### Todas as peças cadastradas
Para exibir todas as peças, basta dar um GET na base URL da api.

#### Peças com uma dada categoria
```
http://localhost:8080/pecas/{categoria_buscada}/categoria
```
- Retorna todas as peças com a categoria buscada.
- As categorias que podem ser buscadas são: `FUNILARIA` `MOTOR`, `PERFORMANCE` e `SOM`.
- A categoria buscada deve estar em letras maiúsculas.
- No exemplo abaixo, todas as peças com a categoria "FUNILARIA" são exibidas.

  ```
  http://localhost:8080/pecas/FUNILARIA/categoria
  ```

#### Peças cujos nomes começam com a palavra especificada
```
http://localhost:8080/pecas/{palavra_buscada}/comeco
```
* Retorna todas as peças cujos nomes começam com a palavra buscada, a busca não é case sensitive.
* No exemplo abaixo, todas as peças cujos nomes começam com a letra "m" são exibidas.

  ```
  http://localhost:8080/pecas/m/comeco
  ```

#### Peças com um dado modelo de carro
```
http://localhost:8080/pecas/{modelo_buscado}/modelo
```
* Retorna todas as peças cujos modelos de carro são iguais ao modelo buscado, a busca não é case sensitive.
* No exemplo abaixo, todas as peças cujos modelos de carro correspondem a "sedan" são exibidas.

  ```
  http://localhost:8080/pecas/sedan/modelo
  ```

#### Modelo de response
Em todas as requisições GET, o preço de custo não é exibido.
```
[
	{
		"id": 1,
		"nome": "Motor",
		"modeloCarro": "Sedan",
		"fabricante": "Brave Car",
		"precoVenda": 1000.0,
		"quantidadeEstoque": 30,
		"categoria": "MOTOR"
	},
	{
		"id": 2,
		"nome": "Rádio",
		"modeloCarro": "Sedan",
		"fabricante": "Road Sound",
		"precoVenda": 100.0,
		"quantidadeEstoque": 50,
		"categoria": "SOM"
	}
]
```

<h2 id="tecnologias">:computer: Tecnologias</h2>
<p align="center">
  JPA | Maven | Spring Boot | PostgreSQL
</p>

<h2 id="Desenvolvedora">:woman: Desenvolvedora</h2>

<p align="center">
  <a href="https://github.com/Danielle-Luz">
    <img width="120px" src="https://avatars.githubusercontent.com/u/99164019?v=4" alt="foto de uma mulher parda com o cabelo castanho, sorrindo levemente na frente de um fundo verde com bits">
  </a>
</p>
<p align="center">
Danielle da Luz Nascimento
</p>
<p align="center">
<a href="https://www.linkedin.com/in/danielle-da-luz-nascimento/">@Linkedin</a>
</p>
