package com.bryhas.project.mailrutest.tools;

import org.openqa.selenium.WebDriver;

/**
 * Author: Andrii Bryhas
 * Date: 10.06.15
 */

public interface IBrowser {

	WebDriver getWebDriver();

	String getWebDriverName();

	void quit();

}
