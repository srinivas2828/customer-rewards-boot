package com.rewards.demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.rewards.demo.functonalinterface.RewardInterfaceFn;

@SpringBootApplication
public class RewardsAssignmentApplication  implements CommandLineRunner{


	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(RewardsAssignmentApplication.class);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		Resource resource = new ClassPathResource("dataset.txt");
		//Alice,18/01/2022,234 
		//<name>,<DD/MM/YYYY>,<amount>
		HashMap<String, CustomerRewards> customerRewards = new HashMap<>();
		try {
			try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
				String line;
				while ((line = br.readLine()) != null) {
					String tokens[] = line.split(",");
					String name = tokens[0];
					int transAmount = Integer.parseInt(tokens[2]);
					int reward = RewardInterfaceFn.calculateRewards(transAmount);
					int month = Integer.parseInt(tokens[1].split("/")[1]);

					if(customerRewards.containsKey(name)) {
						customerRewards.get(name).addReward(month, reward);
					} else {
						CustomerRewards c = new CustomerRewards(name);
						c.addReward(month, reward);
						customerRewards.put(name, c);
					}
				}
			}
			//now process them 
			for(CustomerRewards c: customerRewards.values()) {
				System.out.println(c);
			}


		}catch(FileNotFoundException fnfe) {
		System.out.println("Please check does file exists? if yes then filename is the same?");
		}

	}		
}






