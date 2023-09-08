package lk.ijse.hostel.service.custom;

import lk.ijse.hostel.service.SuperService;

import java.util.ArrayList;

public interface DashboardService extends SuperService {


    public Long getPendingPaymentCount();


    public int getRoomCount();
}
