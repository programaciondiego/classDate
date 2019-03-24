package es.unileon.prg1.date;

	/**
	* Clase que crea una fecha y contiene metodos para tratar esta fecha
	*
	*
	* @version 1.0
	* @author Diego Gonzalez Lopez
	*/

public class Date{

	/**
	* Atributo para almacenar el dia introducido
	*
	* @see Integrer
	*/ 
	private int _day;

	/**
	* Atributo para almacenar el mes introducido
	*
	* @see Integrer
	*/ 
	private int _month;

	/**
	* Atributo para almacenar el anyo introducido
	*
	* @see Integrer
	*/ 
	private int _year;


	/**
	* Crea fechas a partir de los datos introducidos
	*
	* @param day
	* @param month
	* @param year
	*/ 
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


	
	/**
	* Cambia el dia del objeto
	*
	* @param day
	* @return No retorna nada
	*/ 
	public void setDay(int day){

		if (this.isDayofMonthRight(day, this._month)) {
		
			this._day = day;
		}
	}

	/**
	* Cambia el mes del obje
	*
	* @param month
	* @return No retorna nada
	*/ 
	public void setMonth(int month){

		if (isMonthRight(month)) {
			this._month = month;
		}		
	}

	/**
	* Cambia el anyo del objeto
	*
	* @param year
	* @return No retorna nada
	*/ 
	public void setYear(int year){

		this._year = year;
	}
	
	/**
	* Obtiene el dia del objeto
	*
	*
	* @return Retorna un int con el dia
	*/ 
	public int getDay(){
		int day = this._day;
		return day;
	}

	/**
	* Obtiene el mes del objeto
	*
	*
	* @return Retorna un int con el mes del objeto
	*/ 
	public int getMonth(){
		int month = this._month;
		return month;
	}

	/**
	* Obtiene el anyo del objeto
	*
	*
	* @return Retorna el anyo del objeto
	*/ 
	public int getYear(){
		int year = this._year;
		return year;
	}

	/**
	* Llama al metodo getDaysOfMonth y le pasa como parametro el mes obtenido con getMont
	*
	*
	* @return Retorna el numero de dias que tiene el mes dado
	*
	* @see getMonth
	* @see getDaysOfMonth
	*/ 
	public int getDaysOfMonth(){

		int month = this._month;
		int salida = 0;
		salida = getDaysOfMonth(month);
		return	salida;	
	}

	/**
	* Obtiene el numero de dias que tiene el mes del objeto
	*
	* @param month
	* @return Retorna el numero de dias que tiene el mes dado
	*
	* @see getMonth
	*/ 
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

	/**
	* Comprueba si el dia dado dentro de mes es correcto
	*
	* @param day
	* @param month
	* @return Retorna true si es correcto y false si no lo es
	*
	* @see DateException
	*/ 
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

	/**
	* Comprueba que el mes exista
	*
	* @param month
	* @return Retorna true si el mes esta entre 1 y 12, false si no lo esta
	*
	* @see DateException
	*/ 
	private boolean isMonthRight(int month){

		boolean isMonthRight = false;

		if (month >= 1 && month <= 12) {
			isMonthRight = true;
		}

		return isMonthRight;
	}

	/**
	* Genera la fecha en formato (Dia mes anyo)
	*
	*
	* @return Retorna la fecha del objeto Date en formato dia mes anyo
	*/ 
	public String dateWithFormat(){

		StringBuilder salida = new StringBuilder();
		salida.append(this.getDay() + " de " + nameOfMonth(this.getMonth()) + " de " + this.getYear());

		return salida.toString();
	}

	/**
	* Llama al metodo privado nameOfMonth y recibe su return
	*
	*
	* @return Retorna un String con el nombre del mes
	*
	* @see nameOfMonth
	*/ 
	public String nameOfMonth(){

		String salida = "";
		int month = this._month;
		salida = nameOfMonth(month);
		return salida;
	}

