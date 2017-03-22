package sample;
import java.sql.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;

import javafx.scene.control.TextField;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

import javax.lang.model.type.NullType;
import javax.xml.soap.Text;
import javafx.scene.control.ComboBox;
public class Controller {
    // ALOT of declares
    @FXML
    Button delBtn = new Button();
    @FXML
    Label delLbl = new Label();
    @FXML
    TextField nameDel = new TextField();
    @FXML
    TextField surnameDel = new TextField();
    @FXML
    TextField cnpDel = new TextField();
    @FXML
    String s1,s2;
    @FXML
    TextField Txt1 = new TextField();
    @FXML
    TextField Txt2 = new TextField();
    @FXML
    TextField Txt3 = new TextField();
    @FXML
    Button loginBtn = new Button();
    @FXML
    TextField user = new TextField();
    @FXML
    TextField pass = new TextField();
    @FXML
    Label success = new Label();
    @FXML
    TextArea rezultat = new TextArea();
    @FXML
    TextArea viewPpl = new TextArea();
    @FXML
    Label inf1 = new Label();
    @FXML
    Label inf2 = new Label();
    @FXML
    Label inf3 = new Label();
    @FXML
    ComboBox selecturi = new ComboBox();
    @FXML
    ComboBox delUri = new ComboBox();
    @FXML
    ComboBox updates = new ComboBox();
    @FXML
    TextField nameUpdate = new TextField();
    @FXML
    TextField surnameUpdate = new TextField();
    @FXML
    TextField cnpUpdate = new TextField();
    @FXML
    TextField newSalary = new TextField();
    @FXML
    Label changeSel = new Label();
    @FXML
    Label warning = new Label();
    @FXML
    TextArea updateSuccess = new TextArea();
    @FXML
    TextField t1 = new TextField();
    @FXML
    TextField t2 = new TextField();
    @FXML
    TextField t3 = new TextField();
    @FXML
    TextField t4 = new TextField();
    @FXML
    TextField t5 = new TextField();
    @FXML
    TextField t6 = new TextField();
    @FXML
    TextField t7 = new TextField();
    @FXML
    TextField t8 = new TextField();
    @FXML
    TextField t9 = new TextField();
    @FXML
    Label l1 = new Label();
    @FXML
    Label l2 = new Label();
    @FXML
    Label l3 = new Label();
    @FXML
    Label l4 = new Label();
    @FXML
    Label l5 = new Label();
    @FXML
    Label l6 = new Label();
    @FXML
    Label l7 = new Label();
    @FXML
    Label l8 = new Label();
    @FXML
    Label l9 = new Label();
    @FXML
    ComboBox inserts = new ComboBox();
    @FXML
    Button insBtn = new Button();
    @FXML
    Label warningLbl = new Label();
    public void insert(){
        String S2;
        S2 = inserts.getSelectionModel().getSelectedItem().toString();
        String a1=t1.getText();
        String a2=t2.getText();
        String a3=t3.getText();
        String SQL;
        String connectionUrl;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String S3="";
        if(a1.equals("") || a2.equals("") || a3.equals("")){
            warningLbl.setText("Cnp, Nume si Prenume sun obligatorii!");
        }
        else {
            if (S2.equals("Insert Model")) {
                connectionUrl = "jdbc:sqlserver://localhost:1433;databasename=Fotomodel;integratedSecurity=true";
                String a4=t4.getText();
                String a5=t5.getText();
                String a6=t6.getText();
                String a7=t7.getText();
                String a8=t8.getText();
                String a9=t9.getText();
                try {
                    // Establish the connection.
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection(connectionUrl);

                    //Create and execute an SQL statement that returns some data.
                    SQL = "INSERT INTO Fotomodel.dbo.[Model]\n"+
                            "VALUES ('"+a1+"','"+a2+"',"+a3+",'"+a4+"',"+a5+",'"+a6+"','"+a7+"',"+a8+","+a9+")";
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(SQL);

                    while (rs.next()) {
                    }
                }
                catch (Exception e) {

                }
            } else {
                connectionUrl = "jdbc:sqlserver://localhost:1433;databasename=Fotomodel;integratedSecurity=true";
                String a4=t4.getText();
                String a5=t5.getText();
                try {
                    // Establish the connection.
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection(connectionUrl);

                    //Create and execute an SQL statement that returns some data.
                    SQL = "INSERT INTO Fotomodel.dbo.[Angajat] (Nume,Prenume,CNP,Adr_Domiciuliu,Salariu)\n"+
                            "VALUES ('"+a1+"','"+a2+"',"+a3+",'"+a4+"',"+a5+")";

                    System.out.println(SQL);
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(SQL);

                    while (rs.next()) {
                    }
                }
                catch (Exception e) {

                }
            }
        }
    }
    public void insertCBox(){
        String S2;
        S2 = inserts.getSelectionModel().getSelectedItem().toString();
        if(S2.equals("Insert Model")){
            l5.setText("Inaltime");
            l6.setText("Culoare par");
            l7.setText("Culoare ochi");
            l8.setText("Greutate");
            l9.setText("Pret");
        }
        if(S2.equals("Insert Angajat")){
            l5.setText("Salariu");
            l6.setText("N/A");
            l7.setText("N/A");
            l8.setText("N/A");
            l9.setText("N/A");

        }
    }

