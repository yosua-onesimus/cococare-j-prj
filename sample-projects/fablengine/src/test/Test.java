package test;

import model.obj.fb.FbAction;
import model.obj.fb.FbActor;

public class Test {

    public static void main(String[] args) {
        FbActor caster = new FbActor();
        caster.setHp(100);
        caster.setAp(100);
        caster.setEssence(10);

        FbActor target = new FbActor();
        target.setHp(100);
        target.setAp(100);
        target.setEssence(10);

        FbAction action = new FbAction();
        action.execute(caster, target);

        System.out.println(caster.getAp());
        System.out.println(target.getHp());
    }
}
/**
 * Cold Bonus	Frozen	beku, hanya bisa psionic, ess berkurang, memperbesar damage bolt, dapat
 * dihilangkan dengan fire Fire Bonus	Scorch	terbakar, hp berkurang, def berkurang, memperbesar
 * damage aqua, dapat dihilangkan dengan cold Aqua Bonus	Puffed	sesak nafas, ap berkurang, def
 * berkurang, memperbesar damage fire, dapat dihilangkan dengan bolt Bolt Bonus	Aghast	terperanjat,
 * hanya bisa physical, off berkurang, memperbesar damage cold, hilang jika terkena aqua Land	Heavy
 * a character inflicted with heavy has it's movement speed reduced. Wind	Dizzy	Attacks both enemies
 * and allies indiscriminately and uncontrollably.
 */