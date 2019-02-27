package model;
import java.util.*;


//Represents a continent
public class Continent {
	
	public Continent(int ControlValue,String name) {
		this.ContinentId =ContinentId;
		this.Countries = new ArrayList<>();
		this.Name=name;
		this.ControlValue = ControlValue;
	}

	
	//Continent ID
	private int ContinentId;
	
	//Continent Name
	private String Name;
	
	//Continent's Control Value
	private int ControlValue;
	
	//Countries that are in this continent
	private List<Country> Countries;

	//Gets continent's ID
	public int getContinentId() {
		return ContinentId;
	}
	
	//Set Country ID
	public void setContinentId(int ContinentId) {
		this.ContinentId=ContinentId;
	}
	
	//Gets Continent Name
	public String getName() {
		return Name;
	}
		
	//Sets Continent Name
	public void setName(String Name) {
		this.Name=Name;
	}
	
	//Gets continent's countries
	public List<Country> getCountries() {
		return Countries;
	}

	//Sets continent's countries
	public void setCountries(List<Country> Countries) {
		this.Countries = Countries;
	}
	
	public void addCountrie(Country Countrie) {
		this.Countries.add(Countrie);
	}

	//Gets continent's ID
	public int getControlValue() {
		return ControlValue;
	}
		
	//Set Country ID
	public void setControlValue(int ControlValue) {
		this.ControlValue=ControlValue;
	}
}