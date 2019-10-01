package by.it.zavadski.jd01_14;

import java.io.*;

public class TaskA {
    private static String filesPlace(Class <?> className){
       String path= System.getProperty("user.dir")+ File.separator+"src"+File.separator;
       String classDirectory=className.getName().replace(className.getSimpleName(),"").replace(".",File.separator);
       return path+classDirectory;
    }
    public static void main(String[] args) throws IOException {
        DataOutputStream dataOutputStream=null;
        try{
            dataOutputStream=new DataOutputStream((new BufferedOutputStream(new FileOutputStream(filesPlace(TaskA.class)+"dataTaskA.bin"))));
            for (int i = 0; i <20 ; i++) {
                dataOutputStream.writeInt((int) (Math.random() * 25));
            }
        } catch (IOException e) {
            e.printStackTrace();}
        finally {
            if(dataOutputStream!=null){
                try{
                    dataOutputStream.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        try (DataInputStream inputStream=new DataInputStream(new BufferedInputStream(new FileInputStream(filesPlace(TaskA.class)+"dataTaskA.bin")));
             PrintWriter out=new PrintWriter(new FileWriter(filesPlace(TaskA.class)+"resultTaskA.txt"))
        ){
        double sum=0;
        double count=0;
        while (inputStream.available()>0){
            int i=inputStream.readInt();
            System.out.print(i+" ");
            out.print(i+" ");
            sum=sum+i;
            count++;
        }
            System.out.println("\navg="+sum/count);
        out.println("\navg="+sum/count);
        }

        catch (IOException e){
            e.printStackTrace();
        }

    }
}
