import javax.swing.*;

/**
 * Created by Dominik on 04.12.2014.
 */
public class TripCalculatorGUI {
    private JPanel panel1;
    private JButton btAccept;
    private JRadioButton rbCar;
    private JRadioButton rbTruck;
    private JTextField tfConsumption;
    private JComboBox cbAdBlue;
    private JComboBox cbFuel;
    private JTextField tfCargo;
    private JTextField tfAxles;

    public void fillComboBoxes()
    {
        cbAdBlue.addItem("yes");
        cbAdBlue.addItem("no");

        cbFuel.addItem("Diesel");
        cbFuel.addItem("Patroleum");
    }

}
