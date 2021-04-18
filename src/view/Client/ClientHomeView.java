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

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final JPanel contentPane;
    private final JButton buttonnewclient = new JButton("Nuvo Cliente");
    private final JButton buttonsearchclient = new JButton("Cerca Cliente");
    private final JLabel label = new JLabel("Scegliere quale azione effettuare");

    /**
     * Create the frame.
     */
    public ClientHomeView() {
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(null);
        setContentPane(contentPane);
        
        buttonnewclient.setForeground(Color.BLACK);
        buttonnewclient.setBackground(UIManager.getColor("Table.selectionBackground"));
        buttonsearchclient.setBackground(UIManager.getColor("Table.selectionBackground"));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(label.getFont().getSize() + 7f));
        
        buttonnewclient.addActionListener(new ActionListener() {
                public void actionPerformed(final ActionEvent e) {
                        System.out.println("Sto aprendo la view perc registrare il nuovo cliente");
                        NewClientView nuovo = new NewClientView();
                        nuovo.setVisible(true);
                }
        });
        
        buttonsearchclient.addActionListener(new ActionListener() {
                public void actionPerformed(final ActionEvent e) {
                        System.out.println("Sto aprendo la view per registrare cercare il cliente");
                        FindClientView cerca = new FindClientView();
                        cerca.setVisible(true);
                }
        });

        GroupLayout glcontentPane = new GroupLayout(contentPane);
        glcontentPane.setHorizontalGroup(
                glcontentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(glcontentPane.createSequentialGroup()
                                .addGap(60)
                                .addGroup(glcontentPane.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(Alignment.LEADING, glcontentPane.createSequentialGroup()
                                                .addComponent(buttonnewclient, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                                .addGap(105)
                                                .addComponent(buttonsearchclient, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(label, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
                                .addGap(41))
        );
        glcontentPane.setVerticalGroup(
                glcontentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(glcontentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addGap(26)
                                .addGroup(glcontentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(buttonsearchclient, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonnewclient, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(125, Short.MAX_VALUE))
        );
        contentPane.setLayout(glcontentPane);
    }

}
