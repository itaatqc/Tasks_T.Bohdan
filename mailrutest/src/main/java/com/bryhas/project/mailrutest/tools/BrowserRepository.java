package com.bryhas.project.mailrutest.tools;

/**
 * Author: Andrii Bryhas
 * Date: 10.06.15
 */

public class BrowserRepository {

	public static IBrowser getFirefoxByTemporaryProfile() {
		return new FirefoxBrowser();
	}
	
}
