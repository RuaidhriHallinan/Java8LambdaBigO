package com.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.PriorityQueue;

public class WorkOrderRequest {

    private static PriorityQueue<WorkRequest> workRequestPriorityQueue;

    /**
     *
     * @param args
     */
    public static void main(String[] args)  {

        //https://stackoverflow.com/questions/17548150/enqueue-dequeue-and-viewqueue-in-java

        //Generate Random Work Queues
        workRequestPriorityQueue = generateWorkQueue();

        //Iterate through work queues
        for (WorkRequest wr: workRequestPriorityQueue) {
            //Print list of ID's with Timestamps
            System.out.println(wr.toString());
        }

//        addToQueue(8);

//        boolean inQ = checkInQueue(8);

//        if(inQ) {
//            System.out.println("8 is in the queue");
//        } else {
//            System.out.println("8 is not in the queue");
//        }

        Date dateAddStrict = new Date();

        addToQueueStrict(8, dateAddStrict);

        boolean insertedOffer = offerToQueueStrict(8, dateAddStrict);

        if(insertedOffer) {
            System.out.println("8 is added again after offer");
        } else {
            System.out.println("8 was not added again ");
        }

        //Iterate through work queues
        for (WorkRequest wr: workRequestPriorityQueue) {
            //Print list of ID's with Timestamps
            System.out.println(wr.toString());
        }

//        removeFromQueue(8);
//        inQ = checkInQueue(8);
//        if(inQ) {
//            System.out.println("8 is in the queue");
//        } else {
//            System.out.println("8 is not in the queue");
//        }

        WorkRequest wrs = getFromQueue(8);

        if(wrs != null) {
            System.out.println("Got " + wrs.getId() + " from the queue with date " + wrs.getAdded());
        } else {
            System.out.println("Not in the queue");
        }

    }

    private static void addToQueue(int id) {
        System.out.println("Adding " + id + " to the queue");

        if(!checkInQueue(id)) {
            workRequestPriorityQueue.add(new WorkRequest(id, new Date()));
        }
    }

    private static void addToQueueStrict(int id, Date date) {
        System.out.println("Adding " + id + " to the queue with specific date" + date);

        workRequestPriorityQueue.add(new WorkRequest(id, date));
    }

    private static boolean offerToQueueStrict(int id, Date date) {
        System.out.println("Offering " + id + " to the queue with specific date" + date);

        return workRequestPriorityQueue.offer(new WorkRequest(id, date));
    }

    private static WorkRequest getFromQueue(int id) {
        System.out.println("Retrieving " + id + " from the queue");

        for (WorkRequest wrs : workRequestPriorityQueue) {
            if(wrs.getId() == id)  {
                return wrs;
            }
        }

        return null;
    }

    private static void removeFromQueue(int id) {
        System.out.println("Removing " + id + " from the queue");

        for (WorkRequest wrs : workRequestPriorityQueue) {
            if(wrs.getId() == id)  {
                workRequestPriorityQueue.remove(wrs);
            }
        }
    }

    public static boolean checkInQueue(int id) {
        System.out.println("Checking is " + id + " in the queue");

        for (WorkRequest wrs : workRequestPriorityQueue) {
            if(wrs.getId() == id) return true;
        }
        return false;
    }

    private static PriorityQueue<WorkRequest> generateWorkQueue() {
        workRequestPriorityQueue = new PriorityQueue<WorkRequest>();
        workRequestPriorityQueue.add(new WorkRequest(10, new Date(Math.abs(System.currentTimeMillis() - 1000))));
        workRequestPriorityQueue.add(new WorkRequest(5, new Date(Math.abs(System.currentTimeMillis() - 3000))));
        workRequestPriorityQueue.add(new WorkRequest(3, new Date(Math.abs(System.currentTimeMillis() - 4000))));
        workRequestPriorityQueue.add(new WorkRequest(21, new Date(Math.abs(System.currentTimeMillis() - 5000))));
        workRequestPriorityQueue.add(new WorkRequest(4, new Date(Math.abs(System.currentTimeMillis() - 6000))));
        workRequestPriorityQueue.add(new WorkRequest(7, new Date(Math.abs(System.currentTimeMillis() - 7000))));
        workRequestPriorityQueue.add(new WorkRequest(13, new Date(Math.abs(System.currentTimeMillis() - 8000))));
        workRequestPriorityQueue.add(new WorkRequest(11, new Date(Math.abs(System.currentTimeMillis() - 9000))));
        workRequestPriorityQueue.add(new WorkRequest(17, new Date(Math.abs(System.currentTimeMillis() - 1200))));
        workRequestPriorityQueue.add(new WorkRequest(1, new Date(Math.abs(System.currentTimeMillis() - 1300))));

        return workRequestPriorityQueue;

    }

//    protected Function<Double, Double> getPriorityFunctionForClass(WorkOrderClass orderClass){
//        switch(orderClass) {
//            case MANAGEMENT_OVERRIDE:
//                return value -> value;
//            case VIP:
//                return value -> Math.max(4, 2*value* Math.log(value));
//            case PRIORITY:
//                return value ->Math.max(3, value* Math.log(value));
//            case NOMRAL:
//                return value -> value;
//            default:
//                throw new IllegalStateException();
//        }
//    }

}




class WorkRequest implements Comparable<WorkRequest> {

    public int id;
    public Date added;

    public WorkRequest(int id, Date dateAdded) {
        this.id = id;
        this.added = dateAdded;
    }

    public int getId() {
        return id;
    }

    public Date getAdded() {
        return added;
    }

    @Override
    public int compareTo(WorkRequest o) {
        return added.compareTo(o.added);
    }

     /**
     * Overriding the toString representation of the object.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        // Time Formatter for Seconds Only format
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ss");
        //  Get the current Time in Millis
        long currentDateMillis = System.currentTimeMillis();
        // Get the Work Order Request Time
        long timeInQ = this.added.getTime();

        String shortTimeStr = simpleDateFormat.format(currentDateMillis - timeInQ);

        return "WorkRequest [Id: " + id + ", Time in Queue: " + shortTimeStr + "]";
    }
}