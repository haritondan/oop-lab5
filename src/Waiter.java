import java.util.Random;

interface waiterDropsOrder{
    void dropOrder();
}

public class Waiter extends Person implements waiterDropsOrder{
    public Manager m1;
    public Waiter(String Name, Manager m1){
        super(Name);
        this.m1 = m1;
    }
    
    //basic func for out class
    @Override
    void showName(){
        System.out.println("I am waiter and My name is " + name);
    }

    public void showMenus(){
        System.out.println("Waiter brought the menus\n");
    }
    public  void dropOrder(){
        System.out.println("The Waiter dropped the order");
        Random random = new Random();
    }

}
