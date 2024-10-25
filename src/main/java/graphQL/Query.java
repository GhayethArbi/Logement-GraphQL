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


    //rendez vous
    public List<RendezVous> getallrendezVous(){
        return this.rendezVousRepository.getListeRendezVous();
    }
//////
    public List<RendezVous> getListeRendezVousByLogementRef(int reference){
        return this.rendezVousRepository.getListeRendezVousByLogementRef(reference);
    }




    //logement
    public Logement getLogementByReference(int reference){
        return this.logementRepository.getLogementsByReference(reference);
    }

    public List<Logement> getAllLogements() {
        return this.logementRepository.getAllLogements();
    }

    public List<Logement> getLogementByType(Logement.Type type){
        return this.logementRepository.getLogementsByType(type);
    }

}
