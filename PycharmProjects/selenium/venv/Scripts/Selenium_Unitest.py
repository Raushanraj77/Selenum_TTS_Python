import unittest
from selenium import webdriver
from selenium.webdriver.common.keys import Keys


class PythonOrgSearch(unittest.TestCase):

    def setUp(self):
        self.driver = webdriver.Chrome()

    def test_search_in_python_org(self):
        driver = self.driver
        driver.get("http://www.google.lk")
        self.assertIn("Google", driver.title)
        elem = driver.find_element_by_name("q")
        elem.send_keys("Python")
        elem.send_keys(Keys.RETURN)

    def tearDown(self):
        self.driver.close()


if __name__ == "__main__":
    unittest.main()