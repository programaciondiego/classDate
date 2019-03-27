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
	*/ 
	private int day;

	/**
	* Atributo para almacenar el mes introducido
	*/ 
	private int month;

	/**
	* Atributo para almacenar el anyo introducido
	*/ 
	private int year;


	/**
	* Crea fechas a partir de los datos introducidos
	*
	* @param day
	* @param month
	* @param year
	*/ 
	public Date (int day, int month, int year) throws DateException{

		if (isMonthRight(month)) {

			this.month = month;
		}else{

			throw new DateException("Mes "+month+" no valido, debe ser un mes entre 1 y 12");
		}

		if (isDayofMonthRight(day,month)) {

			this.day = day;
		}else{

			throw new DateException("Fecha no valida: (" + day + "/" + month + "/" + year + ")");
		}
		if (year > 0) {
			this.year = year;			
		}else{
			throw new DateException("Anyo no valido");
		}
	}

	/**
	* Crea fechas a partir de los datos introducidos
	*
	* @param anotherDay
	*/ 
	public Date (Date anotherDay){

		this.day = anotherDay.getDay();
		this.month = anotherDay.getMonth();
		this.year = anotherDay.getYear();

	}
	
	/**
	* Crea la fecha 1/1/2017
	*
	*/ 
	public Date (){

		this.day = 1;
		this.month = 1;
		this.year = 2017;

	}

	
	/**
	* Cambia el dia del objeto
	*
	* @param day
	*/ 
	public void setDay(int day) throws DateException{

		if (this.isDayofMonthRight(day, this.month)) {
		
			this.day = day;
		}else{ 
			throw new DateException("Fecha no valida: (" + day + "/" + month + "/" + year + ")");
		}
	}

	/**
	* Cambia el mes del objeto
	*
	* @param month
	*/ 
	public void setMonth(int month) throws DateException{

		if (isMonthRight(month)) {
			this.month = month;
		}else{
			throw new DateException("Mes "+month+" no valido, debe ser un mes entre 1 y 12");
		}
		
	}

	/**
	* Cambia el anyo del objeto
	*
	* @param year
	*/ 
	public void setYear(int year) throws DateException{
		
		if (year > 0) {
			this.year = year;			
		}else{
			throw new DateException("Anyo no valido");
		}
	}
	
	/**
	* Obtiene el dia del objeto
	*
	*
	* @return Retorna un int con el dia
	*/ 
	public int getDay(){
		int day = this.day;
		return day;
	}

	/**
	* Obtiene el mes del objeto
	*
	*
	* @return Retorna un int con el mes del objeto
	*/ 
	public int getMonth(){
		int month = this.month;
		return month;
	}

	/**
	* Obtiene el anyo del objeto
	*
	*
	* @return Retorna el anyo del objeto
	*/ 
	public int getYear(){
		int year = this.year;
		return year;
	}

	/**
	* Llama al metodo daysOfMonth y le pasa como parametro el mes obtenido con getMont
	*
	*
	* @return Retorna el numero de dias que tiene el mes dado
	*
	* @see getMonth
	* @see daysOfMonth
	*/ 
	public int daysOfMonth(){

		int month = this.month;
		int salida = 0;
		salida = daysOfMonth(month);
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
	private int daysOfMonth(int month){

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

		boolean isMonthRight = true;

		if (month < 1 || month > 12) {
			isMonthRight = false;
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
		salida.append(this.getDay() + " de " + getMonthName(this.getMonth()) + " de " + this.getYear());

		return salida.toString();
	}

	/**
	* Llama al metodo privado getMonthName y recibe su return
	*
	*
	* @return Retorna un String con el nombre del mes
	*
	* @see getMonthName
	*/ 
	public String getMonthName(){

		StringBuilder salida = new StringBuilder();
		int month = this.month;
		salida.append(getMonthName(month));
		return salida.toString();
	}

	/**
	* Recibe un int con el numero de un mes y devuelve su nombre
	*
	* @param month
	* @return Retorna un String con el nombre del mes
	*/ 
	private String getMonthName(int month){

		String name = "inicialize";

		switch (month) {
			case 1:
				name = "January";
				break;

			case 2:
				name = "February";
				break;

			case 3:
				name = "March";
				break;

			case 4:
				name = "April";
				break;

			case 5:
				name = "May";
				break;

			case 6:
				name = "June";
				break;

			case 7:
				name = "July";
				break;

			case 8:
				name = "August";
				break;

			case 9:
				name = "September";
				break;

			case 10:
				name = "October";
				break;

			case 11:
				name = "November";
				break;

			case 12:
				name = "December";
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
	public String getSeasonName(){
		
		int month = this.getMonth();

		String season = "estacion";

		switch (month) {

			case 4: //Next
			case 5: //Next
			case 6:
				season = "Spring";
				break;

			case 7: //Next
			case 8: //Next
			case 9:
				season = "Summer";
				break;

			case 10: //Next
			case 11: //Next
			case 12:
				season = "Autumn";
				break;

			case 1: //Next
			case 2: //Next
			case 3:
				season = "Winter";
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

		if (this.day==date.getDay()){
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

		if (this.month==date.getMonth()){
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

		if (this.year==date.getYear()){
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

		boolean isSameDay = this.day==date.getDay();

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

		boolean isSameMonth = this.month==date.getMonth();
		
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

		boolean isSameYear = this.year==date.getYear();
		
		return isSameYear;
	}	

	/**
	* Recibe un Date y compara el valor de su dia, mes y anyo con el del Date sobre el que se ejecuta
	* Hecho sin ifs
	*
	* @param date
	* @return Retorna true si son iguales y false si no lo son
	*/ 	//Metodo que comprueba si la fecha del objeto sobre el que se invoca y el objeto parametro es el mismo
	public boolean isSame(Date date){

		boolean isSameDate = (isSameDay(date) && isSameMonth(date) && isSameYear(date));
		
		return isSameDate;
	}
	
	/**
	* Metodo usado para conocer cuantos meses quedan hasta final de anyo, desde el mes del objeto sobre el que se ejecuta
	*
	*
	* @return Retorna un String con los meses que faltan hasta final de anyo
	*/ 
	public String getMonthsLeft(){

		StringBuilder salida = new StringBuilder(); 


		for (int i = this.getMonth() + 1; i <= 12 ; i++) {
			salida.append(getMonthName(i)+" ");
		}

		return salida.toString();
	}
	
	/**
	* Devuelve todas fechas desde el dia del objeto sobre el que se ejecuta el metodo, 
	* hasta el final del mes del objeto sobre el que se ejecuta el metodo
	*
	* @return Retorna un string con las fechas hasta final de mes
	*/ 
	public String getDaysLeftOfMonth(){

		int daysLeft;

		StringBuilder salida = new StringBuilder();

		switch (month) {
			case 4: //Next
			case 6: //Next
			case 11:
				daysLeft = 30 - this.getDay();
				break;

			case 2:
				daysLeft = 28 - this.getDay();
				break;

			default:
				daysLeft = 31 - this.getDay();
		}

		for (int i = 1 ; i <= daysLeft; i++) {
			salida.append( (this.getDay() + i) + "/" + this.getMonth() + "/" + this.getYear() + " ");
		}		

		return salida.toString();
	}

	/**
	* Devuelve todos los meses del anyo con el mismo numero de dias que el mes del objeto sobre el que se invoca
	*
	*
	* @return Retorna un String con los meses del anyo con el mismo numero de dias
	*/ 
	public String getMonthsSameDays(){

		int month = this.getMonth();
		StringBuilder salida = new StringBuilder();

		for (int i = 1; i <= 12; i++) { 
		
			if (daysOfMonth(month) == daysOfMonth(i)) {
			
				salida.append(getMonthName(i)+" ");			
			}
		}

		return salida.toString();
	}
	
	/**
	* Devuelve el dia del anyo del objeto sore el que se ejecuta
	*
	*
	* @return Retorna el dia del anyo (entre el 1 y el 365)*
	*/ 
	public int daysPast(){

		int month = this.getMonth();
		int day = this.getDay();
		int salida = day - 1;

		for (int i = 1; i < month; i++) {
			
			salida = salida + daysOfMonth(i);
		}

		return salida;
	}
 	
	/**
	* Se ejecuta sobre un objeto Date y dice que dia de la semana en base al dia de 
	* la semana que fue el primer dia del anyo
	*
	* @return Retorna un string con el nombre del dia de la semana
	*/ 
	public String dayOfWeek(int dayOfWeek){

		StringBuilder salida = new StringBuilder();



		int day = (daysPast()%7)+(dayOfWeek);

		switch (day){

			case 1:

				salida.append("Monday");
				break;
			case 2:

				salida.append("Tuesday");
				break;
			case 3:

				salida.append("Wednesday");
				break;
			case 4:

				salida.append("Thursday");
				break;
			case 5:

				salida.append("Friday");
				break;
			case 6:

				salida.append("Saturday");
				break;				
			case 0:

				salida.append("Sunday");
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
	public int numRandomTriesEqualDateWhile(){

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
	public int numRandomTriesEqualDate(){

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

	/**
	* Crea el dia siguiente al objeto sobre el que se ejecuta
	*
	*
	* @return Retorna el dia siguiente
	*
	* @see Date
	*/ 
	public Date tomorrow(){

		Date tomorrow = new Date();

		try{

			if (this.getDay()==this.daysOfMonth()) {
				
				tomorrow.setDay(1);
				if (this.getMonth()==12) {
					tomorrow.setMonth(1);
					tomorrow.setYear(this.getYear()+1);
				}else{
				tomorrow.setMonth(this.getMonth()+1);
				tomorrow.setYear(this.getYear());
				}
			}else{
				tomorrow.setDay(this.getDay()+1);
				tomorrow.setMonth(this.getMonth());
				tomorrow.setYear(this.getYear());
			}
		}catch(DateException e){

			System.err.println("Fallo en el metodo tomorrow");
		}
		return tomorrow;
	}
	
	public String toString(){

		StringBuffer salida = new StringBuffer();

		salida.append(this.getDay() + "/" + this.getMonth() + "/" + this.getYear());

		return salida.toString();
	}

}