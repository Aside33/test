package myservlet.control; 
import mybean.data.*; 
import java.sql.*; 
import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
public class upload extends HttpServlet {   
	public void init(ServletConfig config) throws ServletException  { 
		super.init(config);       
		try {  Class.forName("com.mysql.jdbc.Driver"); 
          }        catch(Exception e){}      }    
	public  void  doPost(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException    {  
		HttpSession session=request.getSession(true);       
		Login login=(Login)session.getAttribute("login"); //��ȡ�û���¼ʱ��Javabean        
		boolean ok=true;         
		if(login==null)  { 
			ok=false;           
			response.sendRedirect("login.jsp");             //�ض��򵽵�¼ҳ��        
			}  if(ok==true)  {  
				String logname=login.getLogname();           
				uploadFileMethod(request,response,logname);    //�����ϴ��ļ�        
				}    }    
	public void uploadFileMethod(HttpServletRequest request,HttpServletResponse response, String logname) 
			throws ServletException,IOException    {  
		UpLoadFile upFile=new UpLoadFile();        
		String backNews="";       
		try{  HttpSession session=request.getSession(true);             
		request.setAttribute("upFile",upFile);             
		String tempFileName=(String)session.getId();             
		File f1=new File(tempFileName);             
		FileOutputStream o=new FileOutputStream(f1);             
		InputStream in=request.getInputStream();             
		byte b[]=new byte[10000];             
		int n;             
		while( (n=in.read(b))!=-1)  {   
			o.write(b,0,n);                 
			}             
		o.close();             
		in.close();             
		RandomAccessFile random=new RandomAccessFile(f1,"r");             
		int second=1;   //����f1�ĵ�2�У���ȡ���ϴ��ļ������֣�            
		String secondLine=null;             
		while(second<=2)  { 
			secondLine=random.readLine();                  
			second++;                } //��ȡ��2����Ŀ¼����'\'�����ֵ�λ�ã�            
		int position=secondLine.lastIndexOf('\\'); //��ȡ�ļ����� 
 

            String fileName=secondLine.substring(position+1,secondLine.length()-1);             
            byte  cc[]=fileName.getBytes("ISO-8859-1");             
            fileName=new String(cc);             
            fileName=fileName.replaceAll(" ","");             //�ļ��Ƿ�����ĸ����������ж�����             
            String checkedStr=fileName.substring(0,fileName.indexOf("."));            
            boolean isLetterOrDigit=true;              
            for(int i=0;i<checkedStr.length();i++)   {  
            	char c=checkedStr.charAt(i);                
            	if(!((c<='z'&&c>='a')||(c<='Z'&&c>='A')||(c<='9'&&c>='0'))) {  
            		isLetterOrDigit=false;                     
            		break;          }    }             
            if(isLetterOrDigit==false)             {  
            	response.sendRedirect("upload.jsp");  //�ض���upload.jspҳ��            
            	} 
            //�����ļ������ϴ��ļ����ӻ�Ա��Ϊǰ׺��             
            String savedFileName=logname.concat(fileName);              
            random.seek(0);              
            long  forthEndPosition=0;  //��ȡ��4�лس����ŵ�λ��             
            int forth=1;            
            while((n=random.readByte())!=-1&&(forth<=4))    {  if(n=='\n')                    
            {  forthEndPosition=random.getFilePointer();  
            forth++;                     }                }             //���ݿͻ��ϴ��ļ������֣������ļ�������̣�           
            File dir=new File("D:/javawork/workspace/adver/WebRoot/image");             
            dir.mkdir();             //����ɾ���û����ϴ�����ͼ���ļ���             
            File file[]=dir.listFiles();             
            for(int k=0;k<file.length;k++)    {  
            	if(file[k].getName().startsWith(logname))                  
            		file[k].delete();             }             
            File savingFile= new File(dir,savedFileName);  //��Ҫ�±�����ϴ��ļ�              
            RandomAccessFile random2=new RandomAccessFile(savingFile,"rw");              
            random.seek(random.length());             
            long endPosition=random.getFilePointer();             
            long mark=endPosition;             
            int j=1;            //ȷ�����ļ�f1�а����ͻ��ϴ����ļ������ݵ����λ�ã���������6��:  
            
 

            while((mark>=0)&&(j<=6))              {   
            	mark--;                  
            	random.seek(mark);                  
            	n=random.readByte();                  
            	if(n=='\n')            
            	{    endPosition=random.getFilePointer();     j++;                 }              }          
            random.seek(forthEndPosition);           
            long startPoint=random.getFilePointer();           
            while(startPoint<endPosition-1)             { 
            	n=random.readByte();               
            	random2.write(n);                
            	startPoint=random.getFilePointer();             }           
            random2.close();           
            random.close();           
            String uri="jdbc:mysql://localhost:3306/tingzi?useUnicode=true&characterEncoding=utf-8";           Connection con=DriverManager.getConnection(uri,"root","123456");           Statement sql=con.createStatement();           ResultSet rs=sql.executeQuery("SELECT * FROM member where logname = '"+logname+"'");            if(rs.next())           {  if(isLetterOrDigit)              { int mm=sql.executeUpdate("UPDATE member SET pic= '"+savedFileName+"' where logname = '"+logname+"'");                if(mm!=0)                { backNews=fileName+"�ɹ��ϴ�";                  upFile.setFileName(fileName);                  upFile.setSavedFileName(savedFileName);                  upFile.setBackNews(backNews);                }              }            }           con.close();            f1.delete();          }      catch(Exception exp)         {  backNews=""+exp;            upFile.setBackNews(backNews);         }      try{  RequestDispatcher dispatcher=  request.getRequestDispatcher("showUploadMess.jsp");//ת�� 

           dispatcher.forward(request, response);   }     
            catch(Exception ee){}     }   
public  void  doGet(HttpServletRequest request,HttpServletResponse response)                          
		throws ServletException,IOException     {   doPost(request,response);     } } 
		