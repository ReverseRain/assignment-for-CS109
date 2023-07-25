package ass5;

import java.awt.*;

public class Cone extends GraphicObject{
    private double radius;
    private double length; //for all test data, the length is larger than radius
    public Cone(ObjectColor color, double radius, double length) {
        super(color);
        this.radius=radius;
        this.length=length;
    }

    @Override
    public double surfaceMeanSize() {
        Double surface=Math.PI*radius*radius+Math.PI*radius*length;
        return surface;
    }

    @Override
    public double volume() {
        Double volume=Math.PI*Math.pow(radius,2)*Math.pow((Math.pow(length,2)-Math.pow(radius,2)),0.5)/3;
        return volume;
    }

    @Override
    public String toString() {
        String Radius,Length;
        Radius=String.format("%.2f",radius);
        Length=String.format("%.2f",length);
        return String.format("Cone: r="+Radius+", l="+Length);
    }
}

