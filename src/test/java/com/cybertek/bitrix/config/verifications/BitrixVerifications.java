package com.cybertek.bitrix.config.verifications;

import com.cybertek.bitrix.config.pages.BitrixStreamPage;
import com.cybertek.utilities.Driver;
import org.junit.Assert;

public class BitrixVerifications {

    BitrixStreamPage streamPage = new BitrixStreamPage();

    public void verify_editor_textBar_is_displayed(){
        Driver.pageLoadTimeout();
        boolean elem = Driver.getDriver().findElement(streamPage.editorTextBar).isDisplayed();
        Assert.assertTrue(elem);
    }
}
