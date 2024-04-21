public class MaterialTypeImp implements MaterialType
{
    private String name;
    private String description;
    private String icon;
    private int maxCap;

    MaterialTypeImp(String name, int maxCap)
    {
        this.name = name;
        this.maxCap = maxCap;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public String getDescription()
    {
        return this.description;
    }

    @Override
    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    @Override
    public String getIcon()
    {
        return this.icon;
    }

    @Override
    public void setMaxCap(int cap)
    {
        this.maxCap = cap;
    }

    @Override
    public int getMaxCap()
    {
        return this.maxCap;
    }

}
