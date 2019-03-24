package es.unileon.prg1.date;

public class MainDate{

	public static void main(String[] args) throws Exception {
		
		try{
			Date dia, otroDia;
			int day; 
			int month;
			int year;

			System.out.println("Introduzca el dia");
			day = Teclado.readInteger();
			System.out.println("Introduzca el mes");
			month = Teclado.readInteger();
			System.out.println("Introduzca el año");
			year = Teclado.readInteger();

			dia = new Date(day, month, year);
		
			/*System.out.println("Introduzca otro dia");
			day = Teclado.readInteger();
			System.out.println("Introduzca otro mes");
			month = Teclado.readInteger();
			System.out.println("Introduzca otro año");
			year = Teclado.readInteger();

			otroDia = new Date(day, month, year);

			System.out.println("\nMismo dia: " + dia.isSameDay(otroDia) + "\n" + "Mismo mes: " + dia.isSameMonth(otroDia) + "\n" + "Mismo year: " + dia.isSameYear(otroDia) + "\n" + "Misma fecha: " + dia.isSameDate(otroDia));
			System.out.println(dia);
		*/

			dia.randomDateUntilItEqualsToGivenWhile();

		}catch(DateException e){

			System.out.println(e.getMessage());
		}
	}
}