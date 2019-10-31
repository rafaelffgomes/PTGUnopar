package ptgunopar.dynu.net.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encriptar {

    public String EncriptarSenha(String Senha) {
        String NovaSenha = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] bytes = md.digest(Senha.getBytes());
            BigInteger bigInt = new BigInteger(1, bytes);
            NovaSenha = bigInt.toString(16);
            while (NovaSenha.length() < 32) {
                NovaSenha = "0" + NovaSenha;
            }
        } catch (NoSuchAlgorithmException ex) {
        }
        return NovaSenha;
    }
}