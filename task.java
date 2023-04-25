import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 * task
 */
public class task {

    public static void main(String[] args) {
        // 1.
        ArrayList<Integer> list1 = get_ArrayList(8, 12);
        println(list1);
        reverse_sorting(list1);
        println(list1);
        println("");

        // 2.
        ArrayList<Integer> list2 = get_ArrayList(15, 25);
        println(list2);
        delete_even_numbers(list2);
        println(list2);
        println("");

        // 3.
        ArrayList<Integer> list3 = get_ArrayList(15, 25);
        println(list3);
        println("min: " + find_min(list3));
        println("max: " + find_max(list3));
        println("average: " + find_average(list3));
        println("");

        // 4.
        ArrayList<Integer> list4_1 = get_ArrayList(5, 8);
        ArrayList<Integer> list4_2 = get_ArrayList(5, 8);
        println(list4_1);
        println(list4_2);
        ArrayList<Integer> list4 = disjunction(list4_1, list4_2);
        println(list4);
        println("");

        // 5.
        ArrayList<Integer> list5 = create_ArrayList_of_nulls();

        // 6.
        LinkedList<Integer> list6 = create_LinkedList_of_nulls();

        // 7.
        println("Nano Time ArrayList: " + count_time_ArrayList());
        println("Nano Time LinkedList: " + count_time_LinkedList());
    }

    static ArrayList<Integer> get_ArrayList(int min_size, int max_size) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int size = new Random().nextInt(min_size, max_size + 1);
        int min = new Random().nextInt(0, 11);
        int max = new Random().nextInt(20, 31);
        for (int i = 0; i < size; i++) {
            list.add(new Random().nextInt(min, max + 1));
        }
        return list;
    }

    static void println(Object o) {
        System.out.println(o);
    }

    static void reverse_sorting(ArrayList<Integer> list) {
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }

    static void delete_even_numbers(ArrayList<Integer> list) {
        Iterator<Integer> list_it = list.iterator();
        while (list_it.hasNext()) {
            if (list_it.next() % 2 == 0) {
                list_it.remove();
            }
        }
    }

    static int find_max(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (Integer i : list) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    static int find_min(ArrayList<Integer> list) {
        int min = Integer.MAX_VALUE;
        for (Integer i : list) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    static double find_average(ArrayList<Integer> list) {
        double avag = 0;
        for (Integer i : list) {
            avag += i;
        }
        avag = round(avag / list.size(), 2);
        return avag;
    }

    static double round(double d, double scale) {
        scale = Math.pow(10, scale);
        d = Math.round(d * scale) / scale;
        return d;
    }

    static ArrayList<Integer> disjunction(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        list2.removeAll(list1);
        list1.addAll(list2);
        return list1;
    }

    static ArrayList<Integer> create_ArrayList_of_nulls() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10000; i++) {
            list.add(0);
        }
        return list;
    }

    static LinkedList<Integer> create_LinkedList_of_nulls() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 10000; i++) {
            list.add(0);
        }
        return list;
    }

    static long count_time_ArrayList() {
        long start = System.nanoTime();
        ArrayList<Integer> list = create_ArrayList_of_nulls();
        long end = System.nanoTime();
        return end - start;
    }

    static long count_time_LinkedList() {
        long start = System.nanoTime();
        LinkedList<Integer> list = create_LinkedList_of_nulls();
        long end = System.nanoTime();
        return end - start;
    }

}
