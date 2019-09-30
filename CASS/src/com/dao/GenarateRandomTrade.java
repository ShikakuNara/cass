package com.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class GenarateRandomTrade {

    public void generateTrades() {

        ProcessBuilder processBuilder = new ProcessBuilder("C:\\Users\\Nk\\Desktop\\ButtonClick\\project\\project_run.bat");
       
		//Process process = Runtime.getRuntime().exec(
        //            "cmd /c hello.bat", null, new File("C:\\Users\\mkyong\\"));
					
        try {

            Process process = processBuilder.start();

            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println(output);
               // System.exit(0);
            } else {
                //abnormal...
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
