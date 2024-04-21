package com.example.ndsuassignment21

import android.content.Intent
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SdkSuppress
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.Until
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

private const val BASIC_SAMPLE_PACKAGE = "com.example.ndsuassignment21"
private const val LAUNCH_TIMEOUT = 5000L

@RunWith(AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = 18)
class UIAutomaterTest {

    private lateinit var device : UiDevice
    @Before
    fun launchAppFromHomeScreen() {
        // Launch the app
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        device.pressHome()

        val launcherPackage: String = device.launcherPackageName
        assertThat(launcherPackage, notNullValue())
        device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT)

        // Launch the app
        val context = InstrumentationRegistry.getInstrumentation().context
        val intent = context.packageManager.getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE)?.apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)  // Clear out any previous instances
        }
        context.startActivity(intent)

        // Wait for the app to appear
        device.wait(
            Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
            LAUNCH_TIMEOUT
        )
    }

    @Test
    fun testExplicitActivity() {
        val buttonSelector = By.clazz("android.widget.Button").hasDescendant(By.text("Start Activity Explicitly"))
        val ExplicitButton: UiObject2? = device.wait(Until.findObject(buttonSelector), LAUNCH_TIMEOUT)

        ExplicitButton?.click()

        // ensure that text for this activity exists
        val textSelector = By.clazz("android.widget.TextView").hasDescendant(By.text("Different OS versions"))
        val textView: UiObject2? = device.wait(Until.findObject(textSelector), LAUNCH_TIMEOUT)
        if (textView != null) {
            assert(true)
        } else {
            assert(false)
        }
    }
}