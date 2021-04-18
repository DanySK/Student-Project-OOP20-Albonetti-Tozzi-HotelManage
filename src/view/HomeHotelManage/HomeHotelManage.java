package view.HomeHotelManage;

import view.Client.*;
import view.Reservation.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class HomeHotelManage extends JFrame {

    /**
     * Variable initialization.
     */
    private static final long serialVersionUID = 1L;
    private final JPanel contentPane;
    private final JButton btnClienti = new JButton("Clienti");
    private final JButton btnPrenota = new JButton("Prenota");
    private final JPanel panel = new JPanel();
    private final GroupLayout glpanel = new GroupLayout(panel);
    private final List<JButton> cells = new ArrayList<>();
    private int size = 4;

    /**
     * Launch the application. momentaneo.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HomeHotelManage frame = new HomeHotelManage();
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
    public HomeHotelManage() {
        setForeground(new Color(128, 0, 0));
        setTitle("Hotel");
        setBackground(new Color(128, 0, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 477, 322);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        panel.setBackground(Color.LIGHT_GRAY);
        /**
         * Action listener for the rooms.
         */
        ActionListener al = e -> {
            //add action on button room
        };
        /**
         * Initialize button room.
         */
        int counter = 1;
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                final JButton jb = new JButton("Stanza:"  + counter);
                jb.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 11));
                jb.setForeground(Color.BLACK);
                jb.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 11));
                jb.setBackground(new Color(127, 255, 0));
                this.cells.add(jb);
                jb.addActionListener(al);
               counter++;
            }
        }
        /**
         * Mouse Listener, open the clients and reservations view.
         */

        btnPrenota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
               ReservationsHomeView reservation = new ReservationsHomeView();
               reservation.setVisible(true);
            };
        });

        btnClienti.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientHomeView client = new ClientHomeView();
                client.setVisible(true);
            }
        });

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(btnPrenota, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(btnClienti, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(btnPrenota, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                                        .addComponent(btnClienti, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        glpanel.setHorizontalGroup(
                glpanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(glpanel.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(glpanel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(glpanel.createSequentialGroup()
                                                .addComponent(cells.get(0), GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(cells.get(1), GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(cells.get(2), GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(cells.get(3), GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(glpanel.createSequentialGroup()
                                                .addComponent(cells.get(4), GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(cells.get(5), GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(cells.get(6), GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(cells.get(7), GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(glpanel.createSequentialGroup()
                                                .addComponent(cells.get(8), GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(cells.get(9), GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(cells.get(10), GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(cells.get(11), GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        glpanel.setVerticalGroup(
                glpanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(glpanel.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(glpanel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(glpanel.createSequentialGroup()
                                                .addComponent(cells.get(3), GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addComponent(cells.get(7), GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addComponent(cells.get(11), GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(glpanel.createSequentialGroup()
                                              .addGroup(glpanel.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(cells.get(2), GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cells.get(1), GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cells.get(0), GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
                                                        .addGap(18)
                                                .addGroup(glpanel.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(cells.get(4), GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(glpanel.createParallelGroup(Alignment.BASELINE)
                                                                .addComponent(cells.get(5), GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(cells.get(6), GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18)
                                                .addGroup(glpanel.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(cells.get(8), GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(glpanel.createParallelGroup(Alignment.BASELINE)
                                                                .addComponent(cells.get(9), GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(cells.get(10), GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(71, Short.MAX_VALUE))
        );
        panel.setLayout(glpanel);
        contentPane.setLayout(gl_contentPane);
    }

}
