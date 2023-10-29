package control;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Archive;
import model.FoodDiary;

/**
 * Controller zum Laden,Speichern, Importieren, Exportieren und Drucken
 * @author sopr092
 *
 */
public class IOController {

	public static final File SAVE_FILE = new File("fd.ser");
	
	private FDController fDController;

	/**
	 * Konstruktor
	 * @param fDController ist die Referenz auf den zentralen Controller zum erreichen der anderen Controller
	 * @throws NullPointerException wird geworfen wenn der Parameter leer ist
	 * @postconditions Der fdController verweist auf den zentralen Controller
	 */
	public IOController(FDController fDController) {
		this.fDController = fDController;
	}

	/**
	 * Lädt die FD-Datei aus der Datei welche unter SAVE_FILE angegeben ist
	 * @throws fdIOException wirft eine Exception wenn beim Laden ein Fehler aufgetreten ist
	 * @postconditions Der in der Datei gespeicherte Zustand vom FoodDiary steht dem System zur Verfügung
	 */

	public void load() throws Exception
	{		
		try
		{
			if(!SAVE_FILE.exists())
				return;	
			
			ObjectInputStream stream = new ObjectInputStream(new FileInputStream(SAVE_FILE));
			FoodDiary foodDiary= (FoodDiary) stream.readObject();
			fDController.setFD(foodDiary); 
	        stream.close();
	        //fDController.getArchiveController().callRefreshArchive();
	        //fDController.getDiaryController().callRefreshDiary();
	        //fDController.getViewController().callRefreshView();
	        
		}
		catch(Exception e)
		{			
			throw new Exception(e.getMessage());
		}		
	}

	/**
	 * Speichert die FD-Datei in der Datei die unter SAVE_FILE angegeben ist
	 * @throws fdIOException wirft eine Exception wenn beim Speichern ein Fehler aufgetreten ist
	 */
	public void save() throws Exception
	{
		try
		{		
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(SAVE_FILE));
			stream.writeObject(fDController.getFD());
			stream.close();
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
		
	}
	
	/**
	 *  @author	sopr095
	 *  @param	DateiPfad d
	 *  Die Methode ruft den ArchiveController mit der methode merge und gibt ihm den Parameter d.
	 */
	public void importArchive(String datei) throws Exception
	{
		try
		{
			//eventuell noch path hinzu?!
			File file = new File(datei);
			
			if(!file.exists())
				return;	
			
			Boolean replace = false;
			
			ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file));			
			Archive archive = (Archive) stream.readObject();	
			fDController.getArchiveController().merge(archive, replace);
		    stream.close();
	        //fDController.getArchiveController().callRefreshArchive();
	        //fDController.getDiaryController().callRefreshDiary();
	        //fDController.getViewController().callRefreshView();
	        
		}
		catch(Exception e)
		{			
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * @author sopr095
	 * @param name : Der Name des exportierten Archives.
	 * @param filePath : Der Ort wo die Datei gespeichert werden soll.
	 * Die Methode ruft den ArchiveController auf zusammen mit seiner Methode export und 
	 * übergibt der Methode die Parameter.
	 */
	public void exportArchive(String datei, String ort) throws Exception
	{
		try
		{		
			String path = ort.concat(datei).concat(".archive");
			File file = new File(path);
			
			if(file.exists())
				return;
			
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file));
			stream.writeObject(fDController.getFD().getArchive());
			stream.close();
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Zum drucken des Tagebuches zuständig
	 * @trhwos fdIOException wirft eine Exception falls beim Drucken etwas schief läuft
	 * @postconditions eine Liste des aktuellen Tagebuchs wurde gedruckt
	 */
	public void print() {

	}

	/**
	 * @return the fDController
	 */
	public FDController getfDController() {
		return fDController;
	}

}
