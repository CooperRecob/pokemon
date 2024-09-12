package com.projects.pokemon;

import javax.swing.*;

public class Encounter {
    static Pokemon player = new Pokemon("Blastoise", 120, new String[] { "Water Gun", "Hydro Pump", "Surf" },
            new int[] { 20, 40, 30 });
    static Pokemon enemy = new Pokemon("Charziard", 130, new String[] { "Flamethrower", "Fire Blast", "Ember" },
            new int[] { 10, 30, 20 });
    static String playerName = player.getName();
    static String enemyName = enemy.getName();

    public static void encounter() {
        // change the window to a battle screen
        JFrame battleFrame = new JFrame("Battle");
        battleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        battleFrame.setSize(16 * 32, 16 * 32);
        battleFrame.setLocationRelativeTo(null);
        battleFrame.setLayout(null);
        battleFrame.setResizable(false);

        // add buttons on the bottom of the screen for the player to choose an action
        JButton attack = new JButton("Attack");
        attack.setLocation(96, 9 * 32);
        attack.setSize(128, 64);
        battleFrame.add(attack);

        JButton bag = new JButton("Bag");
        bag.setLocation(16 * 32 - (96 + 128), 9 * 32);
        bag.setSize(128, 64);
        battleFrame.add(bag);

        JButton pokemon = new JButton("Pokemon");
        pokemon.setLocation(96, 12 * 32);
        pokemon.setSize(128, 64);
        battleFrame.add(pokemon);

        JButton run = new JButton("Run");
        run.setLocation(16 * 32 - (96 + 128), 12 * 32);
        run.setSize(128, 64);
        battleFrame.add(run);

        // add the enemy sprite
        JLabel enemySprite = new JLabel(new ImageIcon("com/projects/pokemon/images/" + enemyName + ".png"));
        enemySprite.setBounds(8 * 32, -64, 32 * 8, 32 * 8);
        battleFrame.add(enemySprite);

        // add the player sprite
        JLabel playerSprite = new JLabel(new ImageIcon("com/projects/pokemon/images/" + playerName + ".png"));
        playerSprite.setBounds(0, 1 * 32, 32 * 8, 32 * 8);
        battleFrame.add(playerSprite);

        // add the health bars
        JProgressBar playerHealthBar = new JProgressBar(0, 100);
        playerHealthBar.setValue(120);
        playerHealthBar.setStringPainted(true);
        playerHealthBar.setString(playerName + " " + player.getHealth() + "/120");
        playerHealthBar.setBounds(32, 16, 6 * 32, 32);
        battleFrame.add(playerHealthBar);

        JProgressBar enemyHealthBar = new JProgressBar(0, 100);
        enemyHealthBar.setValue(130);
        enemyHealthBar.setStringPainted(true);
        enemyHealthBar.setString(enemyName + " " + enemy.getHealth() + "/130");
        enemyHealthBar.setBounds(8 * 32, 7 * 32, 6 * 32, 32);
        battleFrame.add(enemyHealthBar);

        // add the "note" text right below enemy sprite
        JLabel note = new JLabel("You encountered a wild " + enemyName + "!");
        note.setBounds(8 * 32, 8 * 32, 8 * 32, 32);
        battleFrame.add(note);

        // add the background
        JLabel background = new JLabel(new ImageIcon("com/projects/pokemon/images/background.png"));
        background.setBounds(0, 0, 16 * 32, 16 * 32);
        battleFrame.add(background);

        // add the moves and back button
        JButton move1 = new JButton(player.getMoves()[0]);
        move1.setLocation(96, 9 * 32);
        move1.setSize(128, 64);
        battleFrame.add(move1);

        JButton move2 = new JButton(player.getMoves()[1]);
        move2.setLocation(16 * 32 - (96 + 128), 9 * 32);
        move2.setSize(128, 64);
        battleFrame.add(move2);

        JButton move3 = new JButton(player.getMoves()[2]);
        move3.setLocation(96, 12 * 32);
        move3.setSize(128, 64);
        battleFrame.add(move3);

        JButton back = new JButton("Back");
        back.setLocation(16 * 32 - (96 + 128), 12 * 32);
        back.setSize(128, 64);
        battleFrame.add(back);

        move1.setVisible(false);
        move2.setVisible(false);
        move3.setVisible(false);
        back.setVisible(false);

        // attack code
        attack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("Attack");
        
                attack.setVisible(false);
                bag.setVisible(false);
                pokemon.setVisible(false);
                run.setVisible(false);
        
                move1.setVisible(true);
                move2.setVisible(true);
                move3.setVisible(true);
                back.setVisible(true);
        
                // move1 code
                move1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        System.out.println("Move 1");
                    }
                });
        
                // move2 code
                move2.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        System.out.println("Move 2");
                    }
                });
        
                // move3 code
                move3.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        System.out.println("Move 3");
                    }
                });
        
                // back code
                back.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        move1.setVisible(false);
                        move2.setVisible(false);
                        move3.setVisible(false);
                        back.setVisible(false);
        
                        attack.setVisible(true);
                        bag.setVisible(true);
                        pokemon.setVisible(true);
                        run.setVisible(true);
                    }
                });
            }
        });

        // bag code
        bag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("Bag");
            }
        });

        // pokemon code
        pokemon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("Switch Pokemon");
            }
        });

        // run code
        run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                note.setText("You ran away!");
                new java.util.Timer().schedule(new java.util.TimerTask() {
                    @Override
                    public void run() {
                        battleFrame.dispose();
                    }
                }, 1000);
            }
        });

        battleFrame.setVisible(true);
    }

}
