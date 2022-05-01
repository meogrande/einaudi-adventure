package it.fabiobiscaro.crypto.chacha20;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Main {

	public static void main(String[] args) {
		
		String input = "Java & ChaCha20 encryption example.";

        Chacha20 cipher = new Chacha20();

        SecretKey key = null;
		try {
			key = getKey();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}           // 256-bit secret key (32 bytes)
		
        byte[] nonce = getNonce();          // 96-bit nonce (12 bytes)
        int counter = 1;                    // 32-bit initial count (8 bytes)

        System.out.println("Input          : " + input);
        System.out.println("Input     (hex): " + convertBytesToHex(input.getBytes()));

        System.out.println("\n---Encryption---");
        byte[] cText = null;
		try {
			cText = cipher.encrypt(input.getBytes(), key, nonce, counter);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   // encrypt

        System.out.println("Key       (hex): " + convertBytesToHex(key.getEncoded()));
        System.out.println("Nonce     (hex): " + convertBytesToHex(nonce));
        System.out.println("Counter        : " + counter);
        System.out.println("Encrypted (hex): " + convertBytesToHex(cText));

        System.out.println("\n---Decryption---");

        byte[] pText = null;
		try {
			pText = cipher.decrypt(cText, key, nonce, counter);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}              // decrypt

        System.out.println("Key       (hex): " + convertBytesToHex(key.getEncoded()));
        System.out.println("Nonce     (hex): " + convertBytesToHex(nonce));
        System.out.println("Counter        : " + counter);
        System.out.println("Decrypted (hex): " + convertBytesToHex(pText));
        System.out.println("Decrypted      : " + new String(pText));

	}

	// A 256-bit secret key (32 bytes)
    private static SecretKey getKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("ChaCha20");
        keyGen.init(256, SecureRandom.getInstanceStrong());
        return keyGen.generateKey();
    }

    // 96-bit nonce (12 bytes)
    private static byte[] getNonce() {
        byte[] newNonce = new byte[12];
        new SecureRandom().nextBytes(newNonce);
        return newNonce;
    }

    private static String convertBytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte temp : bytes) {
            result.append(String.format("%02x", temp));
        }
        return result.toString();
    }
	
}
