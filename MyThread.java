public class MyThread extends Thread{
    private MyList myList;
    public MyThread(MyList myList) {
        this.myList = myList;
    }

    public void run() {
        System.out.println("ddd");
        try {
            this.myList.remplirTab();
            sleep(1000);
        } catch (Exception var3) {
            System.out.println(var3);
        }
    }
}
