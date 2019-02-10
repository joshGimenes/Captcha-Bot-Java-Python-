import pytesseract
import pyscreenshot as ImageGrab
import pyautogui
import time
from PIL import Image
import re
import pyperclip





if __name__ == '__main__':


    def imageToText (pathToImage):

        pytesseract.pytesseract.tesseract_cmd = 'C:\\Program Files (x86)\\Tesseract-OCR\\tesseract'
        textFromImage = (pytesseract.image_to_string(Image.open(pathToImage)))
        return textFromImage



print(imageToText("C:\\Users\\harry\\Desktop\\Captcha5.png"))
