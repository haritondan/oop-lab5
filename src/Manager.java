interface clientDisputes{
    void clientDisagree();
    void deescalateSituation();
    void escortClientOut();
}

interface managerResponsibility {
    void escortFire();
}
public class Manager extends Person implements clientDisputes, managerResponsibility {

    public String position;
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
        System.out.println("I am the manager, " + name);
    }
    void openRestaurant(){
        System.out.println("Uchiha RestoBar is now open\n");
    }
    void talkToClient(){
        System.out.println("\nHello sir. My name is " + name + ", I am the " + position + ". What can I help you with?");
    }
    void getNewOrder(){
        System.out.println("\nHere is your new order. I am truly sorry for the inconvenience, enjoy your meal sir.");
    }
    void closeRestaurant(){
        System.out.println("The Restaurant has been closed");
    }

    //func for ClientDisputes interface
    public void clientDisagree() {
        System.out.println("Everything is normal with you order sir");
    }
    public void deescalateSituation() {
        System.out.println("Please calm down!");
    }
    public void escortClientOut() {
        System.out.println("Please, leave our restaurant now!");
    }

    //func for the managerResponsibility interface
    public void escortFire() {
        System.out.println("Dear Clients, we have fire at one of our sections. As of right now our restaurant is closed.\nPlease follow our waiters outside \n");
    }
}
