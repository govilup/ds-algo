package com.dsalgo.problemsolving;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Find duplicate rows in a binary matrix
 * Given a binary matrix A of integers 0 and 1, of size N x M.
 * <p>
 * Find and return the indices of the rows which are duplicate of rows which are already present in the matrix.
 * <p>
 * If row[i] and row[j] are same and i < j then answer will contain only index j.
 * <p>
 * Note: Rows are numbered from top to bottom and columns are numbered from left to right. There will be at least one duplicate row in the matrix.
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is the integer matrix A.
 * Output Format
 * <p>
 * Return the indices of the rows in the form of an integer array.
 * Constraints
 * <p>
 * 2 <= N, M <= 1000
 * 0 <= A[i] <= 1
 * For Example
 * <p>
 * Input 1:
 * A = [   [1, 0, 0]
 * [0, 1, 0]
 * [0, 1, 0]   ]
 * Output 1:
 * [3]
 * <p>
 * Input 2:
 * A = [   [1, 1, 1, 0]
 * [0, 0, 0, 1]
 * [1, 1, 1, 0]
 * [0, 0, 0, 1]    ]
 * Output 2:
 * [3, 4]
 *
 * @author govilrajput
 */
public class DuplicateRowsBinaryMatrix {

    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        StringBuilder sb = new StringBuilder();
        Map<String, List<Integer>> map = new HashMap<>();
        int i = 1;
        for (ArrayList<Integer> row : A) {
            for (Integer num : row) {
                sb.append(num);
            }

            String str = sb.toString();

            if (map.containsKey(str)) {
                List<Integer> values = map.get(str);
                values.add(i);
                map.put(str, values);
            } else {
                map.put(str, new ArrayList());
            }
            sb = new StringBuilder();
            i++;
        }

        return map.values().stream()
                .filter(Objects::nonNull)
                .flatMap(Collection::stream).sorted().collect(Collectors.toCollection(ArrayList::new));
    }
}
