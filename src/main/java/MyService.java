import java.util.List;
import java.util.NoSuchElementException;

public class MyService {

    public int computeMax(List<Integer> input) throws NoSuchElementException {
        return input.stream().mapToInt(x -> x).max().orElseThrow(NoSuchElementException::new);
    }

    public int computeMin(List<Integer> input) throws NoSuchElementException {
        return input.stream().mapToInt(x -> x).min().orElseThrow(NoSuchElementException::new);
    }
}
