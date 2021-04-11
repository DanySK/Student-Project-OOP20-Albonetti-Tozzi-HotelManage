package view.Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class FindClientView extends JFrame {

    private JPanel contentPane;
    private JTextField txtInserireQui;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FindClientView frame = new FindClientView();
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
    public FindClientView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        JLabel lblNewLabel = new JLabel("Inserisci il codice fiscale del cliente desiderato");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        
        txtInserireQui = new JTextField();
        txtInserireQui.setHorizontalAlignment(SwingConstants.CENTER);
        txtInserireQui.setText("Inserire CF");
        txtInserireQui.setToolTipText("Codice Fiscale");
        txtInserireQui.setBackground(Color.WHITE);
        txtInserireQui.setColumns(10);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(txtInserireQui, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNewLabel)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(txtInserireQui, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(189, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }

}
