package fr.iglee42.oreunification;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MineralsRegistry {

    public static List<ModObject> MODS = new ArrayList<>();

    public static void loadMinerals(){
        File dir = FMLPaths.CONFIGDIR.get().resolve("oreunification/mods/").toFile();
        if (!dir.exists() && dir.mkdirs()){
            dir.mkdir();
        }
        if (!dir.mkdirs() && dir.isDirectory()) {
            File[] files = dir.listFiles((FileFilter) FileFilterUtils.suffixFileFilter(".json"));
            if (files == null)
                return;

            for (File file : files) {
                JsonObject json;
                InputStreamReader reader = null;
                ModObject mod = null;

                try {
                    JsonParser parser = new JsonParser();
                    reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                    json = parser.parse(reader).getAsJsonObject();
                    String id = file.getName().replace(".json", "");
                    mod = ModUtils.loadFromJson(id, json);

                    reader.close();
                } catch (Exception e) {
                    OreUnification.LOGGER.error("An error occurred while loading minerals", e);
                } finally {
                    IOUtils.closeQuietly(reader);
                }
                if (mod != null) MODS.add(mod);
            }
        }
    }
}
