
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.*;

import java.util.Random;

public class main {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        try {
            File myObj = new File("names.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                names.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Restaurant restaurant = new Restaurant();
        Random random = new Random();
        int clientNumber = 0;

        //while(true) {
            float eventChooser = random.nextFloat(0,1);
            System.out.println(eventChooser);
            if(eventChooser < 0.15) {
                restaurant.manager.openRestaurant();
                System.out.println("error");
                restaurant.manager.closeRestaurant();
            }
            else {
                LocalTime time = LocalTime.parse("08:00");
                do {
                    System.out.println(time);
                    time = time.plusMinutes(15);
                    //manager
                    int rand = random.nextInt(0, names.size());
                    clientNumber ++;
                    for(Iterator<Map.Entry<Client, Integer>> it = restaurant.clientList.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<Client, Integer> entry = it.next();
                        if (entry.getKey().hasOrder && random.nextFloat(0, 1) < 0.15) {
                            entry.getKey().waiter.dropOrder();
                        }
                        if (!entry.getKey().hasOrder && random.nextFloat(0, 1) < 0.9) {
                            entry.getKey().hasOrder = true;
                            restaurant.bugetPerDay += entry.getKey().order();
                        } else {
                            if (random.nextFloat(0, 1) < 0.15 * restaurant.clientList.get(entry.getKey())) {
                                entry.getKey().left();
                                it.remove();
                            } else {
                                restaurant.clientList.put(entry.getKey(), restaurant.clientList.get(entry.getKey()) + 1);
                            }
                        }
                    }
                    restaurant.clientList.put(new Client(names.get(rand), clientNumber, restaurant.getAvailableWaiter().get()), 0);




                } while (time.isBefore(LocalTime.parse("20:01")));
            }
        System.out.println(restaurant.bugetPerDay);
        //}













    }
}
//
       /* int ch;
        do {
            System.out.println("Enter 1 for the normal client scenario");
            System.out.println("Enter 2 for the dropped the food scenario");
            System.out.println("Enter 3 for the manager replaced the food scenario");
            System.out.println("Enter 4 for the manager and client argue scenario");
            System.out.println("Enter 5 for the fire hazard scenario");
            System.out.println("Enter 6 for the special events scenario");
            System.out.println("Enter 9 for the restaurant stocks scenario");
            System.out.println("Enter 0 to stop the program");
            System.out.println("Enter your choice:");
            ch = scan.nextInt();
            switch (ch){
                case 1://Everything is normal
                    c1.arrived();

                    w1.showMenus();
                    int menu1 = random.nextInt(1,4);
                    if(menu1 == 1) {
                        System.out.println("Client chose the " + b1.name + " menu: ");

                    } else if (menu1 == 2) {
                        System.out.println("Client chose the " + e1.name + " menu: ");

                    }else {
                        System.out.println("Client chose the " + s1.name + " menu: ");

                    }
                    c1.order();

                    c1.payClient();
                    break;
                case 2://Waiter drops the food
                    c1.arrived();

                    w1.showMenus();
                    int m2 = random.nextInt(1,4);
                    if(m2 == 1) {
                        System.out.println("Client chose the " + b1.name + " menu: ");

                    } else if (m2 == 2) {
                        System.out.println("Client chose the " + e1.name + " menu: ");

                    }else {
                        System.out.println("Client chose the " + s1.name + " menu: ");

                    }
                    c1.order();
                    w1.dropOrder();
                    int i = random.nextInt(1,3);
                   // System.out.println(i);
                    if(i == 1){

                        c1.payClient();
                    }else{

                    }
                    break;
                case 3://the food is bad gets a replacement
                    c1.arrived();
                    w1.greetClient();
                    w1.showMenus();
                    int m3 = random.nextInt(1,4);
                    if(m3 == 1) {
                        System.out.println("Client chose the " + b1.name + " menu: ");
                        b1.showElements();
                    } else if (m3 == 2) {
                        System.out.println("Client chose the " + e1.name + " menu: ");
                        e1.showElements();
                    }else {
                        System.out.println("Client chose the " + s1.name + " menu: ");
                        s1.showElements();
                    }
                    c1.Order();
                    c1.Vomit();
                    w1.cUnplesead();
                    c1.Complaint();
                    m1.talkToClient();
                    c1.ToManager();
                    m1.getNewOrder();
                    c1.payClient();
                    break;
                case 4://the food is good but the client tries to get food for free
                    c1.arrived();
                    w1.greetClient();
                    w1.showMenus();
                    int m4 = random.nextInt(1,4);
                    if(m4 == 1) {
                        System.out.println("Client chose the " + b1.name + " menu: ");
                        b1.showElements();
                    } else if (m4 == 2) {
                        System.out.println("Client chose the " + e1.name + " menu: ");
                        e1.showElements();
                    }else {
                        System.out.println("Client chose the " + s1.name + " menu: ");
                        s1.showElements();
                    }
                    c1.Order();
                    c1.Vomit();
                    w1.cUnplesead();
                    c1.Complaint();
                    m1.talkToClient();
                    c1.ToManager();
                    m1.clientDisagree();
                    c1.disagreeManager();
                    m1.deescalateSituation();
                    int f = random.nextInt(1,3);
                    if (f != 1) {
                        c1.conArgue();
                        m1.escortClientOut();
                    }
                    c1.left();
                    break;
                case 5://Section Emergency
                    int sf = random.nextInt(1,4);
                    if(sf == 1){
                        b1.fire();
                    } else if (sf == 2) {
                        e1.fire();
                    } else {
                    s1.fire();
                    }
                    w1.sectionOnFire();
                    m1.escortFire();
                    break;
                case 6://Special Events
                    c1.arrived();
                    w1.greetClient();
                    c1.signWaiter();
                    w1.showMenus();
                    c1.Order();
                    w1.bringCakeRing();
                    c1.propose();
                    w1.fireworks();
                    c1.spousesLeft();

                    break;
                case 9:
                    stock.showElements();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Wrong Input!");
                    break;

            }


        }while(ch != 0);
        m1.closeRestaurant();

    }

}

*/




