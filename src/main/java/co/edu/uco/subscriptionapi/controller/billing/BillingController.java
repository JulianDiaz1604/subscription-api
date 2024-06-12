package co.edu.uco.subscriptionapi.controller.billing;

import co.edu.uco.subscriptionapi.domain.billing.Billing;
import co.edu.uco.subscriptionapi.service.billing.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/rest")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @GetMapping("/billing")
    public ResponseEntity<Billing> getBillingById(@RequestParam UUID id) {
        try {
            Billing billing = billingService.getBillingById(id);
            if (billing == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(billing, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/billing/subscription/{subs}")
    public ResponseEntity<Billing> getBillingBySubscriptionId(@PathVariable UUID subs) {
        try {
            Billing billing = billingService.getBySubscriptionId(subs);
            if (billing == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(billing, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/billing")
    public ResponseEntity<Void> deleteBilling(@RequestParam UUID id) {
        try {
            billingService.deleteBilling(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/billing")
    public ResponseEntity<Billing> updateBilling(@RequestBody Billing billing) {
        try {
            Billing updatedBilling = billingService.updateBilling(billing);
            if (updatedBilling == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(updatedBilling, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/billing")
    public ResponseEntity<Billing> saveBilling(@RequestBody Billing billing) {
        try {
            Billing savedBilling = billingService.saveBilling(billing);
            return new ResponseEntity<>(savedBilling, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/billing")
    public ResponseEntity<Billing> patchBilling(@RequestBody Map<?, Object> patchFields, @RequestParam UUID id) {
        try {
            Billing patchedBilling = billingService.patchBilling(id, patchFields);
            if (patchedBilling == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(patchedBilling, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
