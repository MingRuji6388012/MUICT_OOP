public class Main {

    public static void main(String[] args)
    {
        //System.out.println("Abc_098@".matches("[a-zA-Z0-9_]+"));
        //Animal an = new Animal("Human");	//cannot because Animal is an abstract class
        Human isHeHuman = new SuperHuman("Ming",19);
        isHeHuman.makeNoise();
        isHeHuman.walk();
       // isHeHuman.fly();  HE IS HUMAN, HE CANNOT FLY!
        if(isHeHuman instanceof Human){
            System.out.println("I'm Human");
        }else if(isHeHuman instanceof SuperHuman){
            System.out.println("I'm Super Human!!");
        }
        System.out.println("===============================\n");
        Human ClonedHuman = (SuperHuman)isHeHuman;
        ClonedHuman.walk();
        ClonedHuman.makeNoise();
        System.out.println(ClonedHuman.name);
        ClonedHuman.lowerAge();
        isHeHuman.lowerAge();
        if(ClonedHuman == isHeHuman){
            System.out.println("ClonedHuman == isHeHuman");
        }
        System.out.println("Cloned Human's age: "+ClonedHuman.age);
        System.out.println("Cloned isHeHuman's age: "+isHeHuman.age);

        System.out.println("===============================\n");
        SuperHuman hugeMan = new SuperHuman("Araoi",24);
        hugeMan.fly();

        Human manAgain = hugeMan;
        //manAgain.fly(); HE IS HUMAN, HE CANNOT FLY!
        manAgain.makeNoise();
        manAgain.walk();
}

}

//abstract class Animal
abstract class Animal
{	public String name = "";
    public int age = 0;
    public Animal(String _name, int age) {
        name = _name;
        this.age = age;
    }

    public void breathe()
    {
        System.out.println("Breathing...");
    }
    public abstract void lowerAge();
    public abstract void makeNoise();	//you dont know how make noise without knowing what type this animal is.
}

class Human extends Animal
{
    public Human(String _name, int age) {
        super(_name, age);
    }

    public void makeNoise() {
        System.out.println("Hahaha");
    }

    public void walk(){
        System.out.println("WALK!");
    }

    public void lowerAge(){
        age--;
    }
}

class SuperHuman extends Human{
    public SuperHuman(String _name, int age) {
        super(_name,age);
    }

    public void makeNoise() {
        System.out.println("Hahaha UwaUwa -W-");
    }

   public void fly(){
       System.out.println("FEEWWWWW");
   }

    public void lowerAge(){
        age--;
    }
}
