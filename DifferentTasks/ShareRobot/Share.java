public class Share implements Changeable{
    private String name;
    private int price;
    public int getPrice() {
        return price;
    } 
    public String getName() {
        return name;
    } 
    @Override
    public void notifyOfChanges() {
        System.out.println("------------");
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void priceChanges() {
        setPrice(price);
        notifyOfChanges();
    }

    
}
