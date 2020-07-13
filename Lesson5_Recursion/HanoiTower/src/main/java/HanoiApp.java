public class HanoiApp {

    public static void main(String[] args) {

        HanoiTower hanoiTower = new HanoiTower(3);
        HanoiTower.step(HanoiTower.numRings, '0', '1', '2');

    }

}
