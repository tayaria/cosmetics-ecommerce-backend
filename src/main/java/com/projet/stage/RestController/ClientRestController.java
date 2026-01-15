package com.projet.stage.RestController;




import com.projet.stage.Entity.Client;
import com.projet.stage.Reposotery.ClientReposotery;

import com.projet.stage.Service.ClientService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping(value = "/client")
@RestController
@CrossOrigin("*")
public class ClientRestController {
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    ClientReposotery clientRepository;

    @Autowired
    ClientService clientService;
    @RequestMapping(method = RequestMethod.POST )
    ResponseEntity<?> AjouterClient (@RequestBody Client client){
        HashMap<String, Object> response = new HashMap<>();
        if(clientRepository.existsByEmail(client.getEmail())){
            response.put("message", "email exist deja !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }else{
            client.setMdp(this.bCryptPasswordEncoder.encode(client.getMdp()));
            Client savedUser = clientRepository.save(client);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);}

    }
    @RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
    public Client modifierclient(@PathVariable("id")Long id, @RequestBody Client client){
        client.setMdp(this.bCryptPasswordEncoder.encode(client.getMdp()));
        Client savedUser = clientRepository.save(client);

        Client newClient = clientService.ModifierClient(client);
        return newClient;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )

    public void suppClient(@PathVariable("id") Long id){
        clientService.SupprimerClient(id);

    }
    @RequestMapping(method = RequestMethod.GET )
    public List<Client> afficherClient(){
        return clientService.AfficherClients();

    }


    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginClient(@RequestBody Client client) {
        System.out.println("in login-client"+client);
        HashMap<String, Object> response = new HashMap<>();

        Client userFromDB = clientRepository.findClientByEmail(client.getEmail());
        System.out.println("userFromDB+client"+userFromDB);
        if (userFromDB == null) {
            response.put("message", "Client not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            boolean compare = this.bCryptPasswordEncoder.matches(client.getMdp(), userFromDB.getMdp());
            System.out.println("compare"+compare);
            if (!compare) {
                response.put("message", "client not found !");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }else
            {
                String token = Jwts.builder()
                        .claim("data", userFromDB)
                        .signWith(SignatureAlgorithm.HS256, "SECRET")
                        .compact();
                response.put("token", token);
               // response.put("role",userFromDB.getRole());

                return ResponseEntity.status(HttpStatus.OK).body(response);
            }

        }
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Client> getClientById(@PathVariable("id") Long id){

        Optional<Client> client = clientService.AffichierClientById(id);
        return client;
    }
}
