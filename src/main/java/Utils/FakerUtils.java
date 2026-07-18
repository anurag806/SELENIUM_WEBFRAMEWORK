package Utils;

import net.datafaker.Faker;

public class FakerUtils {
    private static final Faker faker=new Faker();
    public  static  String GetfirstName(){
        return faker.name().firstName();
    }
    public static String getEmail(){
        return faker.internet().emailAddress();
    }
    public static String MobileNumber(){
    return faker.phoneNumber().subscriberNumber(10);
    }
}
