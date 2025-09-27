import com.uacm.edu.championsmx.vista.VistaPrincipal;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(()-> {
            VistaPrincipal vista = new VistaPrincipal();
            vista.setVisible(true);
        });
    }
}