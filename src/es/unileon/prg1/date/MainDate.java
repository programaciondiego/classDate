package es.unileon.prg1.date;

public class MainDate{

	public static void main(String[] args) throws Exception {
		
		try{
			Date dia;
			dia = new Date(20, 4, 2019);
			System.out.println(dia);
			dia.monthsOfYearLeft();
		}catch(DateException e){

			System.out.println(e.getMessage());
		}
	}
}