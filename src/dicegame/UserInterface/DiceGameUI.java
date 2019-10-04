/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame.UserInterface;

import dicegame.Account;
import dicegame.AcctValue;
import dicegame.CurrencyVerifier;
import dicegame.Die;
import dicegame.Game;
import dicegame.Input;
import static dicegame.Input.getNumberOfDice;
import static dicegame.Input.getNumberOfSides;
import static dicegame.Input.getPlayerName;
import static dicegame.Input.getStartingAcctVal;
import static dicegame.Input.getWager;
import dicegame.InputValidation;
import dicegame.LettersVerifier;
import dicegame.NumericVerifier;
import dicegame.Player;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.text.InternationalFormatter;

/**
 * The class that is the view for the program
 * @author Wesley
 */
public class DiceGameUI extends javax.swing.JFrame {

    private String playerName;
    private AcctValue initialAcctValue;
    private Account account;
    private Player player;
    private Game game;
    private String aWager;
    private int numOfDice;
    private int numOfSides;
    private String a = null, b = null, c = null, d = null;
    private final int winPercentileLB = 5;
    private final int winPercentileUB = 40;
    private final int losePercentileLB = 41;
    private final int losePercentileUB = 85;
    /**
     * Creates new form DiceGameUI
     */
    public DiceGameUI() { 
        
        //Initialize a game form
        initComponents();
        
        //Cannot roll until user has entered requisite information
        this.btnSubmit.setEnabled(false);
        this.btnRoll.setEnabled(false);
        this.btnPush.setEnabled(false);
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        pnlConfig = new javax.swing.JPanel();
        pnlDice = new javax.swing.JPanel();
        lblNumDice = new javax.swing.JLabel();
        lblNumSides = new javax.swing.JLabel();
        lblRollDice = new javax.swing.JLabel();
        btnRoll = new javax.swing.JButton();
        lblWager = new javax.swing.JLabel();
        btnPush = new javax.swing.JButton();
        txtFWager = new JFormattedTextField();
        txtFWager.setInputVerifier(new CurrencyVerifier(btnRoll));
        txtFWager.addPropertyChangeListener("value", new FormattedTextFieldListener());
        txtFNumSides = new JFormattedTextField();
        txtFNumSides.setInputVerifier(new NumericVerifier());
        txtFNumDice = new JFormattedTextField();
        txtFNumDice.setInputVerifier(new NumericVerifier());
        pnlPlayer = new javax.swing.JPanel();
        lblInitialAcctValue = new javax.swing.JLabel();
        lblPlayerName = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        lblSubmit = new javax.swing.JLabel();
        txtFInitialAcctValue = new JFormattedTextField();
        txtFInitialAcctValue.setInputVerifier(new CurrencyVerifier(btnSubmit));
        txtFInitialAcctValue.addPropertyChangeListener("value", new FormattedTextFieldListener());
        txtFPlayerName = new JFormattedTextField();
        txtFPlayerName.setInputVerifier(new LettersVerifier());
        lblCurrentAcctValue = new javax.swing.JLabel();
        lblNumericAccountValue = new javax.swing.JLabel();
        pnlResults = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaResults = new javax.swing.JTextArea();
        txtAreaResults.setEnabled(false);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlConfig.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pnlDice.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlDice.setToolTipText("Roll Configuration");
        pnlDice.setName("Roll Configuration"); // NOI18N

        lblNumDice.setText("Number of Dice:");

        lblNumSides.setText("Number of Sides:");

        lblRollDice.setText("Roll Dice:");

        btnRoll.setText("Roll!");
        btnRoll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRollActionPerformed(evt);
            }
        });

        lblWager.setText("Wager:");

        btnPush.setText("Push!");
        btnPush.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPushActionPerformed(evt);
            }
        });

        txtFWager.setText("1000");
        txtFWager.setToolTipText("wager as integer");
        txtFWager.setName("txtjFormattedWager"); // NOI18N
        txtFWager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFWagerActionPerformed(evt);
            }
        });

        txtFNumSides.setText("6");
        txtFNumSides.setToolTipText("The number of sides up to 60000");

        txtFNumDice.setText("6");
        txtFNumDice.setToolTipText("The number of dice up to 60000");
        txtFNumDice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFNumDiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDiceLayout = new javax.swing.GroupLayout(pnlDice);
        pnlDice.setLayout(pnlDiceLayout);
        pnlDiceLayout.setHorizontalGroup(
            pnlDiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDiceLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlDiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDiceLayout.createSequentialGroup()
                        .addComponent(lblRollDice)
                        .addGap(18, 18, 18)
                        .addComponent(btnRoll, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPush, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDiceLayout.createSequentialGroup()
                        .addGroup(pnlDiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNumSides)
                            .addComponent(lblWager)
                            .addComponent(lblNumDice))
                        .addGap(28, 28, 28)
                        .addGroup(pnlDiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFWager, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFNumSides, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFNumDice, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        pnlDiceLayout.setVerticalGroup(
            pnlDiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDiceLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(pnlDiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumDice)
                    .addComponent(txtFNumDice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFNumSides, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumSides))
                .addGap(18, 18, 18)
                .addGroup(pnlDiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWager)
                    .addComponent(txtFWager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(pnlDiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRollDice)
                    .addComponent(btnRoll)
                    .addComponent(btnPush))
                .addGap(7, 7, 7))
        );

        pnlPlayer.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlPlayer.setToolTipText("Player configuration");

        lblInitialAcctValue.setText("Initial Account Value:");
        lblInitialAcctValue.setName("lblInitialAcctValue"); // NOI18N

        lblPlayerName.setText("Player Name:");
        lblPlayerName.setName("lblPlayerName"); // NOI18N

        btnSubmit.setText("Submit");
        btnSubmit.setToolTipText("After submit, play controls will become available.");
        btnSubmit.setFocusPainted(false);
        btnSubmit.setFocusable(false);
        btnSubmit.setName("btnSubmit"); // NOI18N
        btnSubmit.setRequestFocusEnabled(false);
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        lblSubmit.setText("Submit:");
        lblSubmit.setName("lblSubmit"); // NOI18N

        txtFInitialAcctValue.setText("100000.23");
        txtFInitialAcctValue.setToolTipText("Starting Account Value");
        txtFInitialAcctValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFInitialAcctValueActionPerformed(evt);
            }
        });

        txtFPlayerName.setText("Name");
        txtFPlayerName.setToolTipText("Enter player name here.");

        javax.swing.GroupLayout pnlPlayerLayout = new javax.swing.GroupLayout(pnlPlayer);
        pnlPlayer.setLayout(pnlPlayerLayout);
        pnlPlayerLayout.setHorizontalGroup(
            pnlPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayerLayout.createSequentialGroup()
                .addGroup(pnlPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPlayerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPlayerName)
                            .addComponent(lblInitialAcctValue)
                            .addComponent(lblSubmit))
                        .addGap(26, 26, 26)
                        .addGroup(pnlPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFInitialAcctValue, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                            .addComponent(txtFPlayerName)))
                    .addGroup(pnlPlayerLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        pnlPlayerLayout.setVerticalGroup(
            pnlPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPlayerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPlayerName)
                    .addComponent(txtFPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(pnlPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInitialAcctValue)
                    .addComponent(txtFInitialAcctValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSubmit)
                    .addComponent(btnSubmit))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        lblCurrentAcctValue.setText("Current Account Value:");
        lblCurrentAcctValue.setToolTipText("");
        lblCurrentAcctValue.setName("lblPlayerName"); // NOI18N

        lblNumericAccountValue.setText("0.00");
        lblNumericAccountValue.setToolTipText("");
        lblNumericAccountValue.setName("lblPlayerName"); // NOI18N

        javax.swing.GroupLayout pnlConfigLayout = new javax.swing.GroupLayout(pnlConfig);
        pnlConfig.setLayout(pnlConfigLayout);
        pnlConfigLayout.setHorizontalGroup(
            pnlConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConfigLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(lblCurrentAcctValue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNumericAccountValue)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConfigLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        pnlConfigLayout.setVerticalGroup(
            pnlConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConfigLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(pnlPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurrentAcctValue)
                    .addComponent(lblNumericAccountValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlDice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );

        pnlResults.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtAreaResults.setBackground(new java.awt.Color(255, 255, 255));
        txtAreaResults.setColumns(20);
        txtAreaResults.setRows(5);
        txtAreaResults.setToolTipText("Results area");
        txtAreaResults.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAreaResults.setEnabled(false);
        jScrollPane1.setViewportView(txtAreaResults);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlResultsLayout = new javax.swing.GroupLayout(pnlResults);
        pnlResults.setLayout(pnlResultsLayout);
        pnlResultsLayout.setHorizontalGroup(
            pnlResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlResultsLayout.setVerticalGroup(
            pnlResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(pnlConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(pnlResults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlResults, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(pnlConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRollActionPerformed
        // Rolls dice
        
        //create an account value object
        AcctValue value2 = new AcctValue(-1,-1, false);
        
        //get wager
        value2 = getWager(this.txtFWager.getText());
            
        Roll(value2);
    }//GEN-LAST:event_btnRollActionPerformed
    
    
    public void Roll(AcctValue value2){
        
        //get number of dice
        int numberOfDice = getNumberOfDice(this.txtFNumDice.getText());
        
        //get number of sides 
        int numberOfSides = getNumberOfSides(this.txtFNumSides.getText());
        
        //define game scores
        this.game.defineScores(numberOfDice, numberOfSides, this.winPercentileLB, this.winPercentileUB, this.losePercentileLB, this.losePercentileUB );
        
        //set set dice count
        this.game.resetDice();
        
        //Make dice
        this.game.makeDice(numberOfDice, numberOfSides);
        
        //set player wager
        this.player.setWager(value2);
        
        int tv = 0;
        //roll each die
        for (Die temp : game.getDice()) {

            //Rolls die
            temp.rollDie();

            //sums values
            tv = tv + temp.getCurrentValue();

        }
        
        //assign the target value
        this.game.setTargetValue(tv); 

        //Verify the score
        game.verifyScore();
        
        if(game.getWin() == 1 && game.getPush()!= true){
            //Won, retrieve the wager and update the players account with the wager amount
            AcctValue acctVal  = player.getWager();
            player.updateAccount(-acctVal.getDollars(), -acctVal.getCents());
            game.incrementWins();
            game.setWin(0);
            
        }
        else if(game.getWin() == 1 && game.getPush() == true){
            //Do nothing
            game.setWin(0);
            game.incrementPushes();
            game.setPush(false);
        }
        else if(game.getWin() == -1 && game.getPush()!= true){
            //Otherwise lost, retrieve the wager
            AcctValue acctVal  = player.getWager();

            //flip it negative
            player.updateAccount(acctVal.getDollars(), acctVal.getCents());

            game.incrementLosses();

            game.setWin(0);
        }
        else if(game.getPush() ==  true){
            game.incrementPushes();
            game.setWin(0);
            game.setPush(false);
        }
        else{
            
            printTextField("\n===========Null game==========");
        }
        
        //finish
        String txt = game.reportGameText();
        
        //print result
        printTextField(txt);
        
        this.lblNumericAccountValue.setText(this.player.getAccount());
    }
    
    public static JFormattedTextField getInitialAcctValueField(){
        return txtFInitialAcctValue;
    }
    
    public static JButton getSubmitBtn(){
        return btnSubmit;
    }
    
    public static JFormattedTextField getWagerValueField(){
        return txtFWager;
    }
    
    public static JButton getRollBtn(){
        return btnRoll;
    }
    
    public void printTextField(String text) {
        this.txtAreaResults.append(text);
    }
    
    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // Submits player info to the game
        this.playerName = getPlayerName(this.txtFPlayerName.getText());
        this.initialAcctValue = getStartingAcctVal(this.txtFInitialAcctValue.getText());
        
        //Set up initial information
        //set up a game
        Account acct = new Account(Locale.US, this.initialAcctValue.getUnits());
        this.player = new Player(this.playerName, acct);
        this.game = new Game(player);
        
        //disable controls after inputing initial info
        this.txtFPlayerName.setEnabled(false);
        this.txtFInitialAcctValue.setEnabled(false);
        this.btnSubmit.setEnabled(false);
        this.lblNumericAccountValue.setText(acct.getAmount());
        //this.btnRoll.setEnabled(true);
        this.btnPush.setEnabled(true);
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnPushActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPushActionPerformed
        //indicate a push
        this.game.setPush(true);
        
        //create an account value object
        AcctValue value2 = new AcctValue(-1,-1, false);
        
        //get wager
        value2 = Input.getWager("0.00");
        
        Roll(value2);
    }//GEN-LAST:event_btnPushActionPerformed

    private void txtFWagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFWagerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFWagerActionPerformed

    private void txtFNumDiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFNumDiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFNumDiceActionPerformed

    private void txtFInitialAcctValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFInitialAcctValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFInitialAcctValueActionPerformed

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
            java.util.logging.Logger.getLogger(DiceGameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiceGameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiceGameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiceGameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DiceGameUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPush;
    private static javax.swing.JButton btnRoll;
    private static javax.swing.JButton btnSubmit;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCurrentAcctValue;
    private javax.swing.JLabel lblInitialAcctValue;
    private javax.swing.JLabel lblNumDice;
    private javax.swing.JLabel lblNumSides;
    private javax.swing.JLabel lblNumericAccountValue;
    private javax.swing.JLabel lblPlayerName;
    private javax.swing.JLabel lblRollDice;
    private javax.swing.JLabel lblSubmit;
    private javax.swing.JLabel lblWager;
    private javax.swing.JPanel pnlConfig;
    private javax.swing.JPanel pnlDice;
    private javax.swing.JPanel pnlPlayer;
    private javax.swing.JPanel pnlResults;
    private javax.swing.JTextArea txtAreaResults;
    private static javax.swing.JFormattedTextField txtFInitialAcctValue;
    private javax.swing.JFormattedTextField txtFNumDice;
    private javax.swing.JFormattedTextField txtFNumSides;
    private javax.swing.JFormattedTextField txtFPlayerName;
    private static javax.swing.JFormattedTextField txtFWager;
    // End of variables declaration//GEN-END:variables
}
