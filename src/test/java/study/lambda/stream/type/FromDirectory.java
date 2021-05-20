package study.lambda.stream.type;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FromDirectory {

	@Test
	public void doTest() throws IOException {
		String tmpdir = System.getProperty("java.io.tmpdir");
		System.out.println("java.io.tmpdir: " + tmpdir);

		Path tempPath = Paths.get(tmpdir);
		Stream<Path> stream = Files.list(tempPath);
		stream.forEach(path -> System.out.println(path.getFileName()));

		File[] files = tempPath.toFile().listFiles();
		if (files != null) {
			for(File f : files) {
				System.out.println(f.getName());
			}
		}


	}
}
