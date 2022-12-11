public class Cat implements CanMeow{
    
    final String name;
    
    public Cat(String name){
        this.name = name;
    }
    
    @Override
    public String toString(){
        return String.format("cat: %s", name);
    }
    
    @Override
    public void meow(){
        System.out.println(String.format("%s: meow!", name));
    }
    
    public void meow(int num){
        
        System.out.print(name + ": ");
        
        for(int i = 0; i < num; i++){
            System.out.print("meow");
            if(i == num - 1) System.out.println("!");
            else System.out.print("-");
        }
    }
}
