
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class selenium_test {

    static WebDriver driver;

    // Define the navigateToPage function
    private static void navigateToPage(String url, String pageName) throws InterruptedException {
        driver.get(url);

        // Wait for the page to load (you may need to adjust the waiting time)
        Thread.sleep(2000); // Adjust the waiting time as needed

        // Verify the URL of the page
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals(url)) {
            System.out.println("Test Case - Navigate to " + pageName + " - Pass");
        } else {
            System.out.println("Test Case - Navigate to " + pageName + " - Fail");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver(); // Use the class variable instead of redefining it

        driver.get("http://localhost/ams/index.php");

        // Find and interact with HTML elements

        // Select user type (e.g., Administrator)
        driver.findElement(By.name("userType")).sendKeys("Administrator");

        // Enter username
        driver.findElement(By.id("exampleInputEmail")).sendKeys("admin@mail.com");

        // Enter password
        driver.findElement(By.id("exampleInputPassword")).sendKeys("Password@123");

        // Click the login button
        driver.findElement(By.name("login")).click();

        // Wait for a while to ensure the page loads (you can use WebDriverWait)

        // Get the actual URL after the login
        String actual_url = driver.getCurrentUrl();
        System.out.println(actual_url);

        // Verify the expected URL
        String expected_url = "http://localhost/ams/Admin/index.php"; // Change this URL
        if (actual_url.equals(expected_url)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        // Test Case 2: Navigate to the "Manage Class" page
        navigateToPage("http://localhost/ams/Admin/createClass.php", "Create Class");

        navigateToPage("http://localhost/ams/Admin/createClassArms.php", "Create Class Arms");

        navigateToPage("http://localhost/ams/Admin/createClassTeacher.php", "Create Class Teachers");
        // Click on "Create Class"
        navigateToPage("http://localhost/ams/Admin/createStudents.php", "Create Students");

        navigateToPage("http://localhost/ams/Admin/createSessionTerm.php", "Create Session and Term");

        // Test Case 3: Logout from the admin module
        navigateToPage("http://localhost/ams/Admin/index.php", "Admin Dashboard");

// Click on the user dropdown to open the dropdown menu
        driver.findElement(By.id("userDropdown")).click();

// Find and click the "Logout" link in the dropdown
        driver.findElement(By.linkText("Logout")).click();

// Wait for a while to ensure the logout process
        Thread.sleep(2000); // Adjust the waiting time as needed

// Get the current URL after logout
        String logoutUrl = driver.getCurrentUrl();
        System.out.println(logoutUrl);

// Verify that you have successfully logged out by comparing the actual URL with the login page URL or any other expected URL
        String expectedLoginUrl = "http://localhost/ams/index.php"; // Change this URL
        if (logoutUrl.equals(expectedLoginUrl)) {
            System.out.println("Pass - Logout Successful");
        } else {
            System.out.println("Fail - Logout Failed");
        }

        driver.findElement(By.name("userType")).sendKeys("Class Teacher");

        // Enter username
        driver.findElement(By.id("exampleInputEmail")).sendKeys("teacher2@mail.com");

        // Enter password
        driver.findElement(By.id("exampleInputPassword")).sendKeys("pass123");

        driver.findElement(By.name("login")).click();

        String actual_url1 = driver.getCurrentUrl();
        System.out.println(actual_url1);

        // Verify the expected URL
        String expected_url1 = "http://localhost/ams/ClassTeacher/index.php"; // Change this URL
        if (actual_url1.equals(expected_url1)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        navigateToPage("http://localhost/ams/ClassTeacher/viewStudents.php", "View Students");

        navigateToPage("http://localhost/ams/ClassTeacher/takeAttendance.php", "Take Attendance");

        navigateToPage("http://localhost/ams/ClassTeacher/viewAttendance.php", "View Class Attendance");
        // Click on "Create Class"
        navigateToPage("http://localhost/ams/ClassTeacher/viewStudentAttendance.php", "View Student Attendance");

        // Test Case 3: Logout from the admin module
        navigateToPage("http://localhost/ams/ClassTeacher/index.php", "Class Teacher Dashboard");

// Click on the user dropdown to open the dropdown menu
        driver.findElement(By.id("userDropdown")).click();

// Find and click the "Logout" link in the dropdown
        driver.findElement(By.linkText("Logout")).click();

        String logoutUrl1 = driver.getCurrentUrl();
        System.out.println(logoutUrl1);

// Verify that you have successfully logged out by comparing the actual URL with the login page URL or any other expected URL
        String expectedLoginUrl1 = "http://localhost/ams/index.php"; // Change this URL
        if (logoutUrl1.equals(expectedLoginUrl1)) {
            System.out.println("Pass - Logout Successful");
        } else {
            System.out.println("Fail - Logout Failed");
        }

       // Thread.sleep(2000); // Adjust the waiting time as needed
        //driver.close();

    }
}



