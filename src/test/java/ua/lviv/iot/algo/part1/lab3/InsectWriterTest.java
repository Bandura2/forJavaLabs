package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class InsectWriterTest {
    InsectWriter writer;
    BufferedReader reader;

    @AfterAll
    public static void cleaning() {

        File actualFile = new File("src/test/resources/fileInsects.csv");
        File emptyFile = new File("src/test/resources/emptyFileInsect.csv");

        actualFile.delete();
        emptyFile.delete();
    }

    @BeforeEach
    public void setUp() throws FileNotFoundException {

        InsectManager manager = new InsectManager();

        Insect mosquitoFirst = new Mosquito("Vasya", 4, true, false, false);
        Insect mosquitoSecond = new Mosquito("Artur", 6, true, true, true);
        Insect hornetFirst = new Hornet("Locky", 2, true, false, true);
        Insect hornetSecond = new Hornet("Sherlok", 4, true, true, false);
        Insect butterflyFirst = new Butterfly("Filename", 8, true, false, false);
        Insect butterflySecond = new Butterfly("Dinar", 6, true, false, true);
        Insect mantisFirst = new Mantis("Olena", 8, false, true, false);
        Insect mantisSecond = new Mantis("Zoro", 2, false, true, true);

        manager.addInsect(mosquitoFirst);
        manager.addInsect(hornetFirst);
        manager.addInsect(butterflyFirst);
        manager.addInsect(hornetSecond);
        manager.addInsect(butterflySecond);
        manager.addInsect(mantisFirst);
        manager.addInsect(mosquitoSecond);
        manager.addInsect(mantisSecond);

        writer = new InsectWriter();
        writer.writeToFile(manager.getInsects(), "src/test/resources/fileInsects.csv");
    }

    @Test
    public void testWriteToFile() throws IOException {

        Path path1 = Paths.get("src/test/resources/expectedFileInsects.csv");
        Path path2 = Paths.get("src/test/resources/fileInsects.csv");

        Assertions.assertEquals(-1L, Files.mismatch(path1, path2));
    }

    @Test
    public void testWriteToFileIsEmpty() throws IOException {

        InsectManager emptyManager = new InsectManager();
        writer = new InsectWriter();

        writer.writeToFile(emptyManager.getInsects(), "src/test/resources/emptyFileInsect.csv");

        reader = new BufferedReader(new FileReader("src/test/resources/emptyFileInsect.csv"));

        while ((reader.readLine()) != null) {

            Assertions.assertNull(reader.readLine());
        }
    }

    @Test
    public void testIsPreviousFile() throws IOException {

        reader = new BufferedReader(new FileReader("src/test/resources/fileInsects.csv"));
        Assertions.assertNotNull(reader);
    }
}
