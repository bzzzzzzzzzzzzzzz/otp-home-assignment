# Taxi API
 
## Classes

### Trip
Stores the trip's parameters, the number of passengers and the distance.

### Vehicle
Stores the vehicles ID, passenger capacity, range and fuel type.

### VehicleController
This class manages the HTTP requests.
+ **public List<Vehicle> getVehicles()**:
   GET request. Returns every vehicle in the database.
+ **public ResponseEntity<Vehicle> addVehicle(Vehicle vehicle)**:
   POST request. Tries to add a new vehicle to the database. Returns the result of the attempt.
+ **public Map<Integer, Float> getPossibleVehicles(Trip trip)**:
   GET request. Returns the available vehicles' IDs for the trip's parameters, the number of passengers and the distance, along with the assumed profits.

### VehicleRepository
The database can be accessed through this interface. It manages Vehicles with Integer IDs.

### VehicleService
Responsible for the communication between the repository and the controller.
+ **public List<Vehicle> getVehicles()**:
   Returns every vehicle in the database.
+ **public Vehicle addVehicle(Vehicle vehicle)**:
   Saves the vehicle to the database.
+ **public Map<Integer, Float> getPossibleVehicles(int numOfPassengers, float distance)**:
   Returns the available vehicles' IDs for the number of passengers and the distance, along with the assumed profits. Only returns the vehicles that have the capacity for the passengers and have the range for the distance.
+ **private float getProfit(Vehicle vehicle, int numOfPassengers, float distance)**:
   Returns the assumed profit for the vehicle with the given passenger number and distance. It first calculates the number of minutes travelled, then the travel fee and then substracts the cost of refueling based on the vehicles type.
