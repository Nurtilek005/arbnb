package arbnb;

import arbnb.config.HibernetConfig;
import arbnb.entyti.Address;
import arbnb.servise.AddresServise;
import arbnb.servise.serviseImp.AddresImp;

/**
 * Hello world!postgres
 *
 */
public class App 
{
    public static void main( String[] args ) {
//        System.out.println(HibernetConfig.getentityManeger());

        AddresServise addresServise = new AddresImp();
//        System.out.println(addresServise.save(new Address("bishkek1", "chuy1", " 1191")));
//        System.out.println(addresServise.save(new Address("bishkek2", "ch42uy", " 1129")));
//        System.out.println(addresServise.save(new Address("bishkek3", "chu4y", " 1193")));
//        System.out.println(addresServise.save(new Address("bishkek4", "ch3uy", " 1194")));
//        System.out.println(addresServise.getAddresById(1L));
        System.out.println(addresServise.updateAddresById(3L, new Address("bish", "bish", "bish")));


    }
}
