import model.Person;

import java.util.List;
import java.util.NoSuchElementException;

public class MyService {
    private final Person person;

    MyService(Person p) {
        this.person = p;
    }

    public int computeMax(List<Integer> input) throws Exception {
        if (!checkAccess(person)) {
            throw new Exception();
        }
        return input.stream().mapToInt(x -> x).max().orElseThrow(NoSuchElementException::new);
    }

    public int computeMin(List<Integer> input) throws Exception {
        if (!checkAccess(person)) {
            throw new Exception();
        }
        return input.stream().mapToInt(x -> x).min().orElseThrow(NoSuchElementException::new);
    }

    public boolean checkAccess(Person p) throws Exception {
        return p.hasAccess();
    }
}
