public interface Warehouse
{
    public void addMaterial(Material material);

    public void removeMaterial(Material material);

    public void transaction(Warehouse two, Material material);

    public int getMaterialCounter(Material material);
}
