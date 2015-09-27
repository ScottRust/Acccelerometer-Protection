package com.scottocus.accelerometer;

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
		Process process = runtime.exec("cmd.exe /c gcdcTool --raw", null, new File("C:\\Users\\user1\\Desktop\\gcdcTool_Win7-8"));
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String line;
		int ax1 = 0, ay1 = 0, az1 = 0, timeFix, lineCount = 0;
		
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
				ax1 += Integer.parseInt(line.substring(11 + timeFix, 12 + timeFix));
			}
			else if (line.substring(13 + timeFix, 14 + timeFix).equals(","))
			{
				ax1 += Integer.parseInt(line.substring(11 + timeFix, 13 + timeFix));
			}
			else if (line.substring(14 + timeFix, 15 + timeFix).equals(","))
			{
				ax1 += Integer.parseInt(line.substring(11 + timeFix, 14 + timeFix));
			}
			else if (line.substring(15 + timeFix, 16 + timeFix).equals(","))
			{
				ax1 += Integer.parseInt(line.substring(11 + timeFix, 15 + timeFix));
			}
			else
			{
				ax1 += Integer.parseInt(line.substring(11 + timeFix, 16 + timeFix));
			}
			
			if (line.substring(line.length() - 8, line.length() - 7).equals(",") && !(line.substring(line.length() - 6, line.length()).contains(",")))
			{
				az1 += Integer.parseInt(line.substring(line.length() - 6, line.length()));
			}
			else if (line.substring(line.length() - 7, line.length() - 6).equals(",") && !(line.substring(line.length() - 5, line.length()).contains(",")))
			{
				az1 += Integer.parseInt(line.substring(line.length() - 5, line.length()));
			}
			else if (line.substring(line.length() - 6, line.length() - 5).equals(",") && !(line.substring(line.length() - 4, line.length()).contains(",")))
			{
				az1 += Integer.parseInt(line.substring(line.length() - 4, line.length()));
			}
			else if (line.substring(line.length() - 5, line.length() - 4).equals(",") && !(line.substring(line.length() - 3, line.length()).contains(",")))
			{
				az1 += Integer.parseInt(line.substring(line.length() - 3, line.length()));
			}
			else if (line.substring(line.length() - 4, line.length() - 3).equals(","))
			{
				az1 += Integer.parseInt(line.substring(line.length() - 2, line.length()));
			}
			else if (line.substring(line.length() - 3, line.length() - 2).equals(","))
			{
				az1 += Integer.parseInt(line.substring(line.length() - 1, line.length()));
			}
			else
			{
				az1 += Integer.parseInt(line.substring(line.length() - 7, line.length()));
			}
			
		    /**if(lineCount == 500)
		    {
		    	if(Math.abs(ax1 - -500) < 200 || Math.abs(ax1 - -500) > 500)
		    	{
		        	java.awt.Toolkit.getDefaultToolkit().beep();
			    	System.out.println("ALERT!");
			    	Calendar cal = Calendar.getInstance();
			        System.out.println(dateFormat.format(cal.getTime()));
			        PrintWriter out = new PrintWriter(new FileWriter("log.txt", true), true);
			        out.println("Disturbance at:");
			        out.println(dateFormat.format(cal.getTime()));
			        out.println();
			        out.close();
			    	//runtime.exec("cmd.exe /c shutdown -s");
			    	ax1 = 0;
			    	az1 = 0;
		    	}
		    }**/
			
			if(lineCount == 500)
			{
				System.out.println(Math.abs(ax1/** - -500**/));
				System.out.println(Math.abs(az1/** - -1016000**/));		        
				ax1 = 0;
				az1 = 0;
				lineCount = -1;
			}
			lineCount++;
		}
	}
}
