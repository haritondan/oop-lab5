import javax.swing.plaf.synth.SynthTextAreaUI;
interface waiterManager{
    void sectionOnFire();

}
interface special{
    void bringCakeRing();
    void fireworks();
}


interface waiterDropsOrder{
    void dropOrder();
    void bringAnotherOrder();
}



public class Waiter extends Person implements waiterDropsOrder,waiterManager, special{
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
    public void greetClient(){
        System.out.println("Good evening, my name is " + name + " and today I will be you waiter");
    }
    public void showMenus(){
        System.out.println("We have 3 menus for you: Bar, Sushi or European. Which one would you like to see?\n");
    }
    public void cUnplesead(){
        System.out.println("What seems to be the problem?");
    }

    //for waiterDropsOrder interface
    public void bringOrder(){
        System.out.println("Here is your order. Enjoy your meal.\n");
    }
    public  void dropOrder(){
        System.out.println("The Waiter dropped the order");
        System.out.println("I am so sorry. I will bring you a new order\n");
    }
    public void bringAnotherOrder(){
        System.out.println("Here is your new order. I am sorry for the inconvenience. Enjoy your meal.\n");
    }


    //func for the waiterManager interface
    public void sectionOnFire(){
        System.out.println("Mr." + m1.name + ", our section is on fire" );
    }

    //for the special interface
    public void bringCakeRing(){
        System.out.println("*The waiter brings the wrong meal(it's a cake and leaves it in from of the client)*");
    }
    public void fireworks() {
        System.out.println("*Waiter pops up confetti*");
    }
}
