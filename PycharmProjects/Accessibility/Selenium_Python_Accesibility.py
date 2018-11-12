from selenium import webdriver
from axe_selenium_python import Axe
import unittest
import json
class test_accessibility(unittest.TestCase):
    with open('C:/Users/kam/PycharmProjects/Accessibility/URLEntries.json', encoding='utf-8') as data_file:
        data = json.loads(data_file.read())

        driver = webdriver.Chrome()

        for i in data['urls']:
            driver.get(i["url"])
            axe = Axe(driver)
            # Inject axe-core javascript into page.
            axe.inject()
            # Run axe accessibility checks.
            results = axe.run()
            # Write results to file

            axe.write_results(results, i["file"])
        driver.close()

    if __name__ == "__main__":
        unittest.main()
