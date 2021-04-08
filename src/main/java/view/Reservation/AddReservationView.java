package view.Reservation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import net.miginfocom.swing.MigLayout;

public class AddReservationView extends JFrame {
    private final JPanel infoPanel = new JPanel();
    private final JPanel labelPanel = new JPanel();
    private final JPanel buttonPanel = new JPanel();
    private JTextField textField;
    private JTextField textField_2;
    private JTextField textField_3;

    /**
     * Create the frame.
     */
    public AddReservationView() {
        setTitle("Aggiungi prenotazione");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 542, 430);
        FlowLayout flowLayout = (FlowLayout) infoPanel.getLayout();
        
        this.getContentPane().add(infoPanel, BorderLayout.NORTH);
        
        
        
        JLabel lblNewLabel_4 = new JLabel("Inserire i dati per confermare la prenotazione");
        infoPanel.add(lblNewLabel_4);
        
        this.getContentPane().add(labelPanel, BorderLayout.CENTER);
        labelPanel.setLayout(new MigLayout("", "[68px][328px]", "[19px][19px][19px][19px]"));
        
        JLabel lblNewLabel = new JLabel("Cliente");
        labelPanel.add(lblNewLabel, "cell 0 0,alignx center,aligny center");
        
        textField = new JTextField();
        labelPanel.add(textField, "cell 1 0,growx,aligny center");
        textField.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Data check-in");
        labelPanel.add(lblNewLabel_1, "cell 0 1,alignx center,aligny center");
        
        JDateChooser dateChooser = new JDateChooser();
        BorderLayout borderLayout = (BorderLayout) dateChooser.getLayout();
        labelPanel.add(dateChooser, "cell 1 1,growx,aligny center");
        
        JLabel lblNewLabel_2 = new JLabel("Data check-out");
        labelPanel.add(lblNewLabel_2, "cell 0 2,alignx center,aligny center");
        
        textField_2 = new JTextField();
        labelPanel.add(textField_2, "cell 1 2,growx,aligny center");
        textField_2.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Stanza");
        labelPanel.add(lblNewLabel_3, "cell 0 3,alignx center,aligny center");
        
        textField_3 = new JTextField();
        labelPanel.add(textField_3, "cell 1 3,growx,aligny center");
        textField_3.setColumns(10);
        FlowLayout flowLayout_1 = (FlowLayout) buttonPanel.getLayout();
        flowLayout_1.setAlignment(FlowLayout.RIGHT);
        
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        JButton btnNewButton = new JButton("Annulla");
        buttonPanel.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Salva");
        buttonPanel.add(btnNewButton_1);
        
    }

}
