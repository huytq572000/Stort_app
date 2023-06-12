/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tesst;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author HP
 */
public class Sorting extends javax.swing.JFrame {

    /**
     * Creates new form Sorting
     */
    public Sorting() {
        setTitle("String Sorting App");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        outputTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
      
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        JButton startButton = new JButton("Tạo mảng và sắp xếp");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runSortingApp();
            }
        });
        mainPanel.add(startButton, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }
    private void runSortingApp() {
        outputTextArea.setText("");

        // Tạo mảng chứa 1000 phần tử random
        String[] array = generateRandomArray(10);

        // Liệt kê mảng đã tạo
        outputTextArea.append("Mảng đã tạo: \n");
        for (String element : array) {
            outputTextArea.append(element + "\n");
        }

        outputTextArea.append("\n");


        outputTextArea.append("Mảng sau khi đã sắp xếp theo thuật toán: \n");
        long startTime = System.nanoTime();
        bubbleSort(array);
        for (String element1 : array) {
            outputTextArea.append(element1 + "\n");
        }
        outputTextArea.append("\n");
        
        long endTime = System.nanoTime();
        long runTime = endTime - startTime;
        outputTextArea.append("Sắp xếp mảng theo thuật toán Bubble Sort: \n");
        outputTextArea.append("Thời gian chạy: " + runTime + " nanoseconds\n");
     
        outputTextArea.append("\n");
        
        outputTextArea.append("Sắp xếp mảng theo thuật toán Selection Sort: \n");
        startTime = System.nanoTime();
        selectionSort(array);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        outputTextArea.append("Thời gian chạy: " + runTime + " nanoseconds\n");
      
        outputTextArea.append("\n");
        
        outputTextArea.append("Sắp xếp mảng theo thuật toán Insertion Sort: \n");
        startTime = System.nanoTime();
        insertionSort(array);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        outputTextArea.append("Thời gian chạy: " + runTime + " nanoseconds\n");
        
        outputTextArea.append("\n");

        outputTextArea.append("Sắp xếp mảng theo thuật toán Quick Sort: \n");
        startTime = System.nanoTime();
        quickSort(array, 0, array.length - 1);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        outputTextArea.append("Thời gian chạy: " + runTime + " nanoseconds\n");

        outputTextArea.append("\n");
        
        outputTextArea.append("Sắp xếp mảng theo thuật toán Merge Sort: \n");
        startTime = System.nanoTime();
        mergeSort(array, 0, array.length - 1);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        outputTextArea.append("Thời gian chạy: " + runTime + " nanoseconds\n");
    }
private String[] generateRandomArray(int size) {
        Random random = new Random();
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            int length = random.nextInt(5) + 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; j++) {
                char c;
                if (random.nextBoolean()) {
                    c = (char) (random.nextInt(26) + 'A'); // Chữ in hoa
                } else {
                    c = (char) (random.nextInt(26) + 'a'); // Chữ thường
                }
                sb.append(c);
            }
            array[i] = sb.toString();
        }
        return array;
    }


    private void bubbleSort(String[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private void selectionSort(String[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            String temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    private void insertionSort(String[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            String key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    private void quickSort(String[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(String[] array, int low, int high) {
        String pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                String temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        String temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    private void mergeSort(String[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(String[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        String[] leftArray = new String[n1];
        String[] rightArray = new String[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        text1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        outputTextArea.setColumns(20);
        outputTextArea.setRows(5);
        jScrollPane1.setViewportView(outputTextArea);

        jLabel2.setText("S1");

        text1.setColumns(20);
        text1.setRows(5);
        jScrollPane2.setViewportView(text1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sorting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sorting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sorting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sorting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sorting().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea outputTextArea;
    private javax.swing.JTextArea text1;
    // End of variables declaration//GEN-END:variables
}
