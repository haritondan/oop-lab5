
interface clientLeft{// for the cases in which our client left of various reasons
    void clientDropLeft();
}
interface clientSpecial{
    void signWaiter();
    void propose();
    void spousesLeft();
}

interface clientUnpleased {
    void Complaint();
    void ToManager();
    void Vomit();
    void disagreeManager();
    void conArgue();
}

public class Client extends Person implements clientLeft, clientUnpleased, clientSpecial {
    public int number;
    public Client(String Name,int Number){
        super(Name);
        number = Number;
    }
    //the basic func of our class
    @Override
    void showName(){
        System.out.println("Client name is " + name);
    }
    void arrived(){//Client arrived
        System.out.println("Client "+number + " has arrived\n");
    }
    void Order(){
        System.out.println("Client made the order\n");
    }
    void payClient(){
        System.out.println("Client" + " " +number + " paid and left.\n");
    }
    void left(){System.out.println("Client left.");}
    //for the clientLeft interface
    public void clientDropLeft(){
        System.out.println("I don't have time for this. *Client left!*");
    }

    //for the clientUnpleased interface
    public void Complaint(){
        System.out.println("This tastes awfully, let me speak with a manager.");
    }
    public void ToManager(){
        System.out.println("This tastes awfully, I want a replace for this order");
    }
    public void Vomit() {
        System.out.println("Ahh.. this is awful");
    }
    public void disagreeManager() {
        System.out.println("YOU DON'T UNDERSTAND NOTHING ABOUT FOOD");
    }
    public void conArgue(){System.out.println("You are so incompetent!");}

    //for the clientSpecial interface
    public void signWaiter() {
        System.out.println("*Client winks at the waiter*");
    }
    public void propose(){
        System.out.println("*The Client proposed to the partner*");
    }
    public void spousesLeft() {
        System.out.println("Our clients left. Our special event is over. \n");
    }
}
