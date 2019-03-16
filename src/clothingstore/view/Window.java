package views;
import javax.swing.JOptionPane;
import controllers.ActionOfOperation;
import controllers.ActionsOfAdd;
import controllers.Option;
import models.Brands;

public class Window {
    
    public ActionOfOperation getActionOfOoeration(){
        return ActionOfOperation.valueOf(JOptionPane.showInputDialog(null,"Select the operation","Cinema Data", 
                JOptionPane.INFORMATION_MESSAGE,null,ActionOfOperation.values(),ActionOfOperation.values()[0]).toString());    
    }
    public ActionsOfAdd getActionOfAdd(){
        return ActionsOfAdd.valueOf(JOptionPane.showInputDialog(null,"Select the operation","Cinema Data", 
                JOptionPane.INFORMATION_MESSAGE,null,ActionsOfAdd.values(),ActionsOfAdd.values()[0]).toString());    
    }
    public  Option getOption(){
        return Option.valueOf(JOptionPane.showInputDialog(null,"Select the option","Cinema Data", 
                JOptionPane.INFORMATION_MESSAGE,null,Option.values(),Option.values()[0]).toString());    
    }
   
    public Brands getBrand(){
        return Brands.valueOf(JOptionPane.showInputDialog(null,"Select the brand","Cinema Data", 
                JOptionPane.INFORMATION_MESSAGE,null,Brands.values(),Brands.values()[0]).toString());    
    }
  
    public int askForId (String tipe){
        return Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the id number of the " + tipe ,"Number",JOptionPane.QUESTION_MESSAGE));
    }
      public int askForNumber (String tipe){
        return Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the  number of the " + tipe ,""));
    }
    public String askForName (){
        return (JOptionPane.showInputDialog(null, "Enter the name","Number",JOptionPane.QUESTION_MESSAGE));
    }
     public void showMessage (String message){
        JOptionPane.showMessageDialog(null, message,"RESULT",JOptionPane.INFORMATION_MESSAGE);
    }
    public void showInformation (){
        JOptionPane.showMessageDialog(null, "El programa maneja la base de datos de una tienda de ropa en la que se manejan 10 tipos de marcas ya establecidas.\n" +
            "\n" +
            "Se pueden manejan tres tipos de datos:\n" +
            " \n" +
            " -Cliente --> (cédula, nombre) (pueden haber máximo 15 clientes)\n" +
            " -Vendedor--> (cédula, nombre) (Pueden haber máximo 5 vededores),(A cada vendedor se le paga 400.000 inicialmente y se le suman 6000 por venta)\n" +
            " -Venta --> (Cliente, Vendedor, Marca, Ganancia) (pueden haber máximo 20 ventas)\n" +
            "\n" +
            "Las operaciones del programa son:\n" +
            "\n" +
            "* Mostrar una lista de vendedores y sus respectivos salarios, teniendo en cuenta las ventas que ya realizaron.\n" +
            "* Mostrar ventas y ganancias totales.\n" +
            "* Recompensar al vendedor que haya hecho más ventas con 100.000 más en su salario.\n" +
            "* Despedir al vendedor que haya hecho menos de 3 ventas.\n" +
            "* Darle un bono al cliente que haya tenido más de 5 compras.\n" +
            "* Borrar de la base de datos a los clientes que no hayan realizado ninguna compra.\n" +
            "* Hacer un sorteo al azar entre los clientes que hayan realizado compras. \n" +
            "* Determinar cual fue la marca que menos se vendio. ","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
    } 
     
}
