package graphQL;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entities.Logement;
import entities.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

import java.util.List;

public class Query implements GraphQLRootResolver {
    private RendezVousRepository rendezVousRepository;
    private LogementRepository logementRepository;
    public Query (RendezVousRepository repoR, LogementRepository repoLg){
        this.rendezVousRepository= repoR;
        this.logementRepository= repoLg;

    }
    public List<RendezVous> getallrendezVous(){
        return this.rendezVousRepository.getListeRendezVous();
    }
    public Logement getLogementByReference(int reference){
        return this.logementRepository.getLogementsByReference(reference);
    }
}
