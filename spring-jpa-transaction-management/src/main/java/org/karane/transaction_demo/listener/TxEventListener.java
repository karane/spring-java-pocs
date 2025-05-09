package org.karane.transaction_demo.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.transaction.event.TransactionPhase;

@Component
public class TxEventListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleAfterCommit(String event) {
        System.out.println("Event received after commit: " + event);
    }

    @EventListener
    public void handleImmediately(String event) {
        System.out.println("Immediate event received: " + event);
    }
}
