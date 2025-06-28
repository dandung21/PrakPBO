package Week08.THT;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class InputHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
            }
        }
    }
}

class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private Player player;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}

class AccountManager {
    private static Map<String, User> users = new HashMap<>();
    private static final String USERS_FILE = "users.dat";

    public static void loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USERS_FILE))) {
            users = (HashMap<String, User>) ois.readObject();
            System.out.println("Data pengguna berhasil dimuat.");
        } catch (FileNotFoundException e) {
            System.out.println("File data pengguna tidak ditemukan. Akan dibuat yang baru.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error memuat data pengguna: " + e.getMessage());
        }
    }

    public static void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE))) {
            oos.writeObject(users);
            System.out.println("Data pengguna berhasil disimpan.");
        } catch (IOException e) {
            System.err.println("Error menyimpan data pengguna: " + e.getMessage());
        }
    }

    public static boolean register(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Username sudah ada. Pilih username lain.");
            return false;
        }
        User newUser = new User(username, password);
        users.put(username, newUser);
        saveUsers();
        System.out.println("Registrasi berhasil!");
        return true;
    }

    public static User login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login berhasil!");
            return user;
        }
        System.out.println("Username atau password salah.");
        return null;
    }
}

abstract class Character implements Serializable {
    protected String name;
    protected double health;
    protected double temporalEnergy;
    protected double attackPower;

    public Character(String name, double health, double temporalEnergy, double attackPower) {
        this.name = name;
        this.health = health;
        this.temporalEnergy = temporalEnergy;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getTemporalEnergy() {
        return temporalEnergy;
    }

    public void setTemporalEnergy(double temporalEnergy) {
        this.temporalEnergy = temporalEnergy;
    }

    public double getAttackPower() {
        return attackPower;
    }

    public abstract void attack(Character target);
}

class Player extends Character implements Serializable {
    private static final long serialVersionUID = 1L;
    private int level;
    private double experience;
    private String krononautType;
    private ArrayList<String> backpack;

    public Player(String name, String krononautType) {
        super(name, 100.0, 80.0, 10.0);
        this.level = 1;
        this.experience = 0;
        this.krononautType = krononautType;
        this.backpack = new ArrayList<>();
        switch (krononautType) {
            case "Arbiter Waktu":
                this.temporalEnergy = 100.0;
                this.attackPower = 8.0;
                break;
            case "Relik Pembawa":
                this.health = 120.0;
                this.attackPower = 7.0;
                break;
            case "Gema Pertempuran":
                this.attackPower = 12.0;
                this.health = 90.0;
                break;
        }
    }

    public int getLevel() {
        return level;
    }

    public void addExperience(double exp) {
        this.experience += exp;
        if (this.experience >= level * 20) {
            levelUp();
        }
    }

    private void levelUp() {
        level++;
        health += 20;
        temporalEnergy += 10;
        attackPower += 2;
        experience = 0;
        System.out.println("Level Up! Anda sekarang Level " + level + "!");
        System.out.println("Health: " + String.format("%.1f", health) + ", Temporal Energy: " + String.format("%.1f", temporalEnergy) + ", Attack Power: " + String.format("%.1f", attackPower));
    }

    public String getKrononautType() {
        return krononautType;
    }

    public ArrayList<String> getBackpack() {
        return backpack;
    }

    public void addItem(String item) {
        if (backpack.size() < 10) {
            backpack.add(item);
            System.out.println("Anda mendapatkan Item: " + item);
        } else {
            System.out.println("Backpack penuh! Item " + item + " tidak dapat diambil.");
        }
    }

    public void usePotion() {
        int potionIndex = -1;
        for (int i = 0; i < backpack.size(); i++) {
            if (backpack.get(i).contains("Potion")) {
                potionIndex = i;
                break;
            }
        }

        if (potionIndex != -1) {
            backpack.remove(potionIndex);
            this.health += 50;
            this.temporalEnergy += 20;
            System.out.println("Potion berhasil digunakan!");
            System.out.println("Your health: " + String.format("%.1f", this.health));
            System.out.println("Your Mana: " + String.format("%.1f", this.temporalEnergy));
        } else {
            System.out.println("Anda tidak memiliki Potion.");
        }
    }

    @Override
    public void attack(Character target) {
        double damage = this.attackPower + (new Random().nextInt(5) - 2);
        System.out.println("You hit the enemy for " + String.format("%.1f", damage) + " damage");
        target.setHealth(target.getHealth() - damage);
    }
}

class Enemy extends Character implements Serializable {
    private static final long serialVersionUID = 1L;
    private int experienceDrop;

    public Enemy(String name, double health, double temporalEnergy, double attackPower, int experienceDrop) {
        super(name, health, temporalEnergy, attackPower);
        this.experienceDrop = experienceDrop;
    }

