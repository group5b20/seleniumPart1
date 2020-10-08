package com.cybertek.bitrix.sergi;

import com.cybertek.bitrix.config.pages.BitrixLoginPage;
import com.cybertek.bitrix.config.pages.BitrixStreamPage;
import com.cybertek.bitrix.config.verifications.BitrixVerifications;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.annotations.Test;

public class BitrixTests1 {

    BitrixLoginPage loginBitrix = new BitrixLoginPage();
    BitrixVerifications verification = new BitrixVerifications();
    BitrixStreamPage streamPage = new BitrixStreamPage();

    @Test
    public void Verify_editor_textBar_is_displayed() {
        Driver.getDriver().get(ConfigurationReader.getProperty("BitrixUrl"));
        loginBitrix.login();
        streamPage.goToEventTab();
        verification.verify_editor_textBar_is_displayed();
        Driver.closeDriver();
    }
}
