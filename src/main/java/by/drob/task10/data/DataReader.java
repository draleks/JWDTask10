package by.drob.task10.data;

import by.drob.task10.exception.DataException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DataReader {
    public String read(String filePath) throws DataException {
        List<String> stringList;
        Path path = Paths.get(filePath);
        try {
            stringList = Files.readAllLines(path);
        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : stringList) {
            stringBuilder.append(line);
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
