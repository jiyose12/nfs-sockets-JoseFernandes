# nfs-sockets-JoseFernandes
Projeto que consiste na criação de um simples sistema de arquivos distribuídos

NFS é um sistema de arquivos distribuídos. Nele, como pode ser visto na imagem abaixo, é possível que um cliente se comunique com o sistema servidor para realizar operações nos arquivos remotos, tais como renomear, criar, remover e ler o conteúdo de uma pasta.

Sua missão é desenvolver, utilizando Sockets, um NFS (básico, sem todos os elementos mostrados nesta imagem), e implementar as seguintes operações (há muito mais, porém, só implementaremos essas):

* readdir: devolve o conteúdo de um diretório (lista de nomes)
* rename: renomeia um arquivo
* create: cria um arquivo
* remove: remove um arquivo

Lembre-se que, diferentemente do exemplo de cliente-servidor que trabalhamos em sala, você não vai fechar a comunicação com o cliente (dar um close no socket). O canal ficará aberto, e o cliente enviará comandos, e o servidor devolverá a resposta. No caso do readdir, por exemplo, o servidor devolverá a lista de arquivos de uma pasta. Já o rename, por exemplo, o servidor apenas alterará o nome de um arquivo, mas não precisará devolver qualquer texto para o cliente. Se o cliente quiser saber se realmente houve a mudança de nome, executa novamente o readdir.

Como sugestão, implemente o servidor, inicialmente, com uma lista de arquivos em memória e faça todas as operações em cima dessa lista (List<String> arquivos). O foco é trabalhar com Sockets, suas facilidades e complexidades para comunicar duas máquinas em rede. Após tudo estar funcionando, é que você, de fato, executa o comando no sistema de arquivos do servidor. Para aprender como trabalhar com arquivos em Java, um bom recurso é esse texto do site da Caelum (apesar de antigo o ano de publicação, o assunto está bem explicado): https://blog.caelum.com.br/evolucao-do-java-io-ao-ni/. Outro bom recurso para aprender como lidar com arquivos, em Java, encontra-se aqui: https://www.baeldung.com/java-nio-2-file-api
