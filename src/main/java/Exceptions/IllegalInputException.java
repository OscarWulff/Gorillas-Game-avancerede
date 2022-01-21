/* s.nr. 214925 Rasmus Søndergaard */
package Exceptions;

public class IllegalInputException extends Exception {
    public IllegalInputException(String errorMessage) {
        super(errorMessage);
    }
}