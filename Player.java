public class Player {
        private String name; // The name of the player
        private Die1 die;     // A Die object that the player will roll

        // Constructor to initialize the player's name and their die
        public Player(String name, Die1 die) {
            this.name = name;
            this.die = die;
        }

        // Getter for the player's name
        public String getName() {
            return name;
        }

        // Setter for the player's name
        public void setName(String name) {
            this.name = name;
        }

        // Getter for the player's die
        public Die1 getDie() {
            return die;
        }

        // Setter for the player's die
        public void setDie(Die1 die) {
            this.die = die;
        }

        // Override toString method to return player's name
        @Override
        public String toString() {
            return "Player: " + name;
        }
}
