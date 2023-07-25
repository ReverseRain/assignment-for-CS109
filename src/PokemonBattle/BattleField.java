package PokemonBattle;

public class BattleField {
    private Trainer trainerA;
    private Trainer trainerB;
    private int turn = 1;
    public BattleField(Trainer trainerA, Trainer trainerB) {
        this.trainerA=trainerA;
        this.trainerB=trainerB;
    }
    public void battle(String skillOfA, String skillOfB) {
        Pokemon A = trainerA.getActivatePokemon();
        Pokemon B = trainerB.getActivatePokemon();
        Skill skillA = getSkill(skillOfA, A);
        Skill skillB = getSkill(skillOfB, B);
        if (A.getSpeed()>=B.getSpeed()){
            if (A.isAlive()&&skillA.getPP()>0){
                if (skillA.getType().equals(Skill.Type.Heal)){
                    A.useSkillTo(A,skillA);
                }
                else A.useSkillTo(B,skillA);
            }
            if (B.isAlive()&&skillB.getPP()>0){
                if (skillB.getType().equals(Skill.Type.Heal)){
                    B.useSkillTo(B,skillB);
                }
                else B.useSkillTo(A,skillB);
            }
        }
        else {
            if (B.isAlive()&&skillB.getPP()>0){
                if (skillB.getType().equals(Skill.Type.Heal)){
                    B.useSkillTo(B,skillB);
                }
                else B.useSkillTo(A,skillB);
            }
            if (A.isAlive()&&skillA.getPP()>0){
                if (skillA.getType().equals(Skill.Type.Heal)){
                    A.useSkillTo(A,skillA);
                }
                else A.useSkillTo(B,skillA);
            }
        }
        if(checkWin()==0){
        if (A.isAlive()==false)
            trainerA.summon();
        if (B.isAlive()==false)
            trainerB.summon();}
        turn++;
//        if (A.getSpeed() >= B.getSpeed()) {
//            if (A!=null&&A.isAlive()){if (skillA.getType()== PokemonBattle.Skill.Type.Heal&&skillA.getPP()>0){
//                A.useSkillTo(A,skillA);
//            } else if (skillA.getType()== PokemonBattle.Skill.Type.Attack&&skillA.getPP()>0) {
//                A.useSkillTo(B,skillA);
//            }}
//            if (B!=null&&B.isAlive()){if (skillB.getType()== PokemonBattle.Skill.Type.Heal&&skillB.getPP()>0){
//                B.useSkillTo(B,skillB);
//            } else if (skillB.getType()== PokemonBattle.Skill.Type.Attack&&skillB.getPP()>0) {
//                B.useSkillTo(A,skillB);
//            }}
//        }
//        else {
//            if (B!=null&&B.isAlive()){if (skillB.getType()== PokemonBattle.Skill.Type.Heal&&skillB.getPP()>0){
//                B.useSkillTo(B,skillB);
//            } else if (skillB.getType()== PokemonBattle.Skill.Type.Attack&&skillB.getPP()>0) {
//                B.useSkillTo(A,skillB);
//            }}
//            if (A!=null&&A.isAlive()){if (skillA.getType()== PokemonBattle.Skill.Type.Heal&&skillA.getPP()>0){
//                A.useSkillTo(A,skillA);
//            } else if (skillA.getType()== PokemonBattle.Skill.Type.Attack&&skillA.getPP()>0) {
//                A.useSkillTo(B,skillA);
//            }}
//        }
//        turn++;
//        trainerA.setActivatePokemon(currentPokemon(A, trainerA));
//        trainerB.setActivatePokemon(currentPokemon(B,trainerB));
    }
    public Skill getSkill(String name,Pokemon pokemon) {
        for (int i = 0; i < pokemon.getSkills().size(); i++) {
            if (pokemon.getSkills().get(i).getName().equals(name)) {
                return pokemon.getSkills().get(i);
            }
        }
        return null;
    }
    public int checkWin() {
        int a=0,b=0;
        for (int i = 0; i < trainerA.getPokemons().size(); i++) {
            if (trainerA.getPokemons().get(i).isAlive())
                a++;
        }
        for (int i = 0; i < trainerB.getPokemons().size(); i++) {
            if (trainerB.getPokemons().get(i).isAlive())
                b++;
        }
        if (a == 0) {
            return 2;
        }
        else if (b==0){
            return 1;
        } else  {return 0;}
    }
    public String toString() {
        String str;
        if (checkWin()==2){
            str=trainerB.getName();
            return String.format("Turn %d:\nPokemonBattle.Trainer %s's PokemonBattle.Pokemon %s\nPokemonBattle.Trainer %s's PokemonBattle.Pokemon %s\nWinner:%s",turn-1,trainerA.getName(),trainerA.getActivatePokemon().toString(),trainerB.getName(),trainerB.getActivatePokemon().toString(),str);}
        else if (checkWin()==1){
            str=trainerA.getName();
            return String.format("Turn %d:\nPokemonBattle.Trainer %s's PokemonBattle.Pokemon %s\nPokemonBattle.Trainer %s's PokemonBattle.Pokemon %s\nWinner:%s",turn-1,trainerA.getName(),trainerA.getActivatePokemon().toString(),trainerB.getName(),trainerB.getActivatePokemon().toString(),str);}
        else
            return str=String.format("Turn %d:\nPokemonBattle.Trainer %s's PokemonBattle.Pokemon %s\nPokemonBattle.Trainer %s's PokemonBattle.Pokemon %s\n",turn-1,trainerA.getName(),trainerA.getActivatePokemon().toString(),trainerB.getName(),trainerB.getActivatePokemon().toString());
    }

