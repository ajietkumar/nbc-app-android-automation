package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGAppShowVideoDetails;
import com.nbcd.Pages.PGVideoPlayerPage;

public class TCAndroid_Vod_Error_messages_Live_VOD_NAF_3554 extends GetWebDriverInstance
{
	
	@Test(groups="PGVideoPlayerPage")
	
	 public void anroid_ErrorMessagesLive_VOD_NAF_3554() throws Exception 
	 {

		PGVideoPlayerPage objHP = new PGVideoPlayerPage(driver);
		
		objHP.anroid_Error_messages_Live_VOD_NAF_3554();
		
		
		
	 }
} 