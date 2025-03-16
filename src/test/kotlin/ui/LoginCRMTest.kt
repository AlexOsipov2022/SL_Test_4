package ui

import OSA.ui.page.LoginCRMPage
import com.codeborne.selenide.Condition.*
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

object TestProperties {
    const val LOGIN = "test.user.login"
    const val PASSWORD = "test.user.password"
}

class LoginCRMTest {

    val BASE_URL: String = "https://kz-solva-release-300.kz.idfaws.com/secure/new-admin/index.html#/login"
//    val BASE_URL: String = "https://solva-bank-release.kz.idfaws.com/secure/new-admin/index.html#/login"
    //    private val BASE_URL: String = "https://kz-solva-release-slkz-91712.kz.idfaws.com/secure/new-admin/index.html#/login"
    val textTitle = `$`("h2.indexTitle")
    val textLoans = `$`("li.ng-binding")

    @BeforeEach
    fun setUp() {
        // Устанавливаем системные свойства (если не переданы в командной строке)
        System.setProperty(TestProperties.LOGIN, System.getProperty(TestProperties.LOGIN, "admmin"))
        System.setProperty(TestProperties.PASSWORD, System.getProperty(TestProperties.PASSWORD, "nimda2012"))

        Configuration.browser = "chrome"
        Configuration.timeout = 10000
    }

    @Test
    fun `user should be able to login with system properties`() {
        open(BASE_URL)

        val login = System.getProperty(TestProperties.LOGIN)
        val password = System.getProperty(TestProperties.PASSWORD)
        val loginPage = LoginCRMPage()

        loginPage.setUsername(login)
        loginPage.setPassword(password)
        loginPage.clicksubmitButton()

        Assertions.assertTrue(textLoans.text().contains("Займы"), "Текст элемента не содержит 'Займы'")

        // Вводим логин и пароль
        `$`("#username").setValue(login)
        `$`("#password").setValue(password)
        `$`("#login-button").click()

        // Проверяем, что вход успешен (например, появился профиль пользователя)
        `$`("#profile").shouldBe(visible)
    }

    @AfterEach
    fun tearDown() {
        closeWebDriver() // Закрываем браузер
        System.clearProperty(TestProperties.LOGIN)
        System.clearProperty(TestProperties.PASSWORD)
    }
}