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

            // Pass through rotors in reverse order
            int index = rotors[2].indexOf(c);
            c = rotors[2].charAt(index);

            index = rotors[1].indexOf(c);
            c = rotors[1].charAt(index);

            index = rotors[0].indexOf(c);
            c = rotors[0].charAt(index);

            result += c;

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

            // Pass through rotors in order
            int index = rotors[0].indexOf(c);
            c = rotors[0].charAt(index);

            index = rotors[1].indexOf(c);
            c = rotors[1].charAt(index);

            index = rotors[2].indexOf(c);
            c = rotors[2].charAt(index);

            result += c;

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
