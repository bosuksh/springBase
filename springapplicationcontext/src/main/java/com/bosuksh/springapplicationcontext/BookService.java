package com.bosuksh.springapplicationcontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    @Qualifier("leeBookRepository")
    BookRepository bookRepository;

    void printBookRepository() {
        System.out.println(bookRepository.getClass());
    }

}
