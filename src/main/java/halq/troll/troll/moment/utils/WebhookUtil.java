package halq.troll.troll.moment.utils;

import java.io.*;
import java.net.*;

/**
 * @author halq
 * @since 25/05/2022
 * @apiNote simple webhook, pasted!!
 */

public class WebhookUtil {

    public static void main(String message) {
    PrintWriter out = null;
    BufferedReader in = null;
    StringBuilder result = new StringBuilder();
        try {
        URL realUrl = new URL("your webhook");
        URLConnection conn = realUrl.openConnection();
        conn.setRequestProperty("accept", "*/*");
        conn.setRequestProperty("connection", "Keep-Alive");
        conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        out = new PrintWriter(conn.getOutputStream());
        String postData = URLEncoder.encode("content", "UTF-8") + "=" + URLEncoder.encode(message, "UTF-8");
        out.print(postData);
        out.flush();
        in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            result.append("/n").append(line);
        }

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
        System.out.println(result.toString());
}
}
