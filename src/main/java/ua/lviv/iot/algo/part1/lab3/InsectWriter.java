package ua.lviv.iot.algo.part1.lab3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public final class InsectWriter {


    public void writeToFile(final List<Insect> insect,
                            final String fileNam) throws FileNotFoundException {

        PrintWriter writer = new PrintWriter(fileNam);

        for (int i = 0; i < insect.size(); i++) {

            writer.println(insect.get(i).getClass().getSimpleName());
            writer.println(insect.get(i).getHeaders());
            writer.println(insect.get(i).toCSV());

            for (int j = i + 1; j < insect.size(); j++) {
                if ((insect.get(i).getClass()) == (insect.get(j).getClass())) {

                    writer.println(insect.get(j).toCSV() + "\n");
                    insect.remove(j);
                    j--;
                }
            }
        }
        writer.close();
    }
}
