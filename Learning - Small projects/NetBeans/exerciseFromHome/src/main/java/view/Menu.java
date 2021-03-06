package view;

import controller.ProcessGroup;
import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import model.edunova.model.Group;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import util.Util;

public class Menu extends javax.swing.JFrame {
    
    private SimpleDateFormat df;
    
    public Menu() {
        initComponents();
        setTitle(Util.getTitle("Menu"));
        jmApp.setText(Util.APP_TITLE);
        df = new SimpleDateFormat("dd. MMMM. yyy. HH:mm:ss");
        df = new SimpleDateFormat("HH:mm:ss");
        Time t = new Time();
        t.start();
        defineGraph();
        
    }
    
    private void defineGraph(){
        DefaultPieDataset dataset = new DefaultPieDataset();
        List<Group> groups = new ProcessGroup().read();
        
        Collections.sort(groups, new GroupComparator());
        
        
        
        for(Group g : new ProcessGroup().read()){
            var number = g.getStudents()==null ? 0 : g.getStudents().size();
           dataset.setValue(g.getName() + " (" +  number + ")", number);
        }
        JFreeChart jFreeChart = ChartFactory.createPieChart("Number of students per group", dataset);
        
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        
        pnlGraph.setLayout(new BorderLayout());
        pnlGraph.add(chartPanel, BorderLayout.CENTER);
        pnlGraph.validate();
    }
    
    private class Time extends Thread {
        
        @Override
        public void run() {
            lblTime.setText(df.format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                
            }
            run();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        lblTime = new javax.swing.JLabel();
        pnlGraph = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmApp = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmiOper = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        lblTime.setText("jLabel1");
        jToolBar1.add(lblTime);

        javax.swing.GroupLayout pnlGraphLayout = new javax.swing.GroupLayout(pnlGraph);
        pnlGraph.setLayout(pnlGraphLayout);
        pnlGraphLayout.setHorizontalGroup(
            pnlGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlGraphLayout.setVerticalGroup(
            pnlGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );

        jmApp.setText("File");

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmApp.add(jMenuItem1);

        jMenuBar1.add(jmApp);

        jmiOper.setText("Programs");

        jMenuItem2.setText("Courses");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jmiOper.add(jMenuItem2);

        jMenuItem3.setText("Professors");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jmiOper.add(jMenuItem3);

        jMenuItem4.setText("Students");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jmiOper.add(jMenuItem4);

        jMenuItem5.setText("Groups");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jmiOper.add(jMenuItem5);

        jMenuItem6.setText("Operator");
        jmiOper.add(jMenuItem6);

        jMenuBar1.add(jmiOper);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 300, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlGraph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlGraph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new CourseWindow().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new ProfessorWindow().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new StudentWindow().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new GroupWindow().setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu jmApp;
    private javax.swing.JMenu jmiOper;
    private javax.swing.JLabel lblTime;
    private javax.swing.JPanel pnlGraph;
    // End of variables declaration//GEN-END:variables
}
