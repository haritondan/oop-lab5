import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;

public class Sushi extends  Section{

    public ArrayList<String> item;

    Sushi(String Name){
        super(Name);
        item = new ArrayList<>();
        item.add("Naghiri");
        item.add("Dragon Rolls");
        item.add("Poke Bowl\n");
    }

    void showElements(){
        for(int i = 0; i < item.size(); i++){
            System.out.println(item.get(i));
        }
    }

    @Override
    public void fire(){
        System.out.println("*" + name + " section is on fire*");
    }
}
