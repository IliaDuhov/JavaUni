import java.util.List;
public class Robot implements Checkable{
    int count;
    int price;
    String name;
    public void action(Share sh){
        if(count == 0){
            System.out.println("Buy");
            count = 100;
            price = sh.getPrice();
            name = sh.getName();
            return;
        }
        if(sh.getPrice() > price+50){
            System.out.println("Sell");
            count = 0;
            price = 0 ;
        }
    }

    @Override
    public void chaeckAction(List<Share> shares) {
        for(Share share:shares){
            share.priceChanges();
            action(share);
        }
    }
}
