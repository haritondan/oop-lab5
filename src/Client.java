interface clientSpecial{
    void signWaiter();
    void spousesLeft();
}

public class Client extends Person implements clientSpecial {
    public int number;
    boolean hasOrder = false;
    public Waiter waiter;
    public Client(String Name,int Number, Waiter waiter){
        super(Name);
        number = Number;
        this.waiter = waiter;
        arrived();
    }
    //the basic func of our class
    @Override
    void showName(){
        System.out.println("Client name is " + name);
    }
    void arrived(){//Client arrived
        System.out.println("Client "+ number + " has arrived " + name +".This Client waiter is "+ waiter.name +"\n");
    }
    int order(){
        System.out.println("Client made the order\n");

        return 10;
    }
    void payClient(){
        System.out.println("Client" + " " +number + " paid and left.\n");
    }
    void left(){System.out.println("Client "+ number + " has left\n");}


    //for the clientSpecial interface
    public void signWaiter() {
        System.out.println("*Client winks at the waiter*");
    }
    public void spousesLeft() {
        System.out.println("Our clients left. Our special event is over. \n");
    }
}
