interface clientDisputes{
    void escortClientOut();
}

interface managerResponsibility {
    void escortFire();
}
public class Manager extends Person implements clientDisputes, managerResponsibility {

    public String position;
    public String waiterName;
    Manager(String Name, String Position){
        super(Name);
        position = Position;
    }


    //base func for our class

    String getManName(){
        return name;
    }
    @Override
    void showName(){
        System.out.println("I am the manager, " + name+ ", I am the " + position + ". What can I help you with?");
    }
    void openRestaurant(){
        System.out.println("Uchiha RestoBar is now open\n");
    }
    void closeRestaurant(){
        System.out.println("The Restaurant has been closed\n");
    }

    //func for ClientDisputes interface
    public void escortClientOut() {
        System.out.println("The manager escorted the client out\n");
    }
    public void newFood(){
        System.out.println("Manager brought new food\n");
    }
    //func for the managerResponsibility interface
    public void escortFire() {
        System.out.println("Fire broke out. The manager escorted the clients\n");
    }
}
