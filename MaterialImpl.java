public class MaterialImpl implements Material
{
    private String name;
    private MaterialType type;
    private int quantity;


    public MaterialImpl(String name,MaterialType type)
    {
        this.name = name;
        this.type = type;
        this.quantity = 0;

    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setQuantities(int quantities)
    {
        this.quantity = quantities;
    }

    @Override
    public int getQuantities()
    {
        return this.quantity;
    }

    @Override
    public void setMaterialType(MaterialType type)
    {
        this.type = type;
    }

    @Override
    public MaterialType getMaterialType()
    {
        return this.type;
    }
}
