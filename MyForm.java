import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;

public class MyForm extends JFrame {
    //les libelles
    JPanel fieldset = new JPanel();
    JLabel formulaire = new JLabel("Exam Tp");
    JLabel nomL=new JLabel("Nom");
    JLabel genreL=new JLabel("Genre");
    // les Inputs
    JTextField nomI = new JTextField(25);
    // les Buttons
    JButton liste=new JButton("Liste");
    JButton ajouter=new JButton("Ajouter");
    JRadioButton hommeI = new JRadioButton("Homme");
    JRadioButton femmeI = new JRadioButton("Femme");
    ButtonGroup bg = new ButtonGroup();
    public MyForm() {
        super("Exam");
        formulaire.setHorizontalAlignment(SwingConstants.CENTER);
        formulaire.setForeground(Color.black);
        formulaire.setFont(new Font("Time New Roman", Font.BOLD, 15));
        hommeI.setSelected(true);
        hommeI.setActionCommand("Homme");
        femmeI.setActionCommand("Femme");
        bg.add(hommeI);
        bg.add(femmeI);
        // Panel Formulaire
        JPanel panelFormulaire=new JPanel();
        panelFormulaire.setLayout(new GridLayout(2,2));
        panelFormulaire.add(nomL);
        panelFormulaire.add(nomI);
        panelFormulaire.add(genreL);
        JPanel panelRadioBouttons=new JPanel();
        panelRadioBouttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelRadioBouttons.add(hommeI);
        panelRadioBouttons.add(femmeI);
        panelFormulaire.add(panelRadioBouttons);


        // Panel Buttons

        JPanel panelBouttons=new JPanel();
        panelBouttons.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelBouttons.add(liste);
        panelBouttons.add(ajouter);
        fieldset.add(panelFormulaire);
        fieldset.setBorder(BorderFactory.createTitledBorder("informations"));
        // Panel Assemblages
        JPanel panelAssemblage=new JPanel();
        panelAssemblage.setLayout(new BorderLayout());
        panelAssemblage.add("Center",fieldset);
        panelAssemblage.add("South",panelBouttons);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add("North",formulaire);
        c.add("Center",panelAssemblage);
        setSize(600,200);
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ajouter.addActionListener(new MyEvents(this));
        liste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyList myList = new MyList();
                myList.initScreen();
            }
        });
        show();
    }
    public static void main (String[] args)
    {
        new MyForm();
    }
}
