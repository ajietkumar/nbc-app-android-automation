package com.nbcd.GenericLib;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import com.nbcd.GenericLib.Extent_Reports;



//=========================================================CLASS & METHODS =============================================================================================
public class GetWebDriverInstance extends Extent_Reports
{
	public static String env;
	private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();
	private static String userSystemOS = System.getProperty("os.name").toLowerCase();
	private static String  genericPath=System.getProperty("user.dir").concat("/src/test/resources/DriverExecutable/");
	public AppiumDriver driver;
	public static  String USERNAME="" ;
	public static  String AUTOMATE_KEY="" ;
	public static  String URL="" ;
	DesiredCapabilities capabilities ;
	//public AppiumDriver appiumDriver;
	public static  String port="" ;

	@SuppressWarnings("deprecation")
	@BeforeClass

	@Parameters(value={"environment","browser","version","os","osversion"})
	public   void getBrowser(String environment,String browser,String version,String os,String osversion) throws Exception 
	{


		env = environment;
		driver = null;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//appiumDriver=null;

		port=GetWebDriverInstance.getPort();
		Properties prop = new Properties();
		try 
		{

			InputStream input = new FileInputStream("config/Config.properties");
			// load a properties file
			prop.load(input);

		} 
		catch (IOException ex) 
		{
			ex.printStackTrace();
		}


		switch (environment.toUpperCase()) 
		{

		case "PHYSICAL_APP":

			try
			{

				

				if(os.trim().startsWith("i") || os.equalsIgnoreCase("6ad5f6262bd814298db3e308662e25ee0ab67c44"))
				{

					capabilities.setCapability("platformName", "iOS");
					capabilities.setCapability("platformVersion", "11.0.3"); 
					capabilities.setCapability("deviceName", "iPhone"); 
					capabilities.setCapability("bundleId", "com.nbcuni.nbc.portal.enterprise");
					if(browser.toLowerCase().contains("landscape")) 
					{
						capabilities.setCapability("orientation", "LANDSCAPE");
					}
					else
					{
				       capabilities.setCapability("orientation", "PORTRAIT");
					}
					
					capabilities.setCapability("udid", "6ad5f6262bd814298db3e308662e25ee0ab67c44");
					
					

					driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

				}


				else 
				{
					//GetWebDriverInstance.stopServer();
					GetWebDriverInstance.startServer();
					Thread.sleep(10000);

					String platformName="Android";
					String udid="LGH630Dc1a1d868";
					String appPackage="com.nbc.nbcapp";
					//String appPackage="com.nbc.nbcapp/debug";
					String appActivity="com.nbc.commonui.activity.DeepLinkActivity";

					String appiumURL = "http://127.0.0.1:" + "4725" + "/wd/hub";

					capabilities.setCapability("deviceName", os);
					capabilities.setCapability("udid", os); //Give Device ID of your mobile phone
					capabilities.setCapability("platformVersion", osversion);
					capabilities.setCapability("appPackage", "com.nbc.nbcapp");
					capabilities.setCapability("platformName", "Android");
					capabilities.setCapability("appActivity", "com.nbc.commonui.activity.DeepLinkActivity");	 

					try {
					driver = new AndroidDriver(new URL(appiumURL), capabilities);	

					driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
					}
					catch(Exception e) {
				   System.out.println(e.getMessage());
					}

				}

			}
			catch(Exception exc)
			{

				 System.out.println(exc.getMessage());
			}
			break;
			
		case "BS_MOBILE_APP":
			try{

				System.out.println("HERES");

				final String USERNAME =prop.getProperty("username");
				final String AUTOMATE_KEY = prop.getProperty("accessKey");;
				URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
				capabilities = new DesiredCapabilities();
				if(os.trim().startsWith("i"))
				{
					capabilities.setCapability("device", os);
					capabilities.setCapability("os_version", osversion);
					capabilities.setCapability("app", "bs://7a78e4be7e6226af92afddde251f545ae8121d7d");	
					capabilities.setCapability("browserstack.debug", "true");
					driver = new IOSDriver(new URL("https://"+USERNAME+":"+AUTOMATE_KEY+"@hub-cloud.browserstack.com/wd/hub"), capabilities);

				}
				else 
				{
					capabilities.setCapability("device", os);
					capabilities.setCapability("os_version", osversion);
					capabilities.setCapability("app", "bs://7a78e4be7e6226af92afddde251f545ae8121d7d");	
					capabilities.setCapability("browserstack.debug", "true");
					driver = new AndroidDriver(new URL("https://"+USERNAME+":"+AUTOMATE_KEY+"@hub-cloud.browserstack.com/wd/hub"), capabilities);

				}
			

			}			
			catch(Exception e){
				System.out.println("Browserstack instance creation ---exception " +e);



			}



			break;



			
			
			
			
		}//END SWITCH

	}


