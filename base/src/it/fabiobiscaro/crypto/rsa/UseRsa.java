package it.fabiobiscaro.crypto.rsa;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class UseRsa {

	public static PrivateKey getPrivateKey(URI filename) throws Exception {

		byte[] keyBytes = Files.readAllBytes(Paths.get(filename));

		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePrivate(spec);
	}

	public static PublicKey getPublicKey(URI filename) throws Exception {

		byte[] keyBytes = Files.readAllBytes(Paths.get(filename));

		X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePublic(spec);
	}

	public static void main(String[] args) throws Exception {
		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
		generator.initialize(2048);
		KeyPair pair = generator.generateKeyPair();

		// Versione generata
		// PrivateKey privateKey = pair.getPrivate();
		// PublicKey publicKey = pair.getPublic();
		
		// Versione caricata dal file
		System.out.println(
				UseRsa.class.getClassLoader().getResource("it/fabiobiscaro/crypto/rsa/private_key.der").toURI());
		PrivateKey privateKey = getPrivateKey(UseRsa.class.getClassLoader().getResource("it/fabiobiscaro/crypto/rsa/private_key.der").toURI());
		
		System.out.println(
				UseRsa.class.getClassLoader().getResource("it/fabiobiscaro/crypto/rsa/public_key.der").toURI());
		PublicKey publicKey = getPublicKey(
				UseRsa.class.getClassLoader().getResource("it/fabiobiscaro/crypto/rsa/public_key.der").toURI());

		/*
		 * Salvo su file anche se non serve
		 * 
		 * try (FileOutputStream fos = new FileOutputStream("public.key")) {
			fos.write(publicKey.getEncoded());
		}

		File publicKeyFile = new File("public.key");
		byte[] publicKeyBytes = Files.readAllBytes(publicKeyFile.toPath());*/

		Cipher encryptCipher = Cipher.getInstance("RSA");
		encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);

		String secretMessage = "Baeldung secret message";

		byte[] secretMessageBytes = secretMessage.getBytes(StandardCharsets.UTF_8);
		byte[] encryptedMessageBytes = encryptCipher.doFinal(secretMessageBytes);

		String encodedMessage = Base64.getEncoder().encodeToString(encryptedMessageBytes);

		System.out.println("Messaggio segreto: " + encodedMessage);

		Cipher decryptCipher = Cipher.getInstance("RSA");
		decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);

		byte[] decryptedMessageBytes = decryptCipher.doFinal(encryptedMessageBytes);
		String decryptedMessage = new String(decryptedMessageBytes, StandardCharsets.UTF_8);

		System.out.println("Messaggio decriptato: " + decryptedMessage);

		// Carico il certificato generato da openssl
		System.out.println(UseRsa.class.getClassLoader().getResource("it/fabiobiscaro/crypto/rsa/private_key.der"));

	}
}
