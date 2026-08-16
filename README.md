Car Indicator Controller
Overview

The Car Indicator Controller is a Java-based simulation of a vehicle's turn-indicator control system.

The controller accepts inputs from the left indicator switch, right indicator switch, and hazard switch and generates the corresponding left and right indicator outputs.

The project demonstrates:

Digital control logic
State-machine based design
Left and right turn indicators
Hazard-light operation
Invalid simultaneous left/right input handling
Java-based testbench
Simulation output suitable for GitHub documentation
Features
Input	Description
Left switch	Activates the left indicator
Right switch	Activates the right indicator
Hazard switch	Activates both indicators
No switch	Turns indicators off

The controller follows these rules:

If the left switch is ON, the left indicator is activated.
If the right switch is ON, the right indicator is activated.
If the hazard switch is ON, both indicators are activated.
If both left and right switches are ON without hazard mode, both indicators remain OFF to avoid an invalid command.
If no switch is selected, both indicators are OFF.
Requirements
Java JDK 8 or later
Any Java IDE or command-line Java compiler
Git and GitHub
Project Structure
car-indicator-controller/
├── README.md
├── src/
│   └── CarIndicatorController.java
├── test/
│   └── CarIndicatorControllerTest.java
└── simulation/
    └── simulation_output.txt

Running the Project

Compile the controller:

javac src/CarIndicatorController.java


Run the simulation:

java -cp src CarIndicatorController


Compile the testbench:

javac -cp src test/CarIndicatorControllerTest.java


Run the testbench:

java -cp src:test CarIndicatorControllerTest


On Windows, use ; instead of : in the classpath:

java -cp src;test CarIndicatorControllerTest

Controller Logic

The controller can be represented using the following logic:

             +----------------+
 Left ------>|                |----> Left Indicator
 Right ----->|   Controller   |----> Right Indicator
 Hazard ---->|                |
             +----------------+


Priority:

Hazard ON
   |
   +----> Left = ON
   +----> Right = ON

Hazard OFF
   |
   +----> Left only  -> Left = ON
   |
   +----> Right only -> Right = ON
   |
   +----> Both       -> Both = OFF
   |
   +----> None       -> Both = OFF

Test Cases

The testbench checks the following conditions:

No switch selected
Left indicator selected
Right indicator selected
Hazard mode selected
Left and right selected simultaneously
Hazard mode with other inputs
Expected Result
Left	Right	Hazard	Left Output	Right Output
0	0	0	0	0
1	0	0	1	0
0	1	0	0	1
0	0	1	1	1
1	1	0	0	0
1	0	1	1	1
0	1	1	1	1
1	1	1	1	1
Conclusion

The project demonstrates how a simple automotive indicator-control system can be modeled using Java. The testbench verifies the controller behavior for normal turn signals, hazard operation, and invalid simultaneous turn commands.

Author

Car Indicator Controller Project

Developed as an academic Java simulation project.
