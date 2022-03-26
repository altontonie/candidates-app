package thashort.gamer.candidateapp.service.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import thashort.gamer.candidateapp.model.entity.Candidate;
import thashort.gamer.candidateapp.service.CandidateService;

import java.util.ArrayList;
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


}
