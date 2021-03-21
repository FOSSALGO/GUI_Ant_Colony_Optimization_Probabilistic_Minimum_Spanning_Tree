
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.UIManager;

import java.awt.GridBagLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.filechooser.FileFilter;

import util.*;
import java.awt.GridBagConstraints;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;

public class UI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JPanel jPanel = null;
    private CardLayout cardLayout = null;  //  @jve:decl-index=0:
    private JPanel jPanel1 = null;
    private Canvas canvas = null;
    private JPanel jPanel2 = null;
    private JButton jButton = null;
    private JButton jButton1 = null;
    private JFileChooser jFileChooser = null;
    private JFileChooser jFileChooser1 = null;
    private JButton jButton2 = null;
    private JButton jButton3 = null;
    private JButton jButton4 = null;
    private JButton jButton5 = null;
    private JButton jButton6 = null;
    private JButton jButton7 = null;
    private JButton jButton8 = null;
    private JButton jButton9 = null;
    private JButton jButton10 = null;
    private JButton jButton11 = null;
    private JButton jButton12 = null;
    private JButton jButton13 = null;
    private JButton jButton14 = null;
    private JButton jButton15 = null;
    private JPanel jPanel3 = null;
    private JPanel jPanel4 = null;
    private JPanel jPanel5 = null;
    private JPanel jPanel6 = null;
    private JButton jButton16 = null;
    private JButton jButton17 = null;
    private JButton jButton18 = null;
    private JButton jButton19 = null;
    private JLabel jLabel = null;
    private JTextField jTextFieldNumGridX = null;
    private JLabel jLabel1 = null;
    private JTextField jTextFieldNumGridY = null;
    private JLabel jLabel2 = null;
    private JTextField jTextFieldGridSize = null;
    private JButton jButton20 = null;
    private JPanel jPanel7 = null;
    private JPanel jPanel8 = null;
    private JPanel jPanel9 = null;
    private JPanel jPanel10 = null;
    private JButton jButton21 = null;
    private JButton jButton22 = null;
    private JButton jButton23 = null;
    private JButton jButton24 = null;
    private JLabel jLabel3 = null;
    private JTextField jTextFieldQ = null;
    private JLabel jLabel4 = null;
    private JTextField jTextFieldAlpha = null;
    private JLabel jLabel5 = null;
    private JTextField jTextFieldBeta = null;
    private JLabel jLabel6 = null;
    private JTextField jTextFieldRho = null;
    private JLabel jLabel7 = null;
    private JTextField jTextFieldTho = null;
    private JLabel jLabel8 = null;
    private JTextField jTextFieldM = null;
    private JLabel jLabel9 = null;
    private JTextField jTextFieldNCMAX = null;
    private JPanel jPanel11 = null;
    private JPanel jPanel12 = null;
    private JPanel jPanel13 = null;
    private JScrollPane jScrollPane = null;
    private JTextArea jTextArea = null;
    private JButton jButton25 = null;
    private JButton jButton27 = null;
    private JButton jButton26 = null;
    private JButton jButton29 = null;
    private JPanel jPanel14 = null;
    private JPanel jPanel16 = null;
    private JButton jButton30 = null;
    private JPanel jPanel17 = null;
    private JCheckBox jCheckBox = null;
    private JCheckBox jCheckBox1 = null;
    private JCheckBox jCheckBox2 = null;
    private JButton jButton28 = null;
    private JButton jButton31 = null;
    private JPanel jPanel15 = null;
    private JPanel jPanel18 = null;
    private JPanel jPanel19 = null;
    private JButton jButton32 = null;
    private JScrollPane jScrollPane1 = null;
    private JTextArea jTextArea1 = null;
    private JCheckBox jCheckBox3 = null;

    /**
     * This method initializes jPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel() {
        if (jPanel == null) {
            jPanel = new JPanel();
            this.cardLayout = new CardLayout();
            jPanel.setLayout(this.cardLayout);
            jPanel.add(getJPanel1(), getJPanel1().getName());
            jPanel.add(getJPanel3(), getJPanel3().getName());
            jPanel.add(getJPanel7(), getJPanel7().getName());
            jPanel.add(getJPanel11(), getJPanel11().getName());
            jPanel.add(getJPanel14(), getJPanel14().getName());
            jPanel.add(getJPanel15(), getJPanel15().getName());
        }
        return jPanel;
    }

    /**
     * This method initializes jPanel1
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel1() {
        if (jPanel1 == null) {
            jPanel1 = new JPanel();
            jPanel1.setLayout(new BorderLayout());
            jPanel1.setName("jPanel1");
            jPanel1.add(getCanvas(), BorderLayout.CENTER);
            jPanel1.add(getJPanel2(), BorderLayout.EAST);
        }
        return jPanel1;
    }

    /**
     * This method initializes canvas
     *
     * @return Canvas
     */
    private Canvas getCanvas() {
        if (canvas == null) {
            canvas = new Canvas();
        }
        return canvas;
    }

    /**
     * This method initializes jPanel2
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel2() {
        if (jPanel2 == null) {
            GridLayout gridLayout = new GridLayout();
            gridLayout.setRows(20);
            gridLayout.setColumns(1);
            jPanel2 = new JPanel();
            jPanel2.setLayout(gridLayout);
            jPanel2.add(getJButton15(), null);
            jPanel2.add(getJButton29(), null);
            jPanel2.add(getJButton20(), null);
            jPanel2.add(getJButton(), null);
            jPanel2.add(getJButton2(), null);
            jPanel2.add(getJButton4(), null);
            jPanel2.add(getJButton7(), null);
            jPanel2.add(getJButton8(), null);
            jPanel2.add(getJButton12(), null);
            jPanel2.add(getJButton13(), null);
            jPanel2.add(getJButton14(), null);
            jPanel2.add(getJButton9(), null);
            jPanel2.add(getJButton10(), null);
            jPanel2.add(getJButton11(), null);
            jPanel2.add(getJButton3(), null);
            jPanel2.add(getJButton1(), null);
            jPanel2.add(getJButton5(), null);
            jPanel2.add(getJButton6(), null);
            jPanel2.add(getJButton26(), null);
        }
        return jPanel2;
    }

    /**
     * This method initializes jButton
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton() {
        if (jButton == null) {
            jButton = new JButton();
            jButton.setText("open graph");
            jButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    boolean result = browse();
                    if (result) {
                        jButton1.setEnabled(true);
                        jButton20.setEnabled(true);
                        jButton5.setEnabled(true);
                        jButton2.setEnabled(false);
                        jButton.setEnabled(false);
                        jButton15.setText("free transform");
                    }
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton;
    }

    /**
     * This method initializes jButton1
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton1() {
        if (jButton1 == null) {
            jButton1 = new JButton();
            jButton1.setText("save graph");
            jButton1.setEnabled(false);
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    boolean result = save();
                    if (result) {
                        jButton1.setEnabled(false);
                        jButton15.setText("free transform");
                        jButton15.setText("free transform");
                    }
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton1;
    }

    /**
     * This method initializes jButton2
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton2() {
        if (jButton2 == null) {
            jButton2 = new JButton();
            jButton2.setText("create graph");
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    jButton4.setEnabled(true);
                    jButton20.setEnabled(true);
                    jButton.setEnabled(false);
                    jButton2.setEnabled(false);
                    jButton15.setText("free transform");
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton2;
    }

    /**
     * This method initializes jButton3
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton3() {
        if (jButton3 == null) {
            jButton3 = new JButton();
            jButton3.setText("set graph");
            jButton3.setEnabled(false);
            jButton3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    boolean result = canvas.setGraph();
                    if (result) {
                        jButton1.setEnabled(true);
                        jButton5.setEnabled(true);
                        jButton3.setEnabled(false);
                        jButton15.setText("free transform");
                    }
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton3;
    }

    /**
     * This method initializes jButton4
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton4() {
        if (jButton4 == null) {
            jButton4 = new JButton();
            jButton4.setText("edit grid properties");
            jButton4.setEnabled(false);
            jButton4.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    viewCurrentGridProperties();
                    jButton15.setText("free transform");
                    cardLayout.show(jPanel, jPanel3.getName());
                    System.out.println("actionPerformed()-cardLayout.show(jPanel, jPanel3.getName());"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton4;
    }

    /**
     * This method initializes jButton5
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton5() {
        if (jButton5 == null) {
            jButton5 = new JButton();
            jButton5.setText("edit ACO parameters");
            jButton5.setEnabled(false);
            jButton5.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    viewCurrentParameters();
                    jButton15.setText("free transform");
                    cardLayout.show(jPanel, jPanel7.getName());
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton5;
    }

    /**
     * This method initializes jButton6
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton6() {
        if (jButton6 == null) {
            jButton6 = new JButton();
            jButton6.setText("run ants");
            jButton6.setEnabled(false);
            jButton6.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    boolean status = canvas.runACO();
                    jButton15.setText("free transform");
                    System.out.println("Status ACO: " + (status));
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton6;
    }

    /**
     * This method initializes jButton7
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton7() {
        if (jButton7 == null) {
            jButton7 = new JButton();
            jButton7.setText("create vertex");
            jButton7.setEnabled(false);
            jButton7.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    boolean result = canvas.createVertices();;
                    if (result) {
                        jButton12.setEnabled(true);
                        jButton13.setEnabled(true);
                        jButton14.setEnabled(true);
                        jButton7.setEnabled(false);
                        jButton8.setEnabled(false);
                        jButton15.setText("free transform");
                    }
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton7;
    }

    /**
     * This method initializes jButton8
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton8() {
        if (jButton8 == null) {
            jButton8 = new JButton();
            jButton8.setText("generate random vertices");
            jButton8.setEnabled(false);
            jButton8.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    String sValue = JOptionPane.showInputDialog(null, "enter num vertices!!", "generate random vertices", JOptionPane.WARNING_MESSAGE);
                    try {
                        int value = Integer.parseInt(sValue.trim());
                        boolean result = canvas.generateRandomVertices(value);
                        if (result) {
                            jButton12.setEnabled(true);
                            jButton13.setEnabled(true);
                            jButton14.setEnabled(true);
                            jButton7.setEnabled(false);
                            jButton8.setEnabled(false);
                            jButton15.setText("free transform");
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton8;
    }

    /**
     * This method initializes jButton9
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton9() {
        if (jButton9 == null) {
            jButton9 = new JButton();
            jButton9.setText("create edge");
            jButton9.setEnabled(false);
            jButton9.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    boolean result = canvas.createEdge();
                    if (result) {
                        jButton3.setEnabled(true);
                        jButton9.setEnabled(false);
                        jButton10.setEnabled(false);
                        jButton11.setEnabled(false);
                        jButton15.setText("free transform");
                    }
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton9;
    }

    /**
     * This method initializes jButton10
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton10() {
        if (jButton10 == null) {
            jButton10 = new JButton();
            jButton10.setText("generate random edges");
            jButton10.setEnabled(false);
            jButton10.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    boolean result = canvas.generateRandomEdges();
                    if (result) {
                        jButton3.setEnabled(true);
                        jButton9.setEnabled(false);
                        jButton10.setEnabled(false);
                        jButton11.setEnabled(false);
                        jButton15.setText("free transform");
                    }
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton10;
    }

    /**
     * This method initializes jButton11
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton11() {
        if (jButton11 == null) {
            jButton11 = new JButton();
            jButton11.setText("generate complete graph");
            jButton11.setEnabled(false);
            jButton11.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    boolean result = canvas.generateCompleteGraph();
                    if (result) {
                        jButton3.setEnabled(true);
                        jButton9.setEnabled(false);
                        jButton10.setEnabled(false);
                        jButton11.setEnabled(false);
                        jButton15.setText("free transform");
                    }
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton11;
    }

    /**
     * This method initializes jButton12
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton12() {
        if (jButton12 == null) {
            jButton12 = new JButton();
            jButton12.setText("set vertex probability");
            jButton12.setEnabled(false);
            jButton12.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    boolean result = canvas.setVertexPobability();
                    if (result) {
                        jButton9.setEnabled(true);
                        jButton10.setEnabled(true);
                        jButton11.setEnabled(true);
                        jButton12.setEnabled(false);
                        jButton13.setEnabled(false);
                        jButton14.setEnabled(false);
                        jButton15.setText("free transform");
                    }
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton12;
    }

    /**
     * This method initializes jButton13
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton13() {
        if (jButton13 == null) {
            jButton13 = new JButton();
            jButton13.setText("set random vertices probabilities");
            jButton13.setEnabled(false);
            jButton13.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    boolean result = canvas.setRandomVerticesProbabilities();
                    if (result) {
                        jButton9.setEnabled(true);
                        jButton10.setEnabled(true);
                        jButton11.setEnabled(true);
                        jButton12.setEnabled(false);
                        jButton13.setEnabled(false);
                        jButton14.setEnabled(false);
                        jButton15.setText("free transform");
                    }
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton13;
    }

    /**
     * This method initializes jButton14
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton14() {
        if (jButton14 == null) {
            jButton14 = new JButton();
            jButton14.setText("set fixed vertices probabilities");
            jButton14.setEnabled(false);
            jButton14.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    String sValue = JOptionPane.showInputDialog(null, "enter fixed value!!", "set fixed probability", JOptionPane.WARNING_MESSAGE);
                    try {
                        float value = Float.parseFloat(sValue.trim());
                        boolean result = canvas.setFixedVerticesProbabilities(value);
                        if (result) {
                            jButton9.setEnabled(true);
                            jButton10.setEnabled(true);
                            jButton11.setEnabled(true);
                            jButton12.setEnabled(false);
                            jButton13.setEnabled(false);
                            jButton14.setEnabled(false);
                            jButton15.setText("free transform");
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton14;
    }

    /**
     * This method initializes jButton15
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton15() {
        if (jButton15 == null) {
            jButton15 = new JButton();
            jButton15.setText("free transform");
            jButton15.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    String judul = canvas.switchCanvasState();
                    jButton15.setText(judul);
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton15;
    }

    /**
     * This method initializes jPanel3
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel3() {
        if (jPanel3 == null) {
            jPanel3 = new JPanel();
            jPanel3.setLayout(new BorderLayout());
            jPanel3.setName("jPanel3");
            jPanel3.add(getJPanel4(), BorderLayout.CENTER);
            jPanel3.add(getJPanel5(), BorderLayout.EAST);
        }
        return jPanel3;
    }

    /**
     * This method initializes jPanel4
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel4() {
        if (jPanel4 == null) {
            jPanel4 = new JPanel();
            jPanel4.setLayout(new GridBagLayout());
            jPanel4.add(getJPanel6(), new GridBagConstraints());
        }
        return jPanel4;
    }

    /**
     * This method initializes jPanel5
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel5() {
        if (jPanel5 == null) {
            GridLayout gridLayout2 = new GridLayout();
            gridLayout2.setRows(18);
            gridLayout2.setColumns(1);
            jPanel5 = new JPanel();
            jPanel5.setLayout(gridLayout2);
            jPanel5.add(getJButton17(), null);
            jPanel5.add(getJButton18(), null);
            jPanel5.add(getJButton16(), null);
            jPanel5.add(getJButton19(), null);
        }
        return jPanel5;
    }

    /**
     * This method initializes jPanel6
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel6() {
        if (jPanel6 == null) {
            jLabel2 = new JLabel();
            jLabel2.setText("grid size");
            jLabel1 = new JLabel();
            jLabel1.setText("num grid-y");
            jLabel = new JLabel();
            jLabel.setText("num grid-x");
            GridLayout gridLayout1 = new GridLayout();
            gridLayout1.setRows(3);
            gridLayout1.setVgap(4);
            gridLayout1.setColumns(2);
            jPanel6 = new JPanel();
            jPanel6.setBorder(BorderFactory.createTitledBorder(null, "grid properties", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), null));
            jPanel6.setLayout(gridLayout1);
            jPanel6.setPreferredSize(new Dimension(300, 120));
            jPanel6.add(jLabel, null);
            jPanel6.add(getJTextFieldNumGridX(), null);
            jPanel6.add(jLabel1, null);
            jPanel6.add(getJTextFieldNumGridY(), null);
            jPanel6.add(jLabel2, null);
            jPanel6.add(getJTextFieldGridSize(), null);
        }
        return jPanel6;
    }

    /**
     * This method initializes jButton16
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton16() {
        if (jButton16 == null) {
            jButton16 = new JButton();
            jButton16.setText("set grid properties");
            jButton16.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    try {
                        int numGridX = Integer.parseInt(jTextFieldNumGridX.getText().trim());
                        int numGridY = Integer.parseInt(jTextFieldNumGridY.getText().trim());
                        int gridSize = Integer.parseInt(jTextFieldGridSize.getText().trim());
                        canvas.setGrid(numGridX, numGridY, gridSize);
                        //cardLayout.show(jPanel, jPanel1.getName());
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    viewCurrentGridProperties();
                    System.out.println("actionPerformed()-canvas.setGrid(numGridX, numGridY, gridSize);"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton16;
    }

    /**
     * This method initializes jButton17
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton17() {
        if (jButton17 == null) {
            jButton17 = new JButton();
            jButton17.setText("default");
            jButton17.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    canvas.resetDefaultGrid();
                    viewCurrentGridProperties();
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton17;
    }

    /**
     * This method initializes jButton18
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton18() {
        if (jButton18 == null) {
            jButton18 = new JButton();
            jButton18.setText("clear");
            jButton18.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    jTextFieldNumGridX.setText("");
                    jTextFieldNumGridY.setText("");
                    jTextFieldGridSize.setText("");
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton18;
    }

    /**
     * This method initializes jButton19
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton19() {
        if (jButton19 == null) {
            jButton19 = new JButton();
            jButton19.setText("ok");
            jButton19.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    jButton7.setEnabled(true);
                    jButton8.setEnabled(true);
                    jButton4.setEnabled(false);
                    cardLayout.show(jPanel, jPanel1.getName());
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton19;
    }

    /**
     * This method initializes jTextFieldNumGridX
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextFieldNumGridX() {
        if (jTextFieldNumGridX == null) {
            jTextFieldNumGridX = new JTextField();
            jTextFieldNumGridX.setHorizontalAlignment(JTextField.RIGHT);
        }
        return jTextFieldNumGridX;
    }

    /**
     * This method initializes jTextFieldNumGridY
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextFieldNumGridY() {
        if (jTextFieldNumGridY == null) {
            jTextFieldNumGridY = new JTextField();
            jTextFieldNumGridY.setHorizontalAlignment(JTextField.RIGHT);
        }
        return jTextFieldNumGridY;
    }

    /**
     * This method initializes jTextFieldGridSize
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextFieldGridSize() {
        if (jTextFieldGridSize == null) {
            jTextFieldGridSize = new JTextField();
            jTextFieldGridSize.setHorizontalAlignment(JTextField.RIGHT);
        }
        return jTextFieldGridSize;
    }

    /**
     * This method initializes jButton20
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton20() {
        if (jButton20 == null) {
            jButton20 = new JButton();
            jButton20.setText("reset graph");
            jButton20.setEnabled(false);
            jButton20.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    boolean result = canvas.resetGraph();
                    if (result) {
                        jButton.setEnabled(true);
                        jButton2.setEnabled(true);
                        jButton4.setEnabled(false);
                        jButton7.setEnabled(false);
                        jButton8.setEnabled(false);
                        jButton12.setEnabled(false);
                        jButton13.setEnabled(false);
                        jButton14.setEnabled(false);
                        jButton9.setEnabled(false);
                        jButton10.setEnabled(false);
                        jButton11.setEnabled(false);
                        jButton3.setEnabled(false);
                        jButton1.setEnabled(false);
                        jButton5.setEnabled(false);
                        jButton6.setEnabled(false);
                        jButton20.setEnabled(false);
                        jButton15.setText("free transform");
                    }
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton20;
    }

    /**
     * This method initializes jPanel7
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel7() {
        if (jPanel7 == null) {
            jPanel7 = new JPanel();
            jPanel7.setLayout(new BorderLayout());
            jPanel7.setName("jPanel7");
            jPanel7.add(getJPanel8(), BorderLayout.CENTER);
            jPanel7.add(getJPanel9(), BorderLayout.EAST);
        }
        return jPanel7;
    }

    /**
     * This method initializes jPanel8
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel8() {
        if (jPanel8 == null) {
            jPanel8 = new JPanel();
            jPanel8.setLayout(new GridBagLayout());
            jPanel8.add(getJPanel10(), new GridBagConstraints());
        }
        return jPanel8;
    }

    /**
     * This method initializes jPanel9
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel9() {
        if (jPanel9 == null) {
            GridLayout gridLayout3 = new GridLayout();
            gridLayout3.setRows(18);
            gridLayout3.setColumns(1);
            jPanel9 = new JPanel();
            jPanel9.setLayout(gridLayout3);
            jPanel9.add(getJButton22(), null);
            jPanel9.add(getJButton23(), null);
            jPanel9.add(getJButton21(), null);
            jPanel9.add(getJButton24(), null);
        }
        return jPanel9;
    }

    /**
     * This method initializes jPanel10
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel10() {
        if (jPanel10 == null) {
            jLabel9 = new JLabel();
            jLabel9.setText("ncMAX");
            jLabel8 = new JLabel();
            jLabel8.setText("num ants (m)");
            jLabel7 = new JLabel();
            jLabel7.setText("tho");
            jLabel6 = new JLabel();
            jLabel6.setText("rho");
            jLabel5 = new JLabel();
            jLabel5.setText("beta");
            jLabel4 = new JLabel();
            jLabel4.setText("alpha");
            jLabel3 = new JLabel();
            jLabel3.setText("Q");
            GridLayout gridLayout4 = new GridLayout();
            gridLayout4.setRows(7);
            gridLayout4.setVgap(4);
            gridLayout4.setColumns(2);
            jPanel10 = new JPanel();
            jPanel10.setLayout(gridLayout4);
            jPanel10.setPreferredSize(new Dimension(300, 280));
            jPanel10.add(jLabel3, null);
            jPanel10.add(getJTextFieldQ(), null);
            jPanel10.add(jLabel4, null);
            jPanel10.add(getJTextFieldAlpha(), null);
            jPanel10.add(jLabel5, null);
            jPanel10.add(getJTextFieldBeta(), null);
            jPanel10.add(jLabel6, null);
            jPanel10.add(getJTextFieldRho(), null);
            jPanel10.add(jLabel7, null);
            jPanel10.add(getJTextFieldTho(), null);
            jPanel10.add(jLabel8, null);
            jPanel10.add(getJTextFieldM(), null);
            jPanel10.add(jLabel9, null);
            jPanel10.add(getJTextFieldNCMAX(), null);
        }
        return jPanel10;
    }

    /**
     * This method initializes jButton21
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton21() {
        if (jButton21 == null) {
            jButton21 = new JButton();
            jButton21.setText("set ACO parameter");
            jButton21.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    try {
                        float Q = Float.parseFloat(jTextFieldQ.getText().trim());
                        float alpha = Float.parseFloat(jTextFieldAlpha.getText().trim());
                        float beta = Float.parseFloat(jTextFieldBeta.getText().trim());
                        float rho = Float.parseFloat(jTextFieldRho.getText().trim());
                        float tho = Float.parseFloat(jTextFieldTho.getText().trim());
                        int m = Integer.parseInt(jTextFieldM.getText().trim());
                        int ncMAX = Integer.parseInt(jTextFieldNCMAX.getText().trim());
                        canvas.setParameters(Q, alpha, beta, m, rho, tho, ncMAX);
                        //cardLayout.show(jPanel, jPanel1.getName());
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    viewCurrentParameters();
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton21;
    }

    /**
     * This method initializes jButton22
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton22() {
        if (jButton22 == null) {
            jButton22 = new JButton();
            jButton22.setText("default");
            jButton22.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    canvas.resetDefaultParameters();
                    viewCurrentParameters();
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton22;
    }

    /**
     * This method initializes jButton23
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton23() {
        if (jButton23 == null) {
            jButton23 = new JButton();
            jButton23.setText("clear");
            jButton23.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    jTextFieldQ.setText("");
                    jTextFieldAlpha.setText("");
                    jTextFieldBeta.setText("");
                    jTextFieldRho.setText("");
                    jTextFieldTho.setText("");
                    jTextFieldM.setText("");
                    jTextFieldNCMAX.setText("");
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton23;
    }

    /**
     * This method initializes jButton24
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton24() {
        if (jButton24 == null) {
            jButton24 = new JButton();
            jButton24.setText("ok");
            jButton24.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    jButton6.setEnabled(true);
                    cardLayout.show(jPanel, jPanel1.getName());
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton24;
    }

    /**
     * This method initializes jTextFieldQ
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextFieldQ() {
        if (jTextFieldQ == null) {
            jTextFieldQ = new JTextField();
        }
        return jTextFieldQ;
    }

    /**
     * This method initializes jTextFieldAlpha
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextFieldAlpha() {
        if (jTextFieldAlpha == null) {
            jTextFieldAlpha = new JTextField();
        }
        return jTextFieldAlpha;
    }

    /**
     * This method initializes jTextFieldBeta
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextFieldBeta() {
        if (jTextFieldBeta == null) {
            jTextFieldBeta = new JTextField();
        }
        return jTextFieldBeta;
    }

    /**
     * This method initializes jTextFieldRho
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextFieldRho() {
        if (jTextFieldRho == null) {
            jTextFieldRho = new JTextField();
        }
        return jTextFieldRho;
    }

    /**
     * This method initializes jTextFieldTho
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextFieldTho() {
        if (jTextFieldTho == null) {
            jTextFieldTho = new JTextField();
        }
        return jTextFieldTho;
    }

    /**
     * This method initializes jTextFieldM
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextFieldM() {
        if (jTextFieldM == null) {
            jTextFieldM = new JTextField();
        }
        return jTextFieldM;
    }

    /**
     * This method initializes jTextFieldNCMAX
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJTextFieldNCMAX() {
        if (jTextFieldNCMAX == null) {
            jTextFieldNCMAX = new JTextField();
        }
        return jTextFieldNCMAX;
    }

    /**
     * This method initializes jPanel11
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel11() {
        if (jPanel11 == null) {
            jPanel11 = new JPanel();
            jPanel11.setLayout(new BorderLayout());
            jPanel11.setName("jPanel11");
            jPanel11.add(getJPanel12(), BorderLayout.CENTER);
            jPanel11.add(getJPanel13(), BorderLayout.SOUTH);
        }
        return jPanel11;
    }

    /**
     * This method initializes jPanel12
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel12() {
        if (jPanel12 == null) {
            jPanel12 = new JPanel();
            jPanel12.setLayout(new BorderLayout());
            jPanel12.add(getJScrollPane(), BorderLayout.CENTER);
        }
        return jPanel12;
    }

    /**
     * This method initializes jPanel13
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel13() {
        if (jPanel13 == null) {
            jPanel13 = new JPanel();
            jPanel13.setLayout(new FlowLayout());
            jPanel13.add(getJButton27(), null);
            jPanel13.add(getJButton25(), null);
        }
        return jPanel13;
    }

    /**
     * This method initializes jScrollPane
     *
     * @return javax.swing.JScrollPane
     */
    private JScrollPane getJScrollPane() {
        if (jScrollPane == null) {
            jScrollPane = new JScrollPane();
            jScrollPane.setViewportView(getJTextArea());
        }
        return jScrollPane;
    }

    /**
     * This method initializes jTextArea
     *
     * @return javax.swing.JTextArea
     */
    private JTextArea getJTextArea() {
        if (jTextArea == null) {
            jTextArea = new JTextArea();
        }
        return jTextArea;
    }

    /**
     * This method initializes jButton25
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton25() {
        if (jButton25 == null) {
            jButton25 = new JButton();
            jButton25.setText("save");
            jButton25.setPreferredSize(new Dimension(70, 32));
            jButton25.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    saveResult();
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton25;
    }

    /**
     * This method initializes jButton27
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton27() {
        if (jButton27 == null) {
            jButton27 = new JButton();
            jButton27.setText("back");
            jButton27.setPreferredSize(new Dimension(70, 32));
            jButton27.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    cardLayout.show(jPanel, jPanel1.getName());
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton27;
    }

    /**
     * This method initializes jButton26
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton26() {
        if (jButton26 == null) {
            jButton26 = new JButton();
            jButton26.setText("result");
            jButton26.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    jTextArea.setText(canvas.resultToString());
                    cardLayout.show(jPanel, jPanel11.getName());
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton26;
    }

    /**
     * This method initializes jButton29
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton29() {
        if (jButton29 == null) {
            jButton29 = new JButton();
            jButton29.setText("view");
            jButton29.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    cardLayout.show(jPanel, jPanel14.getName());
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton29;
    }

    /**
     * This method initializes jPanel14
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel14() {
        if (jPanel14 == null) {
            jPanel14 = new JPanel();
            jPanel14.setLayout(new BorderLayout());
            jPanel14.setName("jPanel14");
            jPanel14.add(getJPanel16(), BorderLayout.CENTER);
        }
        return jPanel14;
    }

    /**
     * This method initializes jPanel16
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel16() {
        if (jPanel16 == null) {
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            jPanel16 = new JPanel();
            jPanel16.setLayout(new GridBagLayout());
            jPanel16.add(getJPanel17(), gridBagConstraints);
        }
        return jPanel16;
    }

    /**
     * This method initializes jButton30
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton30() {
        if (jButton30 == null) {
            jButton30 = new JButton();
            jButton30.setText("back");
            jButton30.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    cardLayout.show(jPanel, jPanel1.getName());
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton30;
    }

    /**
     * This method initializes jPanel17
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel17() {
        if (jPanel17 == null) {
            GridLayout gridLayout5 = new GridLayout();
            gridLayout5.setRows(6);
            gridLayout5.setColumns(1);
            jPanel17 = new JPanel();
            jPanel17.setLayout(gridLayout5);
            jPanel17.setPreferredSize(new Dimension(200, 160));
            jPanel17.add(getJCheckBox(), null);
            jPanel17.add(getJCheckBox1(), null);
            jPanel17.add(getJCheckBox2(), null);
            jPanel17.add(getJCheckBox3(), null);
            jPanel17.add(getJButton28(), null);
            jPanel17.add(getJButton31(), null);
        }
        return jPanel17;
    }

    /**
     * This method initializes jCheckBox
     *
     * @return javax.swing.JCheckBox
     */
    private JCheckBox getJCheckBox() {
        if (jCheckBox == null) {
            jCheckBox = new JCheckBox();
            jCheckBox.setText("vertex label");
        }
        return jCheckBox;
    }

    /**
     * This method initializes jCheckBox1
     *
     * @return javax.swing.JCheckBox
     */
    private JCheckBox getJCheckBox1() {
        if (jCheckBox1 == null) {
            jCheckBox1 = new JCheckBox();
            jCheckBox1.setText("probability");
        }
        return jCheckBox1;
    }

    /**
     * This method initializes jCheckBox2
     *
     * @return javax.swing.JCheckBox
     */
    private JCheckBox getJCheckBox2() {
        if (jCheckBox2 == null) {
            jCheckBox2 = new JCheckBox();
            jCheckBox2.setText("degree");
        }
        return jCheckBox2;
    }

    /**
     * This method initializes jButton28
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton28() {
        if (jButton28 == null) {
            jButton28 = new JButton();
            jButton28.setText("graph info");
            jButton28.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    jTextArea1.setText(canvas.infoToString());
                    cardLayout.show(jPanel, jPanel15.getName());
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton28;
    }

    /**
     * This method initializes jButton31
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton31() {
        if (jButton31 == null) {
            jButton31 = new JButton();
            jButton31.setText("ok");
            jButton31.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    boolean vVertex = jCheckBox.isSelected();
                    boolean vProbability = jCheckBox1.isSelected();
                    boolean vDegree = jCheckBox2.isSelected();
                    boolean hideEdge = jCheckBox3.isSelected();
                    canvas.setView(vVertex, vProbability, vDegree, hideEdge);
                    cardLayout.show(jPanel, jPanel1.getName());
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton31;
    }

    /**
     * This method initializes jPanel15
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel15() {
        if (jPanel15 == null) {
            jPanel15 = new JPanel();
            jPanel15.setLayout(new BorderLayout());
            jPanel15.setName("jPanel15");
            jPanel15.add(getJPanel18(), BorderLayout.CENTER);
            jPanel15.add(getJPanel19(), BorderLayout.SOUTH);
        }
        return jPanel15;
    }

    /**
     * This method initializes jPanel18
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel18() {
        if (jPanel18 == null) {
            jPanel18 = new JPanel();
            jPanel18.setLayout(new BorderLayout());
            jPanel18.add(getJScrollPane1(), BorderLayout.CENTER);
        }
        return jPanel18;
    }

    /**
     * This method initializes jPanel19
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel19() {
        if (jPanel19 == null) {
            jPanel19 = new JPanel();
            jPanel19.setLayout(new FlowLayout());
            jPanel19.add(getJButton32(), null);
        }
        return jPanel19;
    }

    /**
     * This method initializes jButton32
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton32() {
        if (jButton32 == null) {
            jButton32 = new JButton();
            jButton32.setText("back");
            jButton32.setPreferredSize(new Dimension(62, 32));
            jButton32.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    cardLayout.show(jPanel, jPanel14.getName());
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return jButton32;
    }

    /**
     * This method initializes jScrollPane1
     *
     * @return javax.swing.JScrollPane
     */
    private JScrollPane getJScrollPane1() {
        if (jScrollPane1 == null) {
            jScrollPane1 = new JScrollPane();
            jScrollPane1.setViewportView(getJTextArea1());
        }
        return jScrollPane1;
    }

    /**
     * This method initializes jTextArea1
     *
     * @return javax.swing.JTextArea
     */
    private JTextArea getJTextArea1() {
        if (jTextArea1 == null) {
            jTextArea1 = new JTextArea();
        }
        return jTextArea1;
    }

    /**
     * This method initializes jCheckBox3
     *
     * @return javax.swing.JCheckBox
     */
    private JCheckBox getJCheckBox3() {
        if (jCheckBox3 == null) {
            jCheckBox3 = new JCheckBox();
            jCheckBox3.setText("hide original edge");
        }
        return jCheckBox3;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                UI thisClass = new UI();
                thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                thisClass.setVisible(true);
            }
        });
    }

    /**
     * This is the default constructor
     */
    public UI() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     *
     * @return void
     */
    private void initialize() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setSize(1366, 768);
        this.setContentPane(getJContentPane());
        this.getJFileChooser();
        this.getJFileChooser1();
        this.setTitle("ACO PMST");
    }

    /**
     * This method initializes jContentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(new BorderLayout());
            jContentPane.add(getJPanel(), BorderLayout.CENTER);
        }
        return jContentPane;
    }

    private JFileChooser getJFileChooser() {
        if (jFileChooser == null) {
            jFileChooser = new JFileChooser();
            FileFilter filter = new ExtensionFileFilter("graph file(*.graph)", new String[]{"graph"});
            jFileChooser.setFileFilter(filter);
        }
        return jFileChooser;
    }//end of initializeJFileChooser()

    private JFileChooser getJFileChooser1() {
        if (jFileChooser1 == null) {
            jFileChooser1 = new JFileChooser();
            FileFilter filter = new ExtensionFileFilter("result file(*.result)", new String[]{"result"});
            jFileChooser1.setFileFilter(filter);
        }
        return jFileChooser1;
    }//end of initializeJFileChooser()

    private boolean browse() {
        boolean status = false;
        int result = jFileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser.getSelectedFile();
            status = canvas.openGraph(file);
        }
        return status;
    }

    private boolean save() {
        boolean status = false;
        int result = jFileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser.getSelectedFile();
            status = canvas.saveGraph(file);
        }
        return status;
    }

    private boolean saveResult() {
        boolean status = false;
        int result = jFileChooser1.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser1.getSelectedFile();
            String s = jTextArea.getText();
            try {
                FileWriter fileWriter = new FileWriter(file);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.append(s);
                printWriter.close();
                fileWriter.close();
                status = true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return status;
    }

    private void viewCurrentGridProperties() {
        Graph g = canvas.getGraph();
        this.jTextFieldNumGridX.setText("" + g.getNumGridX());
        this.jTextFieldNumGridY.setText("" + g.getNumGridY());
        this.jTextFieldGridSize.setText("" + g.getGridSize());
    }

    private void viewCurrentParameters() {
        Parameters p = canvas.getParameters();
        jTextFieldQ.setText("" + (p.getQ()));
        jTextFieldAlpha.setText("" + (p.getAlpha()));
        jTextFieldBeta.setText("" + (p.getBeta()));
        jTextFieldRho.setText("" + (p.getRho()));
        jTextFieldTho.setText("" + (p.getTho()));
        jTextFieldM.setText("" + (p.getM()));
        jTextFieldNCMAX.setText("" + (p.getNCMAX()));
    }

}
