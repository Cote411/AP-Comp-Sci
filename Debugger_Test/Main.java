/**
 *  This is a class to practice using the debugger.
 *  Answer these questions using the Google form on
 *  Classroom.
 * 
 *  1. Set a breakpoint in the first line of the constructor
 *     Main.Main(). (line 24 of this file)
 *     You may want to use other breakpoints to answer
 *     questions 3 and 4.
 *
 *  2. What values are the strings thisClass, osName, tzCity,
 *     and country being set to in the constructor?
 *
 *  3. What are the values of osData before and after it is
 *      "reversed" in Main.runTests()?
 *
 *  4. Why is the program crashing in Main.runMoreTests()?
 *     Use a breakpoint right before the crash to determine this.
 */
public class Main {
    private int tests;
    private int osd;
    
    public Main() {
      tests = 0;
      String thisClass = getClass().getName();
      String osName = getOperatingSystemName();
      String tzCity = getTimezoneCity();
      String country = getCountry();
      osd = osName.hashCode();
      //System.out.println(osd);
    }
    
    public String getOperatingSystemName() {
      return System.getProperties().getProperty("os.name");
    }
  
    public String getCountry() {
      return System.getProperties().getProperty("user.country");
    }
  
    public String getTimezoneCity() {
      String tzString = System.getProperties().getProperty("user.timezone");
      if (tzString != null) {
        String[] tzStrings = tzString.split("/", 2);
        return tzStrings[tzStrings.length - 1];
      }
      return null;
    }
    
    public int runTests() {
      for (int i = Integer.parseInt(System.getProperties().getProperty("java.class.version").split("\\.")[0]); i >= 0; i--) {
        tests++;
      }
      
      int osData = osd;
      osData = Integer.reverse(osData);
      return osData % 6;
    }
    
    public int runMoreTests() {
      Integer i = Integer.getInteger("42");
      return i.intValue();
    }
    
    public static void main(String[] args) {
      Main test = new Main();
      int firstTest = test.runTests();
      System.out.println("First test is " + firstTest);
      int secondTest = test.runMoreTests();
      System.out.println("Second test is " + secondTest);
    }
  }
  