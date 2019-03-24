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
	
	public int getDay(){
		int day = this._day;
		return day;
	}

	public int getMonth(){
		int month = this._month;
		return month;
	}

	public int getYear(){
		int year = this._year;
		return year;
	}

	public int getDaysOfMonth(){

		int month = this._month;
		int salida = 0;
		salida = getDaysOfMonth(month);
		return	salida;	
	}

	private int getDaysOfMonth(int month){

		int salida = 0;

		switch (month) {
			case 4: //Next
			case 6: //Next
			case 9: //Next
			case 11: 
					salida = 30;				
				break;

			case 2: 
				salida = 28;
				break;

			default:
				salida = 31;
		}

		return salida;
	}

	//Metodo que comprueba que el dia del mes sea correcto
	private boolean isDayofMonthRight(int day, int month){

		boolean isDayRight = false;

		switch (month) {
			
			case 4: //Next
			case 6: //Next
			case 9: //Next
			case 11: 

				if (day >= 1 && day <= 30 ) {
					isDayRight = true;
				}
				break;

			case 2: 
				if (day >= 1 && day <= 28) {
					isDayRight = true;
				}
				break;

			default:
				if (day >= 1 && day <= 31 ) {
					isDayRight = true;
				}
		}
		return isDayRight;
	}

	//Metodo que comprueba que el mes sea correcto
	private boolean isMonthRight(int month){

		boolean isMonthRight = false;

		if (month >= 1 && month <= 12) {
			isMonthRight = true;
		}

		return isMonthRight;
	}

	public String dateWithFormat(){

		StringBuilder salida = new StringBuilder();
		salida.append("(" + this.getDay() + "/" + this.getMonth() + "/" + this.getYear() + ")");

		return salida.toString();
	}

	public String nameOfMonth(){

		String salida = "";
		int month = this._month;
		salida = nameOfMonth(month);
		return salida;
	}

	//Metodo que devuelve el nombre del mes que se le pasa
	private String nameOfMonth(int month){

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
	public String whichSeason(){
		
		int month = this.getMonth();

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

	//Metodo que comprueba si el dia del objeto sobre el que se invoca y el objeto parametro es el mismo
	public boolean isSameDayIf(Date date){

		boolean isSameDay = false;

		if (this._day==date.getDay()){
			isSameDay = true;			
		}

		return isSameDay;
	}

	//Metodo que comprueba si el mes del objeto sobre el que se invoca y el objeto parametro es el mismo
	public boolean isSameMonthIf(Date date){

		boolean isSameMonth = false;

		if (this._month==date.getMonth()){
			isSameMonth = true;			
		}
		
		return isSameMonth;
	}

	//Metodo que comprueba si el año del objeto sobre el que se invoca y el objeto parametro es el mismo
	public boolean isSameYearIf(Date date){

		boolean isSameYear = false;

		if (this._year==date.getYear()){
			isSameYear = true;			
		}
		
		return isSameYear;
	}	

	//Metodo que comprueba si la fecha del objeto sobre el que se invoca y el objeto parametro es el mismo
	public boolean isSameDateIf(Date date){

		boolean isSameDate = false;

		if ((isSameDay(date) && isSameMonth(date) && isSameYear(date))) {
			isSameDate = true;			
		} 
		
		return isSameDate;
	}

	//Metodo que comprueba si el dia del objeto sobre el que se invoca y el objeto parametro es el mismo
	public boolean isSameDay(Date date){

		boolean isSameDay = this._day==date.getDay();

		return isSameDay;
	}

	//Metodo que comprueba si el mes del objeto sobre el que se invoca y el objeto parametro es el mismo
	public boolean isSameMonth(Date date){

		boolean isSameMonth = this._month==date.getMonth();
		
		return isSameMonth;
	}

	//Metodo que comprueba si el año del objeto sobre el que se invoca y el objeto parametro es el mismo
	public boolean isSameYear(Date date){

		boolean isSameYear = this._year==date.getYear();
		
		return isSameYear;
	}	

	//Metodo que comprueba si la fecha del objeto sobre el que se invoca y el objeto parametro es el mismo
	public boolean isSameDate(Date date){

		boolean isSameDate = (isSameDay(date) && isSameMonth(date) && isSameYear(date));
		
		return isSameDate;
	}

	//Metodo que devuelve el nombre de los meses que faltan desde el mes del objeto sobre el que se ejecuta el metodo hasta diciembre, diciembre incluido
	public String monthsOfYearLeft(){

		StringBuilder salida = new StringBuilder();

		if (this.getMonth() == 12) {
			salida.append("\nNo hay meses restantes este anyo, Diciembre es el ultimo mes.\n");
		}else{
			salida.append("\nLos meses restantes este anyo son: \n");
		}

		for (int i = this.getMonth() + 1; i <= 12 ; i++) {
			salida.append(nameOfMonth(i)+"\n");
		}

		return salida.toString();
	}

	//Metodo que devuelve todas fechas desde el dia del objeto sobre el que se ejecuta el metodo, hasta el final del mes del objeto sobre el que se ejecuta el metodo
	public String daysOfMonthLeft(){

		int daysLeft;

		StringBuilder salida = new StringBuilder();

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

		salida.append("\n\nLos dias restantes hasta final de mes son: \n");

		for (int i = 1 ; i <= daysLeft; i++) {
			salida.append("(" + (this._day + i) + "/" + this._month + "/" + this._year + ") \n");
		}		

		return salida.toString();
	}

	//Metodo que devuelve todos los meses del anyo con el mismo numero de dias que el mes del objeto sobre el que se invoca
	public String monthsWithSameDays(){

		int month = this._month;
		StringBuilder salida = new StringBuilder();

		if (month != 2) {

			salida.append("\nLos meses del año con los mismo dias son:\n");

			for (int i = 1; i <= 12; i++) {
			
				if (getDaysOfMonth(month) == getDaysOfMonth(i) && month != i) {
				
					salida.append(nameOfMonth(i)+"\n");			
				}
			}
		}else{
			salida.append("Febrero es el unico mes con 28 dias");
		}

		return salida.toString();
	}

	//Metodo que devuelve el dia del anyo del objeto sore el que se ejecuta
	public int dayOfYear(){

		int month = this.getMonth();
		int day = this.getDay();
		int salida = day;

		for (int i = 1; i < month; i++) {
			
			salida = salida + getDaysOfMonth(i);
		}

		return salida;
	}

	//Metodo que devuelve el dia de la semana 
	public String dayOfWeek(){

		StringBuilder salida = new StringBuilder();


		int dayOfWeek;

			do{
				System.out.println("\n¿Que dia de la semana era el (1/1/" + this.getYear() +")?");
				System.out.println("[1] Lunes\n[2] Martes\n[3] Miercoles\n[4] Jueves\n[5] Viernes\n[6] Sabado\n[7] Domingo\n");			
				dayOfWeek = Teclado.readInteger();
				if (dayOfWeek < 1 && dayOfWeek > 7) {
					System.out.println("Introduzca una de las opciones dadas");
				}
			}while(!(dayOfWeek >= 1 && dayOfWeek <= 7));


		int day = (dayOfYear()%7)+dayOfWeek-1;

		switch (day){

			case 1:

				salida.append("Lunes");
				break;
			case 2:

				salida.append("Martes");
				break;
			case 3:

				salida.append("Miercoles");
				break;
			case 4:

				salida.append("Jueves");
				break;
			case 5:

				salida.append("Viernes");
				break;
			case 6:

				salida.append("Sabado");
				break;				
			case 7:

				salida.append("Domingo");
				break;
		}		

		return salida.toString();
	}

	public int randomDateUntilItEqualsToGivenWhile(){

		int numberOfAttempts = 0;
		int randomDay = 0;

		while(randomDay != dayOfYear()){
		 	
			randomDay =  1 + (int)(Math.random()*365);

			System.out.println(randomDay);

			numberOfAttempts++;
		} 	

		System.out.println("numer de intentos " + numberOfAttempts);

		return numberOfAttempts;
	}

	public String toString(){

		StringBuffer salida = new StringBuffer();

		salida.append(dateWithFormat());
		salida.append("La estacion en esta fecha es " + whichSeason() + " y el nombre del mes es " + nameOfMonth());
		salida.append(daysOfMonthLeft());
		salida.append(monthsOfYearLeft()); 
		salida.append(monthsWithSameDays());	
		salida.append("El dia " + dateWithFormat() + " es el dia " + dayOfYear() + " del anyo, y es " + dayOfWeek());

		return salida.toString();
	}

}