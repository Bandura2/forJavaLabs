package ua.lviv.iot.algo.part1.lab3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public final class InsectWriter {


    public void writeToFile(final List<Insect> insect,
                            final String fileNam) throws FileNotFoundException {

        PrintWriter writer = new PrintWriter(fileNam);

        for (int i = 0; i < insect.size() - 1; i++) {
            for (int j = i + 1; j < insect.size(); j++) {
                if (insect.get(i).getClass().getSimpleName().compareTo(insect.get(j).getClass().getSimpleName()) > 0) {
                    Insect temp = insect.get(i);
                    insect.set(i, insect.get(j));
                    insect.set(j, temp);
                }
            }
        }

        for (int i = 0, j = 1; j < insect.size(); i++, j++) {
            if (i == 0) {

                writer.println(insect.get(i).getClass().getSimpleName());
                writer.println(insect.get(i).getHeaders());
                writer.println(insect.get(i).toCSV());
            }

            if (insect.get(i).getClass().equals(insect.get(j).getClass())) {

                writer.println(insect.get(j).toCSV());
                writer.println();

            } else {

                writer.println(insect.get(j).getClass().getSimpleName());
                writer.println(insect.get(j).getHeaders());
                writer.println(insect.get(j).toCSV());
            }
        }
        writer.close();
    }
}
