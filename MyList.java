import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.geom.AffineTransform;
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
    private final double phi = Math.toRadians(40);
    private final int barb = 20;
    private int chartwidth, chartheight, chartX, chartY;
    public MyList() {
        myDataBase = new MyDataBase();
        model = new DefaultTableModel(entete,0);
        table= new JTable(model);
        chart = new JPanel();
        sp = new JScrollPane();
        myThread = new MyThread(this);



    }
    private void drawArrowHead(Graphics2D g2, Point tip, Point tail, Color color)
    {
        g2.setPaint(color);
        double dy = tip.y - tail.y;
        double dx = tip.x - tail.x;
        double theta = Math.atan2(dy, dx);
        double x, y, rho = theta + phi;
        for(int j = 0; j < 2; j++)
        {
            x = tip.x - barb * Math.cos(rho);
            y = tip.y - barb * Math.sin(rho);
            g2.draw(new Line2D.Double(tip.x, tip.y, x, y));
            rho = theta - phi;
        }
    }
    public void drawChart(){
        int rightX = chartX + chartwidth;
        int topY = chartY - chartheight;
        Point sw = new Point(chartX, chartY);
        Point ne = new Point(rightX, chartY);
        graphe.draw(new Line2D.Double(sw, ne));
        drawArrowHead(graphe, ne, sw, Color.green);

        Point sw1 = new Point(chartX, chartY );
        Point ne1 = new Point(chartX, topY);
        graphe.setColor(Color.red);
        graphe.drawString("Genre", chartwidth, chartY + 25) ;

        Font original = graphe.getFont();

        Font font = new Font(null, original.getStyle(), original.getSize());
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(-90), 0, 0);
        Font rotatedFont = font.deriveFont(affineTransform);
        graphe.setFont(rotatedFont);
        double malePercentage = 0;
        double femalePercentage = 0;
        int total=0;
        int maleNumber = Integer.parseInt(myDataBase.getPersonneByGenre("Homme"));
        int femaleNumber =  Integer.parseInt(myDataBase.getPersonneByGenre("Femme"));
        total = maleNumber + femaleNumber;
        malePercentage = calculatePercentage(maleNumber, total);
        femalePercentage = calculatePercentage(femaleNumber, total);

        String str = "Homme: "+malePercentage+ "%  Femme: " +calculatePercentage(femaleNumber, total) + "%";
        graphe.setFont(original);
        graphe.setColor(Color.red);
        graphe.drawString(str, chartwidth/2 , chartY -60) ;

    }

    public void drawRectangle(String personNumber, Color color, int margin) {
        int height = Integer.parseInt(personNumber);
        int barWidth = 50;
        int xLeft = 50 + margin;
        int yTopLeft = chartY - height;
        Rectangle rec = new Rectangle(xLeft, yTopLeft, barWidth, height);
        graphe.setColor(color);
        graphe.fill(rec);
        graphe.setColor(Color.green);
    }

    public void init(){
        frame =new JFrame("My List");
        frame.setSize(800,400);
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        sp.getViewport().add(table);
        sp.setPreferredSize(new Dimension(800,200));

        JPanel panelTable = new JPanel(new GridLayout(2,1));
        chart.setSize(800,400);
        panelTable.add(sp);
        panelTable.add(chart);
        chart.setBackground(Color.BLACK);
        Container c=frame.getContentPane();
        c.setLayout(new BorderLayout());
        c.add("Center",panelTable);

        frame.setVisible(true);


        remplirTab();
        myThread.start();

    }

    private float calculatePercentage(int number, int total){
        return number * 100 / total;
    }
    public void remplirTab(){
        int width = chart.getWidth();
        int height = chart.getHeight();
        String maleNumber = myDataBase.getPersonneByGenre("Homme");
        String femaleNumber = myDataBase.getPersonneByGenre("Femme");
        chartwidth = width - 180;
        chartX = 25;
        chartY = height - 30;
        myDataBase.remplirTab(model);
        chartheight = Integer.parseInt(myDataBase.getPersonnes());
        graphe=(Graphics2D)chart.getGraphics();
        drawRectangle(maleNumber,Color.blue,0);
        drawRectangle(femaleNumber,Color.white,80);
        drawChart();

    }
}
