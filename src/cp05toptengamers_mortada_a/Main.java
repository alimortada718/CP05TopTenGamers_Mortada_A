/*
 *  Application Title:
 * Author: Ali Mortada
 * Keene State College Computer Science
 * Date:
 * Purpose:
 */
package cp05toptengamers_mortada_a;

/**
 *
 * @author Ali Mortada
 */
public class Main 
{
    public static void main(String[] args) 
    {
        TopTenGamers TopTen = new TopTenGamers();
        TopTen.insert("Spike",120);
        TopTen.insert("Whiz",105);
        TopTen.insert("G-Man",99);
        TopTen.insert("JediMaster",95);
        TopTen.insert("dabomb",150);
        TopTen.insert("Trinity", 130);
        TopTen.insert("minnie", 110);
        TopTen.insert("lol", 100);
        TopTen.insert("Cypher", 90);
        TopTen.insert("MickeyMouse", 80);
        TopTen.insert("BullDozer", 70);
        TopTen.insert("Tank", 95); 
        System.out.println(TopTen);
    }
}
