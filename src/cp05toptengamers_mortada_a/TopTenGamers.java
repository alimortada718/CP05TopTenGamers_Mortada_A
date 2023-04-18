/*
 * Author: Ali Mortada
 * Keene State College Computer Science
 * Date:3/31/2023
 * Purpose: Use a class based on linked lists--use a Doubly Linked List for this assignment. 
The class should have a constructor that sets up an empty list, and a void insert(String name, int score)
method that adds a name and a score pair to the list. The insert method puts the entry in the proper position 
so that the list stays sorted by score. The list should have a maximum size of 10. After the list has 10 elements,
an attempt to add a name with a score that is less than or equal to the minimum score on the list is ignored,
and adding a score that is greater than the minimum score causes an entry with the minimum score to be dropped from the list.



pseudo
1. Check if the score is less than or equal to the minimum score in the list and the list is already full. If true, return without inserting.
2. Create a new Entry object with the given name and score.
3. If the size of the list is zero
   Set the first and last pointers to the new Entry object.
   Set the minimum score to the score of the new Entry object.
    Increment the size of the list by 1.
4. Initialize a pointer variable to the first entry in the list.
While the pointer is not null and the score of the current entry is greater than or equal to the score of the new Entry object
Move the pointer to the next entry.
 */
package cp05toptengamers_mortada_a;

/**
 *
 * @author Ali Mortada
 */
public class TopTenGamers 
{
    //define the maximum size of the list
    private static final int Max_Size = 10;
 
    private class Entry 
    {
        String name;
        int score;
        Entry previous, next;
        //constructor
        Entry(String name, int score) {
            this.name = name;
            this.score = score;
            previous = next = null;
        }
    }
    //instance variables
    private Entry first, last;
    private int size;
    private int minScore;
   // constructor to create new list 
    public TopTenGamers() {
        first = null;
        last = null;
        size = 0;
        minScore = 0;
    }
    
    public void insert(String name, int score)
    {
        if (score <= minScore && size == Max_Size)
        {
            return;
        }
        
        Entry newEntry = new Entry(name, score);
        if (size == 0) 
        {
            first = last = newEntry;
            minScore = score;
            size++;
        } else 
        {
            Entry Currententry = first;
            while (Currententry != null && Currententry.score >= score) 
            {
                Currententry = Currententry.next;
            }
            if (Currententry == null) 
            {
                // Insert at the end
                newEntry.previous = last;
                last.next = newEntry;
                last = newEntry;
            } else if (Currententry == first)
            {
                // Insert at the beginning
                newEntry.next = first;
                first.previous = newEntry;
                first = newEntry;
            } else
            {
                // Insert in the middle
                newEntry.previous = Currententry.previous;
                Currententry.next = Currententry;
                Currententry.previous.next = newEntry;
                Currententry.previous = newEntry;
            }
            if (size < Max_Size) 
            {
                size++;
            } else 
            {
                last = last.previous;
                last.next = null;
            }
            minScore = last.score;
        }
    }
    
    @Override
    public String toString() 
    {
        String output = "";
        Entry current = first;
        while (current != null) {
            output += current.name + "\t" + current.score + "\n";
            current = current.next;
        }
        return output;
    }
}