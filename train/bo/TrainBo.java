package com.ibm.train.bo;

import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.ibm.train.bean.Passenger;
import com.ibm.train.bean.Train;
import com.ibm.train.dao.TrainDAO;
import com.ibm.train.exception.Invalid_Train_Exception;


public class TrainBo {
	TrainDAO dao=new TrainDAO();
	Train train=null;
	public Train findTrain(int tnum)
	{
		return dao.findTrain(tnum);
		
	}
	public List<Train> findAllTrains(String source,String dest)
	{
		return dao.findAll(source,dest);
		
	}
	
	public boolean checkDate(String travelDate) throws ParseException
	{
		SimpleDateFormat dfm = new SimpleDateFormat("dd/MM/yyyy");
		try
		{
			Date d = dfm.parse(travelDate);
			 Date currentDate = new Date();
			 if(d.before(currentDate))
			 {
				 return false;
			 }
		}
		catch (ParseException e)
		{
			
		}
		return true;
	}
	

	
	public static double calcTotalFare(List<Passenger> p){
		

	
		double total=0;
		
		for(Passenger psngr: p){
			
			 total+= TrainBo.calcPassengerFare(psngr);
		   
		}
		return total;
		
	}


	public static  double calcPassengerFare(Passenger p)
	{
		
			double sum=0;
		
			int age=p.getAge();
			double price= p.getFare();
			String gender=p.getGender();
			
			if(age<=12)
			{
				sum=(price*0.5);
				System.out.println(sum);
			}
			else if(age>=60)
			{
				sum=(price*0.6);
			}	
			else if(gender.equalsIgnoreCase("f"))
			{
				sum=(price*0.75);
			}
			else
				{
				sum=price;
				}
			
			return sum;
		
	}
	
		
	
	public static String  generatePNR(Train t, String travelDate)
	{
		String[] str= travelDate.split("/");
		
		int day= Integer.parseInt(str[0]);
		int month= Integer.parseInt(str[1]);
		int year= Integer.parseInt(str[2]);
		
		String pnr=new String();

		int counter = 100;
		pnr= t.getSource().charAt(0)+""+t.getDestination().charAt(0)+""+str[2]+str[1]+str[0]+counter;
		counter++;

		t.setPnr(pnr);
		
     return pnr;
	}

	public boolean registerUser(Train t, List<Passenger> list, String travelDate, int n) throws ParseException
	{      
		train=t;
		
		TrainDAO tdao= new TrainDAO();
		boolean flag=false;

		try{
			//Generation of pnr
			generatePNR(train, travelDate);
			

			
			writeTicket(train,list,travelDate,n);
	
			
		
		}catch (Exception e) {

			System.err.println(e.getMessage());
			return false;
		}
		return flag;
		

	}

	public static void writeTicket(Train t,List<Passenger> p,String travelDate, int n) throws IOException
	{
		

		StringBuilder sb=new StringBuilder();
		sb.append("PNR\t : "+t.getPnr()+"\n");
		sb.append("Train No.\t : "+t.getTrainNo()+"\n");
		sb.append("Train Name\t : "+t.getTrainName()+"\n");
		sb.append("From\t : "+t.getSource()+"\n");
		sb.append("To\t : "+t.getDestination()+"\n");

		sb.append("Travel Date\t : "+travelDate);

		sb.append("\n\nPassengers:\n");
		sb.append("Name \t\tAge \tGender \t\tFare \n");
		for (Passenger passenger:p) 
		{
             double indFare=calcPassengerFare(passenger);
             passenger.setFare(indFare);
			sb.append(passenger.getName()+" \t"+passenger.getAge()+" \t\t"+passenger.getGender()+" \t\t"+passenger.getFare()+"\n");
		}
		
		sb.append("Total Price: "+calcTotalFare(p));
		
		File f1=new File("C:\\WebAppSpace\\TrainApp",t.getPnr()+".txt");
		f1.createNewFile();

		try(FileWriter fos=new FileWriter(f1); 
				BufferedWriter bos=new BufferedWriter(fos);)
		{

			bos.write(sb.toString());
			bos.flush();
		}
		catch(Exception io)
		{
			System.out.println(io.getMessage());
		}

	}
}

	
	


