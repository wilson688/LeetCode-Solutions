package kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StuckInLoop {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        // Reading data using readLine
        String inputCount = reader.readLine();
        int count = Integer.parseInt(inputCount);
        for(int i = 0; i < count; i++) {
            int index = i + 1;
            System.out.println(index + " Abracadabra");
        }
    }


}
