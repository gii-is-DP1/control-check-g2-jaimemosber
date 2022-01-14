package org.springframework.samples.petclinic.feeding;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedingService {
	
	@Autowired
	private FeedingRepository feedingRepository;
	
    public List<Feeding> getAll(){
        List<Feeding> f = feedingRepository.findAll();
    	return f;
    }

    public List<FeedingType> getAllFeedingTypes(){
        List<FeedingType> f = feedingRepository.findAllFeedingTypes();
        return f;
    }

    public FeedingType getFeedingType(String typeName) {
       FeedingType feedingType = feedingRepository.findFeedingRepository(typeName);
       return feedingType;
    }

//    public Feeding save(Feeding p) throws UnfeasibleFeedingException {
//        return feedingRepository.save(p);  
//    }
    
    public void save (Feeding f) {
    	feedingRepository.save(f);
    }
    
}
