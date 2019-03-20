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

	//Metodo que cambia el dia del objeto
	public void setDay(int day){

		if (this.isDayofMonthRight(day, this._month)) {
		
			this._day = day;
		}
	}

	//Metodo que cambia el mes del objeto
	public void setMonth(int month){

		if (isMonthRight(month)) {
			this._month = month;
		}		
	}

	//Metodo que cambia el año del objeto
	public void setYear(int year){

		this._year = year;
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

				if (day >= 1 && day <= 31 ) {
					isDayRight = true;
				}
				break;

			case 4: //Next
			case 6: //Next
			case 11: 

				if (day >= 1 && day <= 30 ) {
					isDayRight = true;
				}
				break;

			case 2: 
				if (day >= 1 && day <= 28) {
					isDayRight = true;
				}
		}
		return isDayRight;
	}

	//Metodo que comprueba que el mes sea correcto
	private boolean isMonthRight(int month){

		boolean isMonthRight = false;

		if (month > 1 && month < 12) {
			isMonthRight = true;
		}

		return isMonthRight;
	}

	//Metodo que devuelve el nombre del mes que se le pasa
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

	//Metodo que comprueba que el dia del mes sea correcto
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


	//Metodo que comprueba si  
	public boolean isSameDay(Date date){

		boolean isSameDay = this._day==day;

		return isSameDay;
	}

	//Metodo que comprueba si
	public boolean isSameMonth(Date date){

		boolean isSameMonth = this._month==month;
		
		return isSameMonth;
	}

	//Metodo que comprueba si
	public boolean isSameYear(Date date){

		boolean isSameYear = this._year==year;
		
		return isSameYear;
	}	

	//Metodo que comprueba si
	public boolean isSameDate(){

		boolean isSameDate = (isSameDay(_day) && isSameMonth(_month) && isSameYear(_year));
		
		return isSameDate;
	}


	//Metodo que imprime el nombre de los meses que faltan desde el mes del objeto sobre el que se ejecuta el metodo hasta diciembre, diciembre incluido
	public void monthsOfYearLeft(){

		System.out.println("Los meses restantes este año son: ");
		int month = this._month + 1;

		for (int i = 12; month <= i ; month++) {
			System.out.println(nameOfMonth(month));
		}
	}

	//Metodo que imprime todas fechas desde el dia del objeto sobre el que se ejecuta el metodo, hasta el final del mes del objeto sobre el que se ejecuta el metodo
	public void daysOfMonthLeft(){

		int daysLeft;

		switch (_month) {
			case 4: //Next
			case 6: //Next
			case 11:
				daysLeft = 30 - _day;
				break;

			case 2:
				daysLeft = 28 - _day;
				break;

			default:
				daysLeft = 31 - _day;
		}

		System.out.println();
		System.out.println("Los dias restantes hasta final de mes son:");
		System.out.println();

		for (int i = 1 ; i <= daysLeft; i++) {
			System.out.println("(" + (this._day + i) + "/" + this._month + "/" + this._year + ")");
		}		
	}

	public monthsWithSameDays

	public String toString(){

		StringBuffer salida = new StringBuffer();

		salida.append("(" + this._day + "/" + this._month + "/" + this._year + ") ");
		salida.append("La estacion en esta fecha es " + whatSeasonIs(_month) + " y el nombre del mes es " + nameOfMonth(_month));

		return salida.toString();
	}

}