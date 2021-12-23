public class MyThread extends Thread{
    private MyList myList;
    public MyThread(MyList myList) {
        this.myList = myList;
    }

    public void run() {
        this.myList.remplirTab();
        try {
            sleep(100);
        } catch (Exception var3) {
        }
    }
}
