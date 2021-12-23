import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MyList extends JFrame {
    String entete[] = {"ID","Nom","Genre"};
    DefaultTableModel model;
    JTable table ;
    JScrollPane sp ;
    MyDataBase myDataBase;
    MyThread myThread;
    public MyList() {
         myDataBase = new MyDataBase();
        model = new DefaultTableModel(entete,0);
        table= new JTable(model);
        sp = new JScrollPane();
        myThread = new MyThread(this);

    }

    public void initScreen(){
        sp.getViewport().add(table);
        sp.setPreferredSize(new Dimension(800,200));
        JPanel panelTable = new JPanel();
        panelTable.add(sp);
        Container c=getContentPane();
        c.setLayout(new BorderLayout());
        c.add("Center",panelTable);
        setSize(900,400);
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //remplirTab();
        myThread.start();
        show();
    }
    public void remplirTab(){
        myDataBase.remplirTab(model);
    }
}
