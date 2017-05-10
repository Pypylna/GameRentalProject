import GUI.WAdministratorPanel;
import GUI.WAdding;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) throws Exception {

        WAdministratorPanel wAdminPanel = new WAdministratorPanel();
        wAdminPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wAdminPanel.setVisible(true);

    }
}
