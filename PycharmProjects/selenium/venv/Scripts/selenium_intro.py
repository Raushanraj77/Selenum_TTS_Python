from selenium import webdriver
from selenium.webdriver.common.keys import Keys

driver = webdriver.Chrome()
driver.get("http://www.google.lk")
assert "Google" in driver.title
elem = driver.find_element_by_name("q")
elem.clear()
elem.send_keys("Python")
elem.send_keys(Keys.RETURN)
assert "Python - Google Search" in driver.title
driver.close()