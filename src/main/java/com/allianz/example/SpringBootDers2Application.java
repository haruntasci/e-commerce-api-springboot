package com.allianz.example;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.CustomerEntityRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.service.CategoryService;
import com.allianz.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.math.BigDecimal;
import java.util.*;


@EnableJpaAuditing
@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringBootDers2Application  {

    @Autowired
    ProductEntityRepository productEntityRepository;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;


    public static void main(String[] args) {

        SpringApplication.run(SpringBootDers2Application.class, args);

    }

//    @Override
//    public void run(String... args) throws Exception {
//
//
//        Timer timer = new Timer();
//        TimerTask task = new Helper();
//
////        Calendar calendar = Calendar.getInstance();
////        calendar.set(Calendar.YEAR, 2023);
////        calendar.set(Calendar.MONTH, Calendar.AUGUST);
////        calendar.set(Calendar.DAY_OF_MONTH, 22);
////        calendar.set(Calendar.HOUR_OF_DAY, 23); // Set hour (24-hour format)
////        calendar.set(Calendar.MINUTE, 0);     // Set minute
////        calendar.set(Calendar.SECOND, 0);      // Set second
////
////        Date specificDateTime = calendar.getTime();
////        System.out.println(specificDateTime);
//
//        timer.schedule(task, 0, 1000);
//
//    }
}
//class Helper extends TimerTask
//{
//    public static int i = 0;
//    public void run()
//    {
//        System.out.println("Timer ran " + ++i);
//        if(i==10){
//            cancel();
//        }
//    }
//}

