import java.io.BufferedReader;

public class Forfun {
    public static void main(String[] args) {
//        String inputfile = "/Users/yxh/NetBeansProjects/XiaohanPrivateProject/database/Originalfile.txt";
//        BufferedReader br = IOUtils.getTextReader(inputfile);
//        String temp = null;
//        String[] temps = null;
//        char[] tempss = null;
//        try {
//            while ((temp = br.readLine()) != null) {
//                temps = temp.split("\t");
//                String name = temps[1] + "_" + temps[0];
//                System.out.println(name);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        for (int i = 1; i < 96; i++) {
//            System.out.println(i);
//        }
        String inputfile = "/Users/yxh/NetBeansProjects/XiaohanPrivateProject/database/Covid.txt";
//        String temp =null;
//        String[] temps = null;
//        BufferedReader[] br = new BufferedReader[95];
//        for (int i = 0; i < 95; i++) {
//            br[i] = IOUtils.getTextReader(inputfile);
//        }
//        HashMap<String, String> DateInformation = new HashMap();
//        try {
//            for (int i = 0; i < 95; i++) {
//                StringBuffer information = new StringBuffer();
//                br[i].readLine();
//                while ((temp = br[i].readLine()) != null) {
//                    int index = i + 1;
//                    temps = temp.split("\t");
//                    information.append(temps[index] + "\t");
//                    continue;
//                }
//                DateInformation.put(String.valueOf(i+1), information.toString());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        BufferedReader br = IOUtils.getTextReader(inputfile);
        String temp = null;
        String[] temps = null;
        StringBuilder sb = new StringBuilder();
        String[] citynames = null;
        try {
            br.readLine();
            while ((temp = br.readLine()) != null) {
                temps = temp.split("\t");
                System.out.println(temps[0]);
                sb.append(temps[0] + "\t");

                continue;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sbs = sb.toString();
        System.out.println(sbs);
        citynames = sb.toString().split("\t");
        System.out.println(citynames[0]);


//        return DateInformation;
    }

}