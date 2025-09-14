package TFG;

import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControladorScene1 {

	@FXML
    private TextField V_B3, V_B3_2;
	@FXML
	private TextArea func, func_2;	  
	@FXML
    private TextField txtIB1;
	@FXML
    private TextField txtIB2;
	
	
	public void Save_3(ActionEvent e3) {
		
		String textoIB1 = "B1 0 x I=" + txtIB1.getText();
		String textoIB2 = "B2 x 0 I=" + txtIB2.getText();
		String textoV3 = "B3 f 0 V=" + V_B3.getText();
		String textofunc = func.getText();
		
		try {
			
            FileWriter writer = new FileWriter("C:\\Users\\Usuari\\Desktop\\TFG\\netlist.net");
            writer.write("*simulacion" + "\n");
            writer.write(textoIB1 + "\n");
            writer.write(textoIB2 + "\n");
                        
            if (V_B3.getText().trim().isEmpty() == false) {
            	writer.write(textoV3 + "\n");
            }
            		
            writer.write(textofunc + "\n");
            writer.write(".backanno\r\n" + ".end");
            writer.close();
                    
			} catch (IOException e) {
					
				e.printStackTrace();
			}
            	
	}

}
