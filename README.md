# Android-Interview-Test

XKCD Comic API- https://xkcd.com/json.html

Current comic can be obtained from- https://xkcd.com/info.0.json

For the first task, we will make a network call to get current comic and display the title, alt, and image (load with glide library) in the comic details fragment screen. ConstraintLayout plus points!

Example comic looks like below. 
{
  "month": "3", 
  "num": 2437, 
  "link": "", 
  "year": "2021", 
  "news": "", 
  "safe_title": "Post-Vaccine Party", 
  "transcript": "", 
  "alt": "[Future update] Well, someone accidentally dropped an M&M in their cup of ice water, and we all panicked and scattered.", 
  "img": "https://imgs.xkcd.com/comics/post_vaccine_party.png", 
  "title": "Post-Vaccine Party",
  "day": "15"
}

retrofit, ok-http, moshi with kotlin for serialization-deserialization is already set up and injected.
lets define the endpoint using retrofit in ComicService and start from there.

![Screenshot_1616010306](https://user-images.githubusercontent.com/51245997/111528686-d74c8780-8737-11eb-879f-e803d684d5ba.png)




