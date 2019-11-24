package com.zee.servlets.backendconnector;

import com.zee.servlets.web.viewmodels.OffersPageVM;
import com.zee.servlets.web.viewmodels.UserVM;

import javax.ejb.Local;
import java.util.ArrayList;
import java.util.Date;

@Local
public interface BackendConnectable {
    String hello(String s);
    OffersPageVM getOffersPageData(UserVM user, Date start, Date end, String depIata, String destIata, boolean oneWay);

}
