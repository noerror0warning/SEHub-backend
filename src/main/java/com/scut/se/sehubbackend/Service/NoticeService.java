package com.scut.se.sehubbackend.Service;

import com.scut.se.sehubbackend.Domain.Notice;
import com.scut.se.sehubbackend.Domain.user.UserAuthentication;
import com.scut.se.sehubbackend.Repository.NoticeRepository;
import com.scut.se.sehubbackend.Repository.user.UserAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoticeService {

    @Autowired
    UserAuthenticationRepository userAuthenticationRepository;

    @Autowired NoticeRepository noticeRepository;
    @Autowired Comparator<Notice> noticeComparator;

    private List<Notice> getAllNotices(){
//        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
//        UserAuthentication user=(UserAuthentication) authentication.getPrincipal();
        UserAuthentication user=userAuthenticationRepository.findById("201730683314").get();
        List<Notice> notices=noticeRepository.findAllByAcceptor(user);
        return notices;
    }

    public ResponseEntity<ArrayList<Map<String,Object>>> getAllFrontNotices(){
//        SortedList<Notice> noticeSortedList=new SortedList<Notice>(new ObservableListWrapper<>(getAllNotices()),noticeComparator);
        List<Notice> noticeSortedList=getAllNotices();
        ArrayList<Map<String, Object>> result=new ArrayList<>();
        for (Notice notice:noticeSortedList){
            Map<String,Object> objectMap=new HashMap<>();
            objectMap.put("noticeType",notice.getType());
            objectMap.put("sponsorName",notice.getSponsor().getUserInformation().getName());
            objectMap.put("sponsorDepart",notice.getSponsor().getUserHistories().first().getDepartment());
            objectMap.put("apyID",notice.getPrincipalId());
            objectMap.put("time",notice.getInitiateTime());
            objectMap.put("remarks",notice.getRemarks());
            result.add(objectMap);
        }
        return new ResponseEntity<ArrayList<Map<String,Object>>>(result, HttpStatus.OK);
    }


}
