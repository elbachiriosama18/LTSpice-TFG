package TFG;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControladorScene3 {
	
   
    @FXML
	private TextArea consola;
    
    private List<String[]> currentList = new ArrayList<>();
    private List<String[]> voltageList = new ArrayList<>();
    private List<String[]> parametersList = new ArrayList<>();
    private List<String[]> StepParametersList = new ArrayList<>();
    private List<String[]> TransAnalisis = new ArrayList<>();
    private List<String[]> InitCond = new ArrayList<>();
    private List<String[]> function = new ArrayList<>();

    
    public void setValores(List<String[]> currentList, List<String[]> voltageList) {
    	this.currentList = currentList;
    	this.voltageList = voltageList;
    	
    	consola.setEditable(false);
    	
        if (!currentList.isEmpty()) {
        	
        	consola.appendText("Corriente: \n");
        	
        	for(int i = 0; i <currentList.size(); i++) {
        		consola.appendText(Arrays.toString(currentList.get(i)) + " ");
        	}
        }

        if (!voltageList.isEmpty()) {
        	
        	consola.appendText("\nVoltage: \n");
        	
        	for(int i = 0; i <voltageList.size(); i++) {
        		consola.appendText(Arrays.toString(voltageList.get(i)) + " ");
        	}
        }
    }
    
    public void setParameters(List<String[]> parametersList, List<String[]> TransAnalisis, List<String[]> InitCond, List<String[]> StepParametersList, List<String[]> function) {
    	this.parametersList = parametersList;
    	this.TransAnalisis = TransAnalisis;
    	this.InitCond = InitCond;
    	this.StepParametersList = StepParametersList;
    	this.function = function;
    	
    	consola.setEditable(false);
    	
        if (!parametersList.isEmpty()) {
        	
        	consola.appendText("\nParametros: \n");
        	
        	for(int i = 0; i <parametersList.size(); i++) {
        		consola.appendText(Arrays.toString(parametersList.get(i)) + " ");
        	}
            
        }
        
        
        if (!TransAnalisis.isEmpty()) {
        	consola.appendText("\nAnalisis Transitorio: \n");
        	
        	for(int i = 0; i <TransAnalisis.size(); i++) {
        		consola.appendText(Arrays.deepToString(TransAnalisis.get(i)) + " ");
        	}
            
        }
        
        if (!InitCond.isEmpty()) {
        	consola.appendText("\nCondiciones Iniciales: \n");
        	
        	for(int i = 0; i <InitCond.size(); i++) {
        		consola.appendText(Arrays.deepToString(InitCond.get(i)) + " ");
        	}
            
        }
        
        
        if (!function.isEmpty()) {
        	consola.appendText("\nFunciones: \n");
        	
        	for(int i = 0; i <function.size(); i++) {
        		consola.appendText(Arrays.deepToString(function.get(i)) + " ");
        	}
            
        }
        
        if (!StepParametersList.isEmpty()) {
        	consola.appendText("\nStep Parameters: \n");
        	
        	for(int i = 0; i <StepParametersList.size(); i++) {
        		consola.appendText(Arrays.deepToString(StepParametersList.get(i)) + " ");
        	}
            
        }

        
    }
    
    public void setnetlist() throws IOException {
    	int contador = 0;
    	
    	FileWriter writer = new FileWriter("C:\\Users\\Usuari\\Desktop\\TFG\\netlist.net");
        
    	writer.write("*Simulacion fichero xml\n");
    	
    	if(!currentList.isEmpty()) {
    		for(int i = 0; i < currentList.size(); i++) {
    			
    			String[] arrayCurrent = currentList.get(i);
    			
                writer.write("\nB"+ contador +" "+ arrayCurrent[0] + " " + arrayCurrent[1] + " I=" + arrayCurrent[2]);
                contador++;
    		}
    	}
    	
    	if (!voltageList.isEmpty()) {
    		for(int i = 0; i < voltageList.size(); i++) {
    			
    			String[] arrayVoltage = voltageList.get(i);
    			
                writer.write("\nB"+ contador +" "+ arrayVoltage[0] + " " + arrayVoltage[1] + " V=" + arrayVoltage[2]);
                contador++;
    		}
    	}
    	
    	String[] arrayTrans = TransAnalisis.get(0);
    	
    	writer.write("\n.tran " + arrayTrans[0] + " " + arrayTrans[1] + " " + arrayTrans[2] + " " + arrayTrans[3]);
    	
    	
    	if(!StepParametersList.isEmpty()) {
    		for(int i = 0; i < StepParametersList.size(); i++) {
        		String[] arrayParam = StepParametersList.get(i);
        	
        		writer.write("\n.step param " + arrayParam[0] + " " + arrayParam[1] + " " + arrayParam[2] + " " + arrayParam[3]);
        	}
    	}
    	
    	if(!parametersList.isEmpty()) {
    		for(int i = 0; i < parametersList.size(); i++) {
        		String[] arrayParam = parametersList.get(i);
        	
        		writer.write("\n.param " + arrayParam[0] + "=" + arrayParam[1]);
        	}
    	}
    	
    	
    	if(!InitCond.isEmpty()) {
    		for(int i = 0; i < InitCond.size(); i++) {
    			String[] arrayIni = InitCond.get(i);
    			writer.write("\n.ic " + arrayIni[0]);
    		}
    		
    	}
    	
    	if(!function.isEmpty()) {
    		for(int i = 0; i < function.size(); i++) {
    			String[] arrayfun = function.get(i);
    			writer.write("\n.func " + arrayfun[0] + " {" + arrayfun[1] + "}");
    		}
    		
    	}
    	
    	writer.write("\n.end\n");
    	writer.close();
        
    }
}
