package es.unileon.prg1.date;

public class MainDate{

	public static void main(String[] args) throws Exception {
		
		try{
			Date dia;
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
			System.out.println(dia);
			dia.monthsOfYearLeft();
			dia.daysOfMonthLeft();
		}catch(DateException e){

			System.out.println(e.getMessage());
		}
	}
}