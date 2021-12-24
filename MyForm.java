import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;

public class MyForm extends JFrame {
    JPanel fieldset = new JPanel();
    JLabel formulaire = new JLabel("Examen");
    JLabel nomL=new JLabel("Nom");
    JLabel genreL=new JLabel("Genre");
    JTextField nomI = new JTextField(25);
    JButton liste=new JButton("Liste");
    JButton ajouter=new JButton("Ajouter");
    JRadioButton hommeRadioButton = new JRadioButton("Homme");
    JRadioButton femmeRadioButton = new JRadioButton("Femme");
    ButtonGroup bg = new ButtonGroup();
    public MyForm() {

        super("Examen");
        Font myFont = new Font("SansSerif", Font.BOLD, 20);
        formulaire.setHorizontalAlignment(SwingConstants.CENTER);
        formulaire.setFont(myFont);
        hommeRadioButton.setSelected(true);
        hommeRadioButton.setActionCommand("Homme");
        femmeRadioButton.setActionCommand("Femme");
        bg.add(hommeRadioButton);
        bg.add(femmeRadioButton);

        JPanel myFormPanel=new JPanel();
        myFormPanel.setLayout(new GridLayout(2,2));
        myFormPanel.add(nomL);
        myFormPanel.add(nomI);
        myFormPanel.add(genreL);
        JPanel panelRadioBouttons=new JPanel();
        panelRadioBouttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelRadioBouttons.add(hommeRadioButton);
        panelRadioBouttons.add(femmeRadioButton);
        myFormPanel.add(panelRadioBouttons);


        JPanel panelBouttons=new JPanel();
        panelBouttons.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelBouttons.add(liste);
        panelBouttons.add(ajouter);
        fieldset.add(myFormPanel);
        fieldset.setBorder(BorderFactory.createTitledBorder("Informations"));


        JPanel panelAssemblage=new JPanel();
        panelAssemblage.setLayout(new BorderLayout());
        panelAssemblage.add("Center",fieldset);
        panelAssemblage.add("South",panelBouttons);
        Container c = getContentPane();

        c.setLayout(new BorderLayout());
        c.add("North",formulaire);
        c.add("Center",panelAssemblage);
        setSize(680,200);
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ajouter.addActionListener(new MyEvents(this));
        ActionListener actioneListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyList myList = new MyList();
                myList.init();
            }
        };
        liste.addActionListener(actioneListener);
        show();
    }
    public static void main (String[] args)
    {
        new MyForm();
    }
}
