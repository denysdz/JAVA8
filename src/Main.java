import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String originText = "Мова Java знайшла широке застосування для програмування браузерів у мережі Інтернет. На ній можна створювати повноцінні програмні продукти - застосунки (applications), а також аплети (applets), що виконуються у мережі Інтернет.";
        String encodedText = TextEncoderDecoder.encode(originText);

        System.out.println(originText);
        System.out.println(encodedText);
        System.out.println(TextEncoderDecoder.decode(encodedText));
        writeToFile("encoded.txt", encodedText);
        writeToFile("origin.txt", originText);
        System.out.println(TextEncoderDecoder.decode(readFromFile("encoded.txt")));

    }

    public static void writeToFile(String fileName, String encodedString) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
            outputStreamWriter.write(encodedString);
            outputStreamWriter.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            int c;
            while ((c = inputStreamReader.read()) != -1) {
                stringBuilder.append((char) c);
            }
            inputStreamReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
    


}