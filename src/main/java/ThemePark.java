import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;

    public ThemePark(ArrayList<Attraction> attractions, ArrayList<Stall> stalls){
        this.attractions = attractions;
        this.stalls = stalls;
    }

    public ArrayList<IReviewed> getAllReviewed(){
        ArrayList<IReviewed> allReviewed = new ArrayList<IReviewed>();
        allReviewed.add((IReviewed) this.attractions);
        allReviewed.add((IReviewed) this.stalls);
        return allReviewed;
    }

    public void visit(Visitor visitor, Attraction attraction){
        attraction.addVisitor();
        visitor.addVisitedAttraction(attraction);
    }

    public HashMap<String, Integer> getAllReviewsHashMap(){
        HashMap<String, Integer> allReviewesHashMap = new HashMap<String, Integer>();
        for (IReviewed review :getAllReviewed()){
            allReviewesHashMap.put(review.getName(), review.getRating());
        }
        return allReviewesHashMap;
    }

    public ArrayList<IReviewed> getAllAllowedForVisitor(Visitor visitor){
        ArrayList<IReviewed> allAllowed = new ArrayList<IReviewed>();
        for (IReviewed review :getAllReviewed()){
            if (review.isAllowedTo(visitor) == false){
            }
            else allAllowed.add(review);
        }
        return allAllowed;
            //Also considered not extending IReview with ISecurity and using something like the below (?) :
            //Try if there isAllowed then check .isallowed(Visitor) == true then allAllowed.add(review);
            //Exception means no isAllowed so allAllowed.add(review);
    }
}
