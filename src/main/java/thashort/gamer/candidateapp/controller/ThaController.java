package thashort.gamer.candidateapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thashort.gamer.candidateapp.model.entity.Candidate;
import thashort.gamer.candidateapp.service.CandidateService;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(path = "/candidates")
public class ThaController {

    @Autowired
    CandidateService candidateService;

    @GetMapping(path = "/")
    public List<Candidate> getAllCandidates() throws ExecutionException, InterruptedException {
        return candidateService.getAllCandidates();
    }

    @GetMapping(path = "/{userId}")
    public Candidate getCandidate(@PathVariable String userId) throws ExecutionException, InterruptedException {
        return candidateService.getCandidate(userId);
    }

    @GetMapping(path = "/skill/{skills}")
    public List<Candidate> getCandidatesBySkill(@PathVariable String skills) throws ExecutionException, InterruptedException {
        return candidateService.getCandidateBySkill(skills);
    }

    @PostMapping(path = "/")
    public String addCandidate(@RequestBody Candidate candidate) throws ExecutionException, InterruptedException {
        return candidateService.addCandidate(candidate);
    }

    @PutMapping(path = "/")
    public String updateCandidate(@RequestBody Candidate candidate) throws ExecutionException, InterruptedException {
        return candidateService.updateCandidate(candidate);
    }

    @DeleteMapping(path = "/{userId}")
    public String deleteCandidate(@PathVariable String userId){
        return candidateService.deleteCandidate(userId);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Test GET Endpoint is working");
    }
}
