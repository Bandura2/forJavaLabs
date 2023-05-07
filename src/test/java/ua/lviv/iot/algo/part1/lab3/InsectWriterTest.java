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

    private static final String PATH_TO_TEST_RESOURCES = "src\\test\\resources\\";
    private static final String FILE_NAME = "fileInsects.csv";
    private static final String EMPTY_FILE_NAME = "emptyFileInsect.csv";
    private static final String EXPECTED_FILE_NAME = "expectedFileInsects.csv";

    @AfterAll
    public static void clean() {

        new File(PATH_TO_TEST_RESOURCES + FILE_NAME).delete();
        new File(PATH_TO_TEST_RESOURCES + EMPTY_FILE_NAME).delete();
    }

    @BeforeEach
    public void setUp() throws FileNotFoundException {

        InsectManager emptyManager = new InsectManager();
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

        InsectWriter writer = new InsectWriter();
        writer.writeToFile(manager.getInsects(), PATH_TO_TEST_RESOURCES +  FILE_NAME);
        writer.writeToFile(emptyManager.getInsects(), PATH_TO_TEST_RESOURCES + EMPTY_FILE_NAME);
    }

    @Test
    public void testWriteToFile() throws IOException {

        Path path1 = Paths.get(PATH_TO_TEST_RESOURCES + EXPECTED_FILE_NAME);
        Path path2 = Paths.get(PATH_TO_TEST_RESOURCES + FILE_NAME);

        Assertions.assertEquals(-1L, Files.mismatch(path1, path2));
    }

    @Test
    public void testWriteToFileIsEmpty() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(PATH_TO_TEST_RESOURCES + EMPTY_FILE_NAME));
        Assertions.assertNull(reader.readLine());
        reader.close();
    }
}
