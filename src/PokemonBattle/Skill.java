package PokemonBattle;

import java.lang.reflect.Type;

public class Skill {
    private String name;
    private Type type;
    private int power;
    private int PP;
    private int maxPP;
    public Skill(String name , Type type, int power, int PP){
        this.name = name;
        this.type = type;
        this.power = power;
        this.PP = PP;
        this.maxPP = PP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    enum Type{
        Heal,Attack
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPP() {
        return PP;
    }

    public void setPP(int PP) {
        if (PP>0&&PP<=maxPP)
        this.PP = PP;
        else if (PP<=0)
            this.PP=0;
        else if (PP>maxPP)
            this.PP=maxPP;
    }

    public int getMaxPP() {
        return maxPP;
    }

    public void setMaxPP(int maxPP) {
        this.maxPP = maxPP;
    }
}
