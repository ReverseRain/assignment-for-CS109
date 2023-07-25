package ass5;

public class Sphere extends GraphicObject {
    private double radius;
    public Sphere(ObjectColor color, double radius) {
        super(color);//特别注意这里的super应该要放到最前面！
        this.radius=radius;
    }

    @Override
    public double surfaceMeanSize() {
        Double surface=4*Math.PI*radius*radius;
        return surface;
    }

    @Override
    public double volume() {
        Double volume =4*Math.PI*Math.pow(radius,3)/3;
        return volume;
    }

    @Override
    public String toString() {
        String r=String.format("%.2f",radius);
        return String.format("Sphere: r="+r);
    }
}
