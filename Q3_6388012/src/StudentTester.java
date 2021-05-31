import java.util.Arrays;

public class StudentTester {

	public static void testTask1()
	{
		class Blob extends Object3D
		{	
			public Blob(String _name, Object3D.Material _matType) { super(_name, _matType); }
			public double getVolume() { return 125; }
			public double getSurface() { return 150; }
		}
		
		Blob b1 = new Blob("OakWoodBlob", Object3D.Material.OakWood);
		Blob b2 = new Blob("HydrogenBlob", Object3D.Material.Hydrogen);
		Blob b3 = new Blob("GoldBlob", Object3D.Material.Gold);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
	}
	
	public static void testTask2()
	{
		Object3D[] os = new Object3D[6];
		os[0] = new Cube("RubberCube", Object3D.Material.Rubber, 3.5);
		os[1] = new Cube("OxygenCube", Object3D.Material.Oxygen, 100);
		os[2] = new Cube("HeliumCube", Object3D.Material.Helium, 6.38);

		os[3] = new Sphere("GoldSphere", Object3D.Material.Gold, 6.78);
		os[4] = new Sphere("WaxSphere", Object3D.Material.Wax, 99.78);
		os[5] = new Sphere("HydroSphere", Object3D.Material.Hydrogen, 5678.78);
		System.out.println(Arrays.toString(os).replaceAll("],", "],\n"));
	}

	public static void testTask3()
	{
		WaxDie[] wds = new WaxDie[5];
		wds[0] = new WaxDie("B", 3);
		WaxDie waxDieB = wds[0];
		wds[1] = new WaxDie("E", 2);
		wds[2] = new WaxDie("D", 1);
		wds[3] = new WaxDie("C", 2);
		wds[4] = new WaxDie("A", 1);
		System.out.println("All wax dice before sorting: ");
		System.out.println(Arrays.toString(wds).replaceAll("],", "],\n"));
		System.out.println("All wax dice after sorting by volumes: ");
		Arrays.sort(wds);
		System.out.println(Arrays.toString(wds).replaceAll("],", "],\n"));
		System.out.println();

		ButterBall[] bbs = new ButterBall[5];
		bbs[0] = new ButterBall("Z", 10.2);
		ButterBall butterBallZ = bbs[0];
		bbs[1] = new ButterBall("X", 12.9);
		bbs[2] = new ButterBall("Y", 13.5);
		bbs[3] = new ButterBall("T", 10.2);
		bbs[4] = new ButterBall("S", 12.9);
		System.out.println("All butter balls before sorting: ");
		System.out.println(Arrays.toString(bbs).replaceAll("],", "],\n"));
		System.out.println("All butter balls after sorting by surface areas: ");
		Arrays.sort(bbs);
		System.out.println(Arrays.toString(bbs).replaceAll("],", "],\n"));

		Sphere s = (Sphere)waxDieB.convertToOtherShape();
		Cube c = (Cube)butterBallZ.convertToOtherShape();
		System.out.println();
		System.out.println("Converting WaxDie B to a Sphere with radius: "+String.format("%,.2f", s.getRadius())+" and volume: "+String.format("%,.2f", s.getVolume()));
		System.out.println("Converting ButterBall Z to a Cube with edge length: "+String.format("%,.2f", c.getEdge())+" and volume: "+String.format("%,.2f", c.getVolume()));
	}
	
	public static void main(String[] args)
	{
		//Uncomment test case that you want to try for each task
		//testTask1();
		//testTask2();
		testTask3();
	}
	
}

