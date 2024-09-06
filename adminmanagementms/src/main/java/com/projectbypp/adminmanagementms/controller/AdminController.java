package com.projectbypp.adminmanagementms.controller;

import com.projectbypp.adminmanagementms.model.Admin;
import com.projectbypp.adminmanagementms.model.Train;
import com.projectbypp.adminmanagementms.service.AdminService;
import com.projectbypp.adminmanagementms.service.BookingService;
import com.projectbypp.adminmanagementms.service.TrainService;
import com.projectbypp.adminmanagementms.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class AdminController {

    Logger logger= LoggerFactory.getLogger(AdminController.class);
    @Autowired
    AdminService adminservice;

    @Autowired
    private UserService userService;

    @Autowired
    private TrainService trainService;

    @Autowired
    private BookingService bookingService;


    @PostMapping("/add")
    public Admin add(@RequestBody Admin admin) {

        logger.info("[add] info message added");

        return adminservice.add(admin);
    }

    @GetMapping("/view/{adminId}")
    @ApiOperation(value = "To View the specific Admin Details ",
            notes = "Provide the Id to view the specific Admin Details")
    public Optional<Admin> view(@PathVariable("adminId") int adminId) {
        logger.info("[view/adminId] info message added");

        return adminservice.view(adminId);
    }

    @DeleteMapping("/delete/{adminId}")
    @ApiOperation(value = "Deletion of Admin Details ",
            notes = "Provide the id to delete the specific Admin Details")
    public String deleteAdmin(@PathVariable("adminId") int adminId) {
        logger.info("[delete/adminId] info message added");
        adminservice.deleteAdmin(adminId);
        return "deleted successfully";
    }

    @PutMapping("/update/{adminId}")
    @ApiOperation(value = "Updation of Admin Details ",
            notes = "Provide the id to update the specific Admin Details")
    public Admin updateTrain(@RequestBody Admin admin, @PathVariable("adminId") int adminId) {
        logger.info("[update/adminId] info message added");
        return adminservice.updateAdmin(adminId, admin);
    }

    //To add train
    @PostMapping("/addtrain")
    @ApiOperation(value = "Admin can Add Train Details ",
            notes = "Provide the Train Details")
    public ResponseEntity addTrain(@Valid @RequestBody Train train){
        logger.info("[addtrain] info message added");
        return trainService.addTrain(train);
    }

    //To view all trains
    @GetMapping("/listalltrains")
    @ApiOperation(value = "Admin can View All Train Data ",
            notes = "Displays all the Train Details")
    public ResponseEntity listalltrains() {
        logger.info("[listalltrains] info message added");

        return trainService.listallTrains();
    }

    //To view Train using TrainId
    @GetMapping("/viewtrainbyno/{trainId}")
    @ApiOperation(value = "Admin can search specific Train Detail by Id ",
            notes = "Provide the train Id to view the required Train Details")
    public  ResponseEntity viewtrainbyId(@PathVariable(value = "trainId") int trainId) {
        logger.info("[viewtrainbyno/trainId] info message added");

        return trainService.listTrainById(trainId);

    }

    //To delete Train data
    @DeleteMapping("/delete/{trainId}")
    @ApiOperation(value = "Admin can Delete Train Details by Id ",
            notes = "Provide the Id to delete the specific Train Details")
    public  ResponseEntity deleteTrain(@PathVariable(value = "trainId") int trainId) {
        logger.info("[delete/trainId] info message added");
        return trainService.deleteTrain(trainId);

    }

    //To update a train data
    @PutMapping("/update/{trainId}")
    @ApiOperation(value = "Admin can update Train Details ",
            notes = "Provide the Id to update the specific Train Details")
    public ResponseEntity updateTrain(@Valid @RequestBody Train train,@PathVariable(value = "trainId") int trainId){
        logger.info("[update/trainId] info message added");
        return trainService.updateTrain(train,trainId);
    }

    //To View All passengers
    @GetMapping("/viewusers")
    @ApiOperation(value = "Admin can view all user Data ",
            notes = "Displays all the user Details")
    public ResponseEntity viewusers(){
        logger.info("[viewusers] info message added");
        return userService.viewUsers();
    }

    //To View the bookings done under TrainId
    @GetMapping("/viewbookingbyTid/{trainId}")
    @ApiOperation(value = "Admin can view all bookings under one train",
            notes = "Displays all the booking Details")
    public ResponseEntity viewbookingbyTid(@PathVariable(value = "trainId") int trainId){
        logger.info("[viewbookingbyTNum] info message added");
        return bookingService.viewbookingbyTid(trainId);
    }




}
