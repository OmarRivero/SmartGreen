/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64;
/**
 *
 * @author imanol
 */
public class Seguridad {
    
    private final static String ALG = "AES";
    private final static String CI = "AES/CBC/PKCS5Padding";
    
    private final static String KEY = "92AE31A79FEEB2A3"; // Llave
    private final static String IV = "0123456789ABCDEF"; //Vector de inicializacion
    
    public static String encriptar(String cleartext) throws Exception {
        Cipher cipher = Cipher.getInstance(CI);
        SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes(), ALG);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
        byte[] encrypted = cipher.doFinal(cleartext.getBytes());
        return new String(encodeBase64(encrypted));
    }

    public static String desencriptar(String encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance(CI);
        SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes(), ALG);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
        byte[] enc = decodeBase64(encrypted);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
        byte[] decrypted = cipher.doFinal(enc);
        return new String(decrypted);
    }
}
