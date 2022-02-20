import java.util.LinkedList;
import java.util.List;

public class ScoringSystem {
 // private Room[] rooms;
  private static final int numDoor = 20;
  private int numRoom;
  private List<Room> rooms = new LinkedList<Room>();

  public ScoringSystem() {
    this.rooms = rooms;
  }

  public List<Room> getRooms() {
    return rooms;
  }

  /**
   * Read all rooms data from python file
   * each room to the list of rooms
   */
  public void readRooms(){
  //TODO:

  }

  /**
   * @return the number of rooms
   */
  public int getRoomCount(){
    int count =0;
    for(Room room :rooms ){
      count++;
    }
    return count;
  }

  /**
   *
   * @return total area
   */
  public double getTotalArea() {
    double totalArea = 0;
    for (Room room : rooms) {
      totalArea = totalArea + room.getArea();
    }
    return totalArea;
  }

  public double getNonUseArea(){
    double nonUseArea = 0;
    for(Room room : rooms ){
      switch(room.getName()){
        case GARAGE:
          nonUseArea = nonUseArea + room.getArea();
          break;
      }
    }
    return nonUseArea;
  }

  public double getCorridorArea(){
    double corridorArea = 0;
    for(Room room : rooms ){
      switch(room.getName()){
        case GARAGE:
          corridorArea = corridorArea + room.getArea();
          break;
      }
    }
    return corridorArea;
  }
  /**
   * calculate total public area from all public type of rooms
   * @return public area
   */
  public double getPublicArea(){
    double publicArea = 0;
    for(Room room : rooms ){
      switch(room.getType()){
        case PUBLIC :
          publicArea = publicArea + room.getArea();
          break;
      }
    }
    return publicArea;
  }

  /**
   * calculate total pravite area from all public type of rooms
   * @return private area
   */
  public double getPrivateArea(){
    double privateArea = 0;
    for(Room room : rooms ){
      switch(room.getType()){
        case PRIVATE :
          privateArea = privateArea + room.getArea();
          break;
      }
    }
    return privateArea;
  }

  public double getPublicRatio(){
    double publicRatio = this.getPublicArea()/this.getTotalArea();
    return publicRatio;
  }

  public double getPraviteRatio(){
    double privateRatio = this.getPrivateArea()/this.getTotalArea();
    return privateRatio;
  }

  public double getCorridorRatio(){
    double corridorRatio = this.getCorridorArea()/this.getTotalArea();
    return corridorRatio;
  }

  public double getAreaUse(){
    double areaUse = this.getTotalArea() -this.getNonUseArea();
    return areaUse;
  }


  public double getScore(){
    double scoreArea = this.getPublicRatio() * numDoor;
    double scoreShortPassage = (1 - this.getCorridorRatio() * 0.2);

    double scoreFlow = 100;
    double scorePrivate = 100;

    double score = scoreArea * 0.3 + scoreShortPassage * 0.1 + scoreFlow * 0.2 + scorePrivate * 0.2;
    return score;
  }



  public static void main(String[] args){
    ScoringSystem scoringSystem = new ScoringSystem();
  //  scoringSystem.readRooms();

    Room living = new Room(RoomName.LIVING, 31477,TypeOfSpace.PUBLIC, new Point2D(0,0));
    Room garage = new Room(RoomName.GARAGE, 27666,TypeOfSpace.NON, new Point2D(0,0));
    Room corridor = new Room(RoomName.CORRIDOR, 9351,TypeOfSpace.NON, new Point2D(0,0));
    Room bathroom = new Room(RoomName.BATHROOM, 7154,TypeOfSpace.PRIVATE, new Point2D(0,0));
    Room storage = new Room(RoomName.STORAGE, 3350,TypeOfSpace.NON, new Point2D(0,0));
    Room bedroom = new Room(RoomName.BEDROOM, 20910,TypeOfSpace.PRIVATE, new Point2D(0,0));

    scoringSystem.rooms.add(living);
    scoringSystem.rooms.add(garage);
    scoringSystem.rooms.add(corridor);
    scoringSystem.rooms.add(bathroom);
    scoringSystem.rooms.add(storage);
    scoringSystem.rooms.add(bedroom);

    System.out.println(scoringSystem.getTotalArea());
    System.out.println(scoringSystem.getPublicArea());
    System.out.println(scoringSystem.getPrivateArea());
    System.out.println(scoringSystem.getTotalArea() - garage.getArea());
    System.out.println(scoringSystem.getScore());


  }


}
