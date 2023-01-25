import java.io.FileInputStream;
import java.security.MessageDigest;

public class U5Exemple2_SHA {
    public static void main(String[] args) throws Exception{
        MessageDigest md = MessageDigest.getInstance("SHA");

        FileInputStream fis = new FileInputStream("fichero.txt");
        
        byte[] dataBytes = new byte[1024];
        int nread=0;
        System.out.println("Contenido del fichero: ");
        while((nread =fis.read(dataBytes)) != -1){
            System.out.println(new String(dataBytes));
            md.update(dataBytes);
        }
        byte[] mdbytes = md.digest();
        System.out.println("Numero de bytes " + md.getDigestLength());
        System.out.println("Algoritmo " + md.getAlgorithm());
        System.out.println("Mensaje resumen " + new String(mdbytes));
        
        StringBuffer hexString = new StringBuffer();


    }
}
