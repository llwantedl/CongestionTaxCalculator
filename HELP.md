# Getting Started

##### How to run the project:

1) Run `CongestionTaxCalculatorApplication.java` Java Spring Boot Application
2) To test application - there are a few options:
   1) open swagger page on `http://localhost:8099/swagger-ui.html` 
   2) run Postman and execute the method in step 3
   3) run similar platform to execute RESTful calls
3) Execute `POST http://localhost:8099/api/v1/congestion-tax/calculate`. Example JSON Body can be seen in `src/test/resources/congestionTaxRequests/congestion-tax-successfull-request.json`.

##### Idea of current implementation

Database layer was mocked due to decision of focusing more on the business logic idea, instead of ORMs.

Toll fee administrator manages toll fees through UI, by adding and changing amount of taxes, when and 
where they are applied. Current implementation adds TollFeeRange interface which allows to implement classes that are
covering UI date picking scenarios. For example, we want to have a special fee for January, or January 23, or every day
from 14:30 to 15:00. All these cases are separate classes inherited from TollFeeRange interface.

Instead of implementing toll fee administrator management API, I have added an empty TollFeeRangeController to
make future intentions more clear, and put mocks of it in TollFeeRangeServiceMockImpl, which covers cases that were
specified in the models at the beginning.

Unfortunately, there was no time to add unit tests to cover all TollFee implementations, as I spent 5 hours, 
instead of 4 suggested. But I made sure that it is working as expected, and provided a guide how to run it.

##### To improve

Would be better to improve Request object for checkIns - make it aggregated by cities - to avoid adding city in each 
record