import java.util.Random;

interface clientSpecial{
    void clientWedding();
    void spousesLeft();
}

public class Client extends Person implements clientSpecial {
    public int number;
    boolean hasOrder = false;
    public Waiter waiter;
    public Bar b1;
    public European e1;
    public Sushi s1;
    public Client(String Name,int Number, Waiter waiter, Bar b1, European e1, Sushi s1){
        super(Name);
        number = Number;
        this.waiter = waiter;
        this.b1 = b1;
        this.e1 = e1;
        this.s1 = s1;
        arrived();
    }
    //the basic func of our class
    @Override
    void showName(){
        System.out.println("Client name is " + name);
    }
    void arrived(){//Client arrived
        System.out.println("\nClient "+ number + " has arrived " + name +".This Client waiter is "+ waiter.name +"\n");
    }
    int order() {
        System.out.println("Client " + number + " made the order\n");
        Random random = new Random();
        int chanceMenu = random.nextInt(1,4);
        int price = 0;
        //menu bar
        if(chanceMenu ==1) {
            if (random.nextFloat(0, 1) < 0.33) {
                int chance = random.nextInt(1, 4);
                if (chance == 1) {
                    price = price + b1.barMenu.get("Enzo");
                } else if (chance == 2) {
                    price = price + b1.barMenu.get("Martini");
                } else {
                    price = price + b1.barMenu.get("B52");
                }
            }
        }
        //menu bar
        else if (chanceMenu ==2) {
            if (random.nextFloat(0, 1) < 0.33) {
                int chance = random.nextInt(1, 4);
                if (chance == 1) {
                    price = price + s1.sushiMenu.get("Naghiri");
                } else if (chance == 2) {
                    price = price + s1.sushiMenu.get("Dragon Rolls");
                } else {
                    price = price + s1.sushiMenu.get("Poke Bowl");
                }
            }
        }
        else {
            //menu european
            if (random.nextFloat(0, 1) < 0.33) {
                int chance = random.nextInt(1, 4);
                if (chance == 1) {
                    price = price + e1.euroMenu.get("Zeama UTM");
                } else if (chance == 2) {
                    price = price + e1.euroMenu.get("Pasta Pardono");
                } else {
                    price = price + e1.euroMenu.get("Lovele Saltele");
                }
            }
        }
        return price;
    }
    void left(){System.out.println("Client "+ number + " has left\n");}
    void complaint(){
        System.out.println("Client "+ number+ " complained about the food\n");
    }


    //for the clientSpecial interface
    public void clientWedding() {
        System.out.println("*CThe restaurant is booked for a wedding today*");
    }
    public void spousesLeft() {
        System.out.println("Our clients left. Our special event is over. \n");
    }
}
