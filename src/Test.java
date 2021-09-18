import java.util.*;

public class Test {

    static class Employee {
        int id;
        String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return id == employee.id &&
                    Objects.equals(name, employee.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }


    public static void main(String[] args) {

        Map<Employee, Integer> map = new HashMap<>();
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("Govil");
        map.put(emp, 1);
        emp.setId(2);
        //map.put(emp, 1);
        System.out.println(map.keySet().toString());
//        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//        ArrayList<Integer> l1 = new ArrayList<Integer>(Arrays.asList(1, -1));
//        ArrayList<Integer> l2 = new ArrayList<Integer>(Arrays.asList(-2, -1));
//        list.add(l1);
//        list.add(l2);
//
//        Collections.sort(list, Test::compare);
//        System.out.println(list);
//        StringBuilder sb = new StringBuilder("1");
//        StringBuilder reverse = sb.reverse();
//
//        System.out.println(sb.toString() + reverse.toString());

/*        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, 3, 4, 4 ));
        ArrayList<Integer> innerList = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(innerList);
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 2);
        map.put('b', 3);
        boolean possible =  map.values().stream().allMatch(x -> (x % 2 == 0));
        if(possible) {
            System.out.println(true);
        }
        System.out.println(solve(A, B));*/
//
//        int[][] task = new int[3][2];
//        task[0][0] = 2;
//        task[0][1] = 8;
//        task[1][0] = 4;
//        task[1][1] = 5;
//        task[2][0] = 5;
//        task[2][1] = 1;
//        System.out.println(solve(3, 16, task));
    }

    static int solve(int n, int t, int[][] task){
        int timeConsumed = 0;
        int timeRemaining = t;
        int presentDistance = 0;
        int count = 0;
        for(int i = 0; i < n; i++) {
            if((task[i][0] - presentDistance) + task[i][1] + timeConsumed <= t) {
                timeConsumed += (task[i][0] - presentDistance) + task[i][1];
                if(t - timeConsumed >= 0) {
                    presentDistance = task[i][0] - presentDistance;
                    count++;
                }
            }
        }
        return count;

    }




    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> ansList = new ArrayList<>();


        ArrayList<Long> numbers = new ArrayList<>();

        for(Integer number : A) {
            numbers.add(hashCode(number));
        }

        for(ArrayList<Integer> arr : B) {
            int l1 = arr.get(0);
            int r1 = arr.get(1);
            int l2 = arr.get(2);
            int r2 = arr.get(3);

            long hash1 = 0;
            long hash2 = 0;

            for (int i = l1; i <= r1; ++i) {
                hash1 += numbers.get(i);
            }

            for (int j = l2; j <= r2; ++j) {
                hash2 += numbers.get(j);
            }

            if (hash1 == hash2) {
                ansList.add(1);
            } else {
                ansList.add(0);
            }
        }
        return ansList;
    }

    public static Long hashCode(int num) {
        long hash = 1000 * 100 + 31;
        hash = 7 * hash + num;
        return hash % 10000007;
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

