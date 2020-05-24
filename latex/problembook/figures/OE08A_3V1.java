                  /*  File:  OE08A_3.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE08A_3 extends Template {

     static {templateClass = new OE08A_3() ; }

     public void setup() {
          filePrefix = "OE08A_3" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 5 ;      // in inches
          ysize = 5 ;   // in inches. 
          xmin = -10 ;
          xmax = 160 ;
          ymin = -10 ;
          ymax = 160 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;
          canvas.append( new fPsWrite(Black+"\n")) ;


          double scale = 2 ;
          
          double[] xlist = {10, 20, 30, 40, 50, 60, 70,
                            80, 90, 100, 110, 120, 130, 140, 150} ;
          double[] ylist = {10, 20, 30, 40, 50, 60, 70,
                            80, 90, 100, 110, 120, 130, 140, 150} ;
          int nx = xlist.length ;
          int ny = ylist.length ;
          
          double dth = 15 ;
          double[][] th =  { {0, 0, 0, 0, 0, 0, 0, 0,
                              0, 0, 0, 0, 0, 0, 0} ,
                             {0, 0, 0, 0, 0, 0, 0, 0,
                              0, 0, 0, 0, 0, 0, 0} ,
                             {0, 0, 0, 0, 0, 0, 0, 0,
                              0, 0, 0, 0, 0, 0, 0} ,
                             {0, 0, 0, 0, 0, 0, 0, 0,
                              0, 0, 0, 0, 0, 0, 0} ,   
                             {0, 0, 0, 0, 0, 0, 0, 0,
                              0, 0, 0, 0, 0, 0, 0} ,
                             {0, 0, 0, 0, 0, 0, 0, 0,
                              0, 0, 0, 0, 0, 0, 0} ,
                             {0, 0, 0, 0, 0, 0, 0, 0,
                              0, 0, 0, 0, 0, 0, 0} ,
                             {0, 0, 0, 0, 0, 0, 0, 0,
                              0, 0, 0, 0, 0, 0, 0} ,
                             {0, 0, 0, 0, 0, 0, 0, 0,
                              0, 0, 0, 0, 0, 0, 0} ,   
                             {0, 0, 0, 0, 0, 0, 0, 0,
                              0, 0, 0, 0, 0, 0, 0} ,
                             {0, 0, 0, 0, 0, 0, 0, 0,
                              0, 0, 0, 0, 0, 0, 0} ,
                             {0, 0, 0, 0, 0, 0, 0, 0,
                              0, 0, 0, 0, 0, 0, 0} ,
                             {0, 0, 0, 0, 0, 0, 0, 0,
                              0, 0, 0, 0, 0, 0, 0} ,
                             {0, 0, 0, 0, 0, 0, 0, 0,
                              0, 0, 0, 0, 0, 0, 0} ,   
                             {0, 0, 0, 0, 0, 0, 0, 0,
                              0, 0, 0, 0, 0, 0, 0} 
                            };
     // row 1
           for (int j=0; j<9 ; j++) {
               th[14][j] = 225 - j*4.5 ;
           }

           for (int j=9; j<nx ; j++) {
               th[14][j] = 180 - (j-9)*90/5.0 ;
           }


     // row 2
           for (int j=0; j<9 ; j++) {
               th[13][j] = 225 - j*4.0 ;
           }

           for (int j=9; j<nx ; j++) {

               th[13][j] = 190 - (j-9)*90/3.7 ;
           }

     // row 3
           for (int j=0; j<8 ; j++) {
               th[12][j] = 225 - j*4.0 ;
           }

           for (int j=8; j<12 ; j++) {
               th[12][j] = 185 - (j-8)*90/4.0 ;
           }

           for (int j=12; j<nx ; j++) {
               th[12][j] = 90 - (j-12)*90/4.0 ;
           }


     // row 4
           for (int j=0; j<8 ; j++) {
               th[11][j] = 225 - j*3.7 ;
           }

           for (int j=8; j<11 ; j++) {
               th[11][j] = 185 - (j-8)*90/4.0 ;
           }

           for (int j=11; j<nx ; j++) {
               th[11][j] = 90 - (j-11)*90/4.0 ;
           }


     // row 5
           for (int j=0; j<8 ; j++) {
               th[10][j] = 225 - j*3.7 ;
           }

           for (int j=8; j<10 ; j++) {
               th[10][j] = 185 - (j-8)*90/4.0 ;
           }

           for (int j=10; j<nx ; j++) {
               th[10][j] = 90 - (j-10)*90/4.0 ;
           }



          fEnv("headHalfWidth", 2.0*0.8) ;
          fEnv("headLength", 6.0*0.8) ;
          double dx, dy, len ;
          len =5 ;
          for (int i=0; i<ny ; i++) {
          for (int j=0; j<nx ; j++) {
                    dx = len*Math.cos(th[i][j]*Math.PI/180.0) ; 
                    dy = len*Math.sin(th[i][j]*Math.PI/180.0) ;
                    fArrow(xlist[j]-dx, ylist[i]-dy, xlist[j]+dx, ylist[i]+dy) ;
          }}
          
     }
}
