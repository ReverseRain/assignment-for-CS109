package ass5;

abstract class GraphicObject {    //特别注意抽象的类是不可以被实例化。    只有其非抽象子类可以创建对象
    private ObjectColor color; //Every graphic has the color, you should use the enum ObjectColor.
    private int id; //Every graphic has an id and the id is unique for each graphic

    public GraphicObject(ObjectColor color) {
        this.color=color;
    }

    public abstract double surfaceMeanSize();
    public abstract double volume();
    public abstract String toString();//抽象方法不能有{}在父类当中不可以具体的实现，要再子类中over ride

    public ObjectColor getColor() {
        return color;
    }
}
