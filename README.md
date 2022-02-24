# Assignment_Database
[![web](https://img.shields.io/static/v1?logo=heroku&message=Online&label=Heroku&color=430098)](https://chinook-assignment-database.herokuapp.com/home)

This assignment was seperated into two parts:
1. Get customer information from the database. Make API Endpoints within Postman
   1. The SQL queries can be found in the Customer Repository (Data Access map)
   2. The API Endpoints can be found under resources --> Assignment_Database_Postman_Collection.json
2. Display 5 random artists, songs, genres and make a search function for track names.
   1. These can be found deployed on Heroku.

Java, Spring Framework, SQL and Thymeleaf was used. These were mandatory for the assignment.


## How To Use
To use the Thymeleaf part you can go to: https://chinook-assignment-database.herokuapp.com/home
Here you can search tracks within the database.

To make use of the API Endpoints load the Postman Collection into Postman.
Here you can play around with changing and getting information from the database.

If you want to run locally go to the DataAccess Map --> ConnectionHelper and change the ConnectionURL to: **jdbc:sqlite:src/main/resources/Chinook_Sqlite.sqlite**
## Future Work
Future work may include:
- exposing customer data with Thymeleaf
- changing spending float points to max 2 float points
- UI Changes
- If a track can not be found: show a warning message

## Built With
[IntelliJ IDEA](https://www.jetbrains.com/idea/)

[Spring Framework](https://spring.io/)

[Thymeleaf](https://www.thymeleaf.org/)

[Chinook Database](https://www.sqlitetutorial.net/sqlite-sample-database/)

## Credits
[Richie Schuurman](https://github.com/RichieSchuurman)

[Savannah Borst](https://github.com/savannah-borst)

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License
[MIT](https://choosealicense.com/licenses/mit/)
