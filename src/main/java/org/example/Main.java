package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {

    private static final String input = "resources/input.txt";

    public static void main(String[] args) throws IOException {

        Writer fileWriter = new FileWriter("resources/output.txt");

        List<String> res = new ArrayList<>();
        for (String[] erey : compareItems()) {
            res.add(Arrays.toString(erey));
        }

        for (String item : res) {
            fileWriter.write(item);
            fileWriter.write("\n");
        }
        fileWriter.close();
    }


    public static String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    public static String getInput() {
        String temple = Main.readFileContentsOrNull(input);
        return temple;
    }

    public static String[] join(String[] a, String[] b) {
        String[] result = Arrays.copyOf(a, a.length + b.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    public static List<String[]> compareItems() {

        String[] itemNames = getInput().split("\\n");
        String number = itemNames[0];
        int parseInt = Integer.parseInt(number);
        List<String> firstPart = new ArrayList<>();

        for (int i = 1; i < parseInt + 1; i++) {
            firstPart.add(itemNames[i]);
        }

        List<String[]> result = new ArrayList<>();
        List<String[]> itemsArreysF = new ArrayList<>();
        for (String itemFirst : firstPart) {
            itemsArreysF.add(itemFirst.split("\\s"));
        }

        List<String> secondPart = new ArrayList<>();

        for (int i = parseInt + 1; i < itemNames.length; i++) {
            secondPart.add(itemNames[i]);
        }

        List<String[]> itemsArreysS = new ArrayList<>();
        for (String itemFirst : secondPart) {
            itemsArreysS.add(itemFirst.split("\\s"));
        }

        for (String[] erey : itemsArreysF) {
            for (int i = 0; i < itemsArreysS.size(); i++) {

                String[] common = join(erey, itemsArreysS.get(i));
                Set<String> items = new HashSet<>(Arrays.asList(common));
                if (common.length != items.size()) {
                    if (!result.contains(erey))
                        result.add(erey);
                    String[] q = {":"};
                    result.add(q);
                    if (!result.contains(itemsArreysS.get(i)))
                        result.add(itemsArreysS.get(i));
                } else {
                    if (!result.contains(erey)) {
                        result.add(erey);

                    }
                }
            }
        }

        return result;
    }
}
