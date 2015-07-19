# ImagePlay
Spring Project to search Images on Flicker and get tag from Imagga



endpoint     /photos

params :   
           search = "AnySearchString"  default vaule is house
           numOfImages= Maximum number of images you want     default vaule is 2
           minConfidence= Minimum confidence allowed (confidence is given Imagga when they tag) default vaule is 50


sample api hit  :    
http://localhost:8080/photos/?search=home&numOfImages=1&minConfidence=10


sample response 


{
data: 
[
{
url: "https://farm4.static.flickr.com/3786/19611789990_e3f31c162b_h.jpg",
tags: 
[
"design",
"graphic",
"icon",
"symbol",
"business",
"set",
"sign",
"element",
"black",
"space",
"shape",
"pattern",
"text",
"modern",
"color",
"paper",
"art",
"card",
"frame",
"light",
"decorative",
"internet",
"copy",
"finance",
"round",
"circle",
"web",
"copyspace",
"backdrop",
"computer",
"3d",
"colors",
"empty",
"curve",
"company",
"icons",
"digital"
]
}
],
errorMessage: "Success",
errorCode: 0,
success: true
}


ps: Replace Strings FLICKER_KEY,FLICKER_KEY,IMAGGA_KEY_SECRET_BASE64 before use.

