/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andrei
 */
public class RunTextEditor {
        public static void main(String[] args) {
        final String processName;
        final String processArg;
        final String osName = System.getProperty("os.name");
        
        if (osName.equals("Linux")) {
            processName = "gedit";
            processArg = "--new-window";
        } else if (osName.contains("Windows")) {
            processName = "notepad.exe";
            processArg = "";
        } else if (osName.contains("OSX")) {
            processName = "Note";
            processArg = "";
        } else {
            System.out.println("Invalid operating system");
            return;
        }
        
        try {
            ProcessBuilder pb;
            pb = new ProcessBuilder(processName, processArg);
            Process p1 = pb.start();
            Process p2 = pb.start();
            Process p3 = pb.start();        
        } catch (IOException ex) {
            Logger.getLogger(Multiprocess.class.getName()).log(Level.SEVERE,
                "IOException found in RunTextEditorThreeTimes", ex);            
        }
    }    
}
