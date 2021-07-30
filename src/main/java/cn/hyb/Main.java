package cn.hyb;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    /**
     * 代码扫描路径
     */
    static String BASE_WORKSPACE = "";//C:\Users\84541\Desktop\calculater

    public static void main(String[] args) {

        System.out.println("请输入目标代码库地址：（如 C:\\Users\\84541\\Desktop\\calculater）");
        Scanner scanner = new Scanner(System.in);
        BASE_WORKSPACE = scanner.nextLine();
        System.out.println("开始扫描代码库，请等待");
        //分析目录
        Map<Path, HashMap<String, String>> fileAnalysisRes = AnalyseUtil.analysis(BASE_WORKSPACE, Arrays.asList(".java", ".xml"));
        //汇总统计
        AtomicReference<Integer> totalLineNum = new AtomicReference<>(0);
        AtomicReference<Integer> totalNoteLineNum = new AtomicReference<>(0);
        fileAnalysisRes.forEach((file, countRes) -> {
            //获取当前文件的统计信息
            String lineNum = countRes.get(CommonConstants.TOTAL_LINE_NUM);
            String noteLineNum = countRes.get(CommonConstants.TOTAL_NOTE_LINE_NUM);
            //输出当前文件的信息
            System.out.println("文件名 :" + file.toString());
            System.out.println("\t当前文件行数:" + lineNum);
            System.out.println("\t当前文件注释行数:" + noteLineNum);
            //统计总数量
            totalLineNum.updateAndGet(v -> v + Integer.parseInt(lineNum));
            totalNoteLineNum.updateAndGet(v -> v + Integer.parseInt(noteLineNum));
        });
        //输出目录统计信息
        System.out.println("该目录总行数：" + totalLineNum);
        System.out.println("该目录注释总行数：" + totalNoteLineNum);
    }
}
