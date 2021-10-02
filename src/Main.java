import JavaLabs.ArrayList;
import JavaLabs.LinkedList;
import JavaLabs.List;

public class Main
{
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        //JavaLabs.ArrayList<Integer> list = new JavaLabs.ArrayList<>();
        list.Add(1);
        list.Add(2);
        list.Add(3);
        list.Add(4);
        //list.Add(new String("Smth"));
        for (int i = 0; i<list.Size(); i++)
            System.out.println(list.Get(i));
        //list.Print();
        System.out.println();
        System.out.println(list.Remove(4));
        System.out.println();
        //list.Print();
        for (int i = 0; i<list.Size(); i++)
            System.out.println(list.Get(i));
        System.out.println();
        System.out.println(list.Contains(null));
        list.Add(10,null);
        System.out.println();
        System.out.println(list.Contains(null));
        System.out.println();
        list.Add(2, 15, 5);
        list.Set(-1, 20);
        for (int i = 0; i<list.Size(); i++)
            System.out.println(list.Get(i));
        System.out.println();
        System.out.println(list.IndexOf(3));
        ArrayList.ChangeDefaultBufferSize(128);
    }
}
