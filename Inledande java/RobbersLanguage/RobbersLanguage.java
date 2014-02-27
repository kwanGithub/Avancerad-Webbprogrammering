/**
 * Translates a text into the robber language (rövarspråket) made famous 
 * in the book about Kalle Blomkvist written by Astrid Lindgren.
 * 
 * In the robber language you duplicate all consonants and add 'o' between then. 
 * "b" becomes "bob" and "i love peace" becomes "i lolovove popeacoce".
 * 
 * @author Kevin Truong
 * @version 2013-10-06
 */
public class RobbersLanguage 
{
    private final String CONSONANTS = "bcdfghjklmnpqrstvwxz";
    
    /**
     * Takes a String and then serches through it for consonants 
     * if found it will return consonant + letter o + consonant
     *  
     * @param text is the text we want to translate
     * @return robberText returns the translated text
     */
    protected String translate(String text) 
    {
        text = text.toLowerCase();
       
        String robbersText = "";
        //itterear igenom String text lika många ggr som texten är i längd
        //Om en bokstav matchar bokstäverna i CONSONANTS så kommer det att ta denna: "bokstav + "o" + bokstaven" och lägga in den i robbestText 
        //Hittas stämmer ingen bokstav med CONSONANTS strängen så kommer bokstaven läggas in i robbesText utan något tillägg.
        //(Liknande återfinnes i distanslektion)
        for(int i = 0; i < text.length(); i ++) 
        {
            if(CONSONANTS.indexOf(text.charAt(i)) >= 0)
            {
                robbersText += text.charAt(i) + "o" + text.charAt(i);
            }
            else
            {
                robbersText += text.charAt(i);
            }
        }
        return robbersText;
    } 
}