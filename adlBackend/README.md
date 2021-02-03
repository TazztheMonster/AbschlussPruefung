# AbschlussPruefung

# Interfaces

GET: `/adl-api/v1/cars/{vin}`

    responses:
     - 200: successful (contains the carData objekt of given vin)
     - 404: vin not found
     - 500: server error
     
POST: `/adl-api/v1/cars`

    responses:
     - 201: successful
     - 409: invalid data
     - 500: server error
     
You can find the full swagger documentation at `/swagger-ui.html`
