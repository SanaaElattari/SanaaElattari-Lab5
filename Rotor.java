public class Rotor {
    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
        //TODO

        //move last char to the front 
        rotorValues = rotorValues.charAt(rotorValues.length() - 1) + rotorValues.substring(0, rotorValues.length() - 1);

        // check if at starting postion 

        if (rotorValues.charAt(0) == startChar) 
        {
            return true; // if at starting position return ture 
        } 
        else 
        {
            return false; // otherwise return false
        }
    }
    

    public int indexOf(char c){
        //TODO

        return rotorValues.indexOf(c); // return index of char c
    }

    public char charAt(int idx){
        //TODO

        return rotorValues.charAt(idx); // return char at index idx
    }
}
    
