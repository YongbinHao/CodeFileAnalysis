package cn.hyb;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtils {

    private String workSpace;
    private List<String> fileNames;
    private Iterator<String> iterator = null;


    FileUtils(String baseWorkSpace) {
        try {
            workSpace = baseWorkSpace;
            fileNames = Files.list(Paths.get(baseWorkSpace))
                    .map(f -> f.getName(f.getNameCount() - 1).toString())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (fileNames != null && !fileNames.isEmpty()) {
            iterator = fileNames.iterator();
        }
    }

    public Iterator<String> getFileIterator() {
        return iterator;
    }

    public List<String> getFiles(String dirName) {
        try {
            return Files.walk(Paths.get(workSpace + dirName))
                    .filter(f -> f.toString().endsWith(".java") || f.toString().endsWith(".xml"))
                    .map(Path::toString)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
