package reflect;

import java.lang.reflect.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;

public class Homework1 {

    /**
     * Prints the declared methods of java.lang.String sorted by name.
     */
    public void streamPipeline1() {
        Arrays.stream(String.class.getDeclaredMethods())
                .sorted((Method a, Method b) -> a.getName().compareTo(b.getName()))
                .forEach(System.out::println);
    }

    /**
     * Prints all distinct names of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline2() {
        Arrays.stream(String.class.getDeclaredMethods())
                .map(a -> a.getName())
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with two or more parameters whose parameters are all of the same type, sorted by name.
     */
    public void streamPipeline3() {
        Arrays.stream(String.class.getDeclaredMethods())
                .filter(a -> a.getParameterCount() > 1)
                .filter(a -> Arrays.stream(a.getParameterTypes()).allMatch(b -> b.equals(a.getParameterTypes()[0])))
                .sorted((Method a, Method b) -> a.getName().compareTo(b.getName()))
                .forEach(System.out::println);
    }

    /**
     * Prints all distinct return types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline4() {
        Arrays.stream(String.class.getDeclaredMethods())
                .map(a -> a.getReturnType())
                .distinct()
                .map(Class::getName)
                .sorted()
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with at least one boolean parameter, sorted by name.
     */
    public void streamPipeline5() {
        Arrays.stream(String.class.getDeclaredMethods())
                .filter(a -> Arrays.stream(a.getParameterTypes()).anyMatch(b -> b.equals(boolean.class)))
                .sorted((Method a, Method b) -> a.getName().compareTo(b.getName()))
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String whose parameters are all of type int, sorted by name.
     */
    public void streamPipeline6() {
        Arrays.stream(String.class.getDeclaredMethods())
                .filter(a -> a.getParameterTypes().length != 0)
                .filter(a -> Arrays.stream(a.getParameterTypes()).allMatch(b -> b.equals(int.class)))
                .sorted((Method a, Method b) -> a.getName().compareTo(b.getName()))
                .forEach(System.out::println);
    }

    /**
     * Returns the longest name of the declared methods of java.lang.String.
     */
    public String streamPipeline7() {

        return Arrays.stream(String.class.getDeclaredMethods())
                .map(a -> a.getName())
                .max((a, b) -> Long.compare(a.length(), b.length())).get();

    }

    /**
     * Returns the longest one from the names of the public declared methods of java.lang.String.
     */
    public String streamPipeline8() {

        return Arrays.stream(String.class.getDeclaredMethods())
                .filter(a -> Modifier.isPublic(a.getModifiers()))
                .map(a -> a.getName())
                .max((a, b) -> Long.compare(a.length(), b.length())).get();
    }

    /**
     * Returns summary statistics about the number of parameters for the declared methods of java.lang.String.
     */
    public IntSummaryStatistics streamPipeline9() {

        return Arrays.stream(String.class.getDeclaredMethods())
                .mapToInt(a -> a.getParameterCount())
                .summaryStatistics();
    }

    /**
     * Returns the maximum number of parameters accepted by the declared methods of java.lang.String.
     */
    public int streamPipeline10() {

        return Arrays.stream(String.class.getDeclaredMethods())
                .mapToInt(a -> a.getParameterCount())
                .max()
                .getAsInt();
    }

    /**
     * Returns the declared method of java.lang.String with the most number of parameters.
     */
    public Method streamPipeline11() {

        return Arrays.stream(String.class.getDeclaredMethods())
                .max((a, b) -> Long.compare(a.getParameterCount(), b.getParameterCount())).get();
    }

    /**
     * Prints all distinct parameter types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline12() {
        Arrays.stream(String.class.getDeclaredMethods())
                .flatMap(a -> Arrays.stream(a.getParameterTypes()))
                .distinct()
                .map(Class::getName)
                .sorted()
                .forEach(System.out::println);
    }

}
