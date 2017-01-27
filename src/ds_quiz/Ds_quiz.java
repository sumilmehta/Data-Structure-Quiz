/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds_quiz;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Sumil Mehta
 */
class Ds_quiz extends JFrame implements ActionListener  
{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    Ds_quiz(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
        b2=new JButton("Bookmark");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);add(b2);  
        set();  
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            JButton bk=new JButton("Bookmark"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            //System.out.println("correct answers ="+count);  
            JOptionPane.showMessageDialog(this,"Correct Answers: "+count);  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Question 1: Which one of the following permutations can be obtained the output using stack assuming that the input is the sequence 1,2,3,4,5 in that order ? ");  
            jb[0].setText("3,5,4,2,1");jb[1].setText("3,4,5,2,1");jb[2].setText("1,5,2,3,4");jb[3].setText("5,4,3,1,2");   
        }  
        if(current==1)  
        {  
            l.setText("Question 2: The initial configuration of the queue is a,b,c,d (a is the front end). To get the configuration d,c,b,a one needs a minimum of ? ");  
            jb[0].setText("2 deletions and 3 additions");jb[1].setText("2 deletions and 3 additions");jb[2].setText(" 3 deletions and 3 additions");jb[3].setText(" 3 deletions and 4 additions");  
        }  
        if(current==2)  
        {  
            l.setText("Question 3: Linked list are not suitable data structure of which one of the following problems ? ");  
            jb[0].setText("Insertion sort");jb[1].setText("Polynomial manipulation");jb[2].setText("Radix sort");jb[3].setText("Binary search");  
        }  
        if(current==3)  
        {  
            l.setText("Question 4: The number of possible ordered trees with three nodes A,B,C is? ");  
            jb[0].setText("22");jb[1].setText("16");jb[2].setText("6");jb[3].setText("10");  
        }  
        if(current==4)  
        {  
            l.setText("Question5: Which of the following algorithm design technique is used in the quick sort algorithm? ");  
            jb[0].setText("Backtracking");jb[1].setText("Dynamic programming");jb[2].setText("Divide and conquer");jb[3].setText("Greedy method");  
        }  
        if(current==5)  
        {  
            l.setText("Question 6: The number of swapping needed to sort numbers 8,22,7,9,31,19,5,13 in ascending order using bubble sort is ?");  
            jb[0].setText("12");jb[1].setText("11");jb[2].setText("14");jb[3].setText("13");  
        }  
        if(current==6)  
        {  
            l.setText("Question 7: Given two sorted lists of size m and n respectively.The number of comparisons needed in the worst case by the merge sort algorithm will be?  ");  
            jb[0].setText("min(m,n)");jb[1].setText("m+n-1");jb[2].setText("max(m,n)");  
                        jb[3].setText("mnButton");  
        }  
        if(current==7)  
        {  
            l.setText("Question 8: Merge sort uses ? ");  
            jb[0].setText("Heuristic search");jb[1].setText("Greedy approach");jb[2].setText("Backtracking approach");  
                        jb[3].setText("Divide and conquer strategy");         
        }  
        if(current==8)  
        {  
            l.setText("Question 9: Which of the following is useful in traversing a given graph by breadth first search");  
            jb[0].setText("List");jb[1].setText("Queue");jb[2].setText("Stack");jb[3].setText("Set");  
        }  
        if(current==9)  
        {  
            l.setText("Question10: The postfix expression for * + a b - c d is?");  
            jb[0].setText("ab cd + - *");jb[1].setText(" ab cd + - *");jb[2].setText("ab + cd - *");  
                        jb[3].setText("ab + cd * -");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[1].isSelected());  
        if(current==1)  
            return(jb[2].isSelected());  
        if(current==2)  
            return(jb[3].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
            return(jb[2].isSelected());  
        if(current==5)  
            return(jb[2].isSelected());  
        if(current==6)  
            return(jb[1].isSelected());  
        if(current==7)  
            return(jb[3].isSelected());  
        if(current==8)  
            return(jb[1].isSelected());  
        if(current==9)  
            return(jb[2].isSelected());  
        return false;  
    }  
    public static void main(String s[])  
    {  
        new Ds_quiz("Data Structure Quiz");  
    }  
}
