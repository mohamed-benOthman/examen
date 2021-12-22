import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyEvents implements ActionListener {
    MyForm form ;
    MyDataBase myDataBase = new MyDataBase(
            "com.mysql.jdbc.Driver",
            "jdbc:mysql://localhost/mydb",
            "root",
            ""
    );
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==form.valider)
        {
            if(myDataBase.Ajouter(form.nomI.getText(), form.hommeI.getText())>0)
                JOptionPane.showMessageDialog(null, "Insertion effectu�e");
            else
                JOptionPane.showMessageDialog(null, "Echec d'insertion");
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