    public int getExperienceDrop() {
        return experienceDrop;
    }

    @Override
    public void attack(Character target) {
        double damage = this.attackPower + (new Random().nextInt(3));
        System.out.println("The enemy hit you for " + String.format("%.1f", damage) + " damage");
        target.setHealth(target.getHealth() - damage);
    }
}

class Game {
    private Player currentPlayer;
    private Random random = new Random();
    private String currentEra;
    private String[] eras = {"Era Purba", "Zaman Medieval", "Era Futuristik", "Masa Kini Alternatif"};

    public Game(Player player) {
        this.currentPlayer = player;
        this.currentEra = "Masa Kini Alternatif";
    }

    public void displayPlayerStats() {
        System.out.println("Your health: " + String.format("%.1f", currentPlayer.getHealth()));
        System.out.println("Your Mana: " + String.format("%.1f", currentPlayer.getTemporalEnergy()));
        System.out.println("Your Level: " + currentPlayer.getLevel() + ".0");
        System.out.println("Krononaut Tipe: " + currentPlayer.getKrononautType());
        System.out.println("Era Saat Ini: " + currentEra);
    }

    public void startGameMenu() {
        int choice;
        do {
            System.out.println("\n*** Selamat datang, " + currentPlayer.getName() + "! ***");
            displayPlayerStats();
            System.out.println("\n1. Open backpack");
            System.out.println("2. Start Adventure");
            System.out.println("3. Use potion");
            System.out.println("4. Exit");
            choice = InputHandler.getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    openBackpack();
                    break;
                case 2:
                    startAdventure();
                    break;
                case 3:
                    currentPlayer.usePotion();
                    // Bagian ini menampilkan prompt berulang, perlu disesuaikan atau dihapus jika tidak diperlukan
                    System.out.println("Your health: " + String.format("%.1f", currentPlayer.getHealth()));
                    System.out.println("Your Mana: " + String.format("%.1f", currentPlayer.getTemporalEnergy()));
                    System.out.println("Your Level: " + currentPlayer.getLevel() + ".0");
                    System.out.println("\n1. Go straight");
                    System.out.println("2. Move right");
                    System.out.println("3. move left");
                    System.out.println("4. Exit Game");
                    InputHandler.getStringInput("Enter your choice: ");
                    break;
                case 4:
                    System.out.println("Terima kasih sudah bermain Chronos Echoes!");
                    AccountManager.saveUsers();
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (true);
    }

    private void openBackpack() {
        System.out.println("\n****Data Information****");
        System.out.println("Blood = " + String.format("%.1f", currentPlayer.getHealth()));
        System.out.println("Mana = " + String.format("%.1f", currentPlayer.getTemporalEnergy()));
        System.out.println("Items in Backpack");
        if (currentPlayer.getBackpack().isEmpty()) {
            for (int i = 0; i < 10; i++) {
                System.out.println((i + 1) + ". null");
            }
        } else {
            for (int i = 0; i < 10; i++) {
                if (i < currentPlayer.getBackpack().size()) {
                    System.out.println((i + 1) + ". " + currentPlayer.getBackpack().get(i));
                } else {
                    System.out.println((i + 1) + ". null");
                }
            }
        }
        InputHandler.getStringInput("Back to games (yes/no)? ");
    }

    private void startAdventure() {
        System.out.println("\nAnda melangkah maju. Udara terasa " + getRandomWeather() + "...");
        changeEraRandomly();
        System.out.println("Anda berada di " + currentEra + "!");

        int eventChance = random.nextInt(100);
        if (eventChance < 40) {
            encounterEnemy();
        } else if (eventChance < 70) {
            findItem();
        } else if (eventChance < 85) {
            triggerAnomaly();
        } else {
            System.out.println("Anda melanjutkan perjalanan. Tidak ada kejadian khusus.");
        }
        // Bagian ini menampilkan prompt berulang setelah setiap petualangan, perlu disesuaikan atau dihapus jika tidak diperlukan
        System.out.println("Your health: " + String.format("%.1f", currentPlayer.getHealth()));
        System.out.println("Your Mana: " + String.format("%.1f", currentPlayer.getTemporalEnergy()));
        System.out.println("Your Level: " + currentPlayer.getLevel() + ".0");
        System.out.println("\n1. Go straight");
        System.out.println("2. Move right");
        System.out.println("3. move left");
        System.out.println("4. Exit Game");
        InputHandler.getStringInput("Enter your choice: ");
    }

    private String getRandomWeather() {
        String[] weathers = {"dingin", "panas", "berangin", "aneh", "elektrik"};
        return weathers[random.nextInt(weathers.length)];
    }

    private void changeEraRandomly() {
        if (random.nextInt(100) < 30) {
            String newEra = eras[random.nextInt(eras.length)];
            if (!newEra.equals(currentEra)) {
                currentEra = newEra;
                System.out.println("Realitas bergeser! Anda kini berada di " + currentEra + "!");
            }
        }
    }

    private void encounterEnemy() {
        System.out.println("Upss!");
        System.out.println("Enemy founded");

        Enemy enemy = getRandomEnemy();
        System.out.println("======Enemy Identity======");
        System.out.println("Enemy Name: " + enemy.getName());
        System.out.println("Enemy Blood: " + String.format("%.1f", enemy.getHealth()));
        System.out.println("Enemy mana: " + String.format("%.1f", enemy.getTemporalEnergy()));
        System.out.println("Enemy Attack Power: " + String.format("%.1f", enemy.getAttackPower()));
        System.out.println("Your health: " + String.format("%.1f", currentPlayer.getHealth()));

        while (currentPlayer.getHealth() > 0 && enemy.getHealth() > 0) {
            System.out.println("\n1. Attack");
            System.out.println("2. Run");
            int choice = InputHandler.getIntInput("Enter your choice: ");

            if (choice == 1) {
                currentPlayer.attack(enemy);
                if (enemy.getHealth() <= 0) {
                    System.out.println("You defeated the enemy!");
                    currentPlayer.addExperience(enemy.getExperienceDrop());
                    System.out.println("Levels Up!");
                    break;
                }
                enemy.attack(currentPlayer);
                if (currentPlayer.getHealth() <= 0) {
                    System.out.println("Anda dikalahkan oleh " + enemy.getName() + "!");
                    System.out.println("Game Over!");
                    System.exit(0);
                }
            } else if (choice == 2) {
                if (random.nextBoolean()) {
                    System.out.println("You ran away from the enemy");
                    break;
                } else {
                    System.out.println("Gagal melarikan diri! " + enemy.getName() + " menyerang!");
                    enemy.attack(currentPlayer);
                    if (currentPlayer.getHealth() <= 0) {
                        System.out.println("Anda dikalahkan oleh " + enemy.getName() + " saat mencoba kabur!");
                        System.out.println("Game Over!");
                        System.exit(0);
                    }
                }
            } else {
                System.out.println("Pilihan tidak valid.");
            }

            System.out.println("\n======Enemy Identity======");
            System.out.println("Enemy Name: " + enemy.getName());
            System.out.println("Enemy Blood: " + String.format("%.1f", enemy.getHealth()));
            System.out.println("Enemy mana: " + String.format("%.1f", enemy.getTemporalEnergy()));
            System.out.println("Enemy Attack Power: " + String.format("%.1f", enemy.getAttackPower()));
            System.out.println("Your health: " + String.format("%.1f", currentPlayer.getHealth()));
        }
    }

    private Enemy getRandomEnemy() {
        String[] enemyNames;
        double baseHealth;
        double baseMana;
        double baseAttack;
        int baseExp;

        switch (currentEra) {
            case "Era Purba":
                enemyNames = new String[]{"Raptor Primal", "Mammoth Berbulu", "Theropod Cepat"};
                baseHealth = 30; baseMana = 5; baseAttack = 8; baseExp = 10;
                break;
            case "Zaman Medieval":
                enemyNames = new String[]{"Goblin Penjarah", "Kesatria Terkutuk", "Penyihir Sesat"};
                baseHealth = 40; baseMana = 10; baseAttack = 10; baseExp = 15;
                break;
            case "Era Futuristik":
                enemyNames = new String[]{"Drone Pengintai", "Robot Penjaga", "Cyborg Pemburu"};
                baseHealth = 50; baseMana = 15; baseAttack = 12; baseExp = 20;
                break;
            case "Masa Kini Alternatif":
                enemyNames = new String[]{"Agen Rahasia Korup", "Wabah Nanobot", "Mutan Kota"};
                baseHealth = 45; baseMana = 12; baseAttack = 11; baseExp = 18;
                break;
            default:
                enemyNames = new String[]{"Musuh Tak Dikenal"};
                baseHealth = 35; baseMana = 8; baseAttack = 9; baseExp = 12;
                break;
        }

        String chosenName = enemyNames[random.nextInt(enemyNames.length)];
        double healthMultiplier = 1 + (currentPlayer.getLevel() - 1) * 0.1;
        double attackMultiplier = 1 + (currentPlayer.getLevel() - 1) * 0.05;
        int expMultiplier = 1 + (currentPlayer.getLevel() - 1) / 2;

        return new Enemy(chosenName,
                baseHealth * healthMultiplier,
                baseMana,
                baseAttack * attackMultiplier,
                baseExp * expMultiplier);
    }


    private void findItem() {
        String[] commonItems = {"Relik Penyembuh (Potion)", "Fragmen Waktu Kecil", "Koin Era Lama"};
        String[] rareItems = {"Kunci Kronos (Era Purba)", "Chip Memori Kuno", "Peta Dimensi"};

        String foundItem;
        if (random.nextInt(100) < 20) {
            foundItem = rareItems[random.nextInt(rareItems.length)];
        } else {
            foundItem = commonItems[random.nextInt(commonItems.length)];
        }
        currentPlayer.addItem(foundItem);
        System.out.println("You got a Item: " + foundItem);
    }

    private void triggerAnomaly() {
        System.out.println("Upss!");
        System.out.println("Anomali Waktu Ditemukan!");
        int anomalyType = random.nextInt(3);

        switch (anomalyType) {
            case 0:
                System.out.println("Anda merasakan aliran energi! Anda mendapatkan bonus XP!");
                currentPlayer.addExperience(15);
                break;
            case 1:
                System.out.println("Realitas berkedip! Anda kehilangan sedikit Energi Temporal.");
                currentPlayer.setTemporalEnergy(currentPlayer.getTemporalEnergy() - 10);
                if (currentPlayer.getTemporalEnergy() < 0) currentPlayer.setTemporalEnergy(0);
                System.out.println("Your Mana: " + String.format("%.1f", currentPlayer.getTemporalEnergy()));
                break;
            case 2:
                System.out.println("Distorsi temporal melukai Anda! Anda kehilangan sedikit Health.");
                currentPlayer.setHealth(currentPlayer.getHealth() - 15);
                if (currentPlayer.getHealth() < 0) currentPlayer.setHealth(0);
                System.out.println("Your health: " + String.format("%.1f", currentPlayer.getHealth()));
                if (currentPlayer.getHealth() <= 0) {
                    System.out.println("Anda tidak bisa menahan anomali ini! Game Over!");
                    System.exit(0);
                }
                break;
        }
    }
}

public class ChronosEchoes {
    public static void main(String[] args) {
        AccountManager.loadUsers();

        int choice;
        do {
            System.out.println("\nSelamat datang di Chronos Echoes: The Shifting Sands!");
            System.out.println("1. Login");
            System.out.println("2. Sign up");
            System.out.println("3. Exit");
            choice = InputHandler.getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    handleLogin();
                    break;
                case 2:
                    handleSignUp();
                    break;
                case 3:
                    System.out.println("Keluar dari game. Sampai jumpa!");
                    AccountManager.saveUsers();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 3);
    }

