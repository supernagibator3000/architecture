public class PingPong extends Thread{
    private String message;
    private Object object;

    public PingPong(String message, Object object) {
        this.message = message;
        this.object = object;
    }

    @Override
    public void run(){
        synchronized (object){
            while (true) {
                System.out.println(message);
                object.notify();
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
