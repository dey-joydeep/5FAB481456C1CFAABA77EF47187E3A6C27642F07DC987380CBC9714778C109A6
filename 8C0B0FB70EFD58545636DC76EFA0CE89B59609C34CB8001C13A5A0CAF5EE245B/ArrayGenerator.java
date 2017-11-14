import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ArrayGenerator {

	public static void main(String[] args) throws IOException {

		int scale = 100;
		int range = 10;

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < range; i++) {
			Random random = new Random();
			sb.append(random.nextInt(scale * 10));
			sb.append(",");
		}

		File f = new File("D:\\test\\array.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(f, false));
		bw.write(sb.toString());
		bw.close();
	}
}
