package fr.iglee42.oreunification;

import net.minecraft.world.item.Item;

public class MineralObject {
    private boolean hasDust,hasBlock,hasNugget,hasPlate,hasRawMaterial,hasOre;
    private Item base,dust,block,nugget,plate,rawMaterial,ore;


    public MineralObject( boolean hasDust, boolean hasBlock, boolean hasNugget, boolean hasPlate, boolean hasRawMaterial, boolean hasOre, Item base, Item dust, Item block, Item nugget, Item plate, Item rawMaterial, Item ore) {
        this.hasDust = hasDust;
        this.hasBlock = hasBlock;
        this.hasNugget = hasNugget;
        this.hasPlate = hasPlate;
        this.hasRawMaterial = hasRawMaterial;
        this.hasOre = hasOre;
        this.base = base;
        this.dust = dust;
        this.block = block;
        this.nugget = nugget;
        this.plate = plate;
        this.rawMaterial = rawMaterial;
        this.ore = ore;
    }


    public boolean hasDust() {
        return hasDust;
    }

    public boolean hasBlock() {
        return hasBlock;
    }

    public boolean hasNugget() {
        return hasNugget;
    }

    public boolean hasPlate() {
        return hasPlate;
    }

    public boolean hasRawMaterial() {
        return hasRawMaterial;
    }

    public boolean hasOre() {
        return hasOre;
    }

    public Item getBase() {
        return base;
    }

    public Item getDust() {
        return dust;
    }

    public Item getBlock() {
        return block;
    }

    public Item getNugget() {
        return nugget;
    }

    public Item getPlate() {
        return plate;
    }

    public Item getRawMaterial() {
        return rawMaterial;
    }

    public Item getOre() {
        return ore;
    }


    public void setHasDust(boolean hasDust) {
        this.hasDust = hasDust;
    }

    public void setHasBlock(boolean hasBlock) {
        this.hasBlock = hasBlock;
    }

    public void setHasNugget(boolean hasNugget) {
        this.hasNugget = hasNugget;
    }

    public void setHasPlate(boolean hasPlate) {
        this.hasPlate = hasPlate;
    }

    public void setHasRawMaterial(boolean hasRawMaterial) {
        this.hasRawMaterial = hasRawMaterial;
    }

    public void setHasOre(boolean hasOre) {
        this.hasOre = hasOre;
    }

    public void setBase(Item base) {
        this.base = base;
    }

    public void setDust(Item dust) {
        this.dust = dust;
    }

    public void setBlock(Item block) {
        this.block = block;
    }

    public void setNugget(Item nugget) {
        this.nugget = nugget;
    }

    public void setPlate(Item plate) {
        this.plate = plate;
    }

    public void setRawMaterial(Item rawMaterial) {
        this.rawMaterial = rawMaterial;
    }

    public void setOre(Item ore) {
        this.ore = ore;
    }
}
