import java.util.HashMap;

/**
 * @author xiaohan
 */


class Cat {

    boolean tired = true;
    boolean hungry = true;
    String happySound = "meow";
    String tiredSound = "Xuuuu";
    String hungrySound = "puuuur";
    String[] sound = {happySound, tiredSound, hungrySound};
    String[] emotion = {"happy", "tired", "hungry"};
    String feel = "";
    HashMap<String, String> FeelsMap = new HashMap<>();

    public void matchEmotion(){
        for(int i =0;i<3;i++){
            FeelsMap.put(emotion[i],sound[i]);
        }
    }

    // A cat is rested and hungry after it sleeps
    public void sleep() {
        this.tired = false;
        this.hungry = true;
    }

    //
    public void eat() {
        // eating when not hungry makes a cat sleepy
        if (!this.hungry) {
            this.tired = true;
        }
        this.hungry = false;
    }

    public String getEmotion() {
        if (!this.hungry && !this.tired) {
            feel = "happy";
        }
        if(this.hungry && ! this.tired){
            feel = "hungry";
        }
        if(!this.hungry && this.tired){
            feel = "tired";
        }
        return feel;
    }
    // sleepy cats say prrrr, energized cats say meow!
    public String noise(String feel) {
        return FeelsMap.get(this.feel);
    }
}

class HouseCat extends Cat {


    private String name;

    public HouseCat(String name) {
        // first initialize as a normal Cat
        super();
        this.name = name;
    }

    public String purr() {
        if (satisfied()) {
            return "I'm a HouseCat";
        }
        return null;
    }

    public boolean satisfied() {
        return !this.hungry && !this.tired;
    }

    public String noise() {
        if (this.satisfied()) {
            return "Hello, my name is " + this.name + "!";
        } else {
            return super.noise(this.feel);
        }
    }
}

class Tiger extends Cat {

    private String name;

    public Tiger(String name) {
        super();
        this.name = name;
    }

    public boolean angry() {
        return this.tired && this.hungry;
    }

    public String noise() {
        if (this.angry()) {
            return "GRRRR";
        } else {
            return super.noise(this.feel);
        }
    }
}

public class Game {

    public Game() {
        this.playing();
    }

    public void playing() {
        Tiger hobbes = new Tiger("hobbes");
        HouseCat garfield = new HouseCat("garfield");
        hobbes.matchEmotion();
        garfield.matchEmotion();
        System.out.println("hobbes says: " + hobbes.noise());
        hobbes.sleep();
        System.out.println("After sleeping, hobbes says: " + hobbes.noise(hobbes.getEmotion()));
        hobbes.eat();
        System.out.println("After eating, hobbes still says: " + hobbes.noise(hobbes.getEmotion()));
        hobbes.eat();
        System.out.println("After eating again, hobbes says: " + hobbes.noise(hobbes.getEmotion()));
        System.out.println("garfield says: " + garfield.noise(garfield.getEmotion()));
        garfield.sleep();
        System.out.println("After sleeping, garfield says: " + garfield.noise(garfield.getEmotion()));
        garfield.eat();
        System.out.println("After eating, garfield says: " + garfield.noise(garfield.getEmotion()));
        System.out.println(garfield.purr());
        garfield.eat();
        System.out.println("After eating again, garfield says: " + garfield.noise(garfield.getEmotion()));
    }

    public static void main(String[] args) {
        new Game();
    }
}
