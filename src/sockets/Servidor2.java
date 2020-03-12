package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor2 {

    public static void main(String[] args) throws IOException {
    FileUtility util = new FileUtility();

        System.out.println("== Servidor ==");

        // Configurando o socket
        ServerSocket serverSocket = new ServerSocket(7001);
        Socket socket = serverSocket.accept();

        // pegando uma referência do canal de saída do socket. Ao escrever nesse canal, está se enviando dados para o
        // servidor
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        // pegando uma referência do canal de entrada do socket. Ao ler deste canal, está se recebendo os dados
        // enviados pelo servidor
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        // laço infinito do servidor
        while (true) {
            System.out.println("Cliente: " + socket.getInetAddress());

            String mensagem = dis.readUTF();
            System.out.println(mensagem);

//            ler arquivos
            if (mensagem.equals("readdir")){
                String res = Utils.print(util.listFiles(new ArrayList()));
                dos.writeUTF(res);
            }
//            renomear arquivos
            if (mensagem.equals("rename")){

                dos.writeUTF("Digite o nome antigo");

                String antigo = dis.readUTF();

                dos.writeUTF("Digite o novo nome");

                String novo = dis.readUTF();

                if(util.renameFile(antigo, novo)){
                    dos.writeUTF("Arquivo renomeado com sucesso");
                }
                else{
                    dos.writeUTF("Falha ao renomear. Crie o arquivo não encontrado: " + antigo);
                }
            }
//            criar arquivo
            if (mensagem.equals("create")){
                dos.writeUTF("Digite o nome do novo arquivo");
                String novoArquivo = dis.readUTF();
                if (util.createFile(novoArquivo))
                    dos.writeUTF("Arquivo criado com sucesso");
                else
                    dos.writeUTF("Falha ao criar o arquivo. Arquivo já existe");
            }
//            deletar arquivo
            if (mensagem.equals("delete")){
                dos.writeUTF("Digite o nome do arquivo a deletar");
                String arquivoDeletado = dis.readUTF();
                if (util.deleteFile(arquivoDeletado))
                    dos.writeUTF("Arquivo deletado com sucesso");
                else
                    dos.writeUTF("Falha ao deletar o arquivo. Arquivo não existe");
            }
            else {
                dos.writeUTF("Não entendi a sua mensagem: " + mensagem);
            }
        }

    }
}
