package com.trxjster.springbootexample.controller;

import com.trxjster.springbootexample.beans.Product;
import com.trxjster.springbootexample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Callable;

@Controller
public class SearchController {

    private final ProductRepository productRepository;
    @Qualifier("mvcTaskExecutor")
    @Autowired
    private AsyncTaskExecutor executor;

    @Autowired
    public SearchController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Async
//    @GetMapping("/search")
//    public Callable<String> search(@RequestParam("search") String search, Model model, HttpServletRequest request){
//        System.out.println("in search controller");
//        System.out.println("search criteria: "+search);
//        System.out.println("Async supported in app: "+request.isAsyncSupported());
//        System.out.println("Thread from servlet container: "+Thread.currentThread().getName());
//
//        return () ->{
//            Thread.sleep(3000);
//            System.out.println("Thread from spring mvc task executor: "+Thread.currentThread().getName());
//            model.addAttribute("products", productRepository.searchByName(search));
//            return "search";
//        };
//
//    }
    //DeferredResult
        @GetMapping("/search")
    public DeferredResult<String> search(@RequestParam("search") String search, Model model, HttpServletRequest request){
        DeferredResult<String> deferredResult = new DeferredResult<>();
        System.out.println("in search controller");
        System.out.println("search criteria: "+search);
        System.out.println("Async supported in app: "+request.isAsyncSupported());
        System.out.println("Thread from servlet container: "+Thread.currentThread().getName());

        executor.execute(() ->{
            try{
                Thread.sleep(3000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Thread from the spring mvc task executor: "+Thread.currentThread().getName());
            model.addAttribute("products", productRepository.searchByName(search));
            deferredResult.setResult("search");
        });

        return deferredResult;
    }
}
