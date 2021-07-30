package cn.hyb;

import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;

public class AnalyseUtil {

    static HashMap<String, String> NOTES_PATTERN = new HashMap<>();

    static {
        NOTES_PATTERN.put(".java", "//");
        NOTES_PATTERN.put(".xml", "<!--");
    }

    static public Map<Path, HashMap<String, String>> analysis(String workSpace, List<String> targetSuffix) {
        //构建扫描工具
        FileUtils fileUtils = new FileUtils(workSpace, targetSuffix);
        Map<Path, HashMap<String, String>> res = new HashMap<>();
        //获取文件迭代器
        Iterator<Path> fileIterator = fileUtils.getFileIterator();
        //进行文件扫描
        while (fileIterator != null && fileIterator.hasNext()) {
            Path fileName = fileIterator.next();
            System.out.println("开始扫描文件：" + fileName);
            //获取代码文件内容
            List<String> codeFiles = fileUtils.getFileContent(fileName);
            //获取文件的后缀名
            String suffix;
            int lastIndexOf = fileName.toString().lastIndexOf(".");
            if (-1 != lastIndexOf) {
                suffix = fileName.toString().substring(lastIndexOf);
            } else {
                continue;
            }

            //创建储存结果的HashMap
            HashMap<String, String> fileItemRes = new HashMap<>();

            //获取单个文件代码行数
            fileItemRes.put(CommonConstants.TOTAL_LINE_NUM, "" + codeFiles.size());

            //扫描每一行文件，获取注释及特定字符信息
            fileItemRes.put(CommonConstants.TOTAL_NOTE_LINE_NUM, "0");
            for (int i = 0; i < codeFiles.size(); i++) {
                String codeFile = codeFiles.get(i);
                String note = NOTES_PATTERN.get(suffix);
                int noteStart = codeFile.indexOf(note);
                if (-1 != noteStart) {
                    fileItemRes.put(CommonConstants.TOTAL_NOTE_LINE_NUM, "" + (Integer.parseInt(fileItemRes.get(CommonConstants.TOTAL_NOTE_LINE_NUM)) + 1));
                }
            }
            //将每个文件的结果放入总结果中
            res.put(fileName, fileItemRes);
        }
        return res;
    }

}
