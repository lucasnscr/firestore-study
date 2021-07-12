package com.lucasnscr.gcp.firestorestudy.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.lucasnscr.gcp.firestorestudy.entity.Phone;
import com.lucasnscr.gcp.firestorestudy.entity.User;

@Component
public class UserRepository {
	
	@Autowired
	private Firestore firestore;
	
	private static final String USERS = "users";
	
	public void saveAsynchronouslyFromMap(String name, List<Phone> phones) throws InterruptedException, java.util.concurrent.ExecutionException {
		DocumentReference docRef = this.firestore.collection(USERS).document(name);
		Map<String, Object> data = new HashMap<>();
		data.put("name", name);
		data.put("phones", phones);
		ApiFuture<WriteResult> result = docRef.set(data);
		System.out.println("Update time: " + result.get().getUpdateTime());
	}
	
	public void update(User user) throws ExecutionException, InterruptedException {
		WriteResult writeResult = this.firestore.document(USERS + "/" + user.getName()).set(user).get();
		System.out.println("Update time: " + writeResult.getUpdateTime());
	}
	
	public User searchFromName(String name) throws ExecutionException, InterruptedException {
		User user = null;
		ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = this.firestore.document(USERS + "/" + name).get();
		user = documentSnapshotApiFuture.get().toObject(User.class);
		if (user != null) {
			return user;
		}
		return user;
	}
	
	public void deleteSomethingDocument(String name) {
		try {
			User user = null;
			ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = this.firestore.document(USERS + "/" + name).get();
			user = documentSnapshotApiFuture.get().toObject(User.class);
			if (user != null) {
				firestore.document(USERS + "/" + name).delete();
			}
		} catch (InterruptedException | ExecutionException e) {
			e.getLocalizedMessage();
		}
	}

}
