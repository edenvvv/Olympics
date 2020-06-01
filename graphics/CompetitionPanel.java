package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CompetitionPanel extends JPanel implements ActionListener {

    private BufferedImage img = null;
    private JPanel buttonPanel;

    public CompetitionPanel()
    {
        super(new BorderLayout());

        try
        {
            img = ImageIO.read(new File(IDrawable.PICTURE_PATH + "competitionBackground.png"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JDialog(), "Cannot open background file");
            System.exit(1);
        }

        this.buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout());

        JButton competition_button = new JButton("Competition");
        JButton add_animal_button = new JButton("Add Animal");
        JButton clear_button = new JButton("Clear");
        JButton eat_button = new JButton("Eat");
        JButton info_button = new JButton("Info");
        JButton exit = new JButton("Exit");
        //addVehicle.addActionListener(this);
        add(this.buttonPanel, BorderLayout.SOUTH);
        buttonPanel.add(competition_button);
        buttonPanel.add(add_animal_button);
        buttonPanel.add(clear_button);
        buttonPanel.add(eat_button);
        buttonPanel.add(info_button);
        buttonPanel.add(exit);



    }

    public void paintComponent(Graphics g)
    {
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e)
    {
        String name = e.getActionCommand();
        //try {
            if (name == "Add Vehicle") {}
               /* if (vehicleQueue.size()>0 && noOfVehicles!=MAX_NUMBER_OF_VEHICLES) //If there are queued vehicles add them isntead..
                {
                    AddVehicleDialog.AddVehicle(city);
                    System.out.println("Vehicle added from queue.");
                    repaint();
                    return;
                }
                if (vehicleQueue.size() == MAX_QUEUED_VEHICLES)
                    throw new ArraySizeException("The program supports "+ (MAX_NUMBER_OF_VEHICLES + MAX_QUEUED_VEHICLES) +" vehicles.");

                if (MAX_NUMBER_OF_ARCHIEVED_VEHICLES == noOfAchievedVehicles)
                    throw new ArraySizeException("The program can't contain more than "
                            + MAX_NUMBER_OF_ARCHIEVED_VEHICLES + " vehicles please restart the program.");
                new AddVehicleDialog(city);
                if (MAX_NUMBER_OF_VEHICLES == noOfVehicles)
                    JOptionPane.showMessageDialog(new JDialog(),"Max number of vehicles reached you may queue up to "
                            + MAX_QUEUED_VEHICLES + " there are currently " + vehicleQueue.size() +" vehicles in queue.","Queued "
                            + "Vehicles", JOptionPane.INFORMATION_MESSAGE);*/
            }
            /*if (name == "Clear") {
                if (noOfVehicles == 0)
                    throw new ArraySizeException("Error: no Vehicle Found!");
                noOfVehicles = 0;
                vehicles = new Vehicle[MAX_NUMBER_OF_VEHICLES];
                System.out.println("Cleared the vehicles"); //A message for the console.
                city.repaint();
                activeCB.removeAllItems();
                JOptionPane.showMessageDialog(new JDialog(), "Cleared the vehicles","Cleared",JOptionPane.INFORMATION_MESSAGE);
            }
            if (name == "Fuel\\Food") {
                if (noOfVehicles == 0)
                    throw new ArraySizeException("Error: no Vehicle Found!");
                Vehicle currentVehicle=GetVehicleById(activeVehicle.getId());
                if (currentVehicle.getVehicleName() == "Bike")
                    throw new NoSuchFieldException("Bike Doesn't require fuel or food.");
                else {
                    JButton benzine = new JButton("Benzine");
                    JButton solar = new JButton("Solar");
                    JButton food = new JButton("Food");
                    JDialog fuelDia=new JDialog();
                    FoodListener fuelL = new FoodListener(currentVehicle,fuelDia);
                    benzine.addActionListener(fuelL);
                    solar.addActionListener(fuelL);
                    food.addActionListener(fuelL);
                    JButton[] options = { benzine, solar, food };
                    JOptionPane.showOptionDialog(fuelDia, "Please choose the right fuel/food ", "Fuel/Food Menu",
                            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                            options[2]);

                }
            }
            if (name == "Lights") {
                Vehicle currentVehicle=GetVehicleById(activeVehicle.getId());
                if (noOfVehicles == 0)
                    throw new ArraySizeException("Error: no Vehicle Found!");
                else {
                    if (currentVehicle.getLights()) {
                        currentVehicle.setLights(false);
                        JOptionPane.showMessageDialog(new JDialog(), "Lights are now Off", "Light trigger",
                                JOptionPane.INFORMATION_MESSAGE);
                    }

                    else {
                        currentVehicle.setLights(true);
                        JOptionPane.showMessageDialog(new JDialog(), "Lights are now On", "Light trigger",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } // end of Lights option.
        } catch (Exception except) {
            JOptionPane.showMessageDialog(new JDialog(), except.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } // end of catch.

        if (name == "Info") {

            String[] columnNames = { "Vehicle", "ID", "Color", "Wheels", "Speed", "Fuel Amount", "Distance",
                    "FuelConsumption", "Lights","Crashed with"};
            Object[][] data = new Object[noOfAchievedVehicles][columnNames.length];
            for (int i = 0; i < noOfAchievedVehicles; i++) {
                data[i][0] = vehiclesAchieve[i].getVehicleName();
                data[i][1] = vehiclesAchieve[i].getId();
                data[i][2] = vehiclesAchieve[i].getColor();
                data[i][3] = vehiclesAchieve[i].getNoOfWheels();
                data[i][4] = vehiclesAchieve[i].getSpeed();
                data[i][5] = vehiclesAchieve[i].getFuel();
                data[i][6] = vehiclesAchieve[i].getMileage();
                data[i][7] = vehiclesAchieve[i].getFuelConsumption();
                data[i][8] = vehiclesAchieve[i].getLights();
                data[i][9] = vehiclesAchieve[i].getCrashedWith();
            }
            JTable info = new JTable(data, columnNames) {
                private static final long serialVersionUID = 1L;
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            info.setFillsViewportHeight(true);
            JScrollPane scrollPane = new JScrollPane(info);
            JDialog infoDialog = MakeInfoDialog(scrollPane);
            infoDialog.setVisible(true);
        }

        if (name == "Exit") {
            pool.shutdownNow();
            System.exit(0);//Simply exits the program.
        }*/
    }

