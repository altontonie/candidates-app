package thashort.gamer.cantidateapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/candidates")
public class ThaController {

    @GetMapping(path = "/")
    public String getAllCandidates(){
        return "all candidates";
    }

    @GetMapping(path = "/{userId}")
    public String getCandidate(@PathVariable String userId){
        return "getting candidate: "+userId;
    }

    @GetMapping(path = "/{skills}")
    public String getCandidatesBySkill(@PathVariable String skills){
        return "getting candidates with skill: "+skills;
    }

    @PostMapping(path = "/")
    public String addCandidate(@RequestBody Object candidate){
        return candidate.toString();
    }
}
