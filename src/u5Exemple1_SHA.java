import java.security.MessageDigest;
import java.security.Provider;

public class u5Exemple1_SHA {
    public static void main(String[] args) throws Exception {
        String texto = "Soy el contido del texto";
        System.out.println("Texto de origen para un hash " + texto);

        MessageDigest md = MessageDigest.getInstance("SHA");

        String clave = "Clavecifrada";

        byte datosBytes[] = texto.getBytes();
        md.update(datosBytes);

        byte resum_amb_clau[] = md.digest(clave.getBytes());

        md.update(texto.getBytes());

        byte resum[] = md.digest();

        System.out.println("Numero de bytes " + md.getDigestLength());
        System.out.println("Algoritmo " + md.getAlgorithm());
        System.out.println("Mensaje resumen " + resum_amb_clau + new String(resum));

        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < resum.length; i++) {
            String hex = Integer.toHexString(0xff & resum[i]);
            if (hex.length() == 1) {
                hexString.append('0');
                hexString.append(hex);
            }
        }

        System.out.println("Mensaje en hexadecimal: " + hexString.toString());
        Provider proveedor = md.getProvider();
        System.out.println("Proveedor " + proveedor.toString());
    }
}
