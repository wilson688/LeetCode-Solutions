package strings;

public class ExcelSheetColumn {


    public String solution(int n) {
        StringBuffer sb = new StringBuffer("");

        while(n != 0) {
            char ch;

            if(n % 26 == 0) {
                ch = 'Z';
                n = n - 26;
                sb.append(ch);
            } else {
                ch = (char) ((((n - 1)) % 26) + 'A');  // minus sky value of A so that we can get the index of the next char
                n = n /26;
                sb.append(ch);
            }

        }

        sb.reverse();

        return sb.toString();
    }




    public static void main(String args[]) {
        ExcelSheetColumn obj = new ExcelSheetColumn();
        System.out.println("===================");
        System.out.println(obj.solution(701));
        System.out.println("===================");
        System.out.println(obj.solution(8));
        System.out.println("===================");
        System.out.println(obj.solution(29));
        System.out.println("===================");
        System.out.println(obj.solution(675));
        System.out.println("===================");
    }
}
