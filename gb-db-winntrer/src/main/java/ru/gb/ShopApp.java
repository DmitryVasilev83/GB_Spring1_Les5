package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import ru.gb.config.DbConfig;
import ru.gb.config.HibernateConfig;
import ru.gb.dao.product.ProductDao;
import ru.gb.entity.Product;

public class ShopApp {

    public static void main(String[] args) {
        // 1
//        OldJdbcManufacturerDao oldJdbcManufacturerDao = new OldJdbcManufacturerDao();
//            for (Manufacturer manufacturer : oldJdbcManufacturerDao.findAll()) {
//            System.out.println(manufacturer);
//        }

//        OldJdbcProductDao oldJdbcProductDao = new OldJdbcProductDao();
//        for (Product product : oldJdbcProductDao.findAll()) {
//           System.out.println(product);
//        }

        // 2
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
//        ProductDao productDao = context.getBean(ProductDao.class);
//        for (Product product : productDao.findAll()) {
//           System.out.println(product);
//        }

        // 3
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
//        ProductDao productDao = context.getBean(ProductDao.class);
//        System.out.println(productDao.findTitleById(3L));

        //4
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
//        ProductDao productDao = context.getBean(ProductDao.class);
//        System.out.println(productDao.findTitleById(3L));
//        System.out.println(productDao.findById(3L));
//        for (Product product : productDao.findAll()) {
//           System.out.println(product);
//        }

        //5
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        ProductDao productDao = context.getBean(ProductDao.class);
        System.out.println("------------------");
        System.out.println(productDao.findById(3L));
        System.out.println("------------------");
        System.out.println(productDao.findTitleById(5L));
//        for (Product product : productDao.findAll()) {
//           System.out.println(product);
//        }



    }
}
