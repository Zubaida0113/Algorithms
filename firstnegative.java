import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class firstnegative {
    public static void main(String[] args) {
        int[] arr = { 12, -1, -7, 8, -15, 30, 16, 28 };
        int k = 3;

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        int i = 0, j = 0;

        while (j < arr.length) {

            if (arr[j] < 0)
                queue.add(arr[j]);

            if ((j - i + 1) < k) {
                j++;
            } else if ((j - i + 1) == k) {
                if (queue.isEmpty()) {
                    list.add(0);
                } else {
                    list.add(queue.peek());
                    if (arr[i] == queue.peek())
                        queue.poll();
                }
                i++;
                j++;
            }

        }

        System.out.println(list);
    }
}

