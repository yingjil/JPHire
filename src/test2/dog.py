import requests
from io import BytesIO
from flask import Flask
import random
from flask import send_file
import time
text = requests.get("http://image-net.org/api/text/imagenet.synset.geturls?wnid=n02111277").text
urls = text.split('\r\n')
app = Flask(__name__)
random.seed(time.time())
@app.route("/image", methods=['GET'])
def image():
    while True:
        url = urls[random.randint(0, len(urls) - 1)]
        image_download = requests.get(url)
        if image_download.status_code!=200:
            continue
        break
    image_file = BytesIO(image_download.content)
    image_file.seek(0)
    response = send_file(image_file,mimetype='image/jpg')
    return response
app.run()