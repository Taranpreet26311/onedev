package com.gitplex.server.manager;

import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;

import org.eclipse.jgit.lib.ObjectId;

import com.gitplex.server.git.NameAndEmail;
import com.gitplex.server.model.Account;
import com.gitplex.server.model.Depot;

public interface CommitInfoManager {
	
	Future<?> requestToCollect(Depot depot);
	
	List<String> getFiles(Depot depot);
	
	int getContributions(Depot depot, Account user, String path);
	
	int getCommitCount(Depot depot);
	
	List<NameAndEmail> getAuthors(Depot depot);
	
	List<NameAndEmail> getCommitters(Depot depot);
	
	/**
	 * Given an ancestor commit, get all its descendant commits including the ancestor commit itself. 
	 * The result might be incomplete if some commits have not be cached yet
	 *  
	 * @param depot
	 * 			repository to get descendant commits
	 * @param ancestor
	 * 			for which commit to get descendants
	 * @return
	 * 			descendant commits
	 */
	Set<ObjectId> getDescendants(Depot depot, ObjectId ancestor);
	
	/**
	 * Given a parent commit, get all its child commits. The result might be incomplete if some commits 
	 * have not be collected yet
	 *  
	 * @param depot
	 * 			repository to get descendant commits
	 * @param parent
	 * 			for which commit to get children
	 * @return
	 * 			child commits
	 */
	Set<ObjectId> getChildren(Depot depot, ObjectId parent);

	void cloneInfo(Depot from, Depot to);
	
}
