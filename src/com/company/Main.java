package com.company;


import com.company.Presentacio.PresentationController;


import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static void setNimbusLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, fall back to cross-platform
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {
                // not worth my time
            }
        }
    }

    public static void main(String[] args) {
        PresentationController.getInstance().inicia();
//        JFrame jFrame = new JFrame("PROP");
//        /**Config jFrame**/
//        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        //jFrame.setPreferredSize(new Dimension(1000, 700));
//
//        new VistaBase(jFrame);

//        jFrame.pack();
//        jFrame.repaint();
//        jFrame.setLocationRelativeTo(null);
//        jFrame.setVisible(true);

//            int op = readOption();
//            while (op != '0') {
//                if (op == '1') {
//                    System.out.println("Hola");
//                    String destinatari = "marcos13594@jediupc.com";
//                    int punts = 20500;
//                    ServiceLayer s = new ServiceLayer();
//                    s.enviaMail(destinatari, punts);
//                }
//                else if (op == '2'){
//                    PresentationController.getInstance().inicia();
//                }
//                else {
//                    System.out.println("Otra opción");
//                }
//                op = readOption();
//            }
//    }
//
//    private static char readOption(){
//        System.out.println("\n---------------------------------");
//        System.out.print("Opcio: ");
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String line = "";
//        try {
//            line = bufferedReader.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if(line.length() == 0){
//            return readOption();
//        }
//        return line.toLowerCase().charAt(0);
//    }
    }
}