    // FINISH ALL THE DECLARES

    // ARATA TOATE MODELELE IMPREUNA CU SALARIU IN UPDATE TAB
    public void showModels(){
        String SQL;
        String connectionUrl;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String S3="";
        connectionUrl = "jdbc:sqlserver://localhost:1433;databasename=Fotomodel;integratedSecurity=true";
        try {
            // Establish the connection.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            //Create and execute an SQL statement that returns some data.
            SQL = "SELECT TOP (1000) Nume, Prenume,CNP,pret \n" +
                    "  FROM Fotomodel.dbo.[Model] x\n";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                S3=S3+rs.getString(1) + " ";
                S3=S3+rs.getString(2)+ " \nCNP:";
                S3=S3+rs.getString(3)+ "    PRET:";
                S3=S3+rs.getString(4)+"\n\n";

            }
        } catch (Exception e) {

        }
        updateSuccess.setText(S3);

    }

    // ARATA TOTI ANGAJATII IMPREUNA CU SALARIU IN UPDATE TAB
    public void showEmployees(){
        String SQL;
        String connectionUrl;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String S3="";
        connectionUrl = "jdbc:sqlserver://localhost:1433;databasename=Fotomodel;integratedSecurity=true";
        try {
            // Establish the connection.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            //Create and execute an SQL statement that returns some data.
            SQL = "SELECT TOP (1000) Nume, Prenume,CNP,Salariu \n" +
                    "  FROM Fotomodel.dbo.[Angajat] x\n";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                S3=S3+rs.getString(1) + " ";
                S3=S3+rs.getString(2)+ " \nCNP:";
                S3=S3+rs.getString(3)+ "    Salariu:";
                S3=S3+rs.getString(4)+"\n\n";

            }
        } catch (Exception e) {

        }
        updateSuccess.setText(S3);
    }

    // STERGE TEXTUL IN UPDATE TAB
    public void clearUp(){
        updateSuccess.setText("");
    }

    // MODIFICA LABEL IN UPDATE TAB
    public void changeLabel(){
        String S2;
        S2 = updates.getSelectionModel().getSelectedItem().toString();
        if(S2.equals("Update Model")) {
            changeSel.setText("Update Pret");
        }
        if(S2.equals("Update Angajat")) {
            changeSel.setText("Update Salariu");
        }
    }

    // APASARE BUTON UPDATE (MODIFICARE PRET/SALARIU)
    public void update(){
        String P="";
        String salariu="";
        String nume="",prenume="",cnp="";
        nume = nameUpdate.getText();
        prenume = surnameUpdate.getText();
        cnp = cnpUpdate.getText();
        salariu = newSalary.getText();
        P = updates.getSelectionModel().getSelectedItem().toString();
        String S4="";
        String SQL;
        String connectionUrl;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        int aux1=0;
        connectionUrl = "jdbc:sqlserver://localhost:1433;databasename=Fotomodel;integratedSecurity=true";
        if(nume.equals("") || prenume.equals("") || cnp.equals("") || salariu.equals("")){
            warning.setText("Toate chenariile sunt obligatorii");
        }
        else {

            warning.setText("");

            try {
                // Establish the connection.
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(connectionUrl);

                if (P.equals("Update Model")) {
                    SQL = "UPDATE Fotomodel.dbo.[Model] \n" +
                            "SET  pret=" + salariu + "\n" +
                            "WHERE CNP = "+cnp+" AND Nume = '"+nume+"' AND Prenume = '"+prenume+"'";
                }
                else{
                    SQL = "UPDATE Fotomodel.dbo.[Angajat] \n"+
                            "SET salariu="+salariu+"\n"+
                            "WHERE CNP = "+cnp+" AND Nume = '"+nume+"' AND Prenume = '"+prenume+"'";
                }
                stmt = con.createStatement();
                rs = stmt.executeQuery(SQL);
                while (rs.next()) {

                }






            }
            catch (Exception e) {
            }


        }
    }

    // STERGE TEXTUL DIN textArea-ul DIN DELETE TAB
    public void clearDel(){
        viewPpl.setText("");
    }

    // AFISEAZA ANGAJATII / MODELELE IN DELETE TAB
    public void view(){
        String P;
        String S4="";
        P = delUri.getSelectionModel().getSelectedItem().toString();
        if(P.equals("Stergere Model")) P = "Model";
        if(P.equals("Stergere Angajat")) P = "Angajat";
        String SQL;
        String connectionUrl;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        connectionUrl = "jdbc:sqlserver://localhost:1433;databasename=Fotomodel;integratedSecurity=true";
        try {
            // Establish the connection.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            //Create and execute an SQL statement that returns some data.
            SQL = "SELECT TOP (1000) Nume, Prenume,CNP \n" +
                    "  FROM Fotomodel.dbo.["+P+"]";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                S4=S4+rs.getString(1) + " ";

                S4=S4+rs.getString(2)+ " ";

                S4=S4+rs.getString(3)+ "\n";

            }
        } catch (Exception e) {

        }
        viewPpl.setText(S4);
    }

    // BUTON DE DELETE MODEL SAU ANGAJAT
    public void delModelAng(){
        String SQL;
        String connectionUrl;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String aux1,nume="",prenume="",cnp="",aux2;
        aux1 = delUri.getSelectionModel().getSelectedItem().toString();
        nume = nameDel.getText();
        prenume = surnameDel.getText();
        cnp = cnpDel.getText();
        delLbl.setText(aux1);
        if(delUri.getSelectionModel().getSelectedItem().toString() == "Choose delete"){
            delLbl.setText("Va rugam sa selectati modul de stergere");
        }
        else {
            if (nume.equals("") || prenume.equals("") || cnp.equals("")) {
                delLbl.setText("Toate chenarele sunt obligatorii");
            }
            else {
                if (aux1.equals("Stergere Model")) {
                        connectionUrl = "jdbc:sqlserver://localhost:1433;databasename=Fotomodel;integratedSecurity=true";
                        try {

                            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                            con = DriverManager.getConnection(connectionUrl);
                            SQL = "DELETE FROM Fotomodel.dbo.[Model]\n"+
                                    "WHERE Id_Model IN (SELECT Id_Model FROM Fotomodel.dbo.[Model]\n"+
                                                        "WHERE CNP = "+cnp+" AND Nume = '"+nume+"' AND Prenume = '"+prenume+"')";
                            stmt = con.createStatement();
                            rs = stmt.executeQuery(SQL);
                            while (rs.next()) {
                            }

                        } catch (Exception e) {

                        }

                }
                else{
                    connectionUrl = "jdbc:sqlserver://localhost:1433;databasename=Fotomodel;integratedSecurity=true";
                    try {

                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        con = DriverManager.getConnection(connectionUrl);
                        SQL = "DELETE FROM Fotomodel.dbo.[Angajat]\n"+
                                "WHERE Id_Angajat IN (SELECT Id_Angajat FROM Fotomodel.dbo.[Angajat]\n"+
                                "WHERE CNP = "+cnp+" AND Nume = '"+nume+"' AND Prenume = '"+prenume+"')";
                        stmt = con.createStatement();
                        rs = stmt.executeQuery(SQL);
                        while (rs.next()) {
                        }

                    } catch (Exception e) {

                    }
                }
            }
        }
    }

    // MODIFICARE LABELURI DIN COMBOBOXUL DIN SELECT
    public void cboxmanipulation(){
        String S2;
        S2 = selecturi.getSelectionModel().getSelectedItem().toString();
        switch(S2){
            case "Model care participa la x evenimente":
                inf1.setText("Nr. evenimente");
                inf2.setText("N/A");
                inf3.setText("N/A");
                break;
            case "Modele care participa la evenimentul x":
                inf1.setText("Numele Evenimentului");
                inf2.setText("N/A");
                inf3.setText("N/A");
                break;
            case "Angajatii care presteaza serviciul x":
                inf1.setText("Numele serviciului");
                inf2.setText("N/A");
                inf3.setText("N/A");
                break;
            case "Evenimente la care part. minim x modele":
                inf1.setText("Nr. minim modele");
                inf2.setText("N/A");
                inf3.setText("N/A");
                break;
            case "Firma care a initiat evenimentul x":
                inf1.setText("Numele evenimentului");
                inf2.setText("N/A");
                inf3.setText("N/A");
                break;
            case "Modele cu x par, y ochi, part macar la un eveniment":
                inf1.setText("Culoare par");
                inf2.setText("Culoare ochi");
                inf3.setText("N/A");
                break;
            case "Angajatii care castiga cel mai mult pentru fiecare seriviciu in parte":
                inf1.setText("N/A");
                inf2.setText("N/A");
                inf3.setText("N/A");
                break;
            case "Nume, Prenume, Pret primele x modele, functie de castig":
                inf1.setText("Primii x");
                inf2.setText("N/A");
                inf3.setText("N/A");
                break;
            case "Angajatii care au salariu > cineva cu studii superioare, avand studii mai mici":
                inf1.setText("N/A");
                inf2.setText("N/A");
                inf3.setText("N/A");
                break;
            case "Angajatii care au salariu mai mare de mediu si lucreaza la x even":
                inf1.setText("Nr minim de evenimente");
                inf2.setText("N/A");
                inf3.setText("N/A");
                break;
        }
    }

    // CLEAR REZULTATE DIN SELECT TAB
    public void clear(){
        rezultat.setText("");
    }

    // SELECT-UL. MANIPULAREA BUTONULUI DE SELECT IN FUNCTIE DE SELECTUL ALES
    public void selection() {
        String x,y,z;
        String S1, S2,S3="";
        S1 = rezultat.getText();
        S2 = selecturi.getSelectionModel().getSelectedItem().toString();
        String SQL;
        String connectionUrl;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        switch (S2) {
            case "Model care participa la x evenimente":
                x = Txt1.getText();
                connectionUrl = "jdbc:sqlserver://localhost:1433;databasename=Fotomodel;integratedSecurity=true";
                try {
                    // Establish the connection.
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection(connectionUrl);

                    //Create and execute an SQL statement that returns some data.
                    SQL = "SELECT TOP (1000) Nume, Prenume \n" +
                            "  FROM Fotomodel.dbo.[Model] M, Fotomodel.dbo.[Model_eve] ME\n"+
                            "WHERE M.Id_Model=ME.Id_model\n"+
                            "GROUP BY M.nume,M.prenume \n"+
                            "HAVING COUNT(M.Id_Model)="+x;
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(SQL);

                    while (rs.next()) {
                        S3=S3+rs.getString(1) + " ";

                        S3=S3+rs.getString(2)+ "\n";

                    }
                } catch (Exception e) {

                }
                break;

            case "Modele care participa la evenimentul x":
                connectionUrl = "jdbc:sqlserver://localhost:1433;databasename=Fotomodel;integratedSecurity=true";
                x = Txt1.getText();
                S3="";
                try {


                    // Establish the connection.
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection(connectionUrl);
                    //Create and execute an SQL statement that returns some data.
                    x="'"+x+"'";
                    SQL = "SELECT M.Nume, M.Prenume \n" +
                            "  FROM Fotomodel.dbo.[Model] M, Fotomodel.dbo.[Eveniment] E, Fotomodel.dbo.[Model_Eve] ME \n"+
                            "WHERE M.Id_Model = ME.Id_Model AND E.Id_Even = ME.Id_Even AND E.nume = "+x+"";
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(SQL);
                    while (rs.next()) {
                        S3=S3+rs.getString(1) + " ";

                        S3=S3+rs.getString(2)+ "\n";

                    }
                } catch (Exception e) {

                }
                break;

            case "Angajatii care presteaza serviciul x":
                connectionUrl = "jdbc:sqlserver://localhost:1433;databasename=Fotomodel;integratedSecurity=true";
                x = Txt1.getText();
                S3="";
                try {


                    // Establish the connection.
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection(connectionUrl);
                    //Create and execute an SQL statement that returns some data.
                    x="'"+x+"'";
                    SQL = "SELECT a.Nume, a.Prenume FROM Fotomodel.dbo.[Angajat] a, Fotomodel.dbo.[Servicii] s\n"+
                            "WHERE a.Id_Serviciu = s.id_serviciu AND s.Nume = "+x+"";
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(SQL);
                    while (rs.next()) {
                        S3=S3+rs.getString(1) + " ";

                        S3=S3+rs.getString(2)+ "\n";

                    }
                } catch (Exception e) {

                }
                break;
            case "Evenimente la care part. minim x modele":
                connectionUrl = "jdbc:sqlserver://localhost:1433;databasename=Fotomodel;integratedSecurity=true";
                x = Txt1.getText();
                S3="";
                try {


                    // Establish the connection.
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection(connectionUrl);
                    //Create and execute an SQL statement that returns some data.
                    SQL =
                            "SELECT E.Nume FROM Fotomodel.dbo.[Model] M,Fotomodel.dbo.[Model_Eve] ME,Fotomodel.dbo.[Eveniment] E\n"+
                                    "WHERE ME.Id_Even=E.Id_Even AND ME.Id_Model = M.Id_Model\n"+
                                    "GROUP BY E.nume\n"+
                                    "HAVING COUNT(Me.Id_model) >="+x+"";

                    stmt = con.createStatement();
                    rs = stmt.executeQuery(SQL);
                    while (rs.next()) {
                        S3=S3+rs.getString(1) + " \n";


                    }
                } catch (Exception e) {

                }
                break;

            case "Firma care a initiat evenimentul x":
                connectionUrl = "jdbc:sqlserver://localhost:1433;databasename=Fotomodel;integratedSecurity=true";
                x = Txt1.getText();
                S3="";
                try {


                    // Establish the connection.
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection(connectionUrl);
                    //Create and execute an SQL statement that returns some data.
                    SQL = "SELECT F.nume FROM Fotomodel.dbo.[Firma_init_ev] F,Fotomodel.dbo.[Eveniment] E\n"+
                            "WHERE E.Id_Firma = F.Id_Firma AND E.Nume='"+x+"'";
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(SQL);
                    while (rs.next()) {
                        S3=S3+rs.getString(1) + " \n";


                    }
                } catch (Exception e) {

                }
                break;

            case "Modele cu x par, y ochi, part macar la un eveniment":
                connectionUrl = "jdbc:sqlserver://localhost:1433;databasename=Fotomodel;integratedSecurity=true";
                x = Txt1.getText();
                y = Txt2.getText();
                S3="";
                try {


                    // Establish the connection.
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection(connectionUrl);
                    //Create and execute an SQL statement that returns some data.
                    SQL = "SELECT nume,prenume,cul_ochi,cul_par,inaltime FROM Fotomodel.dbo.[Model],Fotomodel.dbo.[Model_Eve] me\n"+
                                    "WHERE Cul_par = '"+x+"' AND Cul_Ochi='"+y+"' AND model.id_model = me.Id_Model \n"+
                                    "GROUP BY nume,prenume,cul_ochi,cul_par,inaltime \n"+
                                    "HAVING COUNT(me.id_model) > 0";
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(SQL);
                    while (rs.next()) {
                        S3=S3+rs.getString(1) + " ";
                        S3=S3+rs.getString(2)+ ", ";
                        S3=S3+rs.getString(3)+ ", ";
                        S3=S3+rs.getString(4)+ ", inaltime:";
                        S3=S3+rs.getString(5)+ "\n";
                    }
                } catch (Exception e) {

                }
                break;


            case "Angajatii care castiga cel mai mult pentru fiecare seriviciu in parte":
                connectionUrl = "jdbc:sqlserver://localhost:1433;databasename=Fotomodel;integratedSecurity=true";

                S3="";
                try {


                    // Establish the connection.
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection(connectionUrl);
                    //Create and execute an SQL statement that returns some data.
                    SQL = "SELECT a.nume, a.prenume,s.nume,a.salariu FROM Fotomodel.dbo.[Angajat] a, Fotomodel.dbo.[Servicii] s\n"+
                            "WHERE a.id_serviciu = s.id_serviciu AND a.Salariu IN (SELECT max(a2.salariu) FROM Fotomodel.dbo.[Angajat] a2\n"+
                                                "WHERE a2.id_serviciu = a.Id_Serviciu)";
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(SQL);
                    while (rs.next()) {
                        S3=S3+rs.getString(1) + " ";
                        S3=S3+rs.getString(2) + ", ";
                        S3=S3+rs.getString(3) + "\n SALARIU:";
                        S3=S3+rs.getString(4)+ "\n\n";

                    }
                } catch (Exception e) {

                }
                break;
            case "Nume, Prenume, Pret primele x modele, functie de castig":
                connectionUrl = "jdbc:sqlserver://localhost:1433;databasename=Fotomodel;integratedSecurity=true";
                x = Txt1.getText();
                S3="";
                try {


                    // Establish the connection.
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection(connectionUrl);
                    //Create and execute an SQL statement that returns some data.
                    SQL = "SELECT m.nume, m.prenume, m.Pret FROM Fotomodel.dbo.[Model] m \n"+
                            "WHERE "+x+">(SELECT count(*) FROM Fotomodel.dbo.[Model]\n"+
                                            "WHERE m.pret < pret)"+
                            "ORDER BY m.Pret DESC";
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(SQL);
                    while (rs.next()) {
                        S3=S3+rs.getString(1) + " ";
                        S3=S3+rs.getString(2)+ " ";
                        S3=S3+rs.getString(3)+ "\n";

                    }
                } catch (Exception e) {

                }
                break;
            case "Angajatii care au salariu > cineva cu studii superioare, avand studii mai mici":
                connectionUrl = "jdbc:sqlserver://localhost:1433;databasename=Fotomodel;integratedSecurity=true";
                x = Txt1.getText();
                S3="";
                try {


                    // Establish the connection.
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection(connectionUrl);
                    //Create and execute an SQL statement that returns some data.
                    SQL = "SELECT DISTINCT a.nume, prenume, salariu,[studii necesare] FROM Fotomodel.dbo.[Angajat] a, Fotomodel.dbo.[Servicii] s\n"+
                            "WHERE (salariu> ANY (SELECT salariu FROM Fotomodel.dbo.[angajat] a1,Fotomodel.dbo.[Servicii] s2\n"+
                                    "WHERE a1.Id_Serviciu = s2.Id_Serviciu AND s2.[Studii Necesare] = 'Superioare'))\n"+
                            "AND [studii necesare] != 'Superioare' AND \n"+
                            "a.Id_Serviciu NOT IN (SELECT Id_Serviciu FROM Fotomodel.dbo.[servicii] s2\n"+
                                                     "WHERE s2.[Studii Necesare] = 'Superioare')";
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(SQL);
                    while (rs.next()) {
                        S3=S3+rs.getString(1) + " ";
                        S3=S3+rs.getString(2)+ " ";
                        S3=S3+rs.getString(3)+ " ";
                        S3=S3+rs.getString(4)+ "\n";

                    }
                } catch (Exception e) {

                }
                break;
            case "Angajatii care au salariu mai mare de mediu si lucreaza la x even":
                connectionUrl = "jdbc:sqlserver://localhost:1433;databasename=Fotomodel;integratedSecurity=true";
                x = Txt1.getText();
                S3="";
                try {


                    // Establish the connection.
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection(connectionUrl);
                    //Create and execute an SQL statement that returns some data.
                    SQL = "SELECT Nume, Prenume FROM Fotomodel.dbo.[Angajat] x\n"+
                                    "WHERE Id_Angajat IN (SELECT Id_Angajat FROM Fotomodel.dbo.[Angajat]\n"+
                                    "WHERE "+x+" <= (SELECT COUNT(*) FROM Fotomodel.dbo.[Ang_Ev] y\n"+
                                    "WHERE x.Id_Angajat = y.Id_Ang))\n"+
                                    "AND Salariu<=(SELECT AVG(Salariu) FROM Fotomodel.dbo.[Angajat])";
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(SQL);
                    while (rs.next()) {
                        S3=S3+rs.getString(1) + " ";
                        S3=S3+rs.getString(2)+ "\n";

                    }
                } catch (Exception e) {

                }
                break;

        }

        rezultat.setText(S1 + S3);
    }

    // INTRAREA IN FEREASTRA MAIN DIN FEREASTRA DE LOGIN
    public void switchScreen(){

        s1 = user.getText();
        s2 = pass.getText();
        if(s1.equals("Sandu") && s2.equals("pass123")) {
            Stage stage = (Stage) loginBtn.getScene().getWindow();
            try {
                stage.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Select.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
                /*stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setTitle("ABC");
                stage.setScene(new Scene(root1));
                stage.show();*/
            }
            catch (Exception e) {

            }
        }

        else{
            success.setText("Login Failed");
        }
        //else{
        //    success.setText("Login Failed");
        //}
    }

}
