package view.Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Client.ControllerClient;
import controller.Client.ControllerClientImpl;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class FindClientView extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    private static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    private final JPanel contentPane;
    private final JTextField textfield;
    private final JLabel label = new JLabel("Inserisci il codice fiscale del cliente desiderato");
    private final JLabel lblNonTrovato = new JLabel("Non trovato");
    private final JButton buttonSearch = new JButton("Ricerca");
    
    private String id;
    private final JButton btnElimina = new JButton("Elimina");

    /**
     * Create the frame.
     */
    public FindClientView() {
        ControllerClient client = new ControllerClientImpl();
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        label.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNonTrovato.setFont(new Font("Tahoma", Font.BOLD, 12));
        textfield = new JTextField();
        textfield.setHorizontalAlignment(SwingConstants.CENTER);
        textfield.setToolTipText("Codice Fiscale");
        textfield.setBackground(Color.WHITE);
        textfield.setColumns(10);
        
        buttonSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent e) {
                id = textfield.getText();
                if (client.searchClient(id)) {
                    lblNonTrovato.setText("Trovato");
                }
                else{
                    lblNonTrovato.setText("Questo codice fiscale non è presente");
                }
                
            }
        });
        
        btnElimina.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent e) {
                id = textfield.getText();
                if (client.deleteLine(id)) {
                    lblNonTrovato.setText("Eliminato");
                }
                else {
                    lblNonTrovato.setText("Non Eliminato");
                }
                
            }
        });

        GroupLayout glcontentPane = new GroupLayout(contentPane);
        glcontentPane.setHorizontalGroup(
            glcontentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(glcontentPane.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(glcontentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(label, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                        .addGroup(Alignment.TRAILING, glcontentPane.createSequentialGroup()
                            .addComponent(lblNonTrovato, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                            .addGroup(glcontentPane.createParallelGroup(Alignment.LEADING, false)
                                .addComponent(btnElimina, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonSearch, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                            .addGap(10))
                        .addGroup(glcontentPane.createSequentialGroup()
                            .addComponent(textfield, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(233, Short.MAX_VALUE))))
        );
        glcontentPane.setVerticalGroup(
            glcontentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(glcontentPane.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(textfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                    .addComponent(btnElimina)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(glcontentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(buttonSearch)
                        .addComponent(lblNonTrovato, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
        );
        contentPane.setLayout(glcontentPane);
    }
}
