import java.util.*;
//بشرى فاروق نبيه سلطان
//446818050
//section:2385
public class MapsHashingLab {

    static class KeyValuePair {
        int key;
        String value;

        public KeyValuePair(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    static class ArrayListMap {
        ArrayList<KeyValuePair> list = new ArrayList<>();

        public void add(int key, String value) {
            list.add(new KeyValuePair(key, value));
        }

        public String getValue(int key) {
            for (KeyValuePair pair : list) {
                if (pair.key == key) {
                    return pair.value;
                }
            }
            return "Not Found";
        }
    }

    static class SimpleHash {
        String[] table = new String[10];

        public void insert(int key, String value) {
            int index = key % 10;
            table[index] = value;

            System.out.println("Index: " + index);
            System.out.println("Stored value: " + table[index]);
        }
    }

    public static void main(String[] args) {
        System.out.println("Act1:List Based Map"); 
        ArrayListMap map = new ArrayListMap();
        map.add(5, "A");
        map.add(6, "B");
        map.add(9, "C");
        map.add(8, "D");
        System.out.println("getValue(8): " + map.getValue(8));
        System.out.println("getValue(9): " + map.getValue(9));
        System.out.println("getValue(5): " + map.getValue(5));

        System.out.println("         ");

        System.out.println("Act2:Simple Hash"); 
        SimpleHash hash = new SimpleHash();
        hash.insert(21, "Sara");
        hash.insert(98, "Nora");

         System.out.println("         ");

        System.out.println("Act3:containsKey"); 
        HashMap<String, Integer> studentMap = new HashMap<>();
        studentMap.put("Ala", 95);
        studentMap.put("Rahaf", 80);
        studentMap.put("Bushra", 88);

        Scanner input = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = input.nextLine();

        if (studentMap.containsKey(name)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }

        input.close();
    }
}