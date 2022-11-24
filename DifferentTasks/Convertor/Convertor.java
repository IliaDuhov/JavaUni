abstract class Convertor{
    abstract void read();
    abstract void change();
    abstract void write();
    public void perform(){
        read();
        change();
        write();
    }
}
