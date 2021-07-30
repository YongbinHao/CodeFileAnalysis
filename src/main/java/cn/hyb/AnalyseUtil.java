package cn.hyb;

import java.nio.file.Path;
import java.util.*;

public class AnalyseUtil {
    static public Map<String, HashMap<String, String>> analysis(String workSpace) {

        //构建扫描工具
        FileUtils fileUtils = new FileUtils(workSpace, Arrays.asList(".java", ".xml"));
        Map<String, HashMap<String, String>> res = new HashMap<>();
        //获取文件迭代器
        Iterator<Path> fileIterator = fileUtils.getFileIterator();
        //进行文件扫描
        while (fileIterator != null && fileIterator.hasNext()) {
            Path fileName = fileIterator.next();
            System.out.println("开始扫描文件：" + fileName);
            //获取代码文件内容
            List<String> codeFiles = fileUtils.getFileContent(fileName);
            //扫描每一行文件
            codeFiles.forEach(System.out::println);
        }
        return res;
    }

}
