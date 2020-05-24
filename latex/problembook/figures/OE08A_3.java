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
          fTeXlabel(xmax, -1, "tr", "$x$") ;
          fTeXlabel(-0.5, ymax, "tr", "$y$") ;
          canvas.append( new fPsWrite(Black+"\n")) ;


          double scale = 2 ;
          
          double[] xlist = {10, 20, 30, 40, 50, 60, 70,
                            80, 90, 100, 110, 120, 130, 140, 150} ;
          double[] ylist = {10, 20, 30, 40, 50, 60, 70,
                            80, 90, 100, 110, 120, 130, 140, 150} ;
          int nx = xlist.length ;
          int ny = ylist.length ;
          double[] a1 = {270, 268, 266, 264.5, 263,
                                   260, 252, 244,  236, 228, 
                                   225, 225, 225, 225, 225} ;
          double[] len1 = {3, 3.2, 3.4, 3.6, 3.8,
                                     4, 4.3, 4.4, 4.6, 4.8, 
                                     5, 5, 5, 5, 5} ;
          int[] n1 = {9, 9, 9, 9, 9,
                                   9, 9, 9,  9, 9, 
                                   9, 9, 9, 9, 9} ;
          int[] ln1 = {7, 7, 7, 7, 7,
                                   8, 8, 8,  8, 9, 
                                   9, 9, 9, 9, 9} ;
          double[] a2 = {358, 357, 356, 354.5, 353,
                                   350, 330, 310, 290, 270, 
                                   192, 189, 186, 183, 180} ;
          double[] len2 = {3, 2.8, 2.6, 2.4, 2.2,
                                     2, 1.8, 2, 2, 2, 
                                     4, 4, 4, 4, 4} ;
          double[] a3 = {1,  2,  3, 4, 5,
                                   5, 15, 25,  35, 45, 
                                   90, 104, 123, 142, 161} ;
          double[] len3 = {3,  2.9,  2.8, 2.7, 2.6,
                                     3,  3,  3,  2, 3, 
                                     3, 3, 3, 3, 3} ;
          double[] af = {10, 12, 14, 16, 18,
                                  20, 28, 36,  44, 52, 
                                   60, 69, 76, 83, 90} ;
          double[] lenf = {4.8, 4.8, 4.8, 4.8, 4.8,
                                    4.8, 4.6, 4.4,  4.2, 4, 
                                   3.8, 3.6, 3.4, 3.2, 3} ;
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
double[][] len =  { {0, 0, 0, 0, 0, 0, 0, 0,
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
  
     for(int i=14; i>=0 ; i--) {
                for (int j=0; j<=n1[i] ; j++) {
                     th[i][j] = a1[i] + j*(a2[i]-a1[i])/n1[i] ;
                }

                for (int j=n1[i]+1; j<nx ; j++) {
                     th[i][j] = a3[i] + (j-n1[i]-1)*(af[i]-a3[i])/(nx-n1[i]-2) ;
                }
     }


     for(int i=14; i>=0 ; i--) {
                for (int j=0; j<=ln1[i] ; j++) {
                     len[i][j] = len1[i] + j*(len2[i]-len1[i])/ln1[i]  ;
                }

                for (int j=ln1[i]+1; j<nx ; j++) {
                     len[i][j] = len3[i] + (j-ln1[i]-1)*(lenf[i]-len3[i])/(nx-ln1[i]-2) ;
                }
     }

 


          fEnv("headHalfWidth", 2.0*0.8) ;
          fEnv("headLength", 6.0*0.8) ;
          double dx, dy ;
          for (int i=0; i<ny ; i++) {
          for (int j=0; j<nx ; j++) {
                    dx = len[i][j]*Math.cos(th[i][j]*Math.PI/180.0) ; 
                    dy = len[i][j]*Math.sin(th[i][j]*Math.PI/180.0) ;
                    fArrow(xlist[j]-dx, ylist[i]-dy, xlist[j]+dx, ylist[i]+dy) ;
          }}

          fEnv("lineWidth", 1.3) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ; 



         double ax, ay, bx, by, cx, cy, r ;
         ax = 100; ay = 85 ;
         bx = 125; by = 45 ;
         cx = 90; cy = 135 ;
         r = 1.3 ;
         fEnv("headHalfWidth", 2.0*1.4) ;
         fEnv("headLength", 6.0*1.4) ;
         fDisk(ax,ay, r,r, FILLED) ; fTeXlabel(ax+1,ay, "cl", "$A$") ;
         fDisk(bx,by, r,r, FILLED) ; fTeXlabel(bx+1,by, "cl", "$B$") ;
         fDisk(cx,cy, r,r, FILLED) ; fTeXlabel(cx-2,cy+1, "cr", "$C$") ;

         { double[] bxlist = {bx, 135, 135, cx} ;
           double[] bylist = {by, 80  , 115, cy} ;
           fBezier bezr = new fBezier(bxlist, bylist, 4, OPEN) ;
//            bezr.configure("vertex0outAngle",-45) ;
//            bezr.configure("vertex1outAngle",90) ;
//            bezr.configure("vertex1inAngle", -90) ;
            bezr.configure("vertex3inAngle",210) ;
            canvas.append(bezr) ;
            fArrowhead(135,115, 125) ;
            fTeXlabel(136,117, "bc", "$\\cC_1$") ;
          }

         { double[] cxlist = {bx, 70, 50, 65, cx} ;
           double[] cylist = {by, 60, 90, 115, cy} ;
           fBezier bezl = new fBezier(cxlist, cylist, 5, OPEN) ;
//            bezl.configure("vertex0outAngle",-45) ;
//            bezl.configure("vertex1outAngle",90) ;
//            bezl.configure("vertex1inAngle", -90) ;
//            bezl.configure("vertex3inAngle",210) ;
            canvas.append(bezl) ;
            fArrowhead(65,115, 45) ;
            fTeXlabel(62,115, "cr", "$\\cC_2$") ;
          }
          
  }
}
