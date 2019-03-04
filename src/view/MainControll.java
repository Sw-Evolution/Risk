package view;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import controller.AttackController;
import controller.FortificationController;
import controller.ReadingFiles;
import controller.ReinforcementController;
import model.Country;
import model.Player;

public class MainControll {
	ReadingFiles files;
	MFrame frame;
	Player player;
	MyActionListner myactionlistner;
	AttackController attackcontroller;
	AttackerButtons attackerbuttons;
	ReinforcementController reinforcementcontroller;
	FortificationController fortificationcontroller;

	public MainControll() throws IOException {

	}

	public void Function() throws IOException {
		files = new ReadingFiles();
		reinforcementcontroller = new ReinforcementController();
		myactionlistner = new MyActionListner(this);
		attackerbuttons = new AttackerButtons();
		files.Reads();
		frame = new MFrame(myactionlistner, files.image);
		attackcontroller = new AttackController();
		fortificationcontroller = new FortificationController();
		frame.fun();

		SetButtons();
		PaintCountries();

		myactionlistner.ReinforcementPhase();
		repaintAndRevalidate();
	}

	public void AddArmies(int armies) {
		OnlyNeeded(neighbours(armies));

	}

	public void SetButtons() throws IOException {
		frame.SetButtons(countryObjects());
	}

	public void RefreshButtons() throws IOException {
		frame.Refresh(countryObjects());
		PaintCountries();
		repaintAndRevalidate();
	}

	public List<String> countriesNames() {
		return files.CountriesNames;
	}

	public void repaintAndRevalidate() {
		frame.revalidate();
		frame.repaint();
	}

	public List<Country> neighbours(Integer id) {
		return files.PlayerId.get(id).getTotalCountriesOccupied();
	}

	public HashMap<String, Country> countryObjects() {
		return files.CountryNameObject;
	}

	public void PaintCountries() {
		frame.SetColorToAll(countryObjects());
	}

	public void OnlyNeeded(List<Country> country) {
		frame.OnlyNeeded(country);
	}

	public int PlayerNo() {
		return files.PlayerId.size();
	}

	public Player playerObjet(int id) {
		return files.PlayerId.get(id);
	}

	public String NeighboursList(Country country) {
		List<Country> countrylist = country.getNeighbors();
		String result = "";
		for (int i = 0; i < countrylist.size(); i++) {
			result = result.concat(countrylist.get(i).getName() + ",");
		}
		return result;
	}

	public void ChangePlayerCountry(String countryname) throws IOException {
		Country country = countryObjects().get(countryname);
		country.setPlayer(files.PlayerId.get(0));
		RefreshButtons();

	}

}
