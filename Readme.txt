Damien Thomé Lutz
Para aumentar a produtividade do desenvolvedores foi criado um ambiente automatizado.
Ambiente de desenvolvimento com livereload e watch para os arquivos JS, HTML e CSS do front-end
e redeploy back-end do Spring ao fazer make project por meio do SpringBoot DevTools no Intellij Idea.
Dessa forma tudo o que o desenvolvedor programa, automaticamente é atualizado no Browser sem precisar manualmente salvar arquivos, reiniciar o servidor da aplicação ou atualizar a página.
Portas reservadas: 8080(back-end), 8081(front-end), 9091(liveserver)


Configuração ambiente de desenvolvimento:

Abrir terminal em Angular_springmvc/angular_ui/node_server
$ node server

Abrir outro terminal em Angular_springmvc/angular_ui/static
$ npm run livereload

Abrir outro terminal em Angular_springmvc/angular_ui/static
$ npm run watch


Abrir projeto no Intellij Idea: Angular_springmvc/springmvc
Rodar arquivo Angular_springmvc/springmvc/src/main/java/hello/Application.java

Acessar aplicação em http://localhost:8081/

Abrir projeto no Intellij Idea: Angular_springmvc/angular_ui