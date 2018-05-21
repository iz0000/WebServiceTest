package com.ws.fm;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.ImageGraphicAttribute;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class utils {

    //static Image image = Toolkit.getDefaultToolkit()
    //         .getImage(utils.class.getResource("favicon.ico"));

    public static void main(String[] args) throws IOException, InterruptedException {

        Image image = ImageIO.read(new File("C:\\Users\\zro\\Desktop\\tmp\\timg.jpg"));
        if (image != null) {
            TrayIcon trayIcon = new TrayIcon(image, "这是系统托盘");

            trayIcon.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {// 双击托盘窗口再现
                        System.out.println(new Date().getTime());
                    }
                }
            });
            PopupMenu popupMenu = new PopupMenu();
            popupMenu.add(new MenuItem("禁用(D)"));
            popupMenu.add(new MenuItem("状态(S)"));
            popupMenu.add(new MenuItem("修复(P)"));
            popupMenu.addSeparator();
            popupMenu.add(new MenuItem("更改 Windows 防火墙设置(C)"));
            popupMenu.addSeparator();
            popupMenu.add(new MenuItem("打开网络连接(O)"));
            trayIcon.setPopupMenu(popupMenu);
            try {
                SystemTray systemTray = SystemTray.getSystemTray();
                // 为系统托盘加托盘图标
                systemTray.add(trayIcon);
                Thread.sleep(1000 * 10);
                systemTray.remove(trayIcon);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("image not found");
        }


    }
}
