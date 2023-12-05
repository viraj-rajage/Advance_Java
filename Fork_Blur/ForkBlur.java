//package Advance_Java.Fork_Blur;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import javax.imageio.ImageIO;

public class ForkBlur extends RecursiveAction{
    private final int [] Source; 
    private final int Start; 
    private final int Lenght; 
    private final int [] Destination; 
    private final int BlurWidth =13;

    public ForkBlur(int[] src,int start,int lenght,int[] dest){
        Source = src; 
        Start = start; 
        Lenght = lenght; 
        Destination = dest;
    } 
    protected void ComputeDirectory(){
        int sidePixels = (BlurWidth -1)/2; 
        for(int index= Start; index<Start+Lenght;index++){
            float rt =0 ,gt=0,bt=0; 
            for(int i= -sidePixels;i<=sidePixels;i++){
                int mindex = Math.min(Math.max(i+ index, 0),Source.length -1);
                int pixel = Source[mindex]; 
                rt += (float)((pixel & 0x00ff0000)>>16)/BlurWidth; 
                rt += (float)((pixel & 0x0000ff00)>>8)/BlurWidth; 
                rt += (float)((pixel & 0x000000ff))/BlurWidth;        
            }
            int dpixel;
            dpixel = (0xff000000) 
                | (((int)rt)<<16)
                | (((int)gt)<<8)
                | (((int)bt));
                Destination[index]= dpixel;          
        }
    }  
    protected static int sThreShold=10000; 
    @Override 
    protected void compute(){
        if(Lenght < sThreShold){
            ComputeDirectory(); 
            return;
        } 
        int split = Lenght/2;  
        invokeAll(new ForkBlur(Source,Start,split,Destination),
        new ForkBlur(Source, Start + split, Lenght - split, Destination)); 
    }  
    public static void main(String[] args) throws Exception{
        String srcNmae = "C:\\Users\\viraj\\OneDrive\\Desktop\\Advance_Java\\Fork_Blur\\V.png";
        File srcFile = new File(srcNmae); 
        BufferedImage image = ImageIO.read(srcFile); 
        System.out.println("Source Image"+srcNmae);
        BufferedImage BlurredImage =  blur(image); 
        String dstName = "Blurred-V.png"; 
        File destFile = new File(dstName); 
        ImageIO.write(BlurredImage,"png", destFile); 
        System.out.println("Output Image:"+dstName); 
    } 
    public static BufferedImage blur(BufferedImage srcImage){
        int w = srcImage.getWidth(); 
        System.out.println("W:"+w); 
        int h = srcImage.getHeight(); 
        System.out.println("H:"+h); 
        int[] src = srcImage.getRGB(0,0,w,h,null,0,w);
        System.out.println("src[0]"+src[0]);
        System.out.println("src[src.lenght -1 ]:"+ src[src.length -1]); 
        int[] dst = new  int[src.length];
        System.out.println("src.length: "+ src.length);
        System.out.println("Array size is:"+src.length);
        System.out.println("Threshold is:"+sThreShold);
         
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println(Integer.toString(processors)+"Processor"+(processors != 1 ? "s are":" is ")
        +"Available");
         
        ForkBlur bi = new ForkBlur(src,0,src.length,dst);
        ForkJoinPool pool = new ForkJoinPool();
        long startTime= System.currentTimeMillis(); 
        pool.invoke(bi);
        long endTime = System.currentTimeMillis();
        System.out.println("Image blur took"+(endTime - startTime)+"milliseconds.");
        BufferedImage dstImage = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
        dstImage.getRGB(0,0,w,h,dst,0,w);
        return dstImage;
    }}