    public Trainer getTrainerA() {
        return trainerA;
    }

    public void setTrainerA(Trainer trainerA) {
        this.trainerA = trainerA;
    }

    public Trainer getTrainerB() {
        return trainerB;
    }

    public void setTrainerB(Trainer trainerB) {
        this.trainerB = trainerB;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
        public static void main(String[] args) {

            var pokemon11 = new Pokemon(
                    "11", 50, 2, 9,
                    new Skill("attack", Skill.Type.Attack, 8, 5),
                    new Skill("heal", Skill.Type.Heal, 30, 1)
            );
            var pokemon12 = new Pokemon(
                    "12", 65, 3, 7,
                    new Skill("attack", Skill.Type.Attack, 9, 5),
                    new Skill("thunderbolt", Skill.Type.Attack, 14, 1),
                    new Skill("heal", Skill.Type.Heal, 25, 2)
            );
            var pokemon13 = new Pokemon(
                    "13", 90, 1, 13,
                    new Skill("attack", Skill.Type.Attack, 12, 10),
                    new Skill("heal", Skill.Type.Heal, 15, 3)
            );
            var trainer1 = new Trainer("XiaoZhi", pokemon11);
            trainer1.addPokemon(pokemon12);
            trainer1.addPokemon(pokemon13);

            var pokemon21 = new Pokemon(
                    "21", 80, 1, 11,
                    new Skill("attack", Skill.Type.Attack, 20, 5),
                    new Skill("strong attack", Skill.Type.Attack, 28, 2),
                    new Skill("heal", Skill.Type.Heal, 40, 1)
            );
            var pokemon22 = new Pokemon(
                    "22", 75, 2, 10,
                    new Skill("attack", Skill.Type.Attack, 9, 8),
                    new Skill("heal", Skill.Type.Heal, 20, 2)
            );
            var trainer2 = new Trainer("Paimon", pokemon21, pokemon22);
            var bf = new BattleField(trainer1, trainer2);

            System.out.println("---------------------------------");

            bf.battle("attack", "strong attack");

            System.out.println("你的答案：");
            System.out.println(bf.toString());

            System.out.println("正确答案：");
            System.out.println("Turn 1:\n" +
                    "PokemonBattle.Trainer XiaoZhi's PokemonBattle.Pokemon 11: 22/50\n" +
                    "PokemonBattle.Trainer Paimon's PokemonBattle.Pokemon 21: 64/80\n");

            System.out.println("---------------------------------");

            bf.battle("heal", "attack");

            System.out.println("你的答案：");
            System.out.println(bf.toString());

            System.out.println("正确答案：");
            System.out.println("Turn 2:\n" +
                    "PokemonBattle.Trainer XiaoZhi's PokemonBattle.Pokemon 11: 32/50\n" +
                    "PokemonBattle.Trainer Paimon's PokemonBattle.Pokemon 21: 64/80\n");

            System.out.println("---------------------------------");

            bf.battle("heal", "attack");

            System.out.println("你的答案：");
            System.out.println(bf.toString());

            System.out.println("正确答案：");
            System.out.println("Turn 3:\n" +
                    "PokemonBattle.Trainer XiaoZhi's PokemonBattle.Pokemon 11: 12/50\n" +
                    "PokemonBattle.Trainer Paimon's PokemonBattle.Pokemon 21: 64/80\n");

            System.out.println("---------------------------------");

            bf.battle("attack", "attack");

            System.out.println("你的答案：");
            System.out.println(bf.toString());

            System.out.println("正确答案：");
            System.out.println("Turn 4:\n" +
                    "PokemonBattle.Trainer XiaoZhi's PokemonBattle.Pokemon 12: 65/65\n" +
                    "PokemonBattle.Trainer Paimon's PokemonBattle.Pokemon 21: 64/80\n");

            System.out.println("---------------------------------");

            bf.battle("thunderbolt", "strong attack");

            System.out.println("你的答案：");
            System.out.println(bf.toString());

            System.out.println("正确答案：");
            System.out.println("Turn 5:\n" +
                    "PokemonBattle.Trainer XiaoZhi's PokemonBattle.Pokemon 12: 37/65\n" +
                    "PokemonBattle.Trainer Paimon's PokemonBattle.Pokemon 21: 22/80\n");

            System.out.println("---------------------------------");

            bf.battle("attack", "heal");

            System.out.println("你的答案：");
            System.out.println(bf.toString());

            System.out.println("正确答案：");
            System.out.println("Turn 6:\n" +
                    "PokemonBattle.Trainer XiaoZhi's PokemonBattle.Pokemon 12: 37/65\n" +
                    "PokemonBattle.Trainer Paimon's PokemonBattle.Pokemon 21: 35/80\n");

            System.out.println("---------------------------------");

            bf.battle("heal", "heal");

            System.out.println("你的答案：");
            System.out.println(bf.toString());

            System.out.println("正确答案：");
            System.out.println("Turn 7:\n" +
                    "PokemonBattle.Trainer XiaoZhi's PokemonBattle.Pokemon 12: 62/65\n" +
                    "PokemonBattle.Trainer Paimon's PokemonBattle.Pokemon 21: 35/80\n");

            System.out.println("---------------------------------");

            bf.battle("attack", "attack");

            System.out.println("你的答案：");
            System.out.println(bf.toString());

            System.out.println("正确答案：");
            System.out.println("Turn 8:\n" +
                    "PokemonBattle.Trainer XiaoZhi's PokemonBattle.Pokemon 12: 42/65\n" +
                    "PokemonBattle.Trainer Paimon's PokemonBattle.Pokemon 21: 8/80\n");

            System.out.println("---------------------------------");

            bf.battle("attack", "attack");

            System.out.println("你的答案：");
            System.out.println(bf.toString());

            System.out.println("正确答案：");
            System.out.println("Turn 9:\n" +
                    "PokemonBattle.Trainer XiaoZhi's PokemonBattle.Pokemon 12: 22/65\n" +
                    "PokemonBattle.Trainer Paimon's PokemonBattle.Pokemon 22: 75/75\n");

            System.out.println("---------------------------------");

            bf.battle("heal", "attack");

            System.out.println("你的答案：");
            System.out.println(bf.toString());

            System.out.println("正确答案：");
            System.out.println("Turn 10:\n" +
                    "PokemonBattle.Trainer XiaoZhi's PokemonBattle.Pokemon 12: 29/65\n" +
                    "PokemonBattle.Trainer Paimon's PokemonBattle.Pokemon 22: 75/75\n");

            System.out.println("---------------------------------");

            bf.battle("attack", "attack");

            System.out.println("你的答案：");
            System.out.println(bf.toString());

            System.out.println("正确答案：");
            System.out.println("Turn 11:\n" +
                    "PokemonBattle.Trainer XiaoZhi's PokemonBattle.Pokemon 12: 11/65\n" +
                    "PokemonBattle.Trainer Paimon's PokemonBattle.Pokemon 22: 48/75\n");

            System.out.println("---------------------------------");

            bf.battle("attack", "attack");

            System.out.println("你的答案：");
            System.out.println(bf.toString());

            System.out.println("正确答案：");
            System.out.println("Turn 12:\n" +
                    "PokemonBattle.Trainer XiaoZhi's PokemonBattle.Pokemon 13: 90/90\n" +
                    "PokemonBattle.Trainer Paimon's PokemonBattle.Pokemon 22: 48/75\n");

            System.out.println("---------------------------------");

            bf.battle("heal", "attack");

            System.out.println("你的答案：");
            System.out.println(bf.toString());

            System.out.println("正确答案：");
            System.out.println("Turn 13:\n" +
                    "PokemonBattle.Trainer XiaoZhi's PokemonBattle.Pokemon 13: 72/90\n" +
                    "PokemonBattle.Trainer Paimon's PokemonBattle.Pokemon 22: 48/75\n");

            System.out.println("---------------------------------");

            bf.battle("attack", "attack");

            System.out.println("你的答案：");
            System.out.println(bf.toString());

            System.out.println("正确答案：");
            System.out.println("Turn 14:\n" +
                    "PokemonBattle.Trainer XiaoZhi's PokemonBattle.Pokemon 13: 54/90\n" +
                    "PokemonBattle.Trainer Paimon's PokemonBattle.Pokemon 22: 36/75\n");

            System.out.println("---------------------------------");

            bf.battle("attack", "attack");

            System.out.println("你的答案：");
            System.out.println(bf.toString());

            System.out.println("正确答案：");
            System.out.println("Turn 15:\n" +
                    "PokemonBattle.Trainer XiaoZhi's PokemonBattle.Pokemon 13: 36/90\n" +
                    "PokemonBattle.Trainer Paimon's PokemonBattle.Pokemon 22: 24/75\n");

            System.out.println("---------------------------------");

            bf.battle("attack", "attack");

            System.out.println("你的答案：");
            System.out.println(bf.toString());

            System.out.println("正确答案：");
            System.out.println("Turn 16:\n" +
                    "PokemonBattle.Trainer XiaoZhi's PokemonBattle.Pokemon 13: 18/90\n" +
                    "PokemonBattle.Trainer Paimon's PokemonBattle.Pokemon 22: 12/75\n");

            System.out.println("---------------------------------");

            bf.battle("heal", "heal");

            System.out.println("你的答案：");
            System.out.println(bf.toString());

            System.out.println("正确答案：");
            System.out.println("Turn 17:\n" +
                    "PokemonBattle.Trainer XiaoZhi's PokemonBattle.Pokemon 13: 33/90\n" +
                    "PokemonBattle.Trainer Paimon's PokemonBattle.Pokemon 22: 32/75\n");

            System.out.println("---------------------------------");

            bf.battle("heal", "heal");

            System.out.println("你的答案：");
            System.out.println(bf.toString());

            System.out.println("正确答案：");
            System.out.println("Turn 18:\n" +
                    "PokemonBattle.Trainer XiaoZhi's PokemonBattle.Pokemon 13: 48/90\n" +
                    "PokemonBattle.Trainer Paimon's PokemonBattle.Pokemon 22: 52/75\n");

            System.out.println("---------------------------------");

            bf.battle("attack", "attack");

            System.out.println("你的答案：");
            System.out.println(bf.toString());

            System.out.println("正确答案：");
            System.out.println("Turn 19:\n" +
                    "PokemonBattle.Trainer XiaoZhi's PokemonBattle.Pokemon 13: 30/90\n" +
                    "PokemonBattle.Trainer Paimon's PokemonBattle.Pokemon 22: 40/75\n");

            System.out.println("---------------------------------");

            bf.battle("attack", "attack");

            System.out.println("你的答案：");
            System.out.println(bf.toString());

            System.out.println("正确答案：");
            System.out.println("Turn 20:\n" +
                    "PokemonBattle.Trainer XiaoZhi's PokemonBattle.Pokemon 13: 30/90\n" +
                    "PokemonBattle.Trainer Paimon's PokemonBattle.Pokemon 22: 28/75\n");

            System.out.println("---------------------------------");

            bf.battle("attack", "attack");

            System.out.println("你的答案：");
            System.out.println(bf.toString());

            System.out.println("正确答案：");
            System.out.println("Turn 21:\n" +
                    "PokemonBattle.Trainer XiaoZhi's PokemonBattle.Pokemon 13: 30/90\n" +
                    "PokemonBattle.Trainer Paimon's PokemonBattle.Pokemon 22: 16/75\n");

            System.out.println("---------------------------------");

            bf.battle("attack", "attack");

            System.out.println("你的答案：");
            System.out.println(bf.toString());

            System.out.println("正确答案：");
            System.out.println("Turn 22:\n" +
                    "PokemonBattle.Trainer XiaoZhi's PokemonBattle.Pokemon 13: 30/90\n" +
                    "PokemonBattle.Trainer Paimon's PokemonBattle.Pokemon 22: 4/75\n");

            System.out.println("---------------------------------");

            bf.battle("attack", "attack");

            System.out.println("你的答案：");
            System.out.println(bf.toString());

            System.out.println("正确答案：");
            System.out.println("Turn 23:\n" +
                    "PokemonBattle.Trainer XiaoZhi's PokemonBattle.Pokemon 13: 30/90\n" +
                    "PokemonBattle.Trainer Paimon's PokemonBattle.Pokemon 22: 0/75\n" +
                    "Winner: XiaoZhi\n");

            System.out.println("---------------------------------");

        }
    }
