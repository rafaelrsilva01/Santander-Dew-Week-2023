package com.santander.user.services;

import com.santander.user.models.users.User;
import com.santander.user.repository.accounts.AccountRepository;
import com.santander.user.repository.cards.CardRepository;
import com.santander.user.repository.features.FeaturesRepository;
import com.santander.user.repository.news.NewsRepository;
import com.santander.user.repository.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private AccountRepository accountRepository;
    private CardRepository cardRepository;
    private NewsRepository newsRepository;
    private UserRepository userRepository;
    private FeaturesRepository featuresRepository;

    @Autowired
    public UserService(AccountRepository accountRepository, CardRepository cardRepository, NewsRepository newsRepository, UserRepository userRepository,FeaturesRepository featuresRepository) {
        this.accountRepository = accountRepository;
        this.cardRepository = cardRepository;
        this.newsRepository = newsRepository;
        this.userRepository = userRepository;
        this.featuresRepository = featuresRepository;
    }

    public User createUser(User user){

        var card = cardRepository.save(user.getCard());
        var account = accountRepository.save(user.getAccount());
        var news = newsRepository.saveAll(user.getNews());
        var features = featuresRepository.saveAll(user.getFeatures());
        user.setCard(card);
        user.setAccount(account);
        user.setNews(news);
        user.setFeatures(features);
        return userRepository.save(user);
    }
    public List<User> listUser(){
        return userRepository.findAll();
    }
    public User findOneUser(Long id){

        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }
}
