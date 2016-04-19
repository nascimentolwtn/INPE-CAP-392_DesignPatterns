package com.mystudy;

import br.com.metricminer2.domain.Commit;
import br.com.metricminer2.domain.Modification;
import br.com.metricminer2.persistence.PersistenceMechanism;
import br.com.metricminer2.scm.CommitVisitor;
import br.com.metricminer2.scm.SCMRepository;

public class ModificationsVisitor implements CommitVisitor {

	@Override
	public void process(SCMRepository repo, Commit commit, PersistenceMechanism writer) {

		for (Modification m : commit.getModifications()) {
			writer.write(
					commit.getHash(),
					commit.getDate().toInstant().toString(),
//					commit.getAuthor().getName(),
					commit.getCommitter().getName(),

					m.getFileName(), m.getType());

		}
	}

	@Override
	public String name() {
		return "modifications";
	}

}