package TFG;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.scene.control.TextField;
import javafx.fxml.*;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import java.io.*;
import java.util.*;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import TFG.ControladorScene3;
import TFG.FXML_reader;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class controladores {
	
	@FXML
    private BorderPane borderpane;
	
	
	//Funcion que se ejecuta al pulsar el boton RUN de nuestra interfaz
	public void RunSimul(ActionEvent e1) {
    
        try {
        	
        	//Definimos las rutas de la netlist, el ejecutable de LTspice, Phyton...
        	String netlistFile = "C:\\Users\\Usuari\\Desktop\\TFG\\netlist.net";
            String ltspiceExecutable = "C:\\Users\\Usuari\\AppData\\Local\\Programs\\ADI\\LTspice\\LTspice";
            String imagePath = "C:\\Users\\Usuari\\Desktop\\TFG\\grafico.png"; 
            String pythonexe = "C:\\Users\\Usuari\\AppData\\Local\\Programs\\Python\\Python313\\python.exe";
            String script = "C:\\Users\\Usuari\\Desktop\\TFG\\dataconv.py";
            
            //Comando para ejecutar LTspice y le pasamos la netlist
            ProcessBuilder builder = new ProcessBuilder(ltspiceExecutable, "-Run", netlistFile);
            Process process = builder.start();
            process.waitFor();
            
            //Comando para ejecutar el script de Pyhton
            
            ProcessBuilder builder2 = new ProcessBuilder(pythonexe, script);
            builder2.directory(new File("C:\\Users\\Usuari\\Desktop\\TFG"));
            Process process2 = builder2.start();
            process2.waitFor();
            	
            //Comando para mostrar la imagen generada por el script de phyton
            ProcessBuilder builder3 = new ProcessBuilder("cmd.exe", "/c", "start", "", imagePath);
            Process process3 = builder3.start(); 
            process3.waitFor();
           
      
        }catch (Exception e) {
        	e.printStackTrace();
        }
    }


	//Funcion para mostrar la 2 interfaz
    public void Simul2(ActionEvent e2) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("scene1.fxml"));
        AnchorPane view = loader.load(); 
        loader.setController(this);
        borderpane.setCenter(view);
       	
		
	}
    
    //Funcion para mostrar la 3 interfaz
    public void Simul3(ActionEvent e2) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("scene2.fxml"));
        AnchorPane view = loader.load();
      
        loader.setController(this);
        borderpane.setCenter(view);
 
		
	}
	
    
    //Funcion que se ejecuta al pulsar el boton de fxml que carga el contenido y lo muestra por pantalla
	public void openFXML(ActionEvent e2) throws IOException {
		
		List<String[]> currentList = new ArrayList<>();
		List<String[]> voltageList = new ArrayList<>();
		List<String[]> parametersList = new ArrayList<>();
		List<String[]> StepParametersList = new ArrayList<>();
		List<String[]> TransAnalisis = new ArrayList<>();
		List<String[]> InitCond = new ArrayList<>();
		List<String[]> Functions = new ArrayList<>();
		

		FXMLLoader loader = new FXMLLoader(getClass().getResource("scene3.fxml"));
		AnchorPane view = loader.load();  
	
		borderpane.setCenter(view);

   
		ControladorScene3 controlador = loader.getController();
		FXML_reader fxml = new FXML_reader();
		
		try {
			
			currentList = fxml.readerCurrent();
			voltageList = fxml.readerVoltage();
			parametersList = fxml.readerParameters();
			TransAnalisis = fxml.readerTranAnalysis();
			InitCond = fxml.readerInitCond();
			StepParametersList = fxml.readerStepParameters();
			Functions = fxml.readerFunction();
			
			controlador.setValores(currentList, voltageList);
			controlador.setParameters(parametersList, TransAnalisis,InitCond,StepParametersList,Functions);
			controlador.setnetlist();

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}        
	
}
