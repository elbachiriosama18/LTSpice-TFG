package TFG;

import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class ControladorScene2 {
	
	@FXML
    private TextField V_B3, V_B3_2;
	@FXML
	private TextArea func, func_2;  
	@FXML
    private TextField txtIB1, txtIB1_2;
	@FXML
    private TextField txtIB2, txtIB2_2;
	
	
	public void Save_2(ActionEvent e3) {
		
		String textoIB1 = "B1 0 x I=" + txtIB1.getText();
		String textoIB2 = "B2 x 0 I=" + txtIB2.getText();
		String textoV3 = "B3 f 0 V=" + V_B3.getText();
		String textofunc = func.getText();
		String textoIB1_2 = "B4 0 y I=" + txtIB1_2.getText();
		String textoIB2_2 = "B5 y 0 I=" + txtIB2_2.getText();
		String textoV3_2 = "B6 b 0 V=" + V_B3_2.getText();
		String textofunc_2 = func_2.getText();
		
		
        try {
        	createnetlist("C:\\Users\\Usuari\\Desktop\\TFG\\netlist.net",textoIB1,textoIB2,textofunc,textoV3,textoIB1_2,textoIB2_2,textofunc_2,textoV3_2);
        	
        }catch (Exception e) {
            e.printStackTrace();
        }
       
	}
	
	
	private void createnetlist(String FilePath, String txtIB1, String txtIB2, String func, String txtV3,String txtIB1_2,String txtIB2_2,String txtfunc_2,String txtV3_2) throws IOException {
        
		FileWriter writer = new FileWriter(FilePath);
        
        writer.write("*simulacion" + "\n");
      
        	writer.write(txtIB1 + "\n");
            writer.write(txtIB2 + "\n");
            
            writer.write(txtIB1_2 + "\n");
            writer.write(txtIB2_2 + "\n");
            
            if (V_B3.getText().trim().isEmpty() == false) {
            	writer.write(txtV3 + "\n");
            	System.out.println(txtV3);
            }
            
            if (V_B3_2.getText().trim().isEmpty() == false) {
            	writer.write(txtV3_2 + "\n");
            	System.out.println(txtV3_2);
            }
            
            writer.write(func + "\n");
            writer.write(txtfunc_2+ "\n");
            writer.write(".backanno\r\n" + ".end");
            writer.close();
            
           
        
       
    }

}
