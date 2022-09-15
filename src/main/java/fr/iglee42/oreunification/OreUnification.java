package fr.iglee42.oreunification;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OreUnification.MODID)
public class OreUnification {

    public static final String MODID = "oreunification";

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public OreUnification() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static void server(final ServerStartingEvent event) {
        MineralsRegistry.loadMinerals();
    }

    public static void dataReload(CommandEvent event){
        if (event.getParseResults().getContext().getSource().getDisplayName().getString().equals("reload")){
            MineralsRegistry.loadMinerals();
        }
    }

    public static String[] split(String base,String separator){
        String[] st = base.split(separator);
        String[] finale = new String[2];
        for (String s : st){
            if (s.endsWith(separator))s.substring(s.length()-1);
            finale[finale.length] = s;
        }
        return finale;
    }
}
