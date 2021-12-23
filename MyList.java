import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.geom.Line2D;

public class MyList extends JFrame{
    String entete[] = {"ID","Nom","Genre"};
    DefaultTableModel model;
    JTable table ;
    JPanel chart;
    JScrollPane sp ;
    MyDataBase myDataBase;
    MyThread myThread;
    Graphics2D graphe;
    JFrame frame;
    public MyList() {
        myDataBase = new MyDataBase();
        model = new DefaultTableModel(entete,0);
        table= new JTable(model);
        chart = new JPanel();
        sp = new JScrollPane();
        myThread = new MyThread(this);



    }
    public void drawChart(){
        Dimension prefPanelSize  = chart.getSize();
        Line2D horizontalLine = new Line2D.Float(0, prefPanelSize.height-50, prefPanelSize.width, prefPanelSize.height-50);
        Line2D verticalLine = new Line2D.Float(prefPanelSize.width /15, 0,
                prefPanelSize.width / 15, prefPanelSize.height);
        graphe.setColor(Color.green);
        graphe.draw(horizontalLine);
        graphe.draw(verticalLine);
    }
    public void drawRectangle(String hommeNumber) {
        Dimension d = chart.getSize();
        int height = Integer.parseInt(hommeNumber);
        graphe.setColor(Color.blue);
        graphe.drawRect(0,0,20,800+(height*3));
        graphe.setBackground(Color.blue);
    }

    public void initScreen(){
        frame =new JFrame("My List");
        frame.setSize(800,400);
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        sp.getViewport().add(table);
        sp.setPreferredSize(new Dimension(800,200));

        JPanel panelTable = new JPanel(new GridLayout(2,1));
        panelTable.add(sp);
        panelTable.add(chart);
        chart.setBackground(Color.BLACK);
        Container c=frame.getContentPane();
        c.setLayout(new BorderLayout());
        c.add("Center",panelTable);

        frame.setVisible(true);
        graphe=(Graphics2D)chart.getGraphics();
        remplirTab();
        myThread.start();

    }
    public void remplirTab(){

        myDataBase.remplirTab(model);
        String hommeNumber = myDataBase.getPersonneByGenre("Homme");
        String FemmeNumber = myDataBase.getPersonneByGenre("Femme");
        drawChart();
        drawRectangle(hommeNumber);
    }
}
