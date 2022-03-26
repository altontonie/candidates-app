package thashort.gamer.candidateapp.service.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import thashort.gamer.candidateapp.model.entity.Candidate;
import thashort.gamer.candidateapp.service.CandidateService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class CandidateServiceImpl implements CandidateService {
    @Override
    public Candidate getCandidate(String id) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection("User").document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Candidate candidate;
        if(document.exists()){
            candidate = document.toObject(Candidate.class);
            return candidate;
        }
        return null;
    }

    @Override
    public List<Candidate> getCandidateBySkill(String skill) throws ExecutionException, InterruptedException {
        List<Candidate> candidates = new ArrayList<>();
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference future = dbFirestore.collection("User").document(skill);
        List<QueryDocumentSnapshot> documents = (List<QueryDocumentSnapshot>) future.get().get();
        for (QueryDocumentSnapshot document : documents) {
            candidates.add(document.toObject(Candidate.class));
        }
        return candidates;
    }

    @Override
    public List<Candidate> getAllCandidates() throws ExecutionException, InterruptedException {

        List<Candidate> candidates = new ArrayList<>();
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection("User").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            System.out.println(document.getId() + " => " + document.toObject(Candidate.class));
            candidates.add(document.toObject(Candidate.class));
        }
        return candidates;
    }

    @Override
    public String addCandidate(Candidate candidate) throws ExecutionException, InterruptedException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String date = dateFormat.format(new Date());
        candidate.setDateCreated(date);
        candidate.setUserId(UUID.randomUUID().toString().substring(0,13));
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = firestore.collection("User").document(candidate.getUserId()).set(candidate);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public String updateCandidate(Candidate candidate) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = firestore.collection("User").document(candidate.getUserId()).set(candidate);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public String deleteCandidate(String id) {

        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = firestore.collection("User").document(id).delete();
        return "Successful";
    }
}
