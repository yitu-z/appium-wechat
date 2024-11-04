import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.chromium.ChromiumDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AppiumWechat {



    public static void main(String[] args) {
        AndroidDriver driver;
        var options = new BaseOptions().amend("appium:deviceName", "fcc6b0f3")
                .amend("appium:platformName", "Android")
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:connectHardwareKeyboard", true);


        try {

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            driver=null;
        }
        int times = 100;
        int time = 0;
        String lastMsg = "";
        String currentMsg = "";
        while(time++ <times) {
            lastMsg = currentMsg;
            for (int i = 1; i < 10; i++) {
                String path =
                        "//android.app.Dialog/android.view.View/android.view.View[3]/android.view.View/android.view.View[1]/android.view.View["
                                + i + "]";
                List<WebElement> views = driver.findElements(By.xpath(path));



                for (WebElement e : views) {
                    WebElement view = e.findElement(By.className("android.view.View"));

                    String text = view.getText();

                    if("".equals(text)){
                        continue;
                    }
                    if("已无更多数据".equals(text.trim())){
                        continue;
                    }
                    System.out.println(text);
                    currentMsg = text;



                }
            }
            if(currentMsg.equals(lastMsg)){
                System.out.println("last msg:"+lastMsg);
                System.out.println("curr msg:"+currentMsg);
                break;
            }

            var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            var start = new Point(583, 1817);
            var end = new Point(599, 855);
            var swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), start.getX(),
                    start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(
                    finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));
        }

         lastMsg = "";
         currentMsg = "";
        while(time++ <times) {
            lastMsg = currentMsg;
            for (int i = 1; i < 10; i++) {
                String path =
                        "//android.app.Dialog/android.view.View/android.view.View[3]/android.view.View/android.view.View[1]/android.view.View["
                                + i + "]";
                List<WebElement> views = driver.findElements(By.xpath(path));



                for (WebElement e : views) {
                    WebElement view = e.findElement(By.className("android.view.View"));

                    String text = view.getText();

                    if("".equals(text)){
                        continue;
                    }
                    if("已无更多数据".equals(text.trim())){
                        continue;
                    }
                    System.out.println(text);
                    currentMsg = text;



                }
            }
            if(currentMsg.equals(lastMsg)){
                System.out.println("last msg:"+lastMsg);
                System.out.println("curr msg:"+currentMsg);
                break;
            }


             var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            var start = new Point(487, 890);
            var end = new Point (559, 2005);
            var swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));


        }




    }
}
