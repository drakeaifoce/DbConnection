package com.company;

import com.company.controllers.TrainController;
import com.company.entities.Train;
import com.company.repositories.TrainRepository;
import com.company.repositories.interfaces.ILocomotiveRepository;
import com.company.repositories.interfaces.ITrainRepository;
import com.company.repositories.interfaces.IUserRepository;

import java.util.Scanner;

public class TrainFrontEnd
{
    private final TrainController controller;
    private final Scanner scanner;

    public TrainFrontEnd(ITrainRepository trainRepository, ILocomotiveRepository locomotiveRepository) {
        controller = new TrainController(trainRepository, locomotiveRepository);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all trains");
            System.out.println("2. Get train by id");
            System.out.println("3. Create train");
            System.out.println("4. Get all locomotives");
            System.out.println("5. Get locomotive by id");
            System.out.println("6. Create locomotive");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-6): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllTrainsMenu();
                } else if (option == 2) {
                    getTrainByIdMenu();
                } else if (option == 3) {
                    createTrainMenu();
                } else if(option == 4){
                    getAllLocomotivesMenu();
                }
                else if(option == 5){
                    getLocomotiveByIdMenu();
                }
                else if(option == 6){
                    createLocomotiveMenu();
                }

                else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }

            System.out.println("*************************");

        }
    }

    public void getAllTrainsMenu() {
        String response = controller.getAllTrains();
        System.out.println(response);
    }

    public void getAllLocomotivesMenu() {
        String response = controller.getAllLocomotives();
        System.out.println(response);
    }

    public void getTrainByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        Train train = controller.getTrain(id);
        System.out.println((train == null ? "Train was not found!" : train.toString()));
    }

    public void getLocomotiveByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getLocomotive(id);
        System.out.println(response);
    }

    public void createTrainMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter capacity");
        int capacity = scanner.nextInt();

        String response = controller.createTrain(name,capacity);
        System.out.println(response);
    }

    public void createLocomotiveMenu() throws Exception {
        System.out.println("Please enter train id");
        int train_id = scanner.nextInt();

        try{
            var id = controller.getTrain(train_id).getId();
        }
        catch(Exception ex){
            // System.out.println("Train was not found");
            throw new Exception("Train was not found");
        }

        System.out.println("Please enter name");
        String name = scanner.next();


        String response = controller.createLocomotive(name,train_id);
        System.out.println(response);
    }
}