	/**
	* Recibe un int con el numero de un mes y devuelve su nombre
	*
	* @param month
	* @return Retorna un String con el nombre del mes
	*/ 
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

	
	/**
	* Se ejecuta sobre un objeto Date y devuelve la estacion del anyo en ese mes
	*
	*
	* @return Retorna un String con el nombre de la estacion
	*/ 
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

	/**
	* Recibe un Date y compara el valor de su dia con el del Date sobre el que se ejecuta
	* Hecho con ifs
	*
	* @param date
	* @return Retorna true si son iguales y false si no lo son
	*/ 
	public boolean isSameDayIf(Date date){

		boolean isSameDay = false;

		if (this._day==date.getDay()){
			isSameDay = true;			
		}

		return isSameDay;
	}

	/**
	* Recibe un Date y compara el valor de su mes con el del Date sobre el que se ejecuta
	* Hecho con ifs
	*
	* @param date
	* @return Retorna true si son iguales y false si no lo son
	*/ 
	public boolean isSameMonthIf(Date date){

		boolean isSameMonth = false;

		if (this._month==date.getMonth()){
			isSameMonth = true;			
		}
		
		return isSameMonth;
	}

	/**
	* Recibe un Date y compara el valor de su anyo con el del Date sobre el que se ejecuta
	* Hecho con ifs
	*
	* @param date
	* @return Retorna true si son iguales y false si no lo son
	*/ 
	public boolean isSameYearIf(Date date){

		boolean isSameYear = false;

		if (this._year==date.getYear()){
			isSameYear = true;			
		}
		
		return isSameYear;
	}	

	/**
	* Recibe un Date y compara el valor de su dia, mes y anyo con el del Date sobre el que se ejecuta
	* Hecho con ifs
	*
	* @param date
	* @return Retorna true si son iguales y false si no lo son
	*/ 
	public boolean isSameDateIf(Date date){

		boolean isSameDate = false;

		if ((isSameDay(date) && isSameMonth(date) && isSameYear(date))) {
			isSameDate = true;			
		} 
		
		return isSameDate;
	}

	/**
	* Recibe un Date y compara el valor de su dia con el del Date sobre el que se ejecuta
	* Hecho sin ifs
	*
	* @param date
	* @return Retorna true si son iguales y false si no lo son
	*/ 
	public boolean isSameDay(Date date){

		boolean isSameDay = this._day==date.getDay();

		return isSameDay;
	}

	/**
	* Recibe un Date y compara el valor de su mes con el del Date sobre el que se ejecuta
	* Hecho sin ifs
	*
	* @param date
	* @return Retorna true si son iguales y false si no lo son
	*/ 
	public boolean isSameMonth(Date date){

		boolean isSameMonth = this._month==date.getMonth();
		
		return isSameMonth;
	}

	/**
	* Recibe un Date y compara el valor de su anyo con el del Date sobre el que se ejecuta
	* Hecho sin ifs
	*
	* @param date
	* @return Retorna true si son iguales y false si no lo son
	*/ 
	public boolean isSameYear(Date date){

		boolean isSameYear = this._year==date.getYear();
		
		return isSameYear;
	}	

	/**
	* Recibe un Date y compara el valor de su dia, mes y anyo con el del Date sobre el que se ejecuta
	* Hecho sin ifs
	*
	* @param date
	* @return Retorna true si son iguales y false si no lo son
	*/ 	//Metodo que comprueba si la fecha del objeto sobre el que se invoca y el objeto parametro es el mismo
	public boolean isSameDate(Date date){

		boolean isSameDate = (isSameDay(date) && isSameMonth(date) && isSameYear(date));
		
		return isSameDate;
	}
	
	/**
	* Metodo usado para conocer cuantos meses quedan hasta final de anyo, desde el mes del objeto sobre el que se ejecuta
	*
	*
	* @return Retorna un String con los meses que faltan hasta final de anyo
	*/ 
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
	
	/**
	* Devuelve todas fechas desde el dia del objeto sobre el que se ejecuta el metodo, 
	* hasta el final del mes del objeto sobre el que se ejecuta el metodo
	*
	* @return Retorna un string con las fechas hasta final de mes
	*/ 
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

