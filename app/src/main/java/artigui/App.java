/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package artigui;

import javax.swing.*;

import org.checkerframework.checker.units.qual.s;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.awt.color.*;
import java.awt.GridLayout;
public class App
{
    public static void main(String[] args)
    {
        var frame = new JFrame("Artigiano Bot: Scan Stanza");
        frame.setSize(new Dimension(800,600));
        var constraints = new GridBagConstraints();

        //PANELLO BOTTONI
        var panello_bottoni = new JPanel();
        panello_bottoni.setLayout(new GridBagLayout());

        var bottone_start = new JButton("Inizia Scansione");
        var bottone_stop = new JButton("Ferma Scansione");

        panello_bottoni.add(bottone_start);
        panello_bottoni.add(bottone_stop);

        //BOTTONE START
        bottone_start.addActionListener(e -> 
        {
            System.out.println("Bottone Premuto!");
                Thread thread = new Thread(() -> 
                {
                    try
                    {
                        System.out.println("Thread creato");
                        Runtime.getRuntime().exec("sweethome3d");
                        new HelloJME3().Visualizza();

                    }catch (IOException e1)
                    {
                        e1.printStackTrace();
                        System.out.println("Errore IO");
                    }
                });
                thread.start();
        });


        //PANELLO STANZA
        var panello_stanza = new JPanel();
        var txt_modelli3d = new JLabel("Modelli 3D");
        txt_modelli3d.setForeground(Color.WHITE);
        panello_stanza.add(txt_modelli3d,constraints);
        panello_stanza.setBackground(new Color(15,15,15));
        //Visualizza modello 3d obj
        //new HelloJME3().Visualizza();

        frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
        frame.add(panello_bottoni);
        frame.add(panello_stanza);
        frame.setVisible(true);
    }
}
