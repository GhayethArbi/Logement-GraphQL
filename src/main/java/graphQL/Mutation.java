package graphQL;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import entities.Logement;
import entities.Logement.Type;
import entities.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

public class Mutation  implements GraphQLRootResolver {
    private RendezVousRepository rendezVousRepository;
    private  LogementRepository logementRepository;
    public Mutation (RendezVousRepository repoR , LogementRepository repoLo){
        this.rendezVousRepository= repoR;
        this.logementRepository=repoLo;
    }
    //rendezvous
    public RendezVous createRendezVous(int id , String date , String heure , int refLog , String num ){
        RendezVous r = new RendezVous(id,date,heure,logementRepository.getLogementsByReference(refLog),num);
        this.rendezVousRepository.addRendezVous(r);
        return  r;
    }



    public Boolean updateRendezVous(int id, String date, String heure, String numTel){
        Logement logement = rendezVousRepository.getLogementByRDV(id);
        RendezVous rdv = new RendezVous(id,date,heure,logement,numTel);
        System.out.println(rdv);
        return rendezVousRepository.updateRendezVous(rdv);
    }
    public boolean deleteRendezVous(int id){
        return rendezVousRepository.deleteRendezVous(id);
    }




    //logement
    public Logement createLogement(int reference, String adresse) {
        Logement logement = new Logement(reference,adresse);
        logementRepository.saveLogement(logement);
        return logement;
    }

}