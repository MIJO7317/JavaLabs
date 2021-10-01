import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) {
        System.out.println("Hi");
        JavaLabs.ArrayList<Integer> list = new JavaLabs.ArrayList<>();
        list.Add(1);
        list.Add(2);
        list.Add(3);
        //list.Add(4);
        //list.Add(new String("Smth"));
//        for (int i = 0; i<list.Size(); i++)
//            System.out.println(list.Get(i));
        list.Print();
        System.out.println();
        System.out.println(list.Remove(4));
        System.out.println();
        list.Print();
        System.out.println(list.Contains(null));
        System.out.println();
        JavaLabs.ArrayList.ChangeDefaultBufferSize(128);
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(null);
        System.out.println(arr.contains(null));
    }
}
