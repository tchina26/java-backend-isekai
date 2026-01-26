package basics;

import java.util.ArrayList;
import java.util.List;

public class Repository<T>{
    private final List<T> elements;

    private Repository(List<T> elements) {
        this.elements = new ArrayList<>(elements);
    }

    public static <T> Repository<T> of(List<T> elements){
        if(elements == null) throw new IllegalArgumentException("the list cant be null");
        return new Repository<T>(elements);
    }

    public void add(T element) {
        if(element == null) throw new IllegalArgumentException("the element cant be null");
        this.elements.add(element);
    }

    public List<T> getAll(){
        return List.copyOf(this.elements);
    }

    // metodi per fare CRUD ma verranno implementati
}
