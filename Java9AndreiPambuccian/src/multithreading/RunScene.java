/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

/**
 *
 * @author andrei
 */
public class RunScene {
    static class Television implements Runnable {
        private String[] shows = {"News", "Weather", "Film1", "Film2"};
        private String show = shows[0];
        
        public synchronized void check(String checkedShow) {
            if (show.equals(checkedShow)) {
                notify();
            }
        }
        
        public synchronized String take() {
            try {
                wait();
                return show;
            } catch (InterruptedException ex) {
                return null;
            }
        }
        
        @Override
        public void run() {
            int i = 0;
            try {
                while (true) {
                    Thread.sleep(100);
                    i = i == shows.length - 1 ? 0 : i + 1;
                    show = shows[i];
                }
            } catch (InterruptedException ex) {
                show = null;
            }
        }
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Television television = new Television();
        final String targetShow = "Film2";
        Runnable wife = () -> {
            while(true) {
                System.out.println(television.take());
            }
        };
        Thread threadWife = new Thread(wife);
        
        Runnable husband = () -> {
            try {
                while (true) {
                    television.check(targetShow);
                    Thread.sleep(100);
                }
            } catch (InterruptedException ex) {
               threadWife.interrupt();
            }
        };
        
        new Thread(television).start();
        new Thread(husband).start();
        threadWife.setPriority(Thread.MAX_PRIORITY);
        threadWife.start();
    }
}
