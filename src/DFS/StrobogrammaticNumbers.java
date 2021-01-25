package DFS;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumbers {
    public List<String> findStrobogrammatic(int n) {
        List<String> result = new ArrayList<>();
        char[] template = new char[n];

        if (n % 2 == 1) {
            int middle = template.length / 2;
            template[middle] = '0';
            buildNumber(0, template, result);
            template[middle] = '1';
            buildNumber(0, template, result);
            template[middle] = '8';
            buildNumber(0, template, result);
        } else {
            buildNumber(0, template, result);
        }
        return result;
    }

    private void buildNumber(int index, char[] template, List<String> result) {
        if (index >= template.length / 2) {
            result.add(new String(template));
            return;
        }

        if (index != 0) {
            setAndBuild(index, '0', '0', template, result);
        }
        setAndBuild(index, '1', '1', template, result);
        setAndBuild(index, '6', '9', template, result);
        setAndBuild(index, '9', '6', template, result);
        setAndBuild(index, '8', '8', template, result);
    }

    private void setAndBuild(int index, char c1, char c2, char[] template, List<String> result) {
        template[index] = c1;
        template[template.length - 1 - index] = c2;
        buildNumber(index + 1, template, result);
    }

    public static void main(String[] args) {
        StrobogrammaticNumbers comb = new StrobogrammaticNumbers();
        System.out.println(comb.findStrobogrammatic(2));
    //    System.out.println(comb.findStrobogrammatic(3));
    }
}
