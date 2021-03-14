# technical assignment

to run the project just

```
./gradlew bootrun
```

then in your browser to go
http://localhost:8080/swagger-ui.html

## project considerations
* the csv files are loaded when the system starts
* is not possible to add, delete or change any data
* it sorts the restaurants at load time this means all search runs in worst-case at Θ(n)
* it uses the pattern [Chain of Responsibility](https://refactoring.guru/design-patterns/chain-of-responsibility) to [handles](src/main/kotlin/me/impressione/restaurant/hander) the criteria search 

## things to do
* unit tests
* tests e2e
* user interface

