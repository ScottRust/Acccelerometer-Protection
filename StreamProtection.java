//finished product-exists on laptop as well
package data.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataReaderTest
{
	public static void main(String[] args) throws IOException
	{
		//Starts HID data pipe stream, reads data from the stream 
		Runtime runtime = Runtime.getRuntime(); 
		Process process = runtime.exec("cmd.exe /c gcdcTool --raw", null, new File("C:\\Users\\Administrator\\Desktop\\gcdcTool_Win7-8"));
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String line;
		int /** ax1 = 0, ay1 = 0, az1 = 0,**/ timeFix, lineCount = 0, runs = 0, consec = 0;
		float ax1 = 0, ay1 = 0, az1 = 0, xBase = 0, yBase = 0, zBase = 0;
		String ax, ay, az;
		
		while ((line = br.readLine()) != null)
		{
			//Updating 'timeFix' variable
			if (line.substring(2, 3).equals("."))
			{
				timeFix = 0;
			}
			else if (line.substring(3, 4).equals("."))
			{
				timeFix = 1;
			}
			else if (line.substring(4, 5).equals("."))
			{
				timeFix = 2;
			}
			else if (line.substring(5, 6).equals("."))
			{
				timeFix = 3;
			}
			else if (line.substring(6, 7).equals("."))
			{
				timeFix = 4;
			}
			else if (line.substring(7, 8).equals("."))
			{
				timeFix = 5;
			}
			else if (line.substring(8, 9).equals("."))
			{
				timeFix = 6;
			}
			else if (line.substring(9, 10).equals("."))
			{
				timeFix = 7;
			}
			else
			{
				timeFix = 8;
			}
			
			//Converts string data to integer data for different lengths of number
			if (line.substring(12 + timeFix, 13 + timeFix).equals(","))
			{
				ax = line.substring(11 + timeFix, 12 + timeFix);
				ax.replaceAll("\\s","");
				ax1 += Integer.parseInt(ax);
			}
			else if (line.substring(13 + timeFix, 14 + timeFix).equals(","))
			{
				ax = line.substring(11 + timeFix, 13 + timeFix);
				ax.replaceAll("\\s","");
				ax1 += Integer.parseInt(ax);
			}
			else if (line.substring(14 + timeFix, 15 + timeFix).equals(","))
			{
				ax = line.substring(11 + timeFix, 14 + timeFix);
				ax.replaceAll("\\s","");
				ax1 += Integer.parseInt(ax);
			}
			else if (line.substring(15 + timeFix, 16 + timeFix).equals(","))
			{
				ax = line.substring(11 + timeFix, 15 + timeFix);
				ax.replaceAll("\\s","");
				ax1 += Integer.parseInt(ax);
			}
			else
			{
				ax = line.substring(11 + timeFix, 16 + timeFix);
				ax.replaceAll("\\s","");
				ax1 += Integer.parseInt(ax);
			}
			
			if (line.substring(12 + timeFix, 13 + timeFix).equals(",") && line.substring(line.length() - 8, line.length() - 7).equals(",") && !(line.substring(line.length() - 6, line.length()).contains(",")))
			{
				ay = line.substring(14 + timeFix, line.length() - 8);
				ay.replaceAll("\\s","");
				ay1 += Integer.parseInt(ay);
			}
			else if (line.substring(13 + timeFix, 14 + timeFix).equals(",") && line.substring(line.length() - 8, line.length() - 7).equals(",") && !(line.substring(line.length() - 6, line.length()).contains(",")))
			{
				ay = line.substring(15 + timeFix, line.length() - 8);
				ay.replaceAll("\\s","");
				ay1 += Integer.parseInt(ay);
			}
			else if (line.substring(14 + timeFix, 15 + timeFix).equals(",") && line.substring(line.length() - 8, line.length() - 7).equals(",") && !(line.substring(line.length() - 6, line.length()).contains(",")))
			{
				ay = line.substring(16 + timeFix, line.length() - 8);
				ay.replaceAll("\\s","");
				ay1 += Integer.parseInt(ay);
			}
			else if (line.substring(15 + timeFix, 16 + timeFix).equals(",") && line.substring(line.length() - 8, line.length() - 7).equals(",") && !(line.substring(line.length() - 6, line.length()).contains(",")))
			{
				ay = line.substring(17 + timeFix, line.length() - 8);
				ay.replaceAll("\\s","");
				ay1 += Integer.parseInt(ay);
			}
			else if (line.substring(16 + timeFix, 17 + timeFix).equals(",") && line.substring(line.length() - 8, line.length() - 7).equals(",") && !(line.substring(line.length() - 6, line.length()).contains(",")))
			{
				ay = line.substring(18 + timeFix, line.length() - 8);
				ay.replaceAll("\\s","");
				ay1 += Integer.parseInt(ay);
			}
			else if (line.substring(12 + timeFix, 13 + timeFix).equals(",") && line.substring(line.length() - 7, line.length() - 6).equals(",") && !(line.substring(line.length() - 5, line.length()).contains(",")))
			{
				ay = line.substring(14 + timeFix, line.length() - 7);
				ay.replaceAll("\\s","");
				ay1 += Integer.parseInt(ay);
			}
			else if (line.substring(13 + timeFix, 14 + timeFix).equals(",") && line.substring(line.length() - 7, line.length() - 6).equals(",") && !(line.substring(line.length() - 5, line.length()).contains(",")))
			{
				ay = line.substring(15 + timeFix, line.length() - 7);
				ay.replaceAll("\\s","");
				ay1 += Integer.parseInt(ay);
			}
			else if (line.substring(14 + timeFix, 15 + timeFix).equals(",") && line.substring(line.length() - 7, line.length() - 6).equals(",") && !(line.substring(line.length() - 5, line.length()).contains(",")))
			{
				ay = line.substring(16 + timeFix, line.length() - 7);
				ay.replaceAll("\\s","");
				ay1 += Integer.parseInt(ay);
			}
			else if (line.substring(15 + timeFix, 16 + timeFix).equals(",") && line.substring(line.length() - 7, line.length() - 6).equals(",") && !(line.substring(line.length() - 5, line.length()).contains(",")))
			{
				ay = line.substring(17 + timeFix, line.length() - 7);
				ay.replaceAll("\\s","");
				ay1 += Integer.parseInt(ay);
			}
			else if (line.substring(16 + timeFix, 17 + timeFix).equals(",") && line.substring(line.length() - 7, line.length() - 6).equals(",") && !(line.substring(line.length() - 5, line.length()).contains(",")))
			{
				ay = line.substring(18 + timeFix, line.length() - 7);
				ay.replaceAll("\\s","");
				ay1 += Integer.parseInt(ay);
			}
			else if (line.substring(12 + timeFix, 13 + timeFix).equals(",") && line.substring(line.length() - 6, line.length() - 5).equals(",") && !(line.substring(line.length() - 4, line.length()).contains(",")))
			{
				ay = line.substring(14 + timeFix, line.length() - 6);
				ay.replaceAll("\\s","");
				ay1 += Integer.parseInt(ay);
			}
			else if (line.substring(13 + timeFix, 14 + timeFix).equals(",") && line.substring(line.length() - 6, line.length() - 5).equals(",") && !(line.substring(line.length() - 4, line.length()).contains(",")))
			{
				ay = line.substring(15 + timeFix, line.length() - 6);
				ay.replaceAll("\\s","");
				ay1 += Integer.parseInt(ay);
			}
			else if (line.substring(14 + timeFix, 15 + timeFix).equals(",") && line.substring(line.length() - 6, line.length() - 5).equals(",") && !(line.substring(line.length() - 4, line.length()).contains(",")))
			{
				ay = line.substring(16 + timeFix, line.length() - 6);
				ay.replaceAll("\\s","");
				ay1 += Integer.parseInt(ay);
			}
			else if (line.substring(15 + timeFix, 16 + timeFix).equals(",") && line.substring(line.length() - 6, line.length() - 5).equals(",") && !(line.substring(line.length() - 4, line.length()).contains(",")))
			{
				ay = line.substring(17 + timeFix, line.length() - 6);
				ay.replaceAll("\\s","");
				ay1 += Integer.parseInt(ay);
			}
			else if (line.substring(16 + timeFix, 17 + timeFix).equals(",") && line.substring(line.length() - 6, line.length() - 5).equals(",") && !(line.substring(line.length() - 4, line.length()).contains(",")))
			{
				ay = line.substring(18 + timeFix, line.length() - 6);
				ay.replaceAll("\\s","");
				ay1 += Integer.parseInt(ay);
			}
			else if (line.substring(12 + timeFix, 13 + timeFix).equals(",") && line.substring(line.length() - 5, line.length() - 4).equals(",") && !(line.substring(line.length() - 3, line.length()).contains(",")))
			{
				ay = line.substring(14 + timeFix, line.length() - 5);
				ay.replaceAll("\\s","");
				ay1 += Integer.parseInt(ay);
			}
			else if (line.substring(13 + timeFix, 14 + timeFix).equals(",") && line.substring(line.length() - 5, line.length() - 4).equals(",") && !(line.substring(line.length() - 3, line.length()).contains(",")))
			{
				ay = line.substring(15 + timeFix, line.length() - 5);
				ay.replaceAll("\\s","");
				ay1 += Integer.parseInt(ay);
			}
			else if (line.substring(14 + timeFix, 15 + timeFix).equals(",") && line.substring(line.length() - 5, line.length() - 4).equals(",") && !(line.substring(line.length() - 3, line.length()).contains(",")))
			{
				ay = line.substring(16 + timeFix, line.length() - 5);
				ay.replaceAll("\\s","");
				ay1 += Integer.parseInt(ay);
			}
			else if (line.substring(15 + timeFix, 16 + timeFix).equals(",") && line.substring(line.length() - 5, line.length() - 4).equals(",") && !(line.substring(line.length() - 3, line.length()).contains(",")))
			{
				ay = line.substring(17 + timeFix, line.length() - 5);
				ay.replaceAll("\\s","");
				ay1 += Integer.parseInt(ay);
			}
			else if (line.substring(16 + timeFix, 17 + timeFix).equals(",") && line.substring(line.length() - 5, line.length() - 4).equals(",") && !(line.substring(line.length() - 3, line.length()).contains(",")))
			{
				ay = line.substring(18 + timeFix, line.length() - 5);
				ay.replaceAll("\\s","");
				ay1 += Integer.parseInt(ay);
			}
			else if (line.substring(12 + timeFix, 13 + timeFix).equals(",") && line.substring(line.length() - 4, line.length() - 3).equals(","))
			{
				ay = line.substring(14 + timeFix, line.length() - 4);
				ay.replaceAll("\\s","");
				ay1 += Integer.parseInt(ay);
			}
			else if (line.substring(13 + timeFix, 14 + timeFix).equals(",") && line.substring(line.length() - 4, line.length() - 3).equals(","))
			{
				ay = line.substring(15 + timeFix, line.length() - 4);
				ay.replaceAll("\\s","");
				ay1 += Integer.parseInt(ay);
			}
			else if (line.substring(14 + timeFix, 15 + timeFix).equals(",") && line.substring(line.length() - 4, line.length() - 3).equals(","))
			{
				ay = line.substring(16 + timeFix, line.length() - 4);
				ay.replaceAll("\\s","");
				ay1 += Integer.parseInt(ay);
			}
			else if (line.substring(15 + timeFix, 16 + timeFix).equals(",") && line.substring(line.length() - 4, line.length() - 3).equals(","))
			{
				ay = line.substring(17 + timeFix, line.length() - 4);
				ay.replaceAll("\\s","");
				ay1 += Integer.parseInt(ay);
			}
			else if (line.substring(16 + timeFix, 17 + timeFix).equals(",") && line.substring(line.length() - 4, line.length() - 3).equals(","))
			{
				ay = line.substring(18 + timeFix, line.length() - 4);
				ay.replaceAll("\\s","");
				ay1 += Integer.parseInt(ay);
			}
			
			if (line.substring(line.length() - 8, line.length() - 7).equals(",") && !(line.substring(line.length() - 6, line.length()).contains(",")))
			{
				az = line.substring(line.length() - 6, line.length());
				az.replaceAll("\\s","");
				az1 += Integer.parseInt(az);
			}
			else if (line.substring(line.length() - 7, line.length() - 6).equals(",") && !(line.substring(line.length() - 5, line.length()).contains(",")))
			{
				az = line.substring(line.length() - 5, line.length());
				az.replaceAll("\\s","");
				az1 += Integer.parseInt(az);
			}
			else if (line.substring(line.length() - 6, line.length() - 5).equals(",") && !(line.substring(line.length() - 4, line.length()).contains(",")))
			{
				az = line.substring(line.length() - 4, line.length());
				az.replaceAll("\\s","");
				az1 += Integer.parseInt(az);
			}
			else if (line.substring(line.length() - 5, line.length() - 4).equals(",") && !(line.substring(line.length() - 3, line.length()).contains(",")))
			{
				az = line.substring(line.length() - 3, line.length());
				az.replaceAll("\\s","");
				az1 += Integer.parseInt(az);
			}
			else if (line.substring(line.length() - 4, line.length() - 3).equals(","))
			{
				az = line.substring(line.length() - 2, line.length());
				az.replaceAll("\\s","");
				az1 += Integer.parseInt(az);
			}
			else if (line.substring(line.length() - 3, line.length() - 2).equals(","))
			{
				az = line.substring(line.length() - 1, line.length());
				az.replaceAll("\\s","");
				az1 += Integer.parseInt(az);
			}
			else
			{
				az = line.substring(line.length() - 7, line.length());
				az.replaceAll("\\s","");
				az1 += Integer.parseInt(az);
			}
			
			if(lineCount == 250)
			{
				if (runs == 0)
				{
					xBase = Math.abs(ax1/250);
					yBase = Math.abs(ay1/250);
					zBase = Math.abs(az1/250);
				}
				System.out.println(Math.abs(ax1/250) - xBase);
				System.out.println(Math.abs(ay1/250) - yBase);
				System.out.println(Math.abs(az1/250) - zBase);
				if(((Math.abs(Math.abs(ax1/250) - xBase)) > 1.8) || ((Math.abs(Math.abs(ay1/250) - yBase)) > 1.8) || ((Math.abs(Math.abs(az1/250) - zBase)) > 1.8))
				//1.2 - 1.8 depending on surface
		    	{
			    	System.out.println("WARNING!");
			    	Calendar cal = Calendar.getInstance();
			        System.out.println(dateFormat.format(cal.getTime()));
			        PrintWriter warnOut = new PrintWriter(new FileWriter("warning log.txt", true), true);
			        warnOut.println("Disturbance at:");
			        warnOut.println(dateFormat.format(cal.getTime()));
			        warnOut.println();
			        warnOut.close();
			        consec++;
			        if(consec >= 3)
			        {
			        	System.out.println("ALERT!");
				        java.awt.Toolkit.getDefaultToolkit().beep();
				        System.out.println(dateFormat.format(cal.getTime()));
				        PrintWriter alertOut = new PrintWriter(new FileWriter("alert log.txt", true), true);
				        alertOut.println("Disturbance at:");
				        alertOut.println(dateFormat.format(cal.getTime()));
				        alertOut.println();
				        alertOut.close();
				    	//runtime.exec("cmd.exe /c shutdown -s");
				        consec = 0;
			        }
		    	}
				else
				{
					consec = 0;
				}
				ax1 = 0;
				ay1 = 0;
				az1 = 0;
				lineCount = -1;
				runs++;
			}
			lineCount++;
		}
	}
}
