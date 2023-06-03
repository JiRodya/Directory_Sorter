import java.util.Comparator;

/**
 * Title:       DirectoryComparator
 * Semester:    COP3337-Summer2022
 * @author:     Dianelys Rocha
 * PantherID:   6272943
 *
 * I affirm that this program is entirely my own work.
 * Nothing, but the classes/methods given by the professor,
 * is the work of any other person.
 *
 * This class overrides the compare method inside Comparator.
 * It is used in order to compare the name of to files the way it
 * would make sense for a human being, when the name has numbers
 * on it.
 * example: dir2 would come before dir10
 */


public class DirectoryComparator implements Comparator<String> {

  @Override
  /**
   * @param dirA 1st directory to compare
   * @param dirB 2nd directory to compare
   */
    public int compare(String dirA, String dirB){
        int compareValue;  // will hold the result of the corresponding compareTo() method

        String subStringA, //String part of dirA
               subStringB; //String part of dirB

        int subIntA, //number part of dirA
            subIntB; //number part of dirB

        subStringA = dirA.substring(0, findIntIndex(dirA));
        subStringB = dirB.substring(0,findIntIndex(dirB));

        subIntA = Integer.parseInt(dirA.substring(findIntIndex(dirA)));
        subIntB = Integer.parseInt(dirB.substring(findIntIndex(dirB)));


        //compare the string part
        if(subStringA.equalsIgnoreCase(subStringB)){
            //if string part is equal, compare number part, and store value
            compareValue = Integer.compare(subIntA, subIntB);
        }
        else{
             //if string part is not equal, store value of compareTo for the String part
            compareValue= subStringA.compareToIgnoreCase(subStringB);
        }

        return compareValue;
    }

    /**
     * @param dirName name of the directory
     * @return index at which the directory name changes to numbers
     */
    public int findIntIndex(String dirName){
        int index=0;
        boolean allowEntry = true;
        char currentChar;

        for(int i =0; i < dirName.length();i++){
            currentChar=dirName.charAt(i);
            if(Character.isDigit(currentChar)&& allowEntry){
                index=i;
                allowEntry=false;
            }
        }
        return index;
    }
}
