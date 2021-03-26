package com.pachyc.saver.view;

import com.pachyc.saver.files.CopySave;
import com.pachyc.saver.files.ListManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChosePreset extends JDialog{
    private JPanel mainPanel;
    private JList choseList;
    private JPanel chosePanel;
    private JPanel listPanel;
    private JPanel buttonPanel;
    private JButton choseButt;
    private JButton cancleButt;
    private ListManager listManager;
    private CopySave setPreset;

    public ChosePreset(JFrame parent, boolean modal){
        super(parent, modal);
        this.setTitle("Chose Preset!");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setContentPane(this.mainPanel);
        this.pack();

        this.listManager = new ListManager();
        this.choseList.setModel(listManager.getModel());

        cancleButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancleBut(e);
            }
        });
        choseButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chosButt(e);
            }
        });
    }

    private void chosButt(ActionEvent e){
        int selectedIndex = this.choseList.getSelectedIndex();
        this.setPreset = this.listManager.getCopySave(selectedIndex);
        dispose();
    }

    private void cancleBut(ActionEvent a){
        dispose();
    }

    public CopySave getSetPreset() throws IllegalArgumentException {
        if (this.setPreset == null){
            throw new IllegalArgumentException("Nezvolil jsi preset!");
        }
        return setPreset;
    }
}
