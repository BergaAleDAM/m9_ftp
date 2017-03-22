package m9_ftp;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTP;

public class M9_ftp {

    public static void main(String[] args) {
        
        try {
            String server = "ftp.uv.es";
            String server2 = "ftp.m06uf3.esy.es";
            int port = 21;
			
            String user = "anonymous";            
            String pass = "anonymous";
			
            String user2 = "u454499351.user";
            String pass2 = "user1234";
			
            String ruta = "prova_alejandroB.txt"; //Modificar NOM amb el vostre nom
            
                //PRIEMRA PROVA
            ClientFTP client = new ClientFTP(server2, port, user2, pass2);
            
            //Listamos los directorios que hay
            for (String arg : client.listar()) {
                System.out.println(arg);
            }
	
            client.setDirectorio("pub");//nos metemos en la carpeta pub
        
            for (String arg : client.listar()) {
                System.out.println(arg);
            }//Esto lo hago para ver lo que hay dentro
	
            
            client.enviarFichero(ruta);//Metemos el fichero
        
            for (String arg : client.listar()) {
                System.out.println(arg);
            }//Y para comprobar que lo he metido bien
            
            
            client.activarEnvio();//Lo ponemos en modo binario
            
            String ficheroDescarga = "BaixarFitxer.txt";
            client.baixarFitxer(ficheroDescarga);//Con esto descargamos 
	
            
            client.cerrarSesion();            
            client.desconectarServidor();
                //Y aqui pues basicamente cerramos las conexiones
            
        } catch (IOException ex) {
            Logger.getLogger(M9_ftp.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    
}
