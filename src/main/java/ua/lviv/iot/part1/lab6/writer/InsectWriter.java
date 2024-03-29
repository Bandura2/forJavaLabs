package ua.lviv.iot.part1.lab6.writer;

import ua.lviv.iot.part1.lab6.model.Insect;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class InsectWriter {

    public void writeToFile(final List<Insect> insects,
                            final String fileNam) throws FileNotFoundException {

        PrintWriter writer = new PrintWriter(fileNam);
        Map<String, Boolean> classMap = new HashMap<>();

        insects.sort(Comparator.comparing(insect -> insect.getClass().getSimpleName()));

        for (Insect insect : insects) {
            String nameTemporaryClass = insect.getClass().getSimpleName();

            if (!classMap.containsKey(nameTemporaryClass)) {

                writer.println();
                writer.println(nameTemporaryClass);
                writer.println(insect.reurnHeaders());

                classMap.put(nameTemporaryClass, true);
            }
            if (classMap.containsKey(nameTemporaryClass)) {
                writer.println(insect.toCSV());
            }
        }
        writer.close();
    }
}
