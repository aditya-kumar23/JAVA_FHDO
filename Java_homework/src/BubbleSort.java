public class BubbleSort {
        public static void main(String[] args) {
            String text = "To be or not to be, that is the question;"
                        + "Whether `tis nobler in the mind to suffer"
                        + " the slings and arrows of outrageous fortune,"
                        + " or to take arms against a sea of troubles,"
                        + " and by opposing end them?";
    
            // Define 'words' as sequences of letters and apostrophes
            String[] words = text.split("[^a-zA-Z']+");
    
            // Convert words to lowercase for case-insensitive sorting
            for (int i = 0; i < words.length; i++) {
                words[i] = words[i].toLowerCase();
            }
    
            // Bubble sort to sort the words in alphabetical order
            int n = words.length;
            boolean swapped;
            do {
                swapped = false;
                for (int i = 0; i < n - 1; i++) {
                    if (words[i].compareTo(words[i + 1]) > 0) {
                        // Swap words[i] and words[i + 1]
                        String temp = words[i];
                        words[i] = words[i + 1];
                        words[i + 1] = temp;
                        swapped = true;
                    }
                }
                n--;
            } while (swapped);
    
            // Print the sorted words
            for (String word : words) {
                System.out.println(word);
            }
        }
    }
