public class MyThread extends Thread{
    private MyList myList;
    public MyThread(MyList myList) {
        this.myList = myList;
    }

    public void histogramme (int nbPersonnes){

    }

    public void axesXY(int nbrPersonnes, String labelX, String labelY) {

    }
    public void run() {

        while (true){
            try {
                this.myList.remplirTab();
                sleep(1000);


            } catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }
}
