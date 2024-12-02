import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void showOptions() {
        System.out.println("Options:");
        System.out.println("1. Hero attacks Monster");
        System.out.println("2. Monster attacks Hero");
        System.out.println("3. Hero equips/unequipped sword");
        System.out.println("4. Monster equips/unequipped sword");
        System.out.println("5. Hero equips/unequipped shield");
        System.out.println("6. Monster equips/unequipped shield");
        System.out.println("7. Show hero's information");
        System.out.println("8. Show monster's information");
        System.out.println("9. Hero equips/unequipped necklace");
        System.out.println("10. Monster equips/unequipped ring");
        System.out.println("0. Exit");
    }

    public static void main(String[] args) {
        Knight hero = new Knight("Hero");
        Knight monster = new Knight("Monster");
        Wizard wizard = new Wizard("Harry Potter");

        Sword heroSword = new Sword("Excalibur", 30, 10);
        Shield heroShield = new Shield("Relic Shield", 5, 3);
        Sword monsterSword = new Sword("Long Sword", 10, 5);
        Shield monsterShield = new Shield("Skeleton's Bone", 20, 7);
        Staff wizardStaff = new Staff("The Elder Wand", 100, 50);

        Accessory ringOfSwiftness = new RingOfSwiftness("Lord of the Ring", 0, 0, 45, 0, 0);
        Accessory necklaceOfDamage = new NecklaceOfDamage("King's necklace", 5, 0, 0, 37, 0);


        showOptions();
        while (true) {
            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 1) {
                hero.attack(monster);
            } else if (choice == 2) {
                monster.attack(hero);
            } else if (choice == 3) {
                hero.equipSword(heroSword);
            } else if (choice == 4) {
                monster.equipSword(monsterSword);
            } else if (choice == 5) {
                hero.equipShield(heroShield);
            } else if (choice == 6) {
                monster.equipShield(monsterShield);
            } else if (choice == 7) {
                hero.showCharacterInfo();
            } else if (choice == 8) {
                monster.showCharacterInfo();
            } else if (choice == 9) {
                hero.equipAccessory(necklaceOfDamage);
            } else if (choice == 10) {
                monster.equipAccessory(ringOfSwiftness);
            } else if (choice == 0) {
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}