public class Die1 {
        private int numSides; // The number of sides on the die
        private int value;    // The number on the die when it is rolled

        // Default constructor: sets numSides to 6 and value to 1
        public Die1() {
            this.numSides = 6;
            this.value = 1;
        }

        // Constructor with numSides argument
        public Die1(int numSides) {
            this.numSides = numSides;
            this.value = 1;
        }

        // Getter for numSides
        public int getNumSides() {
            return numSides;
        }

        // Setter for numSides
        public void setNumSides(int numSides) {
            this.numSides = numSides;
        }

        // Getter for value
        public int getValue() {
            return value;
        }

        // Setter for value
        public void setValue(int value) {
            this.value = value;
        }

        // Override toString method to return a string with all data members
        @Override
        public String toString() {
            return "Die with " + numSides + " sides, rolled value: " + value;
        }

        // Method to roll the die and assign a random value
        public void roll() {
            // Generate a random number between 1 and numSides (inclusive)
            this.value = (int) (Math.random() * numSides) + 1;
        }
}
