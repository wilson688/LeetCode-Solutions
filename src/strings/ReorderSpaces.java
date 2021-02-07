package strings;

import java.util.LinkedList;
import java.util.Queue;

public class ReorderSpaces {


    public static String reorderSpaces(String text) {


        //2 3 2 1 1
        Queue<String> queue = new LinkedList<>();
        int count = 0;
        int windowEnd = 0;
        while(windowEnd < text.length()) {
            if(text.charAt(windowEnd) == ' ') {
                count++;
                windowEnd++;
            } else {
                StringBuilder sb = new StringBuilder();
                while(text.charAt(windowEnd) != ' ') {
                    sb.append(text.charAt(windowEnd));
                    windowEnd++;
                }
                queue.offer(sb.toString());
            }
        }

        int qSize = queue.size() - 1;

        System.out.println("count "+count);
        System.out.println("queue size "+queue.size());
        int addSpaceCount = count / qSize;
        int addSpacesAtEnd = count % qSize;

        StringBuilder res = new StringBuilder();

        while(!queue.isEmpty()) {
            String curr = queue.poll();
            res.append(curr);

            if(count >= addSpaceCount) {
                int currSpacesAdded = 0;
                while(currSpacesAdded < addSpaceCount) {
                    res.append(" ");
                    currSpacesAdded++;
                    count--;
                }
            }
        }


        while(addSpacesAtEnd != 0) {
            res.append(" ");
            addSpacesAtEnd--;
        }

        return res.toString();

    }
    public static void main(String[] args) {

        System.out.println(reorderSpaces("  this   is  a sentence "));

    }
}
