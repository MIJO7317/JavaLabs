import JavaLabs.AccountantBot.Employee;
import JavaLabs.AccountantBot.Government;
import JavaLabs.Containers.ArrayList;
import JavaLabs.Containers.LinkedList;
import JavaLabs.Containers.List;
import JavaLabs.Containers.Map;
import JavaLabs.Parser.StringParser;
import com.ibm.icu.text.Transliterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Main
{
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        //JavaLabs.Containers.ArrayList<Integer> list = new JavaLabs.Containers.ArrayList<>();
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
        System.out.println(StringParser.wordCount(" aa aaa aa bb bbb bbbb         bb ddd uuu iii ooo "));
        System.out.println(StringParser.trimRepeat("  aa aaa aa bb bbb   bbbb bb ddd uuu iii    ooo   "));
        System.out.println(("  aa aaa aa bb bbb   bbbb bb ddd uuu iii    ooo   ").replaceAll("\\s+", " ").trim());
        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(3);
        list3.add(5);
        System.out.println(list3);
        Government.addState("Moscow Region", "1");
        Government.addState("Orel Region", "2");
        Government.addCity("Moscow", Government.getState("Moscow Region"));
        //Government.addCity("Moscow", Government.getState("Moscow Regon"));
        System.out.println(Government.states.toString());
//        Document doc;
//        String address = "NaN";
//        String street = "NaN";
//        String house = "NaN";
//        String city = "NaN";
//        String state = "NaN";
//        for (int i = 0; i < 2; i++) {
//            try {
//                doc = Jsoup.connect("https://getfakedata.com/address/ru_RU").get();
//                street = doc.body().getElementsByTag("textarea").get(0).text().split("\n")[0].split(",")[3];
//                house = doc.body().getElementsByTag("textarea").get(0).text().split("\n")[0].split(",")[4];
//                city = doc.body().getElementsByTag("textarea").get(0).text().split("\n")[0].split(",")[2];
//                state = doc.body().getElementsByTag("textarea").get(0).text().split("\n")[0].split(",")[1];
//                address = street + ", " + house;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Address: " + address + '\n' + "City: " + city + '\n' + "State: " + state);
//        }
//        final String CYRILLIC_TO_LATIN = "Russian-Latin/BGN";
//        Transliterator toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);
//        System.out.println(toLatinTrans.transliterate("Вера Брежнева"));
        ArrayList<Employee> employees = Employee.createShortList();
        System.out.println(employees.get(0));
    }
}
