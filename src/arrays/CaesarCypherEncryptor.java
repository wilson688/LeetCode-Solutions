package arrays;

public class CaesarCypherEncryptor {

    public static String caesarCypherEncryptor(String str, int key) {
        // Write your code here.

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length(); i++) {
            int currChar = (str.charAt(i) + key);

            if(currChar <= 122) {
                sb.append((char) currChar);
            } else {
               char ch = (char) (96 + currChar % 122);
               sb.append(ch);
            }
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(caesarCypherEncryptor("xyz", 2));;
    }
}
