package others.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        IntStream stream1 = IntStream.of(4, 2, 7, 3, 5, 1, 6);
        IntStream stream2 = IntStream.of(4, 2, 7, 3, 5, 1, 6);

        OptionalInt first = stream1.sorted().findFirst();
        first.ifPresent(System.out::println);

        OptionalInt any = stream2.findAny();
        any.ifPresent(System.out::println);

        List<String> list = Arrays.asList("A","B","C","D");
        Optional<String> result = list.stream().findAny();
        System.out.println(result.get());

    }

}
