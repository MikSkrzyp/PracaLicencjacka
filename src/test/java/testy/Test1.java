package testy;

import org.testng.annotations.Test;
import page.objects.Logowanie;

public class Test1 extends KonfiguratorTestow{


    @Test
    public void test1Metoda(){
        Logowanie logowanie = new Logowanie().test1();
    }
}
