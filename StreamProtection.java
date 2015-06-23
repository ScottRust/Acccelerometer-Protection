package com.scottocus.accelerometer;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;

public class StreamProtection
{
	public static void main(String[] args) throws IOException
	{
		//Starts HID data pipe stream, reads data from the stream 
		Runtime runtime = Runtime.getRuntime(); 
		Process process = runtime.exec("cmd.exe /c gcdcTool --raw", null, new File("C:\\Users\\user1\\Desktop\\gcdcTool_Win7-8"));
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line, prevLine;
		int ax1, ax2, timeFix, threshhold;
		threshhold = 100;
		
		//Reads first line of data stream to initialize an updating comparison variable
		prevLine = br.readLine();
		//Initializes a variable which fixes later readings according to time change in output
		if (prevLine.substring(2, 3).equals("."))
		{
			timeFix = 0;
		}
		else if (prevLine.substring(3, 4).equals("."))
		{
			timeFix = 1;
		}
		else if (prevLine.substring(4, 5).equals("."))
		{
			timeFix = 2;
		}
		else if (prevLine.substring(5, 6).equals("."))
		{
			timeFix = 3;
		}
		else if (prevLine.substring(6, 7).equals("."))
		{
			timeFix = 4;
		}
		else
		{
			timeFix = 5;
		}
		
		//Converts string output of x-axis readings to integer based on length of digits in number
		if (prevLine.substring(12 + timeFix, 13 + timeFix).equals(","))
		{
			ax1 = Integer.parseInt(prevLine.substring(11 + timeFix, 12 + timeFix));
		}
		else if (prevLine.substring(13 + timeFix, 14 + timeFix).equals(","))
		{
			ax1 = Integer.parseInt(prevLine.substring(11 + timeFix, 13 + timeFix));
		}
		else if (prevLine.substring(14 + timeFix, 15 + timeFix).equals(","))
		{
			ax1 = Integer.parseInt(prevLine.substring(11 + timeFix, 14 + timeFix));
		}
		else if (prevLine.substring(15 + timeFix, 16 + timeFix).equals(","))
		{
			ax1 = Integer.parseInt(prevLine.substring(11 + timeFix, 15 + timeFix));
		}
		else
		{
			ax1 = Integer.parseInt(prevLine.substring(11 + timeFix, 16 + timeFix));
		}
		
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
			else
			{
				timeFix = 5;
			}
			
			//Converts string data to integer data for different lengths of number
			if (line.substring(12 + timeFix, 13 + timeFix).equals(","))
			{
				ax2 = Integer.parseInt(line.substring(11 + timeFix, 12 + timeFix));
			}
			else if (line.substring(13 + timeFix, 14 + timeFix).equals(","))
			{
				ax2 = Integer.parseInt(line.substring(11 + timeFix, 13 + timeFix));
			}
			else if (line.substring(14 + timeFix, 15 + timeFix).equals(","))
			{
				ax2 = Integer.parseInt(line.substring(11 + timeFix, 14 + timeFix));
			}
			else if (line.substring(15 + timeFix, 16 + timeFix).equals(","))
			{
				ax2 = Integer.parseInt(line.substring(11 + timeFix, 15 + timeFix));
			}
			else
			{
				ax2 = Integer.parseInt(line.substring(11 + timeFix, 16 + timeFix));
			}
			
			//Compares previous line x-axis data to current line, if difference is greater than 'threshhold' prints "ALERT!" to console
		    if (Math.abs(ax1 - ax2) > threshhold)
		    {
		    	System.out.println("ALERT!");
		    	//runtime.exec(cmd.exe /c shutdown -s);
		    }
		    ax1 = ax2; //current line data into previous line data
		}
	}
}
