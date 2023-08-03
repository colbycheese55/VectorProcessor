# VectorProcessor3
## Background
This project was created throughout my senior year of high school when I was learning Java in AP Computer Science A. Throughout its creation it changed many times; for example, after I learned arrays, I used an array to represent the cartesian components of a vector, which replaced using a single String where each component was comma separated. The motivation behind this project was to solve non-calculus-based physics problems that were common in an engineering class I was taking. 

The code was then rewritten into its current form, after I decided to update and improve it using the Java skills I now possess. The original code (VectorProcessor2) is under the legacy branch. The current version creates a more standardized user experience across operations, its code is infinitely more readable, and errors from user input are handled.  

## Installation
  First, install JAVA [(here)](https://www.java.com/en/download/)

**EXE Method (recommended, windows only)** <br>
Download the `.exe` file from the current release <br>
Run the `.exe` file

**JAR Method** <br>
Download the `.jar` file from the current release <br>
Open the terminal and type `java -jar <filepath of the file>`
  - Example: `java -jar C:\Users\user\Desktop\VectorProcessor_v3.0.jar`

The program does not 'install' or save any other files, nor does it access the internet.

## How to use
1. Upon startup the user will be prompted to choose which operation they wish to conduct (vector converting, adding, cross product, dot product); enter the integer in the parentheses of the prompt to choose that operation. 
2. Follow the prompts and enter the vector(s) in the formats shown in 'Vector Formats'. 
  - If an entry is invalid, an error will be printed and the entry will be treated as a 0 / null vector, and the program will continue. This is especially helpful for the 'adder' function.
3. The operation will then be conducted, and the result will be printed in multiple formats. 
4. The user is then given a choice to conduct another operation, or to stop by entering `5` 
  - If using the EXE method, entering `5` will also close the window.

## Vector Formats
**Vectors should be entered in the format:** `<Format Code> <Value 1>, <Value 2>, <Value 3, sometimes optional>, <Value 4, always optional>` <br>
**Example:** `cart 5,10,15`

**Accepted Formats**:
- Cartesian (format code is `cart`)
  - `Values 1,2,3` are X, Y, and Z components respectively; Z is optional, and will be assumed to be 0 if not included
- Absolute Polar (format code is `ap`)
  - `Value 1` is magnitude
  - `Value 2` is _theta_ (counterclockwise angle off of the positive X axis, only in the XY plane)
  - `Value 3` is _phi_ (angle between the XY plane and the vector, below the XY plane is negative, range is [-90,90]); optional, will be assumed to be 0 if not included
- Relative Polar (format code is `rp`)
  - `Value 1` is magnitude
  - `Values 2,3,4` are _theta_ X, Y, and Z (angle between the respective axis and the vector, valid range is [0,180]); _theta_ Z is optional, will be assumed to be 90 if not included
- Unit Vector (format code is `unit`)
  - `Value 1` is magnitude
  - `Values 2,3,4` are the X, Y, and Z components of the unit vector (valid range is [0,1], and the combined magnitude must be 1) Z is optional, will be assumed to be 0 if not included
- Directional Unit Vector (format code is `dir`)
  - `Value 1` is magnitude
  - `Values 2,3,4` are the X, Y, and Z directions the vector is measured on. Z is optional, and will be assumed to be 0 if not included

**Additional Entry Guidelines:**
- all angles are assumed to be in degrees
- separate the vector code from the numerical components by at least 1 space
- any number of spaces, or none at all, can be put between commas

## License to Reuse
This source code and any releases may be used for any non-commercial purposes. Please contact me before using the source code, as I'm interested to know where my code travels.
