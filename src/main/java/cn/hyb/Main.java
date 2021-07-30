package cn.hyb;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

        Map<String, HashMap<String, String>> fileAnalysisRes = AnalyseUtil.analysis(BASE_WORKSPACE);
    }


}
