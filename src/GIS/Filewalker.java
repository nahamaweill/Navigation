package GIS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import File_format.Csv2kml;;

public class Filewalker {

	public static ArrayList<String[]> loadCsvLine(String csvFile) throws FileNotFoundException {
		String line = "";
		String csvSplitBy = ",";
		ArrayList<String[]> data = new ArrayList<>();
		String[] dataLine;
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			while ((line = br.readLine()) != null) {
				dataLine = line.split(csvSplitBy);
				data.add(dataLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

    public ArrayList<String> walk( String path ) throws Exception {

		ArrayList<String> ans = new ArrayList<String>();	
        File root = new File( path );
        File[] list = root.listFiles();

        if (list == null) ans = null;

        for ( File f : list ) {
            if ( f.isDirectory() ) {
                walk( f.getAbsolutePath() );
                System.out.println( "Dir:" + f.getAbsoluteFile() );
            }
            else {
    			ans.add(f.toString());
                System.out.println( "File:" + f.getAbsoluteFile() );
            }
        }
    return ans;
    }
    

//    public static 
    
    public static void main(String[] args) throws Exception {
        Filewalker fw = new Filewalker();
        ArrayList<String> h = fw.walk("C:\\Users\\DELL\\Desktop\\Ex2\\Ex2\\data" );
        ArrayList<String[]> ans =  loadCsvLine("C:\\Users\\DELL\\Desktop\\Ex2\\Ex2\\data\\WigleWifi_20171201110209.csv");
        for (int i = 0; i < ans.size(); i++) {
        	for (int j = 0; j < ans.get(i).length; j++) {
			System.out.println(ans.get(i)[j].toString());
        	}
		}
        
        
		}
        
        
        
    }


