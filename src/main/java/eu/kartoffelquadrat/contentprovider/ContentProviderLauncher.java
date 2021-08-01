/**
 * @Author: Maximilian Schiedermeier
 * @Date: August 2021
 */
package eu.kartoffelquadrat.contentprovider;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class powers up Spring and ensures the annotated controllers are detected.
 */
@SpringBootApplication
public class ContentProviderLauncher {
    public static void main(String[] args) {

        SpringApplication.run(ContentProviderLauncher.class, args);
    }
}

