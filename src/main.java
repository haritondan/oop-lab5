
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.*;

import java.util.Random;

import static java.lang.Math.min;

public class main {
    public static void main(String[] args) {
        Bar bar = new Bar("Bar");
        European european = new European("European");
        Sushi sushi = new Sushi("Sushi");
        Stock stock = new Stock("Restaurant Stock");
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

        while(true) {
            float eventChooser = random.nextFloat(0,1);

            if(eventChooser <0.2)
        {   restaurant.manager.openRestaurant();
            int r = random.nextInt(1,4);
            String section;
            if (r == 1){
                section = bar.name;
            } else if (r == 2) {
                 section = sushi.name;
            }else {section = european.name;}
            System.out.println("A fire broke out at section" + section);
            restaurant.manager.escortFire();
            restaurant.manager.closeRestaurant();
        }
        else {
                restaurant.manager.closeRestaurant();
                if (eventChooser < 0.15) {
                for (Iterator<Map.Entry<Client, Integer>> it = restaurant.clientList.entrySet().iterator(); it.hasNext(); ) {
                    Map.Entry<Client, Integer> entry = it.next();
                    entry.getKey().clientWedding();
                    entry.getKey().spousesLeft();
                }
                restaurant.manager.closeRestaurant();
            } else {
                restaurant.manager.openRestaurant();
                LocalTime time = LocalTime.parse("08:00");
                do {
                    System.out.println(time);
                    time = time.plusMinutes(15);
                    //manager
                    int rand = random.nextInt(0, names.size());
                    for (Iterator<Map.Entry<Client, Integer>> it = restaurant.clientList.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<Client, Integer> entry = it.next();
                        if (entry.getKey().hasOrder && random.nextFloat(0, 1) < 0.15) {
                            entry.getKey().complaint();
                            if (random.nextFloat(0, 1) < 0.8) {
                                restaurant.manager.newFood();
                            } else {
                                restaurant.manager.escortClientOut();
                            }
                        }
                        if (entry.getKey().hasOrder && random.nextFloat(0, 1) < 0.15) {
                            entry.getKey().waiter.dropOrder();

                        }
                        if (!entry.getKey().hasOrder && random.nextFloat(0, 1) < 0.9) {
                            entry.getKey().hasOrder = true;
                            restaurant.budgetPerDay += entry.getKey().order();
                        } else {
                            if (random.nextFloat(0, 1) < 0.15 * restaurant.clientList.get(entry.getKey())) {
                                entry.getKey().left();
                                it.remove();
                            } else {
                                restaurant.clientList.put(entry.getKey(), restaurant.clientList.get(entry.getKey()) + 1);
                            }
                        }
                    }
                    for (int i = 0; i < min(random.nextInt(1, 2), restaurant.restaurantCapacity - restaurant.clientList.size()); i++) {
                        restaurant.clientList.put(new Client(names.get(rand), clientNumber, restaurant.getAvailableWaiter().get(), bar, european, sushi), 0);
                        clientNumber++;
                    }
                    System.out.println("Clients in the restaurant: " + restaurant.clientList.size());
                    System.out.println("The last clients left");

                } while (time.isBefore(LocalTime.parse("20:01")));
                restaurant.manager.closeRestaurant();
            }
        }
            int profit = restaurant.budgetPerDay - restaurant.wageBill;
            int profitMonth =+ profit;
            System.out.println("Profit for the day: " + profit);
            int i =+1;
            if (i % 30 == 0){
                System.out.println("Profit for the Month: "+ profitMonth);
            }
        }
    }

}



