package baekjoon;

import java.util.List;
import java.util.function.Consumer;

class ForEachTest implements Consumer<Integer> {
    @Override
    public void accept(Integer integer) {
        System.out.println(integer);
    }

    @Override
    public Consumer<Integer> andThen(Consumer<? super Integer> after) {
        return Consumer.super.andThen(after);
    }
}

public class FunctionalInterfaceTest {
    public static void main(String[] args) {
        List.of(1, 2, 3, 4).forEach(new ForEachTest());
    }
}
