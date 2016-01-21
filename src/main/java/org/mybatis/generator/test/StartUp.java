package org.mybatis.generator.test;


import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class StartUp {

	public static void main(String[] args) {
		try {
			List<String> warnings = new ArrayList<String>();
			URI url = StartUp.class.getResource("generatorConfig.xml").toURI();
			System.out.println(url.toString());
			File configFile = new File(url);
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config = cp.parseConfiguration(configFile);
			DefaultShellCallback shellCallback = new DefaultShellCallback(true);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
					shellCallback, warnings);
			myBatisGenerator.generate(null);
			System.out.println(warnings);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
