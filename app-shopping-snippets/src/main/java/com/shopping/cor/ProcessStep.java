package com.shopping.cor;
public enum ProcessStep {
    START {
        @Override
        public void handle(Request request) {
            System.out.println("START: Validating request...");

            if(request.getMessage().equalsIgnoreCase("START")){
                return;
            }
            // Pass to the next step
            nextStep.handle(request);
        }
    },
    VALIDATE {
        @Override
        public void handle(Request request) {
            System.out.println("VALIDATE: Checking request data...");
            // Simulate validation success
            if (request.getMessage() != null && !request.getMessage().isEmpty()) {
                nextStep.handle(request);
            } else {
                System.out.println("VALIDATE: Validation failed. Request rejected.");
            }
        }
    },
    PROCESS {
        @Override
        public void handle(Request request) {
            System.out.println("PROCESS: Processing request - " + request.getMessage());
            // Process complete
            nextStep.handle(request);
        }
    },
    COMPLETE {
        @Override
        public void handle(Request request) {
            System.out.println("COMPLETE: Request has been successfully processed!");
        }
    };

    // Link to the next step in the chain
    protected ProcessStep nextStep;

    static {
        START.nextStep = VALIDATE;
        VALIDATE.nextStep = PROCESS;
        PROCESS.nextStep = COMPLETE;
        COMPLETE.nextStep = null; // End of the chain
    }

    // Abstract method to be implemented by each step
    public abstract void handle(Request request);
}