
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class NewClass {
    static PreparedStatement pst = null;
    static ResultSet rs = null;
    static ArrayList<String> mus = new ArrayList<String>();
    
    public static void main(String[] args) {
        System.out.println(mus.size());
    }
}
