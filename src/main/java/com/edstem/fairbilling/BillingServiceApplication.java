package com.edstem.fairbilling;

import com.edstem.fairbilling.model.BillingDetail;
import com.edstem.fairbilling.service.BillingService;
import com.edstem.fairbilling.service.BillingServiceImpl;

import java.io.IOException;
import java.util.List;

/**
 * Application main runner.
 */
public class BillingServiceApplication {

    /**
     * Runner for the Billing respone.
     *
     * @param args file path
     */
    public static void main(String[] args) {
        if(args.length > 0) {
            BillingService billingService = new BillingServiceImpl();
            try {
                List<BillingDetail> billingDetails = billingService.parseBillingDetails(args[0]);
                var billingTime = billingService.getUserBillingTime(billingDetails);
                billingTime.forEach(System.out::println);
            } catch (IOException e) {
                System.out.println("Invalid file path - Enter a valid file path");
            }

        } else {
            System.out.println("Invalid file path - Enter a file path");
        }
    }
}
