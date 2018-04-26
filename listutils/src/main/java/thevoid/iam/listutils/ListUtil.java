package thevoid.iam.listutils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import java8.util.function.Consumer;
import java8.util.function.Predicate;
import java8.util.function.ToDoubleFunction;
import java8.util.function.ToIntFunction;
import java8.util.function.ToLongFunction;
import java8.util.stream.Collectors;
import java8.util.stream.StreamSupport;

public final class ListUtil {
    private ListUtil() {
    }

    /**
     * MAP
     */


    public static <T, E> List<E> map(Collection<T> list, Function<? super T, ? extends E> function) {
        return StreamSupport.stream(list)
                .map(function::apply)
                .collect(Collectors.toList());
    }

    public static <T, E> List<E> map(T[] array, Function<? super T, ? extends E> function) {
        return map(Arrays.asList(array), function);
    }

    public static <T, E> List<E> map(Iterable<T> iterable, Function<? super T, ? extends E> function) {
        return map(toList(iterable), function);
    }

    /**
     * FILTER
     */

    public static <T> List<T> filter(Collection<T> list, Predicate<? super T> predicate) {
        return StreamSupport.stream(list)
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static <T> List<T> filter(Iterable<T> iterable, Predicate<? super T> predicate) {
        return filter(toList(iterable), predicate);
    }

    public static <T> List<T> filter(T[] array, Predicate<? super T> predicate) {
        return filter(Arrays.asList(array), predicate);
    }

    /**
     * FOR EACH
     */

    public static <T> void forEach(Collection<T> collection, Consumer<? super T> action) {
        StreamSupport.stream(collection).forEach(action);
    }

    public static <T> void forEach(T[] array, Consumer<? super T> action) {
        forEach(Arrays.asList(array), action);
    }

    public static <T> void forEach(Iterable<T> collection, Consumer<? super T> action) {
        for (T otem : collection) {
            action.accept(otem);
        }
    }

    /**
     * SUM
     */

//    INT

    public static int intSum(List<Integer> list) {
        return StreamSupport.stream(list).mapToInt(value -> value).sum();
    }

    public static int intSum(Integer[] array) {
        return intSum(Arrays.asList(array));
    }

    public static int intSum(Iterable<Integer> iterable) {
        return intSum(toList(iterable));
    }

//    INT with mapper

    public static <T> int intSum(List<T> list, ToIntFunction<T> mapper) {
        return StreamSupport.stream(list).mapToInt(mapper).sum();
    }

    public static <T> int intSum(T[] array, ToIntFunction<T> mapper) {
        return intSum(Arrays.asList(array), mapper);
    }

    public static <T> int intSum(Iterable<T> iterable, ToIntFunction<T> mapper) {
        return intSum(toList(iterable), mapper);
    }

//    DOUBLE

    public static double doubleSum(List<Double> list) {
        return StreamSupport.stream(list).mapToDouble(value -> value).sum();
    }

    public static double doubleSum(Double[] array) {
        return doubleSum(Arrays.asList(array));
    }

    public static double doubleSum(Iterable<Double> iterable) {
        return doubleSum(toList(iterable));
    }

//    DOUBLE with mapper

    public static <T> double doubleSum(List<T> list, ToDoubleFunction<T> mapper) {
        return StreamSupport.stream(list).mapToDouble(mapper).sum();
    }

    public static <T> double doubleSum(T[] array, ToDoubleFunction<T> mapper) {
        return doubleSum(Arrays.asList(array), mapper);
    }

    public static <T> double doubleSum(Iterable<T> iterable, ToDoubleFunction<T> mapper) {
        return doubleSum(toList(iterable), mapper);
    }

//    LONG

    public static long longSum(List<Long> list) {
        return StreamSupport.stream(list).mapToLong(value -> value).sum();
    }

    public static long longSum(Long[] array) {
        return longSum(Arrays.asList(array));
    }

    public static long longSum(Iterable<Long> iterable) {
        return longSum(toList(iterable));
    }

//    LONG with mapper

    public static <T> long longSum(List<T> list, ToLongFunction<T> mapper) {
        return StreamSupport.stream(list).mapToLong(mapper).sum();
    }

    public static <T> long longSum(T[] array, ToLongFunction<T> mapper) {
        return longSum(Arrays.asList(array), mapper);
    }

    public static <T> long longSum(Iterable<T> iterable, ToLongFunction<T> mapper) {
        return longSum(toList(iterable), mapper);
    }

    /**
     * MAX
     */

//    With custom comparator

    public static <T> T max(List<T> list, Comparator<T> function, T defaultValue) {
        return StreamSupport.stream(list)
                .max(function)
                .orElse(defaultValue);
    }

    public static <T> T max(List<T> list, Comparator<T> function) {
        return max(list, function, null);
    }

//    By LONG value

    public static <T> T maxByLong(List<T> list, Function<T, Long> function) {
        return max(list, (f, s) -> Long.compare(function.apply(f), function.apply(s)));
    }

    public static <T> T maxByLong(List<T> list, Function<T, Long> function, T defaultItem) {
        return max(list, (f, s) -> Long.compare(function.apply(f), function.apply(s)), defaultItem);
    }

//    By INT value

    public static <T> T maxByInt(List<T> list, Function<T, Integer> function) {
        return max(list, (f, s) -> Integer.compare(function.apply(f), function.apply(s)));
    }


    public static <T> T maxByInt(List<T> list, Function<T, Integer> function, T defaultItem) {
        return max(list, (f, s) -> Integer.compare(function.apply(f), function.apply(s)), defaultItem);
    }

//    By DOUBLE value

    public static <T> T maxByDouble(List<T> list, Function<T, Double> function) {
        return max(list, (f, s) -> Double.compare(function.apply(f), function.apply(s)));
    }


    public static <T> T maxByDouble(List<T> list, Function<T, Double> function, T defaultItem) {
        return max(list, (f, s) -> Double.compare(function.apply(f), function.apply(s)), defaultItem);
    }

//    By FLOAT value

    public static <T> T maxByFloat(List<T> list, Function<T, Float> function) {
        return max(list, (f, s) -> Float.compare(function.apply(f), function.apply(s)));
    }

    public static <T> T maxByFloat(List<T> list, Function<T, Float> function, T defaultItem) {
        return max(list, (f, s) -> Float.compare(function.apply(f), function.apply(s)), defaultItem);
    }

//    Max LONG

    public static Long maxLong(List<Long> list) {
        return maxLong(list, l -> l);
    }

    public static <T> Long maxLong(List<T> list, ToLongFunction<T> toLongFunction) {
        return StreamSupport.stream(list).mapToLong(toLongFunction).max().orElse(0);
    }

//    Max INT

    public static Integer maxInt(List<Integer> list) {
        return maxInt(list, i -> i);
    }

    public static <T> Integer maxInt(List<T> list, ToIntFunction<T> toIntFunction) {
        return StreamSupport.stream(list).mapToInt(toIntFunction).max().orElse(0);
    }

//    Max FLOAT

    public static Float maxFloat(List<Float> list) {
        return (float) StreamSupport.stream(list).mapToDouble(f -> f).max().orElse(0F);
    }

//    Max DOUBLE

    public static Double maxDouble(List<Double> list) {
        return maxDouble(list, d -> d);
    }

    public static <T> Double maxDouble(List<T> list, ToDoubleFunction<T> toDoubleFunction) {
        return StreamSupport.stream(list).mapToDouble(toDoubleFunction).max().orElse(0);
    }

    /**
     * MIN
     */

//    With custom comparator

    public static <T> T min(List<T> list, Comparator<T> function, T defaultValue) {
        return StreamSupport.stream(list)
                .min(function)
                .orElse(defaultValue);
    }

    public static <T> T min(List<T> list, Comparator<T> function) {
        return min(list, function, null);
    }

//    By LONG value

    public static <T> T minByLong(List<T> list, Function<T, Long> function) {
        return min(list, (f, s) -> Long.compare(function.apply(f), function.apply(s)));
    }

    public static <T> T minByLong(List<T> list, Function<T, Long> function, T defaultItem) {
        return min(list, (f, s) -> Long.compare(function.apply(f), function.apply(s)), defaultItem);
    }

//    By INT value

    public static <T> T minByInt(List<T> list, Function<T, Integer> function) {
        return min(list, (f, s) -> Integer.compare(function.apply(f), function.apply(s)));
    }

    public static <T> T minByInt(List<T> list, Function<T, Integer> function, T defaultItem) {
        return min(list, (f, s) -> Integer.compare(function.apply(f), function.apply(s)), defaultItem);
    }

//    By DOUBLE value

    public static <T> T minByDouble(List<T> list, Function<T, Double> function) {
        return min(list, (f, s) -> Double.compare(function.apply(f), function.apply(s)));
    }

    public static <T> T minByDouble(List<T> list, Function<T, Double> function, T defaultItem) {
        return min(list, (f, s) -> Double.compare(function.apply(f), function.apply(s)), defaultItem);
    }

//    By FLOAT value

    public static <T> T minByFloat(List<T> list, Function<T, Float> function) {
        return min(list, (f, s) -> Float.compare(function.apply(f), function.apply(s)));
    }

    public static <T> T minByFloat(List<T> list, Function<T, Float> function, T defaultItem) {
        return min(list, (f, s) -> Float.compare(function.apply(f), function.apply(s)), defaultItem);
    }

//    Min LONG

    public static Long minLong(List<Long> list) {
        return minLong(list, l -> l);
    }

    public static <T> Long minLong(List<T> list, ToLongFunction<T> toLongFunction) {
        return StreamSupport.stream(list).mapToLong(toLongFunction).min().orElse(0);
    }

//    Min INT

    public static Integer minInt(List<Integer> list) {
        return minInt(list, i -> i);
    }

    public static <T> Integer minInt(List<T> list, ToIntFunction<T> toIntFunction) {
        return StreamSupport.stream(list).mapToInt(toIntFunction).min().orElse(0);
    }

//    Min FLOAT

    public static Float minFloat(List<Float> list) {
        return (float) StreamSupport.stream(list).mapToDouble(f -> f).min().orElse(0F);
    }

//    Min DOUBLE

    public static Double minDouble(List<Double> list) {
        return minDouble(list, d -> d);
    }

    public static <T> Double minDouble(List<T> list, ToDoubleFunction<T> toDoubleFunction) {
        return StreamSupport.stream(list).mapToDouble(toDoubleFunction).min().orElse(0);
    }

    /**
     * FLATTEN
     */

    public static <T> List<T> flatten(List<List<T>> list) {
        return StreamSupport.stream(list)
                .flatMap(StreamSupport::stream)
                .collect(Collectors.toList());
    }

    /**
     * ANY MATCH
     */

    public static <T, E> List<T> anyMatch(List<T> list, List<E> matchList, Matcher<T, E> matcher) {
        return StreamSupport.stream(list)
                .filter(item -> StreamSupport.stream(matchList).anyMatch(matcher.predicate(item)))
                .collect(Collectors.toList());
    }

    public static <T> boolean anyMatch(List<T> list, Predicate<T> predicate) {
        return StreamSupport.stream(list).anyMatch(predicate);
    }

    /**
     * MERGE
     */

    public static <T> List<T> merge(List<T> first, List<T> second) {
        List<T> list = new ArrayList<>();
        list.addAll(first);
        list.addAll(second);
        return list;
    }

    /**
     * CONVERSION
     */

    public static <T> List<T> toList(T item, T... items) {
        List<T> itemList = new ArrayList<>();
        itemList.add(item);
        itemList.addAll(Arrays.asList(items));
        return itemList;
    }


    public static <T> List<T> toList(Iterable<T> iterable) {
        if (iterable == null) {
            return new ArrayList<>();
        }
        if (iterable instanceof List) {
            return (List<T>) iterable;
        }

        List<T> list = new ArrayList<>();
        for (T item : iterable) {
            list.add(item);
        }

        return list;
    }
}