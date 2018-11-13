from Pages.HomePage import Home
from Pages.RegistrationPage import Register
import Utility.TextSpeechReporting
import unittest
import json
from selenium import webdriver
import pytest
import allure

class RegistrationTest(unittest.TestCase):
    @allure.story('Test Automation Solution - Kushan Amarasiri')
    @allure.feature('Test - Auomation Framework in Python')
    @allure.testcase("Registration Test Case")
    def setUp(self):
        with pytest.allure.step("Launch site"):
         self.driver = webdriver.Chrome()

    def test_search_in_python_org(self):

        with open('C:/Users/kam/PycharmProjects/SeleniumPageObjectModel/Data/data.json', encoding='utf-8') as data_file:
            data = json.loads(data_file.read())
        driver = self.driver

        driver.get("http://newtours.demoaut.com/")
        Utility.TextSpeechReporting.speechReporting("Navigated to site new tours")
        driver.set_page_load_timeout(20)
        m = Home(driver)
        m.getRegister().click()
        Utility.TextSpeechReporting.speechReporting("Navigated to Register Page")
        r = Register(driver)
        r.setFirstName(data["userdata"]["newuser"]["firstname"])
        r.setLastName(data["userdata"]["newuser"]["lastname"])
        r.setPhone(data["userdata"]["newuser"]["mobileno"])
        r.setCountry(data["userdata"]["newuser"]["country"])
        r.setEmail(data["userdata"]["newuser"]["emailid"])
        r.setUserName(data["userdata"]["newuser"]["username"])
        r.setPassword(data["userdata"]["newuser"]["password"])
        r.setConfirmPassword(data["userdata"]["newuser"]["password"])
        r.submit
        if __name__ == "__main__":
            unittest.main()

