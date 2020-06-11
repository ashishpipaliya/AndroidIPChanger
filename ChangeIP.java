import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class ChangeIP {

	public static void main(String[] args) throws Exception{
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setPlatform(Platform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "ANDROID");
		capabilities.setCapability("appPackage", "com.android.settings");
		capabilities.setCapability("appActivity", "com.android.settings.RadioInfo");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url,capabilities);
		
    // open radio setting and change type to LTE/CDMA/UMTS auto (PRL)
		driver.findElement(By.id("com.android.settings:id/preferredNetworkType")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='LTE/CDMA/UMTS auto (PRL)']")).click();

    // change type to LTE only wait 2 seconds for data to be connected
		driver.findElement(By.id("com.android.settings:id/preferredNetworkType")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='LTE only']")).click();
		Thread.sleep(2000);
			
		System.out.println("Done");
	
	}

}
