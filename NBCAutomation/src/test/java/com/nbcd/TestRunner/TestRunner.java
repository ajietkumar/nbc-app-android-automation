package com.nbcd.TestRunner;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import com.nbcd.GenericLib.DatabaseFunction;

public class TestRunner
{
	public Hashtable<String, String> htTestRunner;
	public List<String> lstBrowser,lstExecutionType,lstBrowserVersion,lstOS,lstOSVersion;


	@Test
	
	public void tRun()
	{

		try
    	{
			
			DatabaseFunction objDBF= new DatabaseFunction();
			lstExecutionType = objDBF.getTestDataObject("Select Distinct(ExecutionType) from TestSuite Where Execution ='Yes'","TestRunner");
			lstBrowserVersion = objDBF.getTestDataObject("Select Distinct(BrowserVersion) from TestSuite Where Execution ='Yes'","TestRunner");
			lstOS = objDBF.getTestDataObject("Select Distinct(OS) from TestSuite Where Execution ='Yes'","TestRunner");
			lstOSVersion = objDBF.getTestDataObject("Select Distinct(OSVersion) from TestSuite Where Execution ='Yes'","TestRunner");

		/*	lstExecutionType = objDBF.fnExecuteSql("Select Distinct(ExecutionType) from TestSuite Where Execution ='Yes'","TestRunner","ExecutionType");
			lstBrowserVersion = objDBF.fnExecuteSql("Select Distinct(BrowserVersion) from TestSuite Where Execution ='Yes'","TestRunner","BrowserVersion");
			lstOS = objDBF.fnExecuteSql("Select Distinct(OS) from TestSuite Where Execution ='Yes'","TestRunner","OS");
			lstOSVersion = objDBF.fnExecuteSql("Select Distinct(OSVersion) from TestSuite Where Execution ='Yes'","TestRunner","OSVersion");*/
			htTestRunner=objDBF.getHashTestData("Select * from TestSuite Where Execution ='Yes'","TestRunner");
			
    	}
		catch(Exception exc)
		{
			System.out.println("Exception in TestRunner:"+ exc.getMessage());
		}
		
		/*if(lstBrowser.get(0).compareToIgnoreCase("Remote")!= 0)
		{*/
		
					TestNG myTestNG = new TestNG();  //Create an instance on TestNG
					myTestNG.setParallel("tests");
					myTestNG.setSuiteThreadPoolSize(1);
					XmlSuite mySuite = new XmlSuite(); //Create an instance of XML Suite and assign a name for it.
					mySuite.setName("NBCAutomation");
					mySuite.setParallel(XmlSuite.ParallelMode.CLASSES);
					mySuite.setThreadCount(1);
					XmlTest myTest = new XmlTest(mySuite); //Create an instance of XmlTest and assign a name for it.
					myTest.setName("NBCAutomation");			
					List<XmlClass> myClasses = new ArrayList<XmlClass> ();
				 	Set set = htTestRunner.entrySet();
				    Iterator intIterator = set.iterator();
				    while (intIterator.hasNext()) 
				    {
					      Map.Entry entry = (Map.Entry) intIterator.next();
					   
					      myClasses.add(new XmlClass((String) entry.getKey()));
					      
					      myTest.setXmlClasses(myClasses); //Assign that to the XmlTest Object created earlier.
				
					     myTest.addParameter("environment", (String) lstExecutionType.get(0)); //Execution Type
					     myTest.addParameter("browser", (String) entry.getValue()); //Add any parameters that you want to set to the Test.
					     myTest.addParameter("version", (String)lstBrowserVersion.get(0)); //Add any parameters that you want to set to the Test.
					     myTest.addParameter("os", (String)lstOS.get(0)); //Add any parameters that you want to set to the Test.
					     myTest.addParameter("osversion", (String) lstOSVersion.get(0)); //Add any parameters that you want to set to the Test.
				
				    } 
				    List<XmlTest> myTests = new ArrayList<XmlTest>();//Create a list of XmlTests and add the Xmltest you created earlier to it.
					myTests.add(myTest);
					mySuite.setTests(myTests); //add the list of tests to your Suite.
					List<XmlSuite> mySuites = new ArrayList<XmlSuite>();//Add the suite to the list of suites.
					mySuites.add(mySuite);
					myTestNG.setXmlSuites(mySuites);

					System.out.println(mySuites);
					myTestNG.run(); //invoke run() - this will run your class.
		
			//}
		//For Parallel Execution
		
		}

}