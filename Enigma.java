public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){        
        //TODO

        String result = "";

        for (int i = 0; i < message.length(); i++) 
        {
            char c = message.charAt(i);

             // outer to middle 
            int index = rotors[2].indexOf(c);
            char s = rotors[1].charAt(index);
 
             // outer to inner
            index = rotors[2].indexOf(s);
            char de = rotors[0].charAt(index);
 
            result += de;

            // Rotate after each character
            rotate();
        }
        return result;
    }


    
    public String encrypt(String message){
        //TODO

        String result = "";

        for (int i = 0; i < message.length(); i++) 
        {
            char c = message.charAt(i);

            // inner to outer 
            int index = rotors[0].indexOf(c);
            char s = rotors[2].charAt(index);

            // middle to outer 
            index = rotors[1].indexOf(s);
            char en = rotors[2].charAt(index);

            result += en;

            // Rotate after each character
            rotate();
        }
        return result;
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
