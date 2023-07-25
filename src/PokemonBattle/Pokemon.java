package PokemonBattle;

import java.util.ArrayList;

public class Pokemon {
    private String name;
    private int HP;
    private int maxHP;
    private int attack;
    private int speed;
    private ArrayList<Skill> skills=new ArrayList<>();
    public Pokemon(String name, int maxhp, int attack, int speed, Skill... skills) {
        this.name = name;
        this.maxHP = maxhp;
        this.HP = maxhp;
        this.attack = attack;
        this.speed = speed;
        for (int i = 0; i < skills.length; i++) {
            Skill sk=new Skill(skills[i].getName(),skills[i].getType(),skills[i].getPower(),skills[i].getPP());
            this.skills.add(sk);
        }
    }
    public boolean isAlive(){
        if (HP>0){
            return true;
        }
        else
            return false;
    }
    public void useSkillTo(Pokemon target, Skill skill){
        if (skill.getType() == Skill.Type.Heal)
            target.setHP(target.getHP()+skill.getPower());
        else
        target.setHP(target.getHP()-attack*skill.getPower());
        skill.setPP(skill.getPP()-1);
    }
    public String toString(){
        return String.format("%s: %d/%d",name,HP,maxHP);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        if (HP>=0&&HP<=maxHP)
        this.HP = HP;
        else if (HP>maxHP) {
            this.HP=maxHP;
        } else if (HP<0) {
            this.HP=0;
        }
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }

}
