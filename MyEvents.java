import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyEvents implements ActionListener {
    MyForm form ;
    MyDataBase myDataBase ;

    public MyEvents(MyForm form) {
        this.form = form;
        myDataBase = new MyDataBase();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==form.ajouter)
        {
            if(form.nomI.getText().length()>0){
                Personne p = new Personne(form.nomI.getText(), form.bg.getSelection().getActionCommand());
                if(myDataBase.Ajouter(p)>0)
                    JOptionPane.showMessageDialog(null, "Insertion effectuee");
                else
                    JOptionPane.showMessageDialog(null, "Echec d'insertion");
            } else {
                JOptionPane.showMessageDialog(null, "Merci de saisir votre nom");
            }

        }
        //Boutton Supprimer
//        if(e.getSource()==supprimer)
//        {
//            if(myDataBase.Supprimer(Integer.parseInt(idT.getText()))>0)
//                JOptionPane.showMessageDialog(null, "Suppression effectu�e");
//            else
//                JOptionPane.showMessageDialog(null, "Echec de Suppression");
//        }
//        //Boutton Modifier
//        if(e.getSource()==modifier)
//        {
//            if(myDataBase.Modifier(Integer.parseInt(idT.getText()), nomT.getText(), prenomT.getText(), adresseT.getSelectedItem().toString())>0)
//                JOptionPane.showMessageDialog(null, "Modification effectu�e");
//            else
//                JOptionPane.showMessageDialog(null, "Echec de Mise � jour");
//        }

    }
}
