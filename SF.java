import java.io.*;import java.net.*;public class SF{static int j=1,c=21;static String a="",b ="127,0,0,1";public static
void main(String[]d)throws Exception{try{a=d[0];b=d[1].replace(".",",");c=Integer.parseInt(d[2]);}catch(Exception e){}
ServerSocket e=new ServerSocket(c);while(true){try{final Socket q=e.accept();new Thread(){public void run(){try{final
OutputStream o=q.getOutputStream();final OutputStream[]f=new OutputStream[1];final InputStream[]g=new InputStream[1];
String k="";DataInputStream m=new DataInputStream(q.getInputStream());l(o,"200");String l;while((l=m.readLine())!=null){
if(t(l,"USER")){l(o,"230");}if(t(l,"SYST")){l(o,"215 UNIX");}if(t(l,"OPTS")){l(o,"200");}if(t(l,"PWD")){l(o,"257 \"/\"")
;}if(t(l,"TYPE")){l(o,"200");}if(t(l,"SIZE")){File p=new File(a +l.substring(5));if(p.isDirectory()||!p.exists()){l(o,
"550");}else{o.write(("213 "+p.length()+"\r\n").getBytes());}}if(t(l,"CWD")){k=l.substring(4);if(new File(a+k).
isDirectory()){l(o,"250");}else{l(o,"550");}}if(t(l,"QUIT")){l(o,"221");o.close();break;}if(t(l,"RETR")){l(o,"125");
while(f[0]==null){}try{FileInputStream q=new FileInputStream(a+"/"+l.substring(5));i(q,f[0]);q.close();f[0].close();l(o,
"226");}catch(Exception e){l(o,"550");}}if(t(l,"PASV")){j+=1;final int v=j;new Thread(){public void run(){try{
ServerSocket serverSocket=new ServerSocket(13056+v);Socket u=serverSocket.accept();f[0]=u.getOutputStream();g[0]=u.
getInputStream();}catch(Exception e){f[0]=null;g[0]=null;}}}.start();Thread.sleep(111);l(o,"227 ("+b+",51,"+v+ ").");
Thread.sleep(111);}if(t(l,"STOR")){l(o,"125");while(g[0]==null){};FileOutputStream I=new FileOutputStream(a+l.substring(
5));i(g[0],I);I.close();l(o,"226");}if(t(l,"MKD")){new File(a+l.substring(4)).mkdirs();l(o,"250");}if(t(l,"SITE")){l(o,
"200");}if(t(l,"DELE")){new File(a+l.substring(5)).delete();l(o,"200");}if(t(l,"RMD")){new File(a+l.substring(5)).delete
();l(o,"200");}if(t(l,"LIST")){File[]y=new File(a+k).listFiles();if(y==null){}else{l(o,"125");while(f[0]==null){}for(
File n:y){if(n.isHidden())continue;f[0].write(String.format("%s   1 %-10s %-10s %10d Jan  1  11:10 %s\r\n",(n.
isDirectory()?"d":"-")+"rwxrwxrwx","2","1003",n.length(),n.getName()).getBytes());}f[0].close();l(o,"226");}}}}catch(
Throwable t){};}}.start();}catch(Throwable t){}}}static boolean t(String l,String i){return l.startsWith(i);}static void
i(InputStream i,OutputStream t)throws Exception{byte[]l=new byte[1111];int bytesRead;while((bytesRead=i.read(l))>0){t.
write(l,0,bytesRead);}}static void l(OutputStream t,String l)throws Exception{t.write((l+" \r\n").getBytes());}}
