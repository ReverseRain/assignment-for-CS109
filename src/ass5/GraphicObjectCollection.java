package ass5;

import javax.management.StringValueExp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GraphicObjectCollection extends ObjectCollection{
    private List<GraphicObject> graphicObjects=new ArrayList<>(); //A list that stores graphics, the list should be empty (NOT be null) if there is no graphic
    public void addObject(ObjectColor objectColor, double ... parameters){
        switch (parameters.length){
            case 3:
                graphicObjects.add(new Cuboid(objectColor,parameters[0],parameters[1],parameters[2]));
                break;
            case 2:
                graphicObjects.add(new Cone(objectColor,parameters[0],parameters[1]));
                break;
            case 1:
                graphicObjects.add(new Sphere(objectColor,parameters[0]));
                break;
        }
    }
    public List<String> getObjectInfo(){
        List<String> stringList=new ArrayList<>();
        for (int i = 0; i < graphicObjects.size(); i++) {
            stringList.add(graphicObjects.get(i).toString());
        }
        return stringList;
    }
    public int getObjectCount(){
        return graphicObjects.size();
    }
    public List<String> getCountsByColor(){
        List<String> stringList=new ArrayList<>();
        int red=0, yellow=0, blue=0, green=0, black=0, white=0;
        for (int i = 0; i < graphicObjects.size(); i++) {
            switch (graphicObjects.get(i).getColor()){
                case BLUE ->blue++;
                case RED -> red++;
                case BLACK -> black++;
                case GREEN -> green++;
                case WHITE -> white++;
                case YELLOW -> yellow++;
            }
        }
        if (red!=0){
            stringList.add("RED "+ red);}
        if (yellow!=0){
            stringList.add("YELLOW "+ yellow);
        }if (blue!=0){
            stringList.add("BLUE "+ blue);
        }
        if (green!=0){
            stringList.add("GREEN "+ green);
        }
        if (black!=0){
            stringList.add("BLACK "+ black);
        }if (white!=0){
            stringList.add("WHITE "+ white);
        }
        return stringList;
    }
    public List<String> getObjectByVolume(){
        List<String> stringList=new ArrayList<>();
        for (int i = 1; i <graphicObjects.size() ; i++) {
            for (int j = 0; j < graphicObjects.size()-i; j++) {
                if (graphicObjects.get(j).volume()>graphicObjects.get(j+1).volume()){
                    GraphicObject temp=graphicObjects.get(j);
                    graphicObjects.set(j,graphicObjects.get(j+1));
                    graphicObjects.set(j+1,temp);
                }
            }
        }
        for (int i = 0; i < graphicObjects.size(); i++) {
            stringList.add(graphicObjects.get(i).toString());
        }
        return stringList;
    }
    public List<String> getObjectsBySurface(){
        List<String> stringList=new ArrayList<>();
        for (int i = 1; i <graphicObjects.size() ; i++) {
            for (int j = 0; j < graphicObjects.size()-i; j++) {
                if (graphicObjects.get(j).surfaceMeanSize()>graphicObjects.get(j+1).surfaceMeanSize()){
                    GraphicObject temp=graphicObjects.get(j);
                    graphicObjects.set(j,graphicObjects.get(j+1));
                    graphicObjects.set(j+1,temp);
                }
            }
        }
        for (int i = 0; i < graphicObjects.size(); i++) {
            stringList.add(graphicObjects.get(i).toString());
        }
        return stringList;
    }
    public double getWaterInjected(double area, double height){
        double volume=area*height,volumeAll=0;
        for (int i = 0; i < graphicObjects.size(); i++) {
            volumeAll=volumeAll+graphicObjects.get(i).volume();
        }
        if (volume-volumeAll>0){
            return volume-volumeAll;
        }
        else return 0;
    }

 //    if( array[i] >array[i+1]){
 //        int temp = array[i];
 //        array[i] = array[i+1];
 //        array[i+1] = temp;
 //    }     排序的基本原理！！！

}
