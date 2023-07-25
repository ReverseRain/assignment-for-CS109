package PokemonBattle;

import java.util.ArrayList;

public class Trainer {
    private String name;
    private ArrayList<Pokemon>pokemons=new ArrayList<>();
    private Pokemon activatePokemon;
    public Trainer(String name, Pokemon... pokemons) {
        this.name=name;
        for (int i = 0; i < pokemons.length&&this.pokemons.size()<6; i++) {
            boolean a=true;
            for (int j = 0; j < this.pokemons.size(); j++) {
               if (pokemons[i].getName().equals(this.pokemons.get(j).getName())){
                   a=false;
                   break;
               }
            }
            if (a)
            this.pokemons.add(pokemons[i]);
        }
        activatePokemon=summon();
    }
    public void addPokemon(Pokemon... poke) {
        for (int i = 0; i <poke.length&&pokemons.size()<6 ; i++) {
            boolean a=true;
            for (int j = 0; j <pokemons.size() ; j++) {
                if (poke[i].getName().equals(pokemons.get(j).getName())){
                    a=false;
                    break;}
                 }
            if (a)
                pokemons.add(poke[i]);
        }
}
    public void removePokemon(String...name){
        for (int i = 0; i < name.length; i++) {
            int finalI = i;
            pokemons.removeIf(e->e.getName().equals(name[finalI]));
        }
    }
    public boolean isAlive(String name) {
        boolean a=false;
        for (int i = 0; i < pokemons.size(); i++) {
            if (pokemons.get(i).getName().equals(name)){
                if (pokemons.get(i).getHP()>0)
                   a=true;
                break;
            }
        }
        return a;
    }
    public boolean isAlive(Pokemon poke) {
        if (poke.getHP()>0)
            return true;
        else {return false;}
    }
    public Pokemon getPokemon(String name){
        for (int i = 0; i < pokemons.size(); i++) {
            if (pokemons.get(i).getName().equals(name)){
                return pokemons.get(i);
            }
        }
        return null;
    }
    public Pokemon summon(){
        for (int i = 0; i < pokemons.size(); i++) {
            if (pokemons.get(i).isAlive()){
                activatePokemon=pokemons.get(i);
                return pokemons.get(i);}
        }
        return null;
    }
    public Pokemon summon(String name){
        for (int i = 0; i < pokemons.size(); i++) {
            if (pokemons.get(i).getName().equals(name)&&pokemons.get(i).isAlive()){
                activatePokemon=pokemons.get(i);
                return pokemons.get(i);}
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public Pokemon getActivatePokemon() {
        return activatePokemon;
    }

    public void setActivatePokemon(Pokemon activatePokemon) {
        this.activatePokemon = activatePokemon;
    }

    public static void main(String[] args) {Skill attack = new Skill("Beat", Skill.Type.Attack, 5, 10);
        Skill heal = new Skill("Heal", Skill.Type.Heal, 6, 10);

        Pokemon pokemon1 = new Pokemon("pokemon1", 50, 2, 20, attack, heal);
        Pokemon pokemon2 = new Pokemon("pokemon2", 50, 2, 20, attack, heal);
        Pokemon pokemon3 = new Pokemon("pokemon3", 50, 2, 20, attack, heal);
        Pokemon pokemon3Dup = new Pokemon("pokemon3", 50, 2, 20, attack, heal);
        Pokemon pokemon4 = new Pokemon("pokemon4", 50, 2, 20, attack, heal);
        Pokemon pokemon5 = new Pokemon("pokemon5", 50, 2, 20, attack, heal);
        Pokemon pokemon6 = new Pokemon("pokemon6", 50, 2, 20, attack, heal);
        Pokemon pokemon7 = new Pokemon("pokemon7", 50, 2, 20, attack, heal);

        Trainer trainer = new Trainer("Traveler", pokemon1, pokemon1,pokemon2,pokemon1);
//For now, Traveler has pokemon1 and pokemon2.
        trainer.addPokemon(pokemon3, pokemon3Dup, pokemon4, pokemon5, pokemon6, pokemon7);
        for (int i = 0; i < trainer.pokemons.size(); i++) {
            System.out.println(trainer.pokemons.get(i));
        }
//For now, Traveler has pokemon1,2,3,4,5,6. The pokemon7 is not added to the inventory since the inventory is full. The pokemon3Dup is not added into Trainers' inventory.
    }

}