	@AfterMethod(alwaysRun = true)
	public  void closeAllDriver() 
	{

		try
		{
			driver.quit();
		}
		catch(WebDriverException exc)
		{
			System.out.println("WebDriver Exception in CloseAllDriver " +exc.getMessage());
		}

	}

	public static void startServer() throws Exception {
		CommandLine cmd;
		if(userSystemOS.contains("windows")) 
		{
			cmd = new CommandLine("C:\\Program Files (x86)\\Appium\\node.exe");
			cmd.addArgument("C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js",false);
		}
		else 
		{
			cmd = new CommandLine("/Applications/Appium.app/Contents/Resources/node/bin/node");
			cmd.addArgument("/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js");
		}
		//String port=GetWebDriverInstance.getPort();


		cmd.addArgument("--address");
		cmd.addArgument("127.0.0.1");
		cmd.addArgument("--port");
		//cmd.addArgument(port);
		cmd.addArgument("4725");

		DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(cmd, handler);
			Thread.sleep(10000);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}




	}

	public static void stopServer() throws Exception {
		if(userSystemOS.contains("windows")) 
		{
			
			String[] serviceName={"node" ,"adb"};
            // command used to get list of running task
            String TASKLIST = "tasklist";
            // command used to kill a task
            String KILL = "taskkill /IM ";


            Process pro = Runtime.getRuntime().exec(TASKLIST);
            BufferedReader reader = new BufferedReader(new InputStreamReader(pro.getInputStream()));
            String line;

            while((line = reader.readLine()) != null) 
            {

                // System.out.println(line);
                if (line.startsWith(serviceName[0])) 
                {
                    //Runtime.getRuntime().exec(KILL + serviceName[0]);
                    Runtime.getRuntime().exec("taskkill /F /IM adb.exe");
                    
                    System.out.println(serviceName+" killed successfully!");
                }
                
                if (line.startsWith(serviceName[1])) 
                {
                    //Runtime.getRuntime().exec(KILL + serviceName[1]);
                    Runtime.getRuntime().exec("taskkill /F /IM node.exe");
                    System.out.println(serviceName+" killed successfully!");
                }
            }
			/*
			String[] serviceName={"node" ,"adb"};
			// command used to get list of running task
			String TASKLIST = "tasklist";
			// command used to kill a task
			String KILL = "taskkill /IM ";


			Process pro = Runtime.getRuntime().exec(TASKLIST);
			BufferedReader reader = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			String line;

			while((line = reader.readLine()) != null) 
			{

				// System.out.println(line);
				if (line.startsWith(serviceName[0]) ||line.startsWith(serviceName[1])) 
				{
					Runtime.getRuntime().exec(KILL + serviceName[0]);
					System.out.println(serviceName+" killed successfully!");
				}
				if (line.startsWith(serviceName[1])) 
				{
					Runtime.getRuntime().exec(KILL + serviceName[1]);
					System.out.println(serviceName+" killed successfully!");
				}
			}
*/

		}
		else 
		{

			Runtime runtime = Runtime.getRuntime();
			try {
				//runtime.exec("taskkill /F /IM node.exe");
				Runtime.getRuntime().exec(
						new String[] { "bash", "-c", "killall node" });
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static String getPort() throws Exception {

		ServerSocket socket = new ServerSocket(0);
		socket.setReuseAddress(true);
		String port = Integer.toString(socket.getLocalPort());
		socket.close();
		return port;

	}

}
