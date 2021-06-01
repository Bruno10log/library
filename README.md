
# **Reference Documentation**

For reference, please follow the next steps:

- Pull the project
- Import the project as Maven project
- Open the Terminal and go inside the project and execute the following command:

`mvn package`

- Then, create a docker image using

`docker build . --tag library`

- And run this image

`docker run -it -p8080:8080 library:latest`

# **Structure of the API**

The project has 3 main controllers:

- The BookController that manages the books and report to it
- The BookFamilyController that manages the book families and report to it
- The FtpController that manages the upload of the geports generated


# **Endpoints on POSTMAN**

- **/api/book-families - **GET** all book families
- **/api/book-families/{id} - **PUT** to update the data of the book family with the JSON example:
  {
    "name": "test update"
  }
- **/api/book-families- **POST** to insert a new data on the book family with the JSON example:
  {
    "name": "test insert"
  }
  
- **/api/books- **GET** all books
- **/api/books/{id} - **PUT** to update the data of the book with the JSON example:
  {
        "title": "Bryans Life",
        "author": "Louisa Kay",
        "family": "Fantasy"
  }
- **/api/books - **POST** to insert a new data on the book with the JSON example:
  {
        "title": "Bryans Life",
        "author": "Louisa Kay",
        "family": "Fantasy"
  }
  
- **/api/books/report - **GET** to generate a report for the books
- **/api/bookFamilies/report - **GET** to generate a report for the book families

- **/api/ftp/{fileName} - **POSt** to export the report fileName informed to the FTP configured on the application.properties file
