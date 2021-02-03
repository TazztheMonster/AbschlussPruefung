# AbschlussPruefung

# Interfaces

GET: `/adl-api/v1/cars/{vin}`

    responses:
     - 200: successful (contains the carData objekt of given vin)
     - 404: vin not found
     - 500: server error
     
GET: `/adl-api/v1/cars/{vin}/{numberOfEntries}`

    responses:
     - 200: successful (contains a List of carData objekts of given vin)
     - 404: vin not found
     - 500: server error
     
GET: `/` - This is used for the lifenes and readynes probe

    responses:
     - 200: successful
     
POST: `/adl-api/v1/cars`

    responses:
     - 201: successful
     - 409: invalid data
     - 500: server error
     
