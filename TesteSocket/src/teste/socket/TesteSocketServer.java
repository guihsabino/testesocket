package teste.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TesteSocketServer {
	public static void main(String[] args) {
		try {
			System.out.println("Servidor iniciado");
			ServerSocket srv = new ServerSocket(4000);
			System.out.println("Porta 40000 reservada");
			Socket cli = srv.accept();
			System.out.println("Cliente conectado");
			OutputStream out = cli.getOutputStream();
			InputStream in = cli.getInputStream();
			InputStream inputkbd = System.in;
			out.write("Bem vindo ao servidor\n\r".getBytes());
			out.flush();			
			boolean sair = false;
			while( !sair ) {
				//available diz se tem alguma coisa disponnivel pra ser lida
				while (in.available() > 0) { 
					int b = in.read();
				/*	if (b == 27) {
						sair = true;
					} */
					System.out.print((char)b);
				}
				
			/*	while (inputkbd.available() > 0) { 
					int b = inputkbd.read();
					if (b == 27) {
						sair = true;
					}
					out.write(b);
					out.flush();
				} */
			} 
		}  catch (IOException e) {
			e.printStackTrace();
		}	
		System.out.println("Fim do programa");
	}
}