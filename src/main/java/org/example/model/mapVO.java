package org.example.model;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class mapVO {
        public final JPanel ablak= new JPanel(new BorderLayout(2,2));
        JFrame keret= new JFrame("Farkas es kutyak");
        public JButton[][] mezok=new JButton[8][8];
        public JPanel tabla;
        public JButton farkas=new JButton();

        private static final String oszlopok="ABCDEFGH";

        mapVO(){
            Gui();
        }
        public final void Gui(){ //ablak kialakitasa
            ablak.setBorder(new EmptyBorder(8,8,8,9));





            tabla= new JPanel(new GridLayout(0,8));
            tabla.setBorder(new LineBorder(Color.BLACK));
            ablak.add(tabla);

            Insets buttonMargin= new Insets(0,0,0,0);

            for(int i=0;i<mezok.length;i++){
                for(int j=0;j<mezok[i].length;j++){
                    JButton gomb= new JButton();
                    gomb.setMargin(buttonMargin);


                    if((i%2==1 && j%2==1)|| (j%2==0 && i%2==0)){
                        gomb.setBackground(Color.WHITE);}
                    else{
                        gomb.setBackground(Color.BLACK);}
                    mezok[j][i]=gomb;
                }

            }

            //felt�ltj�k a fels�(az oszlopok bet�je) sort

            for(int i=0;i<8;i++){
                tabla.add(String.valueOf(new JLabel(oszlopok.substring(i, i+1), SwingConstants.HORIZONTAL)));
            }
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    switch(j){
                        case 0: tabla.add(new JLabel(" "+ i), SwingConstants.CENTER);

                        default: tabla.add(String.valueOf(mezok[j][i]));}
                }
            }





        }


        public final JPanel getTabla(){
            return tabla;
        }
        public final PopupMenu getGui(){
            return ablak;
        }
        public static void main(String[] args){
            Runnable r= new Runnable(){

                public void run(){
                    mapVO cb =new mapVO();

                    JFrame f = new JFrame("Farkas es kutyak");
                    f.add(cb.getGui());
                    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    f.setLocationByPlatform(false);



                    f.pack();
                    f.setMinimumSize(f.getSize());
                    f.setVisible(true);
                }
            };
            SwingUtilities.invokeLater(r);


        }

    }


