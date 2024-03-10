package com.example.prompt.Util;

import java.io.*;

/**
 * 用于文件读入
 */
public class FileReadUtil {

    public static boolean writeFile(String path, String content) {
        File file = new File(path);
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {//if parent file doesn't exist and fail to make dir
            return false;
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            if (!file.exists() && !file.createNewFile()) {//if file doesn't exist and program fails to create file
                throw new IOException("fail to create file");
            }
            bufferedWriter.write(content);
            bufferedWriter.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String readFile(String path) {
        File file = new File(path);
        StringBuilder content = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(content);
    }

    public static boolean createDirectoryIfAbsent(String path) {
        File file = new File(path);
        return file.exists() || file.mkdirs();
    }
}
