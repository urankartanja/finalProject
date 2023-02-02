package tests;

import org.testng.annotations.Test;

public class ProfileTests extends BaseTest{

   @Test
    public void editsProfile(){
       loginPage.signupFillForm(faker.name().firstName(),faker.internet().emailAddress(),"555111", "555111");

   }
}
