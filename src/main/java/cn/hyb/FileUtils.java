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

    private List<Path> fileNames;
    private Iterator<Path> iterator = null;

    FileUtils(String baseWorkSpace, List<String> targetSuffix) {
        try {
            fileNames = Files.walk(Paths.get(baseWorkSpace))
                    .filter(Files::isRegularFile)
                    .filter(f -> {
                        for (String suffix : targetSuffix) {
                            if (f.toString().endsWith(suffix)) {
                                return true;
                            }
                        }
                        return false;
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (fileNames != null && !fileNames.isEmpty()) {
            iterator = fileNames.iterator();
        }
    }

    public Iterator<Path> getFileIterator() {
        return iterator;
    }

    public List<String> getFileContent(Path dirName) {
        try {
            return Files.lines(dirName).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
