package com.sosog;

import java.io.*;

public class Scan {

    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        File dir = new File("d:/Code/InteliJ/web");
        find(dir);
    }

    static void find(File dir) throws IOException {
        if(dir.isDirectory()){
            if(dir.getName().contains("ruoyi")){
                System.out.println(dir.getPath());
            }
            for(File f: dir.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if(dir.getPath().contains(".git") || dir.getPath().contains("\\target\\")
                            || dir.getPath().contains(".idea")
                            || dir.getPath().contains("Scan")
                            ){
                        return false;
                    }else {
                        return true;
                    }
                }
            })){
                find(f);
            }
        }else {
            br = new BufferedReader(new FileReader(dir));
            String line;
            while( (line = br.readLine()) != null) {
                if (line.contains("若依")){
                    //System.out.println("sed -i 's/若依/东皇/g' /"+dir.getAbsolutePath().replaceAll("\\\\","/").replaceAll(":",""));
                }
            }
        }
    }
}
