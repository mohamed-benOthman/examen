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
        if (e.getSource() == form.ajouter) {
            if (form.nomI.getText().length() > 0) {
                Personne p = new Personne(form.nomI.getText(), form.bg.getSelection().getActionCommand());
                if (myDataBase.Ajouter(p) > 0) {
                    form.nomI.setText("");
                    JOptionPane.showMessageDialog(null, "Ajouté avec succes");
                }
                else
                    JOptionPane.showMessageDialog(null, "Echec ");
            } else {
                JOptionPane.showMessageDialog(null, "Veuillez  saisir votre nom");
            }

        }
    }
}
