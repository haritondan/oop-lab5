interface clientSpecial{
    void signWaiter();
    void spousesLeft();
}

public class Client extends Person implements clientSpecial {
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
    void order(){
        System.out.println("Client made the order\n");
    }
    void payClient(){
        System.out.println("Client" + " " +number + " paid and left.\n");
    }
    void left(){System.out.println("Client left.");}


    //for the clientSpecial interface
    public void signWaiter() {
        System.out.println("*Client winks at the waiter*");
    }
    public void spousesLeft() {
        System.out.println("Our clients left. Our special event is over. \n");
    }
}
