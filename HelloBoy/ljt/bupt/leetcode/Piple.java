package ljt.bupt.leetcode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
class producer extends Thread{
    DataOutputStream d1;
    int i=0;
    Random r=new Random();
    producer(OutputStream out){
        d1=new DataOutputStream(out);
    }
    public void run(){
        
        try{
            while(!Thread.interrupted()){
            	synchronized(d1){
            		if(i<10){
            			double num=r.nextDouble()*10;
                        System.out.println("the num is "+num);
                        d1.writeDouble(num);
                        d1.flush();
                        i++;
                        sleep(500);
            		}else{
            			Thread.yield();
            		}
            	}
            }
        }catch(IOException e){
            System.out.println("this is a output IOExecption");
            e.printStackTrace();
        }catch(InterruptedException e){
            System.out.println("this is a interruprException");
            //e.printStackTrace();
        }
    }
}
class consumer extends Thread{
    DataInputStream d2;
    int count=0;
    double sum=0;
    consumer(InputStream in){
        d2=new DataInputStream(in);
    }
    public void run(){
        try{
        	while(!Thread.interrupted()){
        		synchronized(d2){
        			if(d2.available()>0){
                		double num=d2.readDouble();
                        sum+=num;
                        count++;
                        System.out.println("sum is "+sum);
                        sleep(500);
        			}else{
        				Thread.yield();
        			}
        		}
        	}
        }catch(IOException e){
            System.out.println("this is a input IOException");
            e.printStackTrace();
        }catch(InterruptedException e){
        	System.out.println("this is a interruprException");
        }
    }
}
public class Piple{
    public static void main(String[] args){
    	PipedInputStream p1=null;
    	PipedOutputStream p2=null;
    	ExecutorService exec=Executors.newCachedThreadPool();
        try{
            p1=new PipedInputStream();
            p2=new PipedOutputStream(p1);
            producer p=new producer(p2);
            consumer c=new consumer(p1);
            exec.execute(p);
            exec.execute(c);
            Thread.sleep(5000);
            
        }catch(IOException e){
            System.out.println("this is main function Exception 1");
            e.printStackTrace();
        }catch(InterruptedException e){
        	System.out.println("this is main InterruptedException 1");
        	e.printStackTrace();
        }finally{
        	if(p1!=null){
        		try {
					p1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        	if(p2!=null){
        		try {
					p2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        }
        exec.shutdownNow();
    }
}