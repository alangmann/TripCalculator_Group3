import javax.swing.*;
import java.awt.event.ActionEvent;

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
    private ButtonGroup vehicleGroup;



    public void initialize()
    {
        cbAdBlue.removeAllItems();
        cbFuel.removeAllItems();
        vehicleGroup = new ButtonGroup();
        vehicleGroup.add(rbCar);
        vehicleGroup.add(rbTruck);

        cbAdBlue.addItem("yes");
        cbAdBlue.addItem("no");

        cbFuel.addItem("DIESEL");
        cbFuel.addItem("PATROL");

        btAccept.addActionListener((java.awt.event.ActionListener) this);
    }

    public void actionPerformed(ActionEvent e) {

        if(vehicleGroup.getSelection().equals(rbCar))
        {
            if(cbFuel.getSelectedItem().equals("DIESEL")) {
                Car c = new Car(Integer.parseInt(tfCargo.getText()), Vehicle.fuelType.DIESEL, Double.parseDouble(tfConsumption.getText()));
            }
            else if(cbFuel.getSelectedItem().equals("PATROL"))
            {
                Car c = new Car(Integer.parseInt(tfCargo.getText()), Vehicle.fuelType.PATROL, Double.parseDouble(tfConsumption.getText()));
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Nicht alles ausgewählt");
            }
        }


    }

}
