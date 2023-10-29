package support;
import java.time.LocalDate;
import java.time.LocalDateTime;

import model.Unit;

/**
 * Eine Klasse, die Daten in schöne Stringrepresentationen umwandelt
 * @author sopr096
 *
 */
public class NiceStrings {
	
	/**
	 * Formt ein LocalDate in einen String der Form <Tag>.<Monat>.<Jahr> um
	 */
	public static String dateToString(LocalDate date){
		String year = "" + date.getYear();
		
		String month = "" + date.getMonthValue();
		if(date.getMonthValue() < 10){
			month = "0" + month;
		}
		
		String day = "" + date.getDayOfMonth();
		if(date.getDayOfMonth() < 10){
			day = "0" + day;
		}
		
		return day + "." + month + "." + year;
	}
	
	/**
	 * Formt ein LocalDateTime in einen String der Form <Tag>.<Monat>.<Jahr>, <Stunde>:<Minute> um
	 */
	public static String dateToString(LocalDateTime date){
		String dateString = dateToString(date.toLocalDate());
		
		String hour = "" + date.getHour();
		if(date.getHour() < 10){
			hour = "0" + hour;
		}
		
		String minute = "" + date.getMinute();
		if(date.getMinute() < 10){
			minute = "0" + minute;
		}
		
		return dateString + ", " + hour + ":" + minute;
	}
	
	public static String unitToString(Unit unit){
		if(unit == Unit.GRAM){
			return " g";
		}
		if(unit == Unit.DROP){
			return " Tropfen";
		}
		if(unit == Unit.LITER){
			return " l";
		}
		if(unit == Unit.MILLILITER){
			return " ml";
		}
		if(unit == Unit.PIECE){
			return " Stück";
		}
		return "";
	}
}
