class EmptyListException extends Exception
{
      // Parameterless Constructor
      public EmptyListException() {}

      // Constructor that accepts a message
      public EmptyListException(String message)
      {
         super(message);
      }
 }