package graphQL;



import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import repository.LogementRepository;
import repository.RendezVousRepository;

import javax.servlet.annotation.WebServlet;
@WebServlet(urlPatterns = "/graphql")

public class GaphQLEndPoint extends SimpleGraphQLServlet {
    public GaphQLEndPoint(){
        super(buildSchema());
    }
    private static GraphQLSchema buildSchema() {
        LogementRepository lr = new LogementRepository();
        RendezVousRepository rdvRepo = new RendezVousRepository();
        return SchemaParser.newParser()
                .file("schema.graphqls")


                .resolvers(new Query(rdvRepo, lr), new Mutation(rdvRepo, lr))
                .build()
                .makeExecutableSchema();
    }
}