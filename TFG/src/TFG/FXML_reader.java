package TFG;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FXML_reader {
	
	private static final String FILNAME = "C:\\Users\\Usuari\\eclipse-workspace\\TFG\\src\\TFG\\Circuit.xml";
    
    public FXML_reader() {
    	
    }
    
    
    
    public List<String[]> readerCurrent() throws ParserConfigurationException, SAXException, IOException {
        
    	List<String[]> currentList = new ArrayList<>();
    	
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder builder = factory.newDocumentBuilder();
    	
    	Document document = builder.parse(new File(FILNAME));
    	NodeList currents = document.getElementsByTagName("current");
    	
        for (int i = 0; i < currents.getLength(); i++) {
        	String Cu[] = new String[3];
            Element current = (Element) currents.item(i);
            
            Cu[0] = current.getElementsByTagName("nodoA").item(0).getTextContent();
            Cu[1] = current.getElementsByTagName("nodoB").item(0).getTextContent();
            Cu[2] = current.getElementsByTagName("value").item(0).getTextContent();
            
            
         
            currentList.add(Cu);
        }

        return currentList;
    	
    }
    
    public List<String[]> readerVoltage() throws ParserConfigurationException, SAXException, IOException {
    	
    	List<String[]> voltageList = new ArrayList<>();
    	
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder builder = factory.newDocumentBuilder();
    	
    	Document document = builder.parse(new File(FILNAME));
        NodeList voltages = document.getElementsByTagName("voltage");

        for (int i = 0; i < voltages.getLength(); i++) {
        	String value[] = new String[3];
        	
            Element voltage = (Element) voltages.item(i);
            
            value[0] = voltage.getElementsByTagName("nodoA").item(0).getTextContent();
            value[1] = voltage.getElementsByTagName("nodoB").item(0).getTextContent();
            value[2] = voltage.getElementsByTagName("value").item(0).getTextContent();

            
            voltageList.add(value);
        }
        
        return voltageList;
    }
    
    public List<String[]> readerTranAnalysis() throws ParserConfigurationException, SAXException, IOException {
    	
    	List<String[]> TransAnalisis = new ArrayList<>();
    	
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder builder = factory.newDocumentBuilder();
    	
    	Document document = builder.parse(new File(FILNAME));
        NodeList TranAnalysis = document.getElementsByTagName("TranAnalysis");
        
        
        for (int i = 0; i < TranAnalysis.getLength(); i++) {
        	
        	String Ts[] = new String[4];
            Element Transis = (Element) TranAnalysis.item(i);
          
            Ts[0] = Transis.getElementsByTagName("Tstep").item(0).getTextContent();
            Ts[1] = Transis.getElementsByTagName("Tstop").item(0).getTextContent();
            Ts[2] = Transis.getElementsByTagName("Tstart").item(0).getTextContent();
            Ts[3] = Transis.getElementsByTagName("UIC").item(0).getTextContent();
            
            TransAnalisis.add(Ts);
            
        }
        
        return TransAnalisis;
    }
    
    public List<String[]> readerStepParameters() throws ParserConfigurationException, SAXException, IOException {
    	
    	List<String[]> StepParametersList = new ArrayList<>();
    	
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder builder = factory.newDocumentBuilder();
    	
    	Document document = builder.parse(new File(FILNAME));
        NodeList StepParameters = document.getElementsByTagName("StepParameters");
        
        
        for (int i = 0; i < StepParameters.getLength(); i++) {
        	
        	String Pm[] = new String[4];
        	
            Element param = (Element) StepParameters.item(i);
      
            Pm[0] = param.getElementsByTagName("nameParam").item(0).getTextContent();
            Pm[1] = param.getElementsByTagName("inicalValue").item(0).getTextContent();
            Pm[2] = param.getElementsByTagName("finalValue").item(0).getTextContent();
            Pm[3] = param.getElementsByTagName("increment").item(0).getTextContent();
            
            StepParametersList.add(Pm);
            
        }
        return StepParametersList;
    }
    
public List<String[]> readerParameters() throws ParserConfigurationException, SAXException, IOException {
    	
    	List<String[]> ParametersList = new ArrayList<>();
    	
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder builder = factory.newDocumentBuilder();
    	
    	Document document = builder.parse(new File(FILNAME));
        NodeList Parameters = document.getElementsByTagName("Parameters");
        
        
        for (int i = 0; i < Parameters.getLength(); i++) {
        	
        	String Pm[] = new String[2];
        	
            Element param = (Element) Parameters.item(i);
      
            Pm[0] = param.getElementsByTagName("nameParam").item(0).getTextContent();
            Pm[1] = param.getElementsByTagName("Value").item(0).getTextContent();
           
            
            ParametersList.add(Pm);
            
        }
        return ParametersList;
    }
    
    public List<String[]> readerInitCond() throws ParserConfigurationException, SAXException, IOException {
        
    	List<String[]> InitCond = new ArrayList<>();
    	
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder builder = factory.newDocumentBuilder();
    	
    	Document document = builder.parse(new File(FILNAME));
    	NodeList Iconditions = document.getElementsByTagName("initialConditions");
    	
        
        for (int i = 0; i < Iconditions.getLength(); i++) {
        	
        	String Ini[] = new String[1];
        	
            Element Icond = (Element) Iconditions.item(i);
            
            Ini[0] = Icond.getElementsByTagName("Vx").item(0).getTextContent();
            
            InitCond.add(Ini);
            
            
        }

        return InitCond;
    	
    }
    
    public List<String[]> readerFunction() throws ParserConfigurationException, SAXException, IOException {
        
    	List<String[]> functionlist = new ArrayList<>();
    	
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder builder = factory.newDocumentBuilder();
    	
    	Document document = builder.parse(new File(FILNAME));
    	NodeList function = document.getElementsByTagName("function");
    	
        
        for (int i = 0; i < function.getLength(); i++) {
        	
        	String fun[] = new String[2];
        	
            Element funct = (Element) function.item(i);
            
            fun[0] = funct.getElementsByTagName("name").item(0).getTextContent();
            fun[1] = funct.getElementsByTagName("value").item(0).getTextContent();
            
            functionlist.add(fun);
            
            
        }

        return functionlist;
    	
    }
}
