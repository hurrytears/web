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
            for(File f: dir.listFiles()){
                find(f);
            }
        }else {
            br = new BufferedReader(new FileReader(dir));
            String line;
            while( (line = br.readLine()) != null) {
                if (line.toLowerCase().contains("web") && !line.toLowerCase().contains("author")
                        && !dir.getPath().contains(".css")
                        && !dir.getPath().contains(".git")
                        && !dir.getPath().contains(".html")
                        && !dir.getPath().contains(".js")
                        ){
                    System.out.println(dir.getPath() + "---------------->" + line);
                }
            }
        }
    }
}
