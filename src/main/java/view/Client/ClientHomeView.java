package view.Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class ClientHomeView extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClientHomeView frame = new ClientHomeView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ClientHomeView() {
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(null);
        setContentPane(contentPane);
        
        JButton btnNewButton = new JButton("Nuvo Cliente");
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setBackground(UIManager.getColor("Table.selectionBackground"));
        btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        System.out.println("Sto aprendo la view perc registrare il nuovo cliente");
                        NewClientView nuovo = new NewClientView();
                        nuovo.setVisible(true);
                }
        });
        
        JButton btnNewButton_1 = new JButton("Cerca Cliente");
        btnNewButton_1.setBackground(UIManager.getColor("Table.selectionBackground"));
        btnNewButton_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        System.out.println("Sto aprendo la view per registrare cercare il cliente");
                        FindClientView cerca = new FindClientView();
                        cerca.setVisible(true);
                }
        });
        
        JLabel lblNewLabel = new JLabel("Scegliere quale azione effettuare");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getSize() + 7f));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(60)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                                .addGap(105)
                                                .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
                                .addGap(41))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addGap(26)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(125, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }

}
