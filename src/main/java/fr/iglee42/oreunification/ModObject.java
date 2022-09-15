package fr.iglee42.oreunification;

import java.util.ArrayList;
import java.util.List;

public class ModObject {
    private String modid;
    private List<Mineral> minerals = new ArrayList<>();

    public ModObject(String modid) {
        this.modid = modid;
    }

    public ModObject(String modid,List<Mineral> objects) {
        this.modid = modid;
        this.minerals = objects;
    }

    public String getModid() {
        return modid;
    }

    public List<Mineral> getMinerals(){
        return minerals;
    }

    public Mineral getByName(String name){
        return minerals.stream().filter(m->m.name().equals(name)).findFirst().get();
    }
}
