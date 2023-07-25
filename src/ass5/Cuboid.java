package ass5;

public class Cuboid extends GraphicObject{
    private double x; //The length of cuboid
    private double y; //The width of cuboid
    private double z; //The height of cuboid
    public Cuboid(ObjectColor color, double x, double y, double z) {
        super(color);
        this.x=x;
        this.y=y;
        this.z=z;
    }

    @Override
    public double surfaceMeanSize() {
        Double surface=2*x*y+2*y*z+2*x*z;
        return surface;
    }

    @Override
    public double volume() {
        Double volum=x*y*z;
        return volum;
    }

    @Override
    public String toString() {
        String X,Y,Z;
        X=String.format("%.2f",x);
        Y=String.format("%.2f",y);
        Z=String.format("%.2f",z);
        return String.format("Cuboid: x="+X+", y="+Y+", z="+Z);
    }
}
