import java.util.*;
import java.util.stream.Collectors;


public class Test {
    public static void main(String[] args) {
        ArrayList<PersonData> list = new ArrayList();
        PersonData p1 = new PersonData();
        p1.setId("1");
        p1.setName("张三");
        p1.setType("管理员");
        p1.setAge(20);
        p1.setHeight("170cm");
        p1.setWeight("60kg");
        p1.setHair("少");
        list.add(p1);

        PersonData p2 = new PersonData();
        p2.setId("2");
        p2.setName("李四");
        p2.setType("管理员");
        p2.setAge(30);
        p2.setHeight("170cm");
        p2.setWeight("60kg");
        p2.setHair("少");
        list.add(p2);

        PersonData p3 = new PersonData();
        p3.setId("3");
        p3.setName("王五");
        p3.setType("用户");
        p3.setAge(40);
        p3.setHeight("170cm");
        p3.setWeight("60kg");
        p3.setHair("少");
        list.add(p3);

        PersonData p4 = new PersonData();
        p4.setId("4");
        p4.setName("马六");
        p4.setType("访客");
        p4.setAge(50);
        p4.setHeight("170cm");
        p4.setWeight("60kg");
        p4.setHair("少");
        list.add(p4);

        PersonData p5 = new PersonData();
        p5.setId("5");
        p5.setName("马七");
        p5.setType("访客");
        p5.setAge(50);
        p5.setHeight("170cm");
        p5.setWeight("60kg");
        p5.setHair("少");
        list.add(p5);

        List<String> stIdList1 = list.stream()
                .map(PersonData::getId)
                .collect(Collectors.toList());
        stIdList1.forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.println("----------");
        List<String> stHeightList1 = list.stream()
                .map(PersonData::getHeight)
                .collect(Collectors.toList());
        stHeightList1.forEach(s -> System.out.print(s+" "));
        System.out.println();
        System.out.println("----------");
        List<String> stHairList1 = list.stream()
                .map(PersonData::getHair)
                .collect(Collectors.toList());
        stHairList1.forEach(s -> System.out.print(s+" "));
        System.out.println();
        System.out.println("----------");
        List<String> stTypeList1 = list.stream()
                .map(PersonData::getType)
                .collect(Collectors.toList());
        stTypeList1.forEach(s -> System.out.print(s+" "));
        System.out.println();
        System.out.println("----------");

    }

}

class Human {
    public String height;
    public String weight;
    public String hair;

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getHair() {
        return hair;
    }
}


class PersonData extends Human {
    private String id;
    private String type;
    private String name;
    private int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//	public PersonData(String id, String type, String name, int age) {
//		super();
//		this.id = id;
//		this.type = type;
//		this.name = name;
//		this.age = age;
//	}
//
//	public PersonData() {
//
//	}
}

