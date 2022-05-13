package com.company;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

class Controller {

    //- в колекції цілих чисел поміняти місцями максимум та мінімум;
    static List<Integer> changeMaximumAndMinimum(List<Integer> integerList) {
        IntSummaryStatistics iss = integerList.stream().collect(Collectors.summarizingInt(x -> x));
        return integerList.stream().map(n -> n == iss.getMax() ? iss.getMin() : n == iss.getMin() ? iss.getMax() : n)
                .collect(Collectors.toList());
    }


    //       - визначити середнє арифметичне елементів колекції цілих чисел та сформувати
    //     вихідну колекцію з елементів, що є більшими за середнє арифметичне;
    static List<Integer> collectionOfElementsGreaterThanArithmeticMean(List<Integer> integerList) {
        return integerList.stream().collect(Collectors.filtering(i -> i > integerList.stream().
                collect(Collectors.averagingInt(Integer::intValue)), Collectors.toList()));
    }


    //- в кожному реченні тексту без використання попереднього розбиття на речення
    //визначити різницю між кількістю приголосних та голосних букв і сформувати
    //відповідний Map (key: номер речення, value: визначена різниця між кількістю
    //приголосних та голосних букв).


    static Map<Integer, Long> createMapWhereKeyIndexSupplyValueDifferenceBetweenConsonantsAndVowels(String text) {

        Pattern vowelsSymbols = Pattern.compile("[AEIOUYaeiouy]");
        AtomicReference<Matcher> matcher1 = new AtomicReference<>();
        AtomicInteger index = new AtomicInteger();
        AtomicLong consonants = new AtomicLong();
        AtomicLong vowels = new AtomicLong();

        return Arrays.stream(text.split("")).collect(HashMap::new,
                (integerLongHashMap, symbol) -> {
                    matcher1.set(vowelsSymbols.matcher(symbol));
                    if (!symbol.equals("\s")) {
                        if (symbol.equals(".") || symbol.equals("!") || symbol.equals("?")) {
                            integerLongHashMap.put(index.getAndIncrement(), consonants.get() - vowels.get());
                            consonants.set(0);
                            vowels.set(0);
                        } else if (matcher1.get().find()) {
                            vowels.getAndIncrement();
                        } else {
                            consonants.getAndIncrement();
                        }
                    }
                }, HashMap::putAll);
    }

    static Map<Integer, Long> createMapWhereKeyIndexSupplyValueDifferenceBetweenConsonantsAndVowels2(String text) {
        Pattern vowelsSymbols = Pattern.compile("[AEIOUYaeiouy]");
        AtomicReference<Matcher> matcher = new AtomicReference<>();
        String[] stringArray = text.split("[.!?]");

        return Arrays.stream(stringArray).collect(Collectors.toMap(
                sentence -> List.of(stringArray).indexOf(sentence),
                sentence -> {
                    AtomicLong consonants = new AtomicLong();
                    AtomicLong vowels = new AtomicLong();
                    // ---------------------====First solution====---------------------
                    Arrays.stream(sentence.split("")).forEach(symbol -> {
                                matcher.set(vowelsSymbols.matcher(symbol));
                                if (!symbol.equals("\s")) {
                                    if (matcher.get().find()) {
                                        vowels.getAndIncrement();
                                    } else {
                                        consonants.getAndIncrement();
                                    }
                                }
                            }
                    );
                    return consonants.get() - vowels.get();
                },
                (x, y) -> {
                    System.out.println("Key error");
                    return 404L; // Возвращаю как показатель ошибки так как повториться ключ возможность не имеет
                },
                LinkedHashMap::new
        ));
    }
}
