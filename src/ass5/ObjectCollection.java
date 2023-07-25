package ass5;

import java.util.List;

public abstract class ObjectCollection {
    private List<GraphicObject> graphicObjects; //A list that stores graphics, the list should be empty (NOT be null) if there is no graphic
    public abstract void addObject(ObjectColor objectColor, double ... parameters);
    public abstract List<String> getObjectInfo();
    public abstract int getObjectCount();
    public abstract List<String> getCountsByColor();
    public abstract List<String> getObjectByVolume();
    public abstract List<String> getObjectsBySurface();
    public abstract double getWaterInjected(double area, double height);

}
