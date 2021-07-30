package cn.hyb;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AnalyseUtil {
    static public Map<String, HashMap<String, String>> analysis(String workSpace) {

        //构建扫描工具
        FileUtils fileUtils = new FileUtils(workSpace);
        Map<String, HashMap<String, String>> res = new HashMap<>();
        //获取文件迭代器
        Iterator<String> fileIterator = fileUtils.getFileIterator();
        //进行文件扫描
        while (fileIterator != null && fileIterator.hasNext()) {
            String fileName = fileIterator.next();
            System.out.println("开始扫描文件：" + fileName);
            //获取目录下所有代码文件
            List<String> codeFiles = fileUtils.getFiles(fileName);
            //扫描每一个文件
            codeFiles.forEach(f -> {
            });
        }
        return res;
    }

}