    private static void handleLogin() {
        String username = InputHandler.getStringInput("Enter a username: ");
        String password = InputHandler.getStringInput("Enter a password: ");
        User loggedInUser = AccountManager.login(username, password);
        if (loggedInUser != null) {
            if (loggedInUser.getPlayer() == null) {
                System.out.println("\nchoose your roles:");
                System.out.println("1. Magicians");
                System.out.println("2. Fighters");
                System.out.println("3. Scavenger (Relik Pembawa)");
                int roleChoice = InputHandler.getIntInput("Your choice: ");
                String krononautType;
                switch (roleChoice) {
                    case 1:
                        krononautType = "Arbiter Waktu";
                        break;
                    case 2:
                        krononautType = "Gema Pertempuran";
                        break;
                    case 3:
                        krononautType = "Relik Pembawa";
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Default ke Arbiter Waktu.");
                        krononautType = "Arbiter Waktu";
                        break;
                }
                Player newPlayer = new Player(loggedInUser.getUsername(), krononautType);
                loggedInUser.setPlayer(newPlayer);
                AccountManager.saveUsers();
            }
            Game game = new Game(loggedInUser.getPlayer());
            game.startGameMenu();
        }
    }

    private static void handleSignUp() {
        String username = InputHandler.getStringInput("Enter a username: ");
        String password = InputHandler.getStringInput("Enter a password: ");

        if (AccountManager.register(username, password)) {
            System.out.println("\nchoose your roles:");
            System.out.println("1. Magicians");
            System.out.println("2. Fighters");
            System.out.println("3. Scavenger (Relik Pembawa)");
            int roleChoice = InputHandler.getIntInput("Your choice: ");
            String krononautType;
            switch (roleChoice) {
                case 1:
                    krononautType = "Arbiter Waktu";
                    break;
                case 2:
                    krononautType = "Gema Pertempuran";
                    break;
                case 3:
                    krononautType = "Relik Pembawa";
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Default ke Arbiter Waktu.");
                    krononautType = "Arbiter Waktu";
                    break;
            }
            User newUser = AccountManager.login(username, password);
            if (newUser != null) {
                Player newPlayer = new Player(username, krononautType);
                newUser.setPlayer(newPlayer);
                AccountManager.saveUsers();
                System.out.println("Profil pemain berhasil dibuat untuk " + krononautType + "!");
            }
        }
    }
}
