/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andrei
 */
public class OpenFile {
    public static void main(String[] args) {
        Consumer<Exception> log = new Consumer<Exception>() {
            public void accept(Exception e) {
                Logger.getLogger(OpenFile.class.getName())
                        .log(Level.INFO, null, e);
            }
        };
 
        try {
            BufferedReader r = new BufferedReader(new FileReader("text.txt"));
            try {
                while (r.ready()) {
                    System.out.println(r.readLine());
                }
            } catch (IOException e) {
                log.accept(e);
            } finally {
                try {
                    r.close();                
                } catch (IOException e) {
                    log.accept(e);
                }
            }
        } catch (FileNotFoundException e) {
            log.accept(e);            
        }        
    }
}
