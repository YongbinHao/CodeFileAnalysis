package cn.hyb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyseUtil {
    static public Map<String, HashMap<String, String>> analysis(String workSpace){

        //构建扫描工具
        FileUtils fileUtils = new FileUtils(workSpace);
        Map<String, List<String>> res = new HashMap<>();
        //获取文件迭代器
        fileUtils.getFileIterator();
        return null;
    }

}
