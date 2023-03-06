package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {


    private static final String input = "resources/input.txt";

    public static void main(String[] args) {

        System.out.println(compareItems());
    }


    public static String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    Outpoot input2 = new Outpoot();

    public static String getInput() {
        String temple = Main.readFileContentsOrNull(input);
        return temple;
    }


    public static String[] join(String[] a, String[] b) {
        String[] result = Arrays.copyOf(a, a.length + b.length);
        System.arraycopy(b, 0, result, a.length, b.length);

        return result;
    }


    public static String compareItems() {

        String[] itemNames = getInput().split("\\n");
        String number = itemNames[0];

        int parseInt = Integer.parseInt(number);
        List<String> firstPart = new ArrayList<>();

        for (int i = 0; i < parseInt + 1; i++) {
            firstPart.add(itemNames[i]);
        }
        System.out.println(firstPart);

        /////////////первая часть готова
        /////////////теперь нужно сделать массив из нее

        List<String[]> result = new ArrayList<>();
        List<String[]> itemsArreysF = new ArrayList<>();
        for (String itemFirst : firstPart) {

            itemsArreysF.add(itemFirst.split("\\s"));

        }


        List<String> secondPart = new ArrayList<>();
        List<String> resultItems = new ArrayList<>();


        for (int i = parseInt + 1; i < itemNames.length; i++) {
            secondPart.add(itemNames[i]);
        }
        System.out.println(secondPart);


        /////////////вторая часть готова
        /////////////теперь нужно сделать массив из нее

        List<String[]> itemsArreysS = new ArrayList<>();
        for (String itemFirst : secondPart) {

            itemsArreysS.add(itemFirst.split("\\s"));

        }


        for (String[] erey : itemsArreysF) {

            for (int i = 0; i < itemsArreysS.size(); i++) {

                String[] common = join(erey, itemsArreysS.get(i));
                Set<String> items = new HashSet<>(Arrays.asList(common));
                if (common.length != items.size()) {
                    result.add(erey);
                    result.add(itemsArreysS.get(i));
                }
               // result.add(erey);
            }


        }

        System.out.println( result);


        return null;
    }
}

///два списка с массивами готова


//            String substring = item;
//            String[] substrings = substring.split("\\s");
//
//            for (int i = 0; i < secondPart.size(); i++) {
//                String substringSecond = secondPart.get(i);
//                String[] substringsSeconds = substringSecond.split("\\s");
//
//                for (int j = 0; j < substrings.length; j++) {
//                    for (int k = 0; k < substringsSeconds.length; k++) {
//                        if (substrings[i].equals(substringsSeconds[j])) {
//                            itemsResembling = true;
//                        }
//                    }
//                }
//if (itemsResembling = true)
//                resultItems.add(item+":"+substringSecond);
//            }
//
//
//        }
//
//
//        System.out.println(resultItems);