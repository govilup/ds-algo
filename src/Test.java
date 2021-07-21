import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<Integer>(Arrays.asList(1, -1));
        ArrayList<Integer> l2 = new ArrayList<Integer>(Arrays.asList(-2, -1));
        list.add(l1);
        list.add(l2);

        Collections.sort(list, Test::compare);
        System.out.println(list);

        //System.out.println(solve(new ArrayList<Integer>(Arrays.asList(2, 2, 3, 4, 4, 5, 6, 7, 10)), 8));
    }


    public static int solve(ArrayList<Integer> A, int B) {
        long result = 0;
        int mod = 1000000007;

        //USE HASHING
        Map<Integer, Integer> map = new HashMap<>();

        for(Integer num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int i = 0; i < A.size(); i++) {
            int diff = B - A.get(i);
            if(map.containsKey(diff)) {
                map.put(A.get(i), map.get(A.get(i)) - 1);
                result = (result + map.get(diff)) % mod;
                map.put(A.get(i), map.get(A.get(i)) + 1);
            }
        }

        return (int)(result / 2) % mod;
    }

    public static String simplifyPath(String A) {

        Deque<String> stack = new LinkedList<>();

        StringBuilder result = new StringBuilder();
        result.append("/");

        int len = A.length();

        for(int i = 0; i < len; i++) {
            StringBuilder dir = new StringBuilder();

            while(i < len && A.charAt(i) == '/') {
                i++;
            }

            while(i < len && A.charAt(i) != '/') {
                dir.append(A.charAt(i));
                i++;
            }

            if(dir.toString().equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (dir.toString().equals(".")) {
                continue;
            } else if (dir.length() != 0){
                stack.push(dir.toString());
            }
        }

        while(!stack.isEmpty()) {
            if(stack.size() != 1) {
                result.append(stack.removeLast()).append("/");
            } else {
                result.append(stack.removeLast());
            }
        }

        return result.toString();
    }

    private static int compare(List<Integer> o1, List<Integer> o2) {
        int d1 = o1.get(0) * o1.get(0) + o1.get(1) * o1.get(1);
        int d2 = o2.get(0) * o2.get(0) + o2.get(1) * o2.get(1);
        if (d1 <= d2) {
            return -1;
        }
        return 1;
    }
}

