# VectorProcessor2
This project was created throughout my senior year of high school when I was learning Java in AP Computer Science A. Throughout its creation it changed many times; for example, after I learned arrays, I used an array to represent the cartesian components of a vector, which replaced using a single String where each component was comma separated. The motivation behind this project was to solve non-calculus-based physics problems that were common in an engineering class I was taking. 

The ”vector_converter3D” can only convert between different vector formats, but also serves as the framework for the other programs. The “vector_adder3D” can endlessly add vectors, and subtract by entering a negative vector. The “dotcross_calc” program calculates the dot product, the cross product, and the angle between two vectors. There was originally a 2D version for the vector adder and converter, but this became redundant one I created the 3D versions; 2D native support does exist for most vector formats. 




Supported Vector Formats and Other Notes:

- note: for 2D vectors enter [magnitude z] [e z] [distance z] and [phi] as 0, enter [theta z] as 90

- Polar Coordinates: [magnitude], [theta x], [theta y], [theta z] ::: ex. 100, 120, 30, 90

- Cartesian Coordinates: [magnitude x]i + [magnitude y]j + [magnitude z]k ::: ex. 100i+200j+-300k

  -- note: even if it means typing "+-" you must separate values by a plus sign

- Unit Vector: [magnitude]e where e=[e x]i+[e y]j+[e z]k ::: ex. 200e where e=0.6i+0.5j+0.3k

  -- note: even if it means typing "+-" you must separate values by a plus sign

- Theta and Phi: [magnitude], [theta], [phi] ::: ex. 100, 45, 10

- Directional unit vector: [magnitude]; [distance x]; [distance y]; [distance z] ::: ex. 100; 10; -5; 2

- note: all vectors must originate from the same point

- always run the main() method, rather than an individual method
