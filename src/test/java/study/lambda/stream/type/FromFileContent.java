package study.lambda.stream.type;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class FromFileContent {

	private static final String CRLF = System.lineSeparator();

	@Test
	public void doTest() throws IOException {
		String tmpdir = System.getProperty("java.io.tmpdir");
		Path tempPath = Paths.get(tmpdir, "sample.txt");

		String content = "☆ Hello ☆" + CRLF + "★ World ★";

		try {
			Files.write(tempPath, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return;
		}
		System.out.println("Write Text File: " + tempPath);
		Stream<String> stream;

		// Charset.defaultCharset() : OS default Charset
		//
		System.out.println("Files.lines()");
		stream = Files.lines(tempPath, StandardCharsets.UTF_8);
		stream.forEach(System.out::println);

		System.out.println("\nBufferedReader.lines()");
		File file = tempPath.toFile(); // access os file system
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			stream = br.lines();
			stream.forEach(System.out::println);
		}

		if (file.delete())
			System.out.println("Deleted File: " + file.getAbsolutePath());

	}
}
