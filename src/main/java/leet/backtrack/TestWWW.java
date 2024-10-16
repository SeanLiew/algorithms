package leet.backtrack;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: liuxiaozheng
 * @date 2024-10-16 12:07
 */
public class TestWWW {
    static class File{
        String fileName;

        String fileContent;

        public File(String name){
            this.fileName = name;
        }
    }

    static class FileDir{

        String fileDirName;

        List<FileDir> fileDirs;

        Map<String, FileDir> fileDirMap;

        List<File> files;

        public FileDir(String name){
            this.fileDirName = name;
            fileDirs = new ArrayList<>();
            files = new ArrayList<>();
            fileDirMap = new HashMap<>();
        }
    }

    static class FileStstem{
        public static FileDir root = new FileDir("root");

        //"/a/b"
        public static FileDir createFileDir(String path) {
            String[] pathArr = path.split("/");
            FileDir last = root;
            for (String filePathName : pathArr) {
                //""
                FileDir fileDir = last.fileDirMap.get(filePathName);
                if (fileDir == null) {
                    fileDir = new FileDir(filePathName);
                }
                if (last != null) {
                    last.fileDirs.add(fileDir);
                    last.fileDirMap.put(fileDir.fileDirName, fileDir);
                }
                last = fileDir;
            }
            return last;
        }

        public static void createFile(String path, String fileName) {
            FileDir lastFileDir = createFileDir(path);

            File file = new File(fileName);

            lastFileDir.files.add(file);
        }

        public static void printFileDirAndFilesOfPath(String path) {
            String[] pathArr = path.split("/");
            //需要找的目录
            FileDir targetFileDir = null;
            FileDir firstOfSearch = root;
            for (String filePathName : pathArr) {
                FileDir temp = firstOfSearch.fileDirMap.get(filePathName);
                if (temp == null) {
                    targetFileDir = null;
                    break;
                }
                firstOfSearch = temp;
                targetFileDir = temp;
            }
            //没找到
            if (targetFileDir == null) {
                return;
            }
            if (targetFileDir != null) {
                System.out.println("目录:");
                if (targetFileDir.fileDirs != null) {
                    for (FileDir fileDir : targetFileDir.fileDirs) {
                        System.out.println(fileDir.fileDirName);
                    }
                }
                System.out.println("文件:");
                if (targetFileDir.files != null) {
                    for (File file : targetFileDir.files) {
                        System.out.println(file.fileName);
                    }
                }
            }
        }

        // "a/b"
        public static void deleteFileDir(String path) {
            String[] pathArr = path.split("/");
            //需要找的目录
            FileDir targetFileDir = root;
            FileDir upperLevelDir = root;
            for (String filePathName : pathArr) {
                FileDir temp = targetFileDir.fileDirMap.get(filePathName);
                if (temp == null) {
                    targetFileDir = null;
                    break;
                }
                upperLevelDir = targetFileDir;
                targetFileDir = temp;
            }
            //不存在
            if (targetFileDir == null) {
                return;
            }
            List<FileDir> fileDirs = upperLevelDir.fileDirs;
            //删除
            Iterator<FileDir> iterator = fileDirs.iterator();
            while (iterator.hasNext()) {
                FileDir temp = iterator.next();
                if (temp.fileDirName.equals(targetFileDir.fileDirName)) {
                    iterator.remove();
                }
            }

            upperLevelDir.fileDirMap.remove(targetFileDir.fileDirName);

        }


        public static void deleteFile(String path, String fileName) {
            String[] pathArr = path.split("/");
            //需要找的目录
            FileDir targetFileDir = root;
            for (String filePathName : pathArr) {
                FileDir temp = targetFileDir.fileDirMap.get(filePathName);
                if (temp == null) {
                    targetFileDir = null;
                    break;
                }
                targetFileDir = temp;
            }
            //不存在
            if (targetFileDir == null) {
                return;
            }
            List<File> file = targetFileDir.files;
            //删除
            Iterator<File> iterator = file.iterator();
            while (iterator.hasNext()) {
                File temp = iterator.next();
                if (temp.fileName.equals(fileName)) {
                    iterator.remove();
                }
            }
        }

        public static void modifyFile(String path, String fileName, String newContent) {
            String[] pathArr = path.split("/");
            //需要找的目录
            FileDir targetFileDir = root;
            for (String filePathName : pathArr) {
                FileDir temp = targetFileDir.fileDirMap.get(filePathName);
                if (temp == null) {
                    targetFileDir = null;
                    break;
                }
                targetFileDir = temp;
            }
            //不存在
            if (targetFileDir == null) {
                return;
            }
            List<File> file = targetFileDir.files;
            Iterator<File> iterator = file.iterator();
            while (iterator.hasNext()) {
                File temp = iterator.next();
                if (temp.fileName.equals(fileName)) {
                    temp.fileContent = newContent;
                }
            }
        }

        public static void printFile(String path, String fileName) {
            String[] pathArr = path.split("/");
            //需要找的目录
            FileDir targetFileDir = root;
            for (String filePathName : pathArr) {
                FileDir temp = targetFileDir.fileDirMap.get(filePathName);
                if (temp == null) {
                    targetFileDir = null;
                    break;
                }
                targetFileDir = temp;
            }
            //不存在
            if (targetFileDir == null) {
                return;
            }
            List<File> file = targetFileDir.files;
            Iterator<File> iterator = file.iterator();
            while (iterator.hasNext()) {
                File temp = iterator.next();
                if (temp.fileName.equals(fileName)) {
                    System.out.println(temp.fileContent);
                }
            }
        }
    }


    public static void main(String[] args) {
        FileDir fileDir = FileStstem.createFileDir("a/b");
        FileStstem.printFileDirAndFilesOfPath("a");

        FileStstem.createFile("a", "c");
        FileStstem.printFileDirAndFilesOfPath("a");

        FileStstem.deleteFile("a", "c");
        FileStstem.printFileDirAndFilesOfPath("a");


    }
}
