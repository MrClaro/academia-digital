<h1> Projeto Spring Data JPA de uma academia de ginástica </h1>

<hr>

<h2>🎯 Objetivo do Projeto</h2>
<p> Aplicar os conhecimentos adquiridos ao longo do <strong>Bootcamp Spring Boot disponibilizado</strong>  pela <a href="https://dio.me/"><strong> Digital Innovation One</strong></a>, em meio ao projeto foram aplicados os principais conceitos de mapeamento objeto relacional (ORM) usando o <strong>Spring Data JPA</strong>. Para isso, uma <strong>API RESTful</strong> foi desenvolvida com ênfase na modelagem de suas entidades, no domínio de uma academia de ginástica.</p>

<h2>🛠 Tecnologias Utilizadas</h2>

<ul>
    <li>IDE IntelliJ</li>
    <li>Java 11</li>
    <li>Maven</li>
    <li><strong>Spring Web</strong></li>
    <li><strong>Spring Data JPA</strong></li>
    <li><strong>PostgreSQL Driver</strong></li>
    <li><strong>Hibernate Validator</strong></li>
    <li>Lombok</li>
    <li>Postman</li>
</ul>

<hr>

<h2> 🚦 Guia </h2>
<p>Para a execução do projeto, algumas ferramentas devem estar instaladas e já pré-configuradas, sendo estas:</p>

<ol>
    <li> PostgreSQL </li>
    <li> JDK </li>
    <li> Postman (Sua utilização é obrigatória para a realização de alguns verbos HTTP) </li>
    <li> Maven </li>
</ol>


<h2> Endpoints da Aplicação </h2>

>Utilize o Postman para poder realizar a utilizaçào de todos os verbos HTTP.

<h3>Alunos</h3>

>POST - /alunos - deve-se passar o corpo da requisição seguindo o seguinte formato:

        
        {   "nome": "###",
            "cpf": "###.###.###-##", 
            "bairro": "###", 
            "dataDeNascimento": "##/##/####" }
        
>PUT - /alunos/atualizar - para efetuar a atualização deve-se passar o corpo da requisição seguindo o seguinte formato:

        {   "nome": "####",
            "bairro": "####",
            "dataDeNascimento": "##/##/####" }

>GET - /alunos - irá retornar todos os alunos listados.

>GET - /alunos/{id} - irá retornar somente o aluno pertencente ao id.

>GET - /alunos com parâmetros - como parâmetros de consulta, é possivel informar a dataDeNascimento do aluno que deseja buscar.

>DELETE - /alunos/{id} - Irá excluir o aluno referente ao id aluno.
>  > Para utilizar diretamente por este método, é necessário que ele não tenha uma matrícula vinculada a ele, assim, ao deletar o aluno, suas avaliações vinculadas serão excluidas junto.

<h3>Avaliação Física</h3>

>POST - /avaliacoes - deve-se passar o corpo da requisição seguindo o seguinte formato, sendo a altura informada em Cm, ex: 171.0:


        {   "alunoId" : #,
            "peso" : ##.#,
            "altura" : ###.# }


>PUT - /avaliacoes/{id} - para efetuar a atualização deve-se passar o corpo da requisição seguindo o seguinte formato:

        {   "altura" : ###.#,
            "peso" : ##.#  }

>GET - /avaliacoes - irá retornar todas as avaliações criadas e seus respectivos alunos.

>GET - /avaliacoes/{id} - irá retornar somente a avaliação pertencente ao id.

>DELETE - /avaliacoes/{id} - irá deletar a avaliação referente ao id.


<h3>Matrícula</h3>

>POST - /matriculas - deve-se passar o corpo da requisição seguindo o seguinte formato, sendo a altura informada em Cm, ex: 171.0:


        {  "alunoId" : # }

>GET - /matriculas - irá retornar todas as matriculas criadas e seus respectivos alunos.

>GET - /matriculas/{id} - irá retornar somente a avaliação pertencente ao id.

>GET - /alunos com parâmetros - como parâmetros de consulta, é possivel informar a bairro do aluno que deseja buscar.

>DELETE - /matriculas/{id} - irá deletar a avaliação referente ao id.
> > A exclusão da matricula, já apaga por usa vez o aluno ligado a ela, bem como as avaliações ligadas ao aluno.

<h2>🔗 Links Úteis</h2>
<ul>
    <li><a href="https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/common-application-properties.html">Common application properties</a></li>
    <li><a href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.repositories">Spring Data JPA - Reference Documentation</a></li>
    <li><a href="https://strn.com.br/artigos/2018/12/11/todas-as-anotações-do-jpa-anotações-de-mapeamento/">Anotações do JPA</a> </li>
</ul>


<h2> 🤝 Contribuindo </h2>

Este repositório foi criado para fins de estudo, então contribua com ele.
Se possível:

⭐️  Star o projeto

🐛 Encontrar e relatar issues

<hr>



