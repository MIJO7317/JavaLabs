import JavaLabs.*;

public class Main
{
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        //JavaLabs.ArrayList<Integer> list = new JavaLabs.ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        //list.Add(new String("Smth"));
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
        //list.Print();
        System.out.println();
        System.out.println(list.remove(4));
        System.out.println();
        //list.Print();
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
        System.out.println();
        System.out.println(list.contains(null));
        list.add(10, null);
        System.out.println();
        System.out.println(list.contains(null));
        System.out.println();
        list.add(2, 15, 5);
        list.set(-1, 20);
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
        System.out.println();
        System.out.println(list.indexOf(3));
        ArrayList.changeDefaultBufferSize(128);
        Map<List<Integer>, String> map = new Map<>(Map.ListType.ARRAY_LIST);
        map.put(list, "Stas");
        map.getEntries().set(0, new Map.Entry<>(list, "neStas"));
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(3);
        list1.add(4);
        list1.add(6);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(2);
        list2.add(5);
        list2.add(8);
        LinkedList<Integer> mergeList = LinkedList.merge(list1, list2);
        for (int i = 0; i < mergeList.size(); i++) {
            System.out.print(mergeList.get(i) + ", ");
        }
        System.out.println();
        System.out.println(StringParser.wordCount(" aa aaa aa bb bbb bbbb bb ddd uuu iii ooo "));
        System.out.println(StringParser.trimRepeat("  aa aaa aa bb bbb   bbbb bb ddd uuu iii    ooo   "));
        System.out.println(("  aa aaa aa bb bbb   bbbb bb ddd uuu iii    ooo   ").replaceAll("\\s+", " ").trim());
    }
}
