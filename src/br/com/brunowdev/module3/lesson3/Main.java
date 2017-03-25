package br.com.brunowdev.module3.lesson3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by BRUNO-PC on 25/03/2017.
 */
public class Main {

    public static void main(String... args) {

        wrongWay();

        myWay();

    }

    private static void wrongWay() {

        List<Long> values = createMyList();

        LongAdder longAdder = new LongAdder();

        // Isto é errado porque muda o "estado" dentro de um loop funcional
        // O correto é apenas utilizar para métodos que não alteram o estado de objetos
        values.stream().forEach(value -> longAdder.add(value));

        long total = longAdder.sum();

    }

    private static void myWay() {

        List<Long> values = createMyList();

        // Correto: Pois não altera o estado de nenhum objeto dentro do loop funcional
        // Utiliza os valores do objeto para obter a informação necessária
        long total = values
                .stream()
                .mapToLong(Long::longValue)
                .sum();

    }

    private static List<Long> createMyList() {
        List<Long> values = new ArrayList<>(3);

        values.add(0l);
        values.add(1l);
        values.add(2l);

        return values;
    }


}
