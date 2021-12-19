import java.util.Scanner;

public class ShapeComparisionMain {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(new Point(2,3), new Point(10,7) );

        System.out.println("area of rectangle r :" + r.getAreaRectangle(r));
        r.print();
              //comparing two rectangles
        System.out.println("comparision :" + r.isSmaller(new Rectangle(new Point(2,3),
                new Point(10,7) ), new Rectangle(new Point(3,3), new Point(12,12) )));

        
        new Rectangle(new Point(3,3), new Point(12,12) ).print();// print method for rectangle object
        new Point(3,3);//print method of point object
        Circle c = new Circle(new Point(2,3),4);
        
        System.out.println("circle:" + c.getAreaCircle(c));
        c.print();
    }
    
}
class Point{
public int x_coordinate;
public int y_coordinate;

public Point(int x,int y){
    this.x_coordinate=x;
    this.y_coordinate=y;
}
public void print(){
    System.out.println("x_coordinate:"+x_coordinate+"y_coordinate:"+y_coordinate);
}
} 

class Rectangle{

    Point pointOne;
    Point pointTwo;
    public Rectangle(Point pointOne, Point pointTwo){
       this.pointOne = pointOne;
       this.pointTwo = pointTwo;
    }
    
    public int getHeight(){
                
        return pointTwo.y_coordinate-pointOne.y_coordinate;
    }
    public int getWidth(){

        return pointTwo.x_coordinate-pointOne.x_coordinate;
    }
    public int getAreaRectangle(Rectangle rec){
        return rec.getHeight()*rec.getWidth();
    }
    public boolean isSmaller(Rectangle rec2,Rectangle rec){//compare area of rectangle
        if(rec2.getAreaRectangle(rec2)< rec.getAreaRectangle(rec))
        return true;
        else
        return false;

    }
    public void print(){
        System.out.println("point One:"+this.pointOne+" point two:"+ this.pointTwo + " height:" + getHeight()+ " width" + getWidth());
    }

}

class Circle{

    Point circle_point;
    public double radius;

public Circle(Point circle_point, double radius){
    this.circle_point = circle_point;
    this.radius = radius;
}

public double getAreaCircle(Circle c ){//calculate area of circle

    return Math.PI*radius*radius;
}

      public boolean isSmaller(Circle c1,Circle c2)//compare two circles
      {
               if(c1.getAreaCircle(c1)< c2.getAreaCircle(c2))
                     return true;
               else
                     return false;

}

public void print(){
    System.out.println("point:"+this.circle_point+" radius:"+ this.radius + " area:"  );
}
}