	/**
	* Devuelve todos los meses del anyo con el mismo numero de dias que el mes del objeto sobre el que se invoca
	*
	*
	* @return Retorna un String con los meses del anyo con el mismo numero de dias
	*/ 
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
			salida.append("Febrero es el unico mes con 28 dias\n");
		}

		return salida.toString();
	}
	
	/**
	* Devuelve el dia del anyo del objeto sore el que se ejecuta
	*
	*
	* @return Retorna el dia del anyo (entre el 1 y el 365)*
	*/ 
	public int dayOfYear(){

		int month = this.getMonth();
		int day = this.getDay();
		int salida = day;

		for (int i = 1; i < month; i++) {
			
			salida = salida + getDaysOfMonth(i);
		}

		return salida;
	}
 	
	/**
	* Se ejecuta sobre un objeto Date y dice que dia de la semana en base al dia de 
	* la semana que fue el primer dia del anyo
	*
	* @return Retorna un string con el nombre del dia de la semana
	*/ 
	public String dayOfWeek(){

		StringBuilder salida = new StringBuilder();


		int dayOfWeek;

		do{
			System.out.println("\n¿Que dia de la semana era el (1/1/" + this.getYear() +")?");
			System.out.println("[1] Lunes\n[2] Martes\n[3] Miercoles\n[4] Jueves\n[5] Viernes\n[6] Sabado\n[7] Domingo\n");			
			dayOfWeek = Teclado.readInteger();
			if (dayOfWeek < 1 || dayOfWeek > 7) {
				System.out.println("Introduzca una de las opciones dadas");
			}
		}while(!(dayOfWeek >= 1 && dayOfWeek <= 7));


		int day = (dayOfYear()%7)+(dayOfWeek-1);

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
			default:

				salida.append("Domingo");
				break;
		}		

		return salida.toString();
	}


	/**
	* Genera fechas aleatorias hasta que coincide con la del objeto sobre el que se ejecuta el metodo
	* Hecho con while
	*
	* @return Retorna el numero de intentos
	*/ 
	public int randomDateUntilItEqualsToGivenWhile(){

		int numberOfAttempts = 0;
		int randomDay = 0;
		int randomMonth = 0;

		while(randomDay != getDay() && randomMonth != getMonth()){
		 	
			if (randomDay != getDay()){
				randomDay =  1 + (int)(Math.random()*31);			
			}

			if (randomMonth != getMonth()) {
				randomMonth =  1 + (int)(Math.random()*12);
			}

			numberOfAttempts++;
		} 	

		return numberOfAttempts;
	}

	/**
	* Genera fechas aleatorias hasta que coincide con la del objeto sobre el que se ejecuta el metodo
	* Hecho con Do-while
	*
	* @return Retorna el numero de intentos
	*/ 
	public int randomDateUntilItEqualsToGiven(){

		int numberOfAttempts = 0;
		int randomDay = 0;
		int randomMonth = 0;

		do{
		 	
			if (randomDay != getDay()){
				randomDay =  1 + (int)(Math.random()*31);			
			}

			if (randomMonth != getMonth()) {
				randomMonth =  1 + (int)(Math.random()*12);
			}

			numberOfAttempts++;
		}while(randomDay != getDay() && randomMonth != getMonth());

		return numberOfAttempts;
	}

	public String toString(){

		StringBuffer salida = new StringBuffer();

		salida.append("El dia " + dateWithFormat() + " es el dia " + dayOfYear() + " del anyo, y es " + dayOfWeek());
		salida.append("\nLa estacion en esta fecha es " + whichSeason() + " y el nombre del mes es " + nameOfMonth());
		salida.append(daysOfMonthLeft());
		salida.append(monthsOfYearLeft()); 
		salida.append(monthsWithSameDays());	
		salida.append("\nSe han necesitado " + randomDateUntilItEqualsToGiven() + " intentos para generar una fecha aleatoria equivalente a la fecha dada");

		return salida.toString();
	}

}