package fr.iglee42.oreunification;

import com.google.gson.JsonObject;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModUtils {


    /*
    {
        "minerals": [
            "lead": {

            },
            "tin": {
                "baseItem": not null or error
            }

        ]



    }
     */

    public static ModObject loadFromJson(String id, JsonObject json) {
        List<Mineral> output = new ArrayList<>();
        List<JsonObject> mineralsJson = new ArrayList<>();
        for (int i = 0; i <= json.getAsJsonArray("minerals").size(); i++){
            mineralsJson.add(json.getAsJsonArray("minerals").get(i).getAsJsonObject());
        }
        for (JsonObject mineral : mineralsJson){


            MineralObject m = getMineral(mineral);
            RecipesObject r = null;
            output.add(new Mineral(mineral.getAsString(),r,m));
        }
        return new ModObject(id,output);
       /* Mineral mineral = new Mineral(id);
        List<String> modIds = new ArrayList<>();
        for (int i = 0; i < json.getAsJsonArray("modIds").size(); i++){
            modIds.add(json.getAsJsonArray("modIds").get(i).getAsString());
        }
        for (String modI : modIds){
            JsonObject mod = json.getAsJsonObject(modI);
            boolean hasBase = false;
            boolean hasDust = false;
            boolean hasBlock = false;
            boolean hasNugget = false;
            boolean hasPlate = false;
            Item baseItem = Items.STONE;
            Item dust = Items.STONE;
            Item block = Items.STONE;
            Item nugget = Items.STONE;
            Item plate = Items.STONE;
            if (mod.has("baseItem")){
                hasBase = true;
                String[] itemMod = OreUnification.split(mod.get("baseItem").getAsString(),":");
                String modItemId = itemMod[0];
                String item = itemMod[1];
                ResourceLocation itemLoc = new ResourceLocation(modItemId,item);
                baseItem = Registry.ITEM.getOrDefault(itemLoc);
            }if (mod.has("dust")){
                hasDust = true;
                String[] itemMod = OreUnification.split(mod.get("dust").getAsString(),":");
                String modItemId = itemMod[0];
                String item = itemMod[1];
                ResourceLocation itemLoc = new ResourceLocation(modItemId,item);
                dust = Registry.ITEM.getOrDefault(itemLoc);
            }if (mod.has("block")){
                hasBlock = true;
                String[] itemMod = OreUnification.split(mod.get("block").getAsString(),":");
                String modItemId = itemMod[0];
                String item = itemMod[1];
                ResourceLocation itemLoc = new ResourceLocation(modItemId,item);
                block = Registry.ITEM.getOrDefault(itemLoc);
            }if (mod.has("nugget")){
                hasNugget = true;
                String[] itemMod = OreUnification.split(mod.get("nugget").getAsString(),":");
                String modItemId = itemMod[0];
                String item = itemMod[1];
                ResourceLocation itemLoc = new ResourceLocation(modItemId,item);
                nugget = Registry.ITEM.getOrDefault(itemLoc);
            }if (mod.has("plate")){
                hasPlate = true;
                String[] itemMod = OreUnification.split(mod.get("plate").getAsString(),":");
                String modItemId = itemMod[0];
                String item = itemMod[1];
                ResourceLocation itemLoc = new ResourceLocation(modItemId,item);
                plate = Registry.ITEM.getOrDefault(itemLoc);
            }
            mineral.addMod(modI);
            mineral.setModInfo(modI,hasBase,hasDust,hasBlock,hasNugget,hasPlate,baseItem,dust,block,nugget,plate);
        }
        return mineral;*/
    }

    private static MineralObject getMineral(JsonObject mineral) {
        boolean hasBlock;
        boolean hasNugget;
        boolean hasDust;
        boolean hasPlate;
        boolean hasRawMaterial;
        boolean hasOre;
        Item baseItem;
        Item block = null;
        Item nugget = null;
        Item dust = null;
        Item plate = null;
        Item rawMaterial = null;
        Item ore = null;

        hasBlock = mineral.get("hasBlock").getAsBoolean();
        hasNugget = mineral.get("hasNugget").getAsBoolean();
        hasDust = mineral.get("hasDust").getAsBoolean();
        hasPlate = mineral.get("hasPlate").getAsBoolean();
        hasRawMaterial = mineral.get("hasRawMaterial").getAsBoolean();
        hasOre = mineral.get("hasOre").getAsBoolean();

        baseItem = getItem(mineral.get("baseItem").getAsString());
        if (baseItem == null) throw new IllegalArgumentException("Base Item Parameter Can't be null");
        if (hasBlock) block = getItem(mineral.get("block").getAsString());
        if (hasNugget) nugget = getItem(mineral.get("nugget").getAsString());
        if (hasDust) dust = getItem(mineral.get("dust").getAsString());
        if (hasPlate) plate = getItem(mineral.get("plate").getAsString());
        if (hasRawMaterial) rawMaterial = getItem(mineral.get("rawMaterial").getAsString());
        if (hasOre) ore = getItem(mineral.get("ore").getAsString());
        return new MineralObject( hasDust,  hasBlock,  hasNugget,  hasPlate, hasRawMaterial, hasOre,baseItem,  dust,  block,  nugget,  plate, rawMaterial, ore);
    }

    private static Item getItem(String name) {
        String[] it = OreUnification.split(name,":");
        return Registry.ITEM.get(new ResourceLocation(it[0],it[1]));
    }
}
