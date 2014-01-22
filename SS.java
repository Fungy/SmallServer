import java.io.*;import java.net.*;import java.util.*;public class SS{public static void main(final String[] a)throws
 Exception{ServerSocket s=new ServerSocket(9999);while(true){try{final Socket c=s.accept();new Thread(){public void run(
){try{OutputStream o=c.getOutputStream();String u=new DataInputStream(c.getInputStream()).readLine();u=u.substring(5, u.
indexOf(" HTTP/"));String t=u.substring(u.lastIndexOf(".")+1);String e="image/"+t;if("html".equalsIgnoreCase(t))e="text"
+"/html";String k="";try{k=a[0];}catch(Exception n){}FileInputStream f=new FileInputStream(k+u);String l="\r\n";o.write(
("HTTP/1.1 200 OK"+l+"Date:"+new Date()+l+"Server:SS"+l+"Content-Type: "+e+"; charset=UTF-8"+l+"Content-Length:"+f.
available()+l+l).getBytes());byte[] b=new byte[1024];int y;while((y=f.read(b))>0){o.write(b,0,y);}o.flush();c.close();}
catch(Throwable t){t.printStackTrace();};}}.start();}catch (Throwable t){t.printStackTrace();}}}}