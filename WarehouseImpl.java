import java.util.HashMap;

public class WarehouseImpl implements Warehouse
{
    private final HashMap<String,HashMap<String,Material>> inventory;

    int id;
    WarehouseImpl(int id)
    {
        this.id = id;
        inventory = new HashMap<>();
    }

    @Override
    public void addMaterial(Material material) {
        String materialTypeName = material.getMaterialType().getName();

        if (!inventory.containsKey(materialTypeName))
        {
            // Если нет inner для данного типа материала, создаем новый
            HashMap<String, Material> inner = new HashMap<>();
            inner.put(material.getName(), material);
            inventory.put(materialTypeName, inner);
            material.setQuantities(1);
        }
        else
        {
            HashMap<String, Material> inner = inventory.get(materialTypeName);
            if (inner.containsKey(material.getName()))
            {
                // Если материал уже существует внутри inner, увеличиваем его количество
                Material existingMaterial = inner.get(material.getName());
                if (existingMaterial.getQuantities() < material.getMaterialType().getMaxCap() - 1)
                {
                    int count = existingMaterial.getQuantities();
                    existingMaterial.setQuantities(count + 1);
                }
                else
                {
                    // Достигнуто максимальное количество
                    System.out.println("Max capacity reached for material: " + material.getName());
                }
            }
            else
            {
                // Если материал не существует внутри inner, добавляем его
                inner.put(material.getName(), material);
                material.setQuantities(1);
            }
        }
    }

    public boolean checkForElementInH(Material material)
    {
        return this.inventory.containsKey(material.getMaterialType().getName());
    }

    public boolean checkForElementInHH(Material material)
    {
        if(!checkForElementInH(material))
        {
            return true;
        }
        return !this.inventory.get(material.getMaterialType().getName()).containsKey(material.getName());
    }
    @Override
    public void removeMaterial(Material material)
    {
        if(checkForElementInH(material) && this.inventory.get(material.getMaterialType().getName()).containsKey(material.getName()))
        {
            if(this.inventory.get(material.getMaterialType().getName()).get(material.getName()).getQuantities() <= 0)
            {
                System.out.println("Max Capacity Of Elements, can't add more");
            }
            else
            {
                int count = inventory.get(material.getMaterialType().getName()).get(material.getName()).getQuantities();
                this.inventory.get(material.getMaterialType().getName()).get(material.getName()).setQuantities(count - 1);
            }
        }
    }

    @Override
    public void transaction(Warehouse two, Material material)
    {
        String materialTypeName = material.getMaterialType().getName();

        if (!checkForElementInH(material) && !checkForElementInHH(material))
        {
            System.out.println("Transaction Failed, material not found in inventories");
        } else if (!inventory.containsKey(materialTypeName) || !inventory.get(materialTypeName).containsKey(material.getName()) || inventory.get(materialTypeName).get(material.getName()).getQuantities() <= 0) {
            System.out.println("Transaction Failed, not enough items");
        } else
        {
            removeMaterial(material);
            two.addMaterial(material);
        }
    }

    @Override
    public int getMaterialCounter(Material material)
    {
        if(!checkForElementInH(material))
        {
            System.out.println("No such object");
            return 0;
        }
        if(checkForElementInHH(material))
        {
            System.out.println("No such object");
            return 0;
        }
        return (inventory.get(material.getMaterialType().getName())).get(material.getName()).getQuantities();
    }
}
