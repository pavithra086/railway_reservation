package com.projectbypp.adminmanagementms.service;


import com.projectbypp.adminmanagementms.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class TrainService {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity addTrain(Train train)throws HttpClientErrorException {
        Train addtrain=restTemplate.postForObject("http://train-management-service/train/addtrain",train,Train.class);
        return new ResponseEntity<>(addtrain, HttpStatus.OK);

    }

    public ResponseEntity<Train[]> listallTrains() throws HttpClientErrorException {
        Train[] response= restTemplate.getForEntity("http://Train-management-service/train/listalltrains"
                ,Train[].class).getBody();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    public ResponseEntity listTrainById(int trainId) throws  HttpClientErrorException {
        Train train=restTemplate.getForObject("http://Train-management-service/train/viewtrainbyno/" +trainId,Train.class);
        return new ResponseEntity(train,HttpStatus.OK);
    }

    public ResponseEntity deleteTrain(int trainId) throws HttpClientErrorException {
        restTemplate.delete("http://Train-management-service/train/delete/" +trainId,Train.class);
        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity updateTrain(Train train,int trainId) throws HttpClientErrorException{
        restTemplate.put("http://Train-management-service/train/update/" +trainId,Train.class);
        return new ResponseEntity(HttpStatus.OK);
    }








}
