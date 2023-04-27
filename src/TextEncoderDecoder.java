import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TextEncoderDecoder {
    private static final String KEY = "Джугалик Денис Ігорович";

    public static String encode(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int keyIndex = i % KEY.length();
            char keyChar = KEY.charAt(keyIndex);
            char encodedChar = (char) (c + keyChar);
            sb.append(encodedChar);
        }
        return sb.toString();
    }

    public static String decode(String encodedText) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < encodedText.length(); i++) {
            char c = encodedText.charAt(i);
            int keyIndex = i % KEY.length();
            char keyChar = KEY.charAt(keyIndex);
            char decodedChar = (char) (c - keyChar);
            sb.append(decodedChar);
        }
        return sb.toString();
    }

}
