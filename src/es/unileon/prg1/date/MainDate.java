package es.unileon.prg1.date;

public class MainDate{

	public static void main(String[] args) throws Exception {
		
		try{
			Date dia;
			int day; 
			int month;
			int year;
			int dayOfWeek;

			System.out.println("Introduzca el dia");
			day = Teclado.readInteger();
			System.out.println("Introduzca el mes");
			month = Teclado.readInteger();
			System.out.println("Introduzca el año");
			year = Teclado.readInteger();

			do{
				System.out.println("¿Que dia de la semana era el (1/1/" + year +")?");
				System.out.println("[1] Lunes\n[2] Martes\n[3] Miercoles\n[4] Jueves\n[5] Viernes\n[6] Sabado\n[7] Domingo\n");			
				dayOfWeek = Teclado.readInteger();
				if (dayOfWeek < 1 && dayOfWeek > 7) {
					
					System.out.println("Introduzca una de las opciones dadas");
				}
			}while(!(dayOfWeek > 1 && dayOfWeek < 7));


			dia = new Date(day, month, year);
			System.out.println(dia);
			dia.monthsOfYearLeft();
			dia.daysOfMonthLeft();
			System.out.println(dayOfWeek);

			System.out.println("Dia de la semana " + dia.dayOfWeek(dayOfWeek));
		}catch(DateException e){

			System.out.println(e.getMessage());
		}
	}
}