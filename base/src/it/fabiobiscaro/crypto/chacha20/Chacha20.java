package it.fabiobiscaro.crypto.chacha20;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.ChaCha20ParameterSpec;

public class Chacha20 {

	private static final String ENCRYPT_ALGO = "ChaCha20";

    public byte[] encrypt(byte[] pText, SecretKey key, byte[] nonce, int counter) throws Exception {

        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO); // Si può scegliere l'algoritmo che si preferisce

        ChaCha20ParameterSpec param = new ChaCha20ParameterSpec(nonce, counter);

        cipher.init(Cipher.ENCRYPT_MODE, key, param);

        byte[] encryptedText = cipher.doFinal(pText); // Esegue l'operazione impostata

        return encryptedText;
    }

    public byte[] decrypt(byte[] cText, SecretKey key, byte[] nonce, int counter) throws Exception {

        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);

        ChaCha20ParameterSpec param = new ChaCha20ParameterSpec(nonce, counter);

        cipher.init(Cipher.DECRYPT_MODE, key, param); 

        byte[] decryptedText = cipher.doFinal(cText); // Esegue l'operazione impostata

        return decryptedText;

    }
	
}