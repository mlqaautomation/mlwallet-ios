package com.iosmlwalletpages;

import org.openqa.selenium.By;

public class KPXLogin {
    public static By googleSign = By.xpath("//*[@class='nsm7Bb-HzV7m-LgbsSe-bN97Pc-sM5MNb ']");
    public static By email_google = By.xpath("//*[@type='email']");
    public static By nextBtn_google = By.xpath("//*[contains(text(), 'Next')]");
    public static By password_google = By.xpath("//*[@type='password']");
    public static By try_another_way_google = By.xpath("//span[contains(text(), 'Try another way')]");
    public static By enter_back_up_codes_google = By.xpath("//*[contains(text(), 'Enter one of your 8-digit backup codes')]");
    public static By input_back_up_codes_google = By.xpath("//*[@type= 'tel']");

    public static By LoginText = By.xpath("//*[contains(text(), 'Login')][1]");
}
