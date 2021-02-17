import java.util.Random;

public class MoveWords{

    public static final int EMPATE = 0;
    public static final int GANA = 1;
    public static final int PIERDE = 2;

    private static final String[] validMoves = {"TIJERAS", "PAPEL", "PIEDRA", "TORITO", "SEPIA"};
    private static final String[] validCommands = {"SALIR", "HELP"};

    private Random rnd;
    
    public MoveWords(){
    	rnd = new Random();
    }
    
    public boolean isValidMoveCommand(String value){

	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
	    	    return true;
	    }
	    
	    for (int i =0; i< validCommands.length; i++){
	        if(validCommands[i].equals(value))
		        return true;
	    }
	    
	    return false;
    }

    public String randomMove(){
	    float p = rnd.nextFloat();
	    return validMoves[ (int) (p * validMoves.length)];
    }

    public void showMoves(){
        for (String move : validMoves)
	        System.out.print(move+" ");
	    System.out.println();
    }
    public void showCommands(){
	    for (String cmd : validCommands)
	        System.out.print(cmd+" ");
	    System.out.println();
    }

    public void showWords(){
        showMoves();
        showCommands();    
    }

    private static int getIndex(String value){
	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
		        return i;
	    }
    	return -1;
    }

    public static int checkWinner(String first, String second){
	    int first_i, second_i;

	    first_i = getIndex(first);
	    second_i = getIndex(second);
	    
	    if (first_i == second_i) return EMPATE;			 //Al introducir las nuevas opciones hay un fallo en el salto de 3 posiciones 
	    if(first_i == 4 && second_i == 2) {return GANA;} //correci�n Spock-Roca perd�a contra esta opci�n.
	    if(first_i == 3 && second_i == 1) {return GANA;} //Correci�n Lagartija perd�a contra papel, ahora ya el valor devuelto es "GANA"
	    if(first_i == 2 && second_i == 0) {return GANA;} //Similar con Piedra y tijera
	    
	    return (( (first_i +1) % validMoves.length ) == second_i ) ? GANA: PIERDE;
	}
	
} 
