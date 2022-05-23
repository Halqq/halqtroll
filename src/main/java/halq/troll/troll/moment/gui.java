package halq.troll.troll.moment;

import javax.swing.*;

/**
 * @author halqq
 * @since 23/05/22
 * @apiNote Malware created for educational purposes, I am not responsible for misuse
 */

public class gui extends JFrame {
    public static void Display(){
        gui.wewhen();
    }
            public static void wewhen() {

                JFrame f;

                f=new JFrame("LMAO");

                String message = "you were trolled, my condolences, im deleting your system32";

                JOptionPane.showMessageDialog(f, message);
            }

    }

