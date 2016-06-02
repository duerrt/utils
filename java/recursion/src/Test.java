/**
 * Created by duerrt on 5/29/16.
 */
public class Test {


    public static void main(String[] args) {

        Test t = new Test();
        t.process();
    }

    private void process() {

        System.out.println(" hi");
        removeFlowersInVase(10);
    }

    private void removeFlowersInVase(int flowers){
        System.out.println(" Flowers in vase " + flowers);
        flowers -= 1;
        if (flowers > 0){
            removeFlowersInVase(flowers);
        } else{
            System.out.println("All done!");
        }


    }
}