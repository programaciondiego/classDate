package es.unileon.prg1.date;

public class Date{

	private int _day;
	private int _month;
	private int _year;

	public Date (int day, int month, int year) throws Exception{

		if (isMonthRight(month)) {

			this._month = month;
		}else{

			throw new DateException("Mes "+month+" no valido, debe ser un mes entre 1 y 12");
		}

		if (isDayofMonthRight(day,month)) {

			this._day = day;
			this._year = year;			
		}else{

			throw new DateException("Fecha no valida: (" + day + "/" + month + "/" + year + ")");
		}

	}

	//Metodo que comprueba que el dia del mes sea correcto
	private boolean isDayofMonthRight(int day, int month){

		boolean isDayRight = false;

		switch (month) {
			
			case 1:  //Next
			case 3:  //Next
			case 5:  //Next
			case 7:  //Next
			case 8:  //Next
			case 10: //Next
			case 12: 

				if (day >= 1 || day <= 31 ) {
					isDayRight = true;
				}
				break;

			case 4: //Next
			case 6: //Next
			case 11: 

				if (day >= 1 || day <= 30 ) {
					isDayRight = true;
				}
				break;

			case 2: 
				if (day >= 1 || day <= 28) {
					isDayRight = true;
				}
		}
		return isDayRight;
	}

	private boolean isMonthRight(int month){

		boolean isMonthRight = false;

		if (month > 1 && month < 12) {
			isMonthRight = true;
		}

		return isMonthRight;
	}


	public String nameOfMonth(int month){

		String name = "inicialize";

		switch (month) {
			case 1:
				name = "Enero";
				break;

			case 2:
				name = "Febrero";
				break;

			case 3:
				name = "Marzo";
				break;

			case 4:
				name = "Abril";
				break;

			case 5:
				name = "Mayo";
				break;

			case 6:
				name = "Junio";
				break;

			case 7:
				name = "Julio";
				break;

			case 8:
				name = "Agosto";
				break;

			case 9:
				name = "Septiembre";
				break;

			case 10:
				name = "Octubre";
				break;

			case 11:
				name = "Noviembre";
				break;

			case 12:
				name = "Diciembre";
				break;
		}

		return name;
	}


	public String whatSeasonIs(int month){
		
		String season = "estacion";

		switch (month) {

			case 4: //Next
			case 5: //Next
			case 6:
				season = "Primavera";
				break;

			case 7: //Next
			case 8: //Next
			case 9:
				season = "Verano";
				break;

			case 10: //Next
			case 11: //Next
			case 12:
				season = "Otoño";
				break;

			case 1: //Next
			case 2: //Next
			case 3:
				season = "Invierno";
				break;
		}

		return season;
	}


	public void setDay(int day){

		if (this.isDayofMonthRight(day, this._month)) {
		
			this._day = day;
		}
	}


	public void setMonth(int month){

		this._month = month;
	}


	public void setYear(int year){

		this._year = year;
	}


	public boolean isSameDay(int day){

		boolean isSameDay = this._day==day;

		return isSameDay;
	}


	public boolean isSameMonth(int month){

		boolean isSameMonth = this._month==month;
		
		return isSameMonth;
	}


	public boolean isSameYear(int year){

		boolean isSameYear = this._year==year;
		
		return isSameYear;
	}	


	public boolean isSameDate(){

		boolean isSameDate = (isSameDay(_day) && isSameMonth(_month) && isSameYear(_year));
		
		return isSameDate;
	}

	public void monthsOfYearLeft(int month){

		System.out.println("Los meses restantes este año son: ");

		for (int i = 12; month <= i ; month++) {
			System.out.println(nameOfMonth(month));
		}
	}

	public void monthsOfYearLeft(){

		System.out.println("Los meses restantes este año son: ");
		int month = this._month + 1;

		for (int i = 12; month <= i ; month++) {
			System.out.println(nameOfMonth(month));
		}
	}


	public String toString(){

		StringBuffer salida = new StringBuffer();

		salida.append("(" + this._day + "/" + this._month + "/" + this._year + ") ");
		salida.append("La estacion en esta fecha es " + whatSeasonIs(_month) + " y el nombre del mes es " + nameOfMonth(_month));

		return salida.toString();
	}

}