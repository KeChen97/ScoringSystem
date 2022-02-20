public class Room {
//  private String name;
  private RoomName name;
  private double area;
  private TypeOfSpace type;
  private Point2D center;

//  private double distanceToLiving;

  public Room(RoomName name, double area, TypeOfSpace type, Point2D center) {
    this.name = name;
    this.area = area;
    this.type = type;
    this.center = center;
  }

  public double getArea(){
    return this.area;
  }

  public TypeOfSpace getType() {
    return this.type;
  }

  public RoomName getName(){
    return this.name;
  }

  public Point2D getCenter() {
    return center;
  }
//
//  public double getDistanceToLiving() {
//    return this.distanceToLiving;
//  }

}
