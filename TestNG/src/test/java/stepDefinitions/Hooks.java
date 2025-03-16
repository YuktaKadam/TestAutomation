package stepDefinitions;


import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.Serializers;
import org.example.testng.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import java.io.IOException;

public class Hooks extends BaseTest {


  @Before
  public void setup() throws IOException {
    System.out.println("Before hook running");
     initializedriver();
  }

  @After
  public void close()
  {
    closedriver();
  }
}
