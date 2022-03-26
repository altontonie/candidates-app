package thashort.gamer.candidateapp.service;


import thashort.gamer.candidateapp.model.entity.Candidate;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface CandidateService {
    Candidate getCandidate(String id) throws ExecutionException, InterruptedException;
    List<Candidate> getCandidateBySkill(String skill) throws ExecutionException, InterruptedException;
    List<Candidate> getAllCandidates() throws ExecutionException, InterruptedException;
    String addCandidate(Candidate candidate) throws ExecutionException, InterruptedException;
    String updateCandidate(Candidate candidate) throws ExecutionException, InterruptedException;
    String deleteCandidate(String id);
}
