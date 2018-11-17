package com.cg.ams.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.ams.bean.AssetAllocationBean;
import com.cg.ams.bean.AssetsBean;
import com.cg.ams.bean.EmployeeBean;
import com.cg.ams.bean.UserMasterBean;
import com.cg.ams.exceptions.AssetException;
import com.cg.ams.service.IUserService;
import com.cg.ams.service.UserServiceImpl;

public class MainClient {
	
	 static Scanner scanner=new Scanner(System.in);
	 static IUserService userservice=new UserServiceImpl();
	 static AssetAllocationBean asstbean= new AssetAllocationBean();
	 static AssetsBean asset=new AssetsBean();
	 static	 EmployeeBean employeebean=new EmployeeBean();
	 
		
	public static void main(String[] args) throws AssetException {
			int adminFlag=0;	
			int input;
	do{
		System.out.println("\n"+"Login AS : "+"\n"+"1. Manager"+"\n"+"2. Administrator"+"\n"+"3. To Exit");
		
		input=scanner.nextInt();
		switch (input) {
		case 1 : UserMasterBean bean = loginAttempt();
		bean.setUserType("Manager");

		boolean result =   userservice.LoginValidate(bean);
		if(result)
		{
			System.out.println("1. Allocate the Assets to an Employee"+"\n"+"2. DeAllocate the Assets from an Employee"+"\n"+"3. View Request Status");
			int choice=scanner.nextInt();
			
			
			if(choice==1)
			{
				System.out.println("Enter the Employee id.");
				int empId=scanner.nextInt();
				scanner.nextLine();
				System.out.println("enter asset name");
				String assetname=scanner.nextLine();
				employeebean.setEmpNo(empId);
				asstbean.setAssetName(assetname);
				int res=userservice.Allocate(empId,assetname);
				asstbean.setReqId(res);
				
				if(res>0)
				{
					
					System.out.println("Allocation request generated for employee number: "+empId+" with request id: "+asstbean.getReqId());
					adminFlag=1;
				}
				else {
					System.out.println("Request can not be generated at the moment");
				}
			
			
			}
			if(choice==2)
			{
				System.out.println("Enter the Employee id.");
				int empId=scanner.nextInt();
				scanner.nextLine();
				System.out.println("enter asset name");
				/*   */String assetname=scanner.nextLine();
				employeebean.setEmpNo(empId);
				int res=userservice.Allocate(empId,assetname);
				asstbean.setReqId(res);
				if(res>0)
				{
					
					System.out.println("DeAllocation request generated for employee number: "+empId+" with request id: "+asstbean.getReqId());
					adminFlag=-1;
				}
				else {
					System.out.println("Request can not be generated at the moment");
				}
			
			
			
				
			}
			
			if(choice==3)
			{
				System.out.println("Enter the Request Id to Know the Status");
				int reqId=scanner.nextInt();
				userservice.reqStatus(reqId);
				
				
			}
			
			
		}else
		{
			System.err.println("Invalid Manager Login");
		}
		        
		        

			break;
		case 2:
			UserMasterBean bean1 = loginAttempt();
			bean1.setUserType("Admin");
			
					
			boolean result1 =   userservice.LoginValidate(bean1);
			if(result1)
			{
				System.out.println("1.Insert");
				System.out.println("2.view requests");
				
				int option=scanner.nextInt();
				
				switch(option)
				{
				case 1:
					AssetsBean assetbean = new AssetsBean();
					System.out.println("enter asset id");
					int assetId=scanner.nextInt();
					scanner.nextLine();
					
					System.out.println("enter assetName");
					String name=scanner.nextLine();
					System.out.println("enter quantity");
					int quantity=scanner.nextInt();
					scanner.nextLine();
					System.out.println("enter status");
					String status=scanner.nextLine();
					assetbean.setAssetId(assetId);
					assetbean.setAssetName(name);
				    assetbean.setQuantity(quantity);
                    assetbean.setStatus(status);				
				    int insert =userservice.insertDetails(assetbean);
				    System.out.println(insert+" asset inserted");
					break;
				case 2:
					if(adminFlag==1)
						
					{
					System.out.println("Request to allocate asset: "+asstbean.getAssetName()+" to employye Id: "+employeebean.getEmpNo() );
					
					
					int Quantity=userservice.viewQuantity(asstbean.getAssetName());
					//System.out.println(Quantity);
					if(Quantity>0)
					{
						System.out.println(asstbean.getAssetName()+"is approved to" +employeebean.getEmpNo());
						int quantity1=userservice.decrementQuantity(asstbean.getAssetName());
						//System.out.println(quantity);
						
					}
					else
					{
						int delete=userservice.deleteAsset(asstbean.getAssetName());
						System.out.println(delete);
					    System.out.println("Rejected");
					
					
					
					}
					
					
					
					}
					System.out.println(asstbean.getAssetName());
					System.out.println("Request to Deallocate asset: "+asstbean.getAssetName()+" to employye Id: "+employeebean.getEmpNo() );
					int thanu=userservice.increaseQuantity(asstbean.getAssetName());
					
					break;
				
				}
			
			}else
			{
				System.out.println("Invalid");
			}
		break;
		}
	}while(input==1 || input==2);
	}
	public static  UserMasterBean  loginAttempt(){

		int loginAttempts=0;
		UserMasterBean bean= null;
		//while( loginAttempts<=3)
		//{
			scanner.nextLine();
			System.out.println("Username: ");
			String username;
			username=scanner.nextLine();
			System.out.println("Password: ");
			String password;
			password=scanner.nextLine();
			/*loginAttempts++;*/
		
			
	     bean = new UserMasterBean(username, password);
		//}
		
		
		return bean;
		
	}










}
