import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.*;

class Info{
	String Name;
	int Age;
	int RollNo;
	String Class;
	String Address;
}

class School extends Info {
	
	int total;
	Info[] list;
	
	void getTotal(int value) {
		total=value;
		list=new Info[total];
	}
	
	void readDetails() {		//getting the input from File
		try {
			File ip=new File("input.txt");
			File mainFile=new File("data.txt");
			
			Scanner read=new Scanner(ip);
			Writer data=new FileWriter(mainFile);
			
			mainFile.createNewFile();
			
				for(int j=0;j<total;j++) {
					String Sample=read.nextLine();
					String[] info=Sample.split("-",0);
					
					list[j]=new Info();
					list[j].Name=info[0];
					list[j].Age=Integer.parseInt(info[1]);
					list[j].RollNo=Integer.parseInt(info[2]);
					list[j].Class=info[3];
					
					data.append(Sample+'\n');
				}
			
				data.close();
				read.close();
				
			System.out.println("Input Taken SuccessFully");
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
	
	void writeDetails() {									//writing the details taken into a file
		System.out.println("Enter the file Name: ");
		Scanner sc=new Scanner(System.in);
		String fileName=sc.nextLine();
		
		File newFile=new File(fileName);
		
		try{
			newFile.createNewFile();
			System.out.println("File Created");
		}
		catch(IOException e) {
			System.out.println("File Already Present, Writing the Data into it");
		}
		
		try {
			Writer file=new FileWriter(fileName);
			
			for(int i=0;i<total;i++) {
				file.append(list[i].Name+'-'+Integer.toString(list[i].Age)+'-'+Integer.toString(list[i].RollNo)+'-'+list[i].Class+'\n');
			}
			file.close();
			
			System.out.println("Written detail to "+fileName);
			
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}

	void delete() {
		
		boolean flag=false;
		boolean deleted=false;
		try
		{
			File newFile=new File("temp.txt");
			File oldFile=new File("data.txt");

			if(newFile.createNewFile())
				System.out.println("New File Created");
			
			Scanner sc=new Scanner(System.in);
			
			this.Display();
			
			System.out.println("Roll Number: ");
			int skip=sc.nextInt();
			
			sc=new Scanner(oldFile);
			
			Writer fWriter=new FileWriter(newFile);
			
			for(int j=0;j<total;j++) {
				String Sample=sc.nextLine();
				String[] info=Sample.split("-",0);
				
				if(Integer.parseInt(info[2])!=skip)
				{
					fWriter.append(Sample+'\n');
				}
				else
					flag=true;
			}
			
			fWriter.close();
			
			fWriter=new FileWriter(oldFile);
			sc=new Scanner(newFile);
			
			while(sc.hasNextLine())
				fWriter.write(sc.nextLine()+'\n');
			
			if(flag)
				System.out.println("Deleted the Record SuccessFully");
			else
				System.out.println("No such Record Available");
			
			fWriter.close();
			
			File reName=new File("data.txt");
			
			fWriter.close();
			newFile.delete();
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
	
	void Display() {							//displaying the output to console
		try {
			File ip=new File("data.txt");
			Scanner read=new Scanner(ip);
				
			if(read.hasNextLine()) {				//checking if the records arent empty
			
				while(read.hasNextLine()) {			
					String Sample=read.nextLine();	//moving to the next line
					System.out.println(Sample);		//printing each record
				}
				
				read.close();
			}
			
			else 									//no records found
				System.out.println("The Records are Empty");
		}
													//no file available for Records
		catch(FileNotFoundException e) {
			System.out.println(e);
		}
	}
	
	void search() {
		try {
			
			Scanner read=new Scanner(System.in);
			System.out.println("Enter the Roll Number");
			int toSearch=read.nextInt();					//reading the roll number to delete
			
			boolean found=false;							
			File dataFile=new File("data.txt");				
			read=new Scanner(dataFile);						//initialize the Scanner to read the records
			
			String Sample;
			String[] info;
			
			while(read.hasNextLine()) {						//searching the records
				
				Sample=read.nextLine();						//moving to the next line
				info=Sample.split("-",0);					//splitting
				
				if(Integer.parseInt(info[2])==toSearch) {				//comparing
					System.out.println("\nRecord Found: "+Sample);
					found=true;
				}
			}
			
			if(!found)										//record not found 
				System.out.println("Not Found");
			
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
}

public class FileHandling {
	public static void main(String args[]) {

		School obj=new School();
		int choice=0;
		
		Scanner sc=new Scanner(System.in);
		
		while(choice<6) {
			System.out.println();

			System.out.println("1. Display");
			System.out.println("2. Update - Read From File");
			System.out.println("3. Write to a File");
			System.out.println("4. Delete Record");
			System.out.println("5. Search");
			System.out.println("6. Exit");
			System.out.print("Choice: ");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				obj.Display();
				break;
			case 2:
				System.out.print("\nTotal Entries: ");
				obj.getTotal(sc.nextInt());
				obj.readDetails();
				break;
			case 3:
				obj.writeDetails();
				break;
			case 4:
				obj.delete();
				break;
			case 5:
				obj.search();
				break;
			}
		}
	}
}


/*
Vedant Daigavane-19-11-FE
Rohit James-19-10-FE
Sameer Tulsani-19-1-FE
Sameer Memon-19-4-FE
Sufiya Sayyed-19-8-FE
Harshil Shah-19-7-FE
Aryan Sharma-19-15-FE
Mihir Kumar-19-5-FE
Shivani Jain-19-9-FE
Ritika Patil-19-3-FE
Shantanu Kundra-19-2-FE
Harshal Rane-19-13-FE
Tanushri Tare-19-12-FE
Sanskar Zanwar-19-6-FE
Karan Tiwari-19-14-FE
*/

	
/*
1. Display
2. Update - Read From File
3. Write to a File
4. Delete Record
5. Search
6. Exit
Choice: 1
Vedant Daigavane-19-11-FE
Rohit James-19-10-FE
Sameer Tulsani-19-1-FE
Sameer Memon-19-4-FE
Sufiya Sayyed-19-8-FE
Harshil Shah-19-7-FE
Aryan Sharma-19-15-FE
Mihir Kumar-19-5-FE
Shivani Jain-19-9-FE
Ritika Patil-19-3-FE
Shantanu Kundra-19-2-FE
Harshal Rane-19-13-FE
Tanushri Tare-19-12-FE
Sanskar Zanwar-19-6-FE
Karan Tiwari-19-14-FE

1. Display
2. Update - Read From File
3. Write to a File
4. Delete Record
5. Search
6. Exit
Choice: 2

Total Entries: 5
Input Taken SuccessFully

1. Display
2. Update - Read From File
3. Write to a File
4. Delete Record
5. Search
6. Exit
Choice: 1
Vedant Daigavane-19-11-FE
Rohit James-19-10-FE
Sameer Tulsani-19-1-FE
Sameer Memon-19-4-FE
Sufiya Sayyed-19-8-FE

1. Display
2. Update - Read From File
3. Write to a File
4. Delete Record
5. Search
6. Exit
Choice: 3
Enter the file Name: 
output.txt
File Created
Written detail to output.txt

1. Display
2. Update - Read From File
3. Write to a File
4. Delete Record
5. Search
6. Exit
Choice: 4
Vedant Daigavane-19-11-FE
Rohit James-19-10-FE
Sameer Tulsani-19-1-FE
Sameer Memon-19-4-FE
Sufiya Sayyed-19-8-FE
Roll Number: 
10
Deleted the Record SuccessFully

1. Display
2. Update - Read From File
3. Write to a File
4. Delete Record
5. Search
6. Exit
Choice: 1
Vedant Daigavane-19-11-FE
Sameer Tulsani-19-1-FE
Sameer Memon-19-4-FE
Sufiya Sayyed-19-8-FE

1. Display
2. Update - Read From File
3. Write to a File
4. Delete Record
5. Search
6. Exit
Choice: 5
Enter the Roll Number
4

Record Found: Sameer Memon-19-4-FE

1. Display
2. Update - Read From File
3. Write to a File
4. Delete Record
5. Search
6. Exit
Choice: 6

*/
