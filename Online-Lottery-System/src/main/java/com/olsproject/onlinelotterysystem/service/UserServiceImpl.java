package com.olsproject.onlinelotterysystem.service;
import com.olsproject.onlinelotterysystem.entity.User;
import com.olsproject.onlinelotterysystem.entity.Winner;
import com.olsproject.onlinelotterysystem.error.CannotRegister;
import com.olsproject.onlinelotterysystem.error.MoreUsersRequired;
import com.olsproject.onlinelotterysystem.repository.UserRepository;
import com.olsproject.onlinelotterysystem.repository.WinnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private WinnerRepository winnerRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public User registerUser(User user) throws CannotRegister {
        Optional<Winner> u=winnerRepository.findByMobileNo(user.getMobileNo());
        if(u.isPresent()){
            throw new CannotRegister("User cannot register he is already winner");
        }
            return userRepository.save(user);

//        Long check= user.getPersonalIdNo();
//        boolean x=winnerRepository.existsById(check);
//        if (x) {
//            System.out.println("x = " + x);
//            System.out.println("User Cannot register he is already winner");
//            return  null;
//        }
//        else {
//
//            return userRepository.save(user);
//        }
    }

    @Override
    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }



    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(String toEmail,
                                String body,
                                String subject) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("jonsnowdracarysgot@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
        System.out.println("Mail Send...");
    }
    
    
    @Override
    public List<User> pickWinners() throws MoreUsersRequired {
        int val=userRepository.findCountOfParticipants();
        if(val<3){
            throw new MoreUsersRequired("More users required to draw lottery");
        }
        List<User> winners = new ArrayList<>();
        List<User> users= userRepository.findAll();
        System.out.println(users.size());

        Random randNum = new Random();
        Set<Integer>set = new HashSet<Integer>();
        while (set.size() < 3) {
            int x=randNum.nextInt(users.size());
            User user=users.get(x);
            if(user.isParticipate()){
                set.add(x);
            }


        }

        Iterator value = set.iterator();
        while (value.hasNext()) {
           // System.out.println(value.next());
            winners.add(users.get((Integer) value.next()));
       }
User winner1= winners.get(0);
        Winner win1=Winner.builder()
                .name(winner1.getName())
                .emailId(winner1.getEmailId())
                .mobileNo(winner1.getMobileNo())
                .date(new Date())
                .PersonalIdNo(winner1.getPersonalIdNo())
                .amount(5000)
                .position("First")
                .id((long) winner1.getId())
                .build();
        winner1.setParticipate(false);
        winnerRepository.save(win1);

        String toEmail= winner1.getEmailId();
        String body ="Congratualtion " +winner1.getName() +" you have won the Lottery gor first prize";
        String subject ="Congratulation";
     emailSenderService.sendMail(toEmail,body);

        User winner2= winners.get(1);

        Winner win2=Winner.builder()
                .name(winner2.getName())
                .emailId(winner2.getEmailId())
                .mobileNo(winner2.getMobileNo())
                .date(new Date())
                .PersonalIdNo(winner2.getPersonalIdNo())
                .amount(3000)
                .position("Second")
                .id((long) winner2.getId())
                .build();
        winnerRepository.save(win2);
winner2.setParticipate(false);
        User winner3= winners.get(2);

        Winner win3=Winner.builder()
                .name(winner3.getName())
                .emailId(winner3.getEmailId())
                .mobileNo(winner3.getMobileNo())
                .date(new Date())
                .PersonalIdNo(winner3.getPersonalIdNo())
                .amount(5000)
                .position("Third")
                .id((long) winner3.getId())
                .build();
winner3.setParticipate(false);
        winnerRepository.save(win3);



//        User winner1=users.get(value.next())
    //    System.out.println("winners = " + winners);

//        int z =getRandomNumber(users.size());
//
//        System.out.println("z = " + z);
//        User winner1 = users.get(z);
//        winners.add(winner1);
//        //System.out.println("winner1 = " + winner1);4
//        int z2;
//        do{
//            z2 =getRandomNumber(users.size());
//        } while(z2==z);
//
//       // System.out.println("z2 = " + z2);
//        User winner2 = users.get(z2);
//        winners.add(winner2);
//        //System.out.println("winner2 = " + winner2);
//
//
//        int z3;
//        do{
//            z3 =getRandomNumber(users.size());
//
//        } while(z3==z && z3==z2);
//       // System.out.println("z3 = " + z3);
//        User winner3 = users.get(z3);
//        winners.add(winner3);
//        //System.out.println("winner3 = " + winner3);
//        System.out.println("winners = " + winners);
        return winners;
    }

}
