package com.mystudy;
import br.com.metricminer2.MetricMiner2;
import br.com.metricminer2.RepositoryMining;
import br.com.metricminer2.Study;
import br.com.metricminer2.persistence.csv.CSVFile;
import br.com.metricminer2.scm.GitRepository;
import br.com.metricminer2.scm.commitrange.Commits;

public class MyStudy implements Study {

	public static void main(String[] args) {
		new MetricMiner2().start(new MyStudy());
		System.out.println("Finish!");
	}

	@Override
	public void execute() {
		new RepositoryMining()
			.in(GitRepository.singleProject("C:\\Users\\Nascimento\\git\\VANT2008"))
			.through(Commits.all())
			.withThreads(3)
			.process(new DevelopersVisitor(), new CSVFile(".\\devs.csv"))
			.process(new ModificationsVisitor(), new CSVFile(".\\modifications.csv"))
			.process(new JavaParserVisitor(), new CSVFile(".\\java-parser.csv"))
			.mine();
	}
}
	
