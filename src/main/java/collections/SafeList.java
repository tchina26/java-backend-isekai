package collections;

import java.util.ArrayList;
import java.util.List;

public class SafeList<T> {
    private List<T> list = new ArrayList<>();

    private SafeList (){
    }

    public static <T> SafeList<T> of (List<T> list){
        SafeList<T> safeList = new SafeList<>();
        safeList.list = new ArrayList<>(list);
        return safeList;
    }

    public List<T> getAll(){
        return List.copyOf(list);
    }
    public void add( T element){
        list.add(element);
    }
}

