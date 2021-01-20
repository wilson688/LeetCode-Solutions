package strings;

import java.util.LinkedList;

//time complexity of this algo is O(2^N)

class CountAndSay {
    public String solution(int n) {

        if(n == 1) return "1";
       //add a fist index 1 and delimiter -1
        LinkedList<Integer> prevSeq = new LinkedList<>();
        prevSeq.add(1);
        prevSeq.add(-1);
        StringBuffer sb = new StringBuffer();

        LinkedList<Integer> finalSeq = finalSequence(n,prevSeq);

        for(Integer digit: finalSeq) {
            sb.append(String.valueOf(digit));
        }



     return sb.toString();
    }


    public LinkedList<Integer> finalSequence(int n, LinkedList<Integer> prev) {
        if(n == 1) {
            prev.pollLast();
            return prev;
        }

        LinkedList<Integer> innerSequence = new LinkedList<>();
        int digit = prev.get(0);
        int count = 1;
        for(int i = 1; i < prev.size(); i++) {
            if(digit != prev.get(i)) {
                innerSequence.add(digit);
                innerSequence.add(count);
                digit = prev.get(i);
                count = 1;
            } else {
                count += 1;
            }
        }


        innerSequence.add(-1);


        return finalSequence(n-1, innerSequence);
    }

    public static void main(String args[]) {
        CountAndSay obj = new CountAndSay();
        System.out.println("===================");
        System.out.println(obj.solution(3));
        System.out.println("===================");
        System.out.println(obj.solution(4));
        System.out.println("===================");
        System.out.println(obj.solution(9));
        System.out.println("===================");
        System.out.println(obj.solution(8));
        System.out.println("===================");
        System.out.println(obj.solution(10));
    }
}