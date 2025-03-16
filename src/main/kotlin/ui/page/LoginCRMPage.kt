package OSA.ui.page

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import org.openqa.selenium.By

class LoginCRMPage {

    private val usernameField = "input[name='username']"
    private val passwordField = "input[name='password']"
    private val submitButton = "button[type='submit']"

//    private val usernameField2: By = By.name("username")
//    private val passwordField: By = By.name("password")
//    private val submitButton = By.name("submit")

    fun setUsername(username: String) {
        `$`(usernameField).value = username
    }

    fun setPassword(password: String) {
        `$`(passwordField).setValue(password)
    }

    fun clicksubmitButton() {
        `$`(submitButton).shouldBe(Condition.enabled).click()
    }
}