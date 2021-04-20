package application;

import java.awt.Toolkit;


import view.HomeHotelManage.HomeHotelManageView;

public final class HotelManage {

public static void main(final String[] args) {
    new HotelManage().start();
    }

    private void start() {
        final HomeHotelManageView mainFrame = new HomeHotelManageView();
        mainFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,
                Toolkit.getDefaultToolkit().getScreenSize().height);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
