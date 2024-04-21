
public class Main {
    public static void main(String[] args)
    {
        Warehouse first = new WarehouseImpl(1);
        Warehouse second = new WarehouseImpl(2);

        MaterialType iron = new MaterialTypeImp("Iron", 65);

        Material iron_boots = new MaterialImpl("Iron_boots",iron);

        Material iron_chest = new MaterialImpl("Iron_Chest",iron);
        first.addMaterial(iron_boots);

        Material iron_sword = new MaterialImpl("Iron_Sword", iron);
        for(int i = 0; i < 34; ++i)
        {
            first.addMaterial(iron_boots);
        }
        first.addMaterial(iron_chest);
        for(int i = 0; i < 32; ++i)
        {
            first.addMaterial(iron_chest);
        }

        for(int i = 0; i < 64; ++i)
        {
            first.addMaterial(iron_sword);
        }
        first.transaction(second, new MaterialImpl("Iron_boots",iron));
        first.transaction(second, new MaterialImpl("Iron_sword",iron));
        System.out.println("COUNTER OF FIRST IS: ");
        System.out.println(first.getMaterialCounter(iron_chest));
//
//
        first.removeMaterial(iron_boots);
        first.removeMaterial(iron_chest);
        System.out.println(first.getMaterialCounter(iron_boots));

        System.out.println("COUNTER OF SECOND IS: ");

        System.out.println(second.getMaterialCounter(iron_boots));


    }
}