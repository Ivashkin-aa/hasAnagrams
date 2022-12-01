# hasAnagrams
For a given list of words, determine whether it contains anagrams (two words are anagrams if one can be composed from the second)

## Use case

HTTP POST request with key <words> and value <**your string** (delimiter '_') >
``` 
http://0.0.0.0:8080/compare?words=tac_light_cat
```

## To run app
To build and tag the Docker image:
``` console
docker build -t has-anagrams
```
To start the image:
``` console
docker run -p 8080:8080 has-anagrams
```
