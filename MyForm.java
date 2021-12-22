import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyForm extends JFrame {
    JLabel formulaire = new JLabel("Exam Tp");
    JLabel nomL=new JLabel("Nom");
    JLabel genreL=new JLabel("genre");
    JTextField nomI = new JTextField();
    JButton valider=new JButton("Ajouter");
    JButton annuler=new JButton("Annuler");
    JRadioButton hommeI = new JRadioButton("Homme");
    JRadioButton femmeI = new JRadioButton("Femme");
    ButtonGroup bg = new ButtonGroup();
    public MyForm() {
        super("Exam");
        formulaire.setHorizontalAlignment(SwingConstants.CENTER);
        formulaire.setForeground(Color.black);
        formulaire.setFont(new Font("Time New Roman", Font.BOLD, 15));
        hommeI.setSelected(true);
        bg.add(hommeI);
        bg.add(femmeI);
        JPanel panelFormulaire=new JPanel();
        panelFormulaire.setLayout(new GridLayout(0,1));
        Container c = getContentPane();
        panelFormulaire.add(formulaire);
        panelFormulaire.add(nomL);
        panelFormulaire.add(nomI);
        panelFormulaire.add(genreL);
        panelFormulaire.add(hommeI);
        panelFormulaire.add(femmeI);
        panelFormulaire.add(valider);
        panelFormulaire.add(annuler);
        c.add(panelFormulaire);
        setSize(500,200);
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        show();
    }
    public static void main (String[] args)
    {
        new MyForm();
    }
}
