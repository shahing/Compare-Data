package restAssuredAPI;

import java.util.*;

public class CompareData {
	
	enum Value{
		SAME,AFTER,BEFORE
	}
	
	public static String checkDate(String date1,String date2) {
		String[] splittedDate1 = date1.split("-");
		String[] splittedDate2 = date2.split("-");
		if(!splittedDate1[0].equals(splittedDate2[0]) ) {
			if(Integer.parseInt(splittedDate1[0]) > Integer.parseInt(splittedDate2[0])) {
				return Value.AFTER.toString();
			}else {
				return Value.BEFORE.toString();
			}
		}else if(!splittedDate1[1].equals(splittedDate2[1])) {
			if(Integer.parseInt(splittedDate1[1]) > Integer.parseInt(splittedDate2[1])) {
				return Value.AFTER.toString();
			}else {
				return Value.BEFORE.toString();
			}
		}else if(!splittedDate1[2].equals(splittedDate2[2])) {
			if(Integer.parseInt(splittedDate1[2]) > Integer.parseInt(splittedDate2[2])) {
				return Value.AFTER.toString();
			}else {
				return Value.BEFORE.toString();
			}
		}else {
			return Value.SAME.toString();
		}
	}
	
	public static void main(String[] args) {
		Map<String, Map<String, String>> map = new HashMap<>();
		Map<String, String> hatchback = new HashMap<>();
        hatchback.put("2020-02-03", "2020-03-04");
        hatchback.put("2020-03-04", "2020-04-02");
        hatchback.put("2020-04-02", "2020-05-04");
        hatchback.put("2020-05-04", "2020-06-03");
        hatchback.put("2020-06-03", "2020-07-05");
        hatchback.put("2020-07-05", "2020-08-03");
        hatchback.put("2020-08-03", "2020-09-01");
        hatchback.put("2020-09-01", "2020-10-01");
        hatchback.put("2020-10-01", "2020-11-01");
        hatchback.put("2020-11-01", "2020-12-02");
        hatchback.put("2020-12-02", "2021-01-05");
        hatchback.put("2021-01-05", "2021-02-03");
        hatchback.put("2021-02-03", "2021-03-04");
        hatchback.put("2021-03-04", "2021-04-04");
        hatchback.put("2021-04-04", "2021-05-03");
        map.put("hatchback", hatchback);
        Map<String, String> sedan = new HashMap<>();
        sedan.put("2020-02-03", "2020-03-05");
        sedan.put("2020-03-06", "2020-04-03");
        sedan.put("2020-04-01", "2020-05-04");
        sedan.put("2020-05-04", "2020-06-02");
        sedan.put("2020-06-01", "2020-07-03");
        sedan.put("2020-07-03", "2020-08-06");
        sedan.put("2020-08-05", "2020-09-01");
        sedan.put("2020-09-03", "2020-10-01");
        sedan.put("2020-10-01", "2020-11-03");
        sedan.put("2020-11-02", "2020-12-03");
        sedan.put("2020-12-04", "2021-01-03");
        sedan.put("2021-01-02", "2021-02-03");
        sedan.put("2021-02-05", "2021-03-02");
        sedan.put("2021-03-02", "2021-04-05");
        sedan.put("2021-04-03", "2021-05-04");
        map.put("sedan", sedan);
        
        List<String> same_start_same_end = new ArrayList<>();
        List<String> same_start_after_end = new ArrayList<>();
        List<String> after_start_after_end = new ArrayList<>();
//        List<String> after_start_same_end = new ArrayList<>();
        List<String> before_start_same_end = new ArrayList<>();
        List<String> same_start_before_end = new ArrayList<>();
        List<String> before_start_before_end = new ArrayList<>();
        List<String> before_start_after_end = new ArrayList<>();
        List<String> after_start_before_end = new ArrayList<>();
        for (Map.Entry<String, String> sed : sedan.entrySet()) {
		   for(Map.Entry<String,String> hat : hatchback.entrySet()) {
			   String sedStart = sed.getKey();
			   String sedEnd = sed.getValue();
			   String hatStart = hat.getKey();
			   String hatEnd = hat.getValue();
			   
			   String startDateStatus = checkDate(sedStart,hatStart);
			   String endDateStatus = checkDate(sedEnd,hatEnd);
			   
			   if(startDateStatus.equals(Value.SAME.toString()) && endDateStatus.equals(Value.SAME.toString())) {
				   same_start_same_end.add(sedStart+" "+sedEnd);
			   }else if(startDateStatus.equals(Value.SAME.toString()) && endDateStatus.equals(Value.AFTER.toString())) {
				   same_start_after_end.add(sedStart+" "+hatEnd);
			   }else if(startDateStatus.equals(Value.AFTER.toString()) && endDateStatus.equals(Value.AFTER.toString())) {
				   after_start_after_end.add(hatStart+" "+hatEnd);
			   }else if(startDateStatus.equals(Value.BEFORE.toString()) && endDateStatus.equals(Value.SAME.toString())) {
				   before_start_same_end.add(sedStart+" "+sedEnd);
			   }else if(startDateStatus.equals(Value.SAME.toString()) && endDateStatus.equals(Value.BEFORE.toString())) {
				   same_start_before_end.add(sedStart+" "+hatEnd);
			   }else if(startDateStatus.equals(Value.BEFORE.toString()) && endDateStatus.equals(Value.BEFORE.toString())) {
				   before_start_before_end.add(sedStart+" "+hatEnd);
			   }else if(startDateStatus.equals(Value.BEFORE.toString()) && endDateStatus.equals(Value.AFTER.toString())) {
				   before_start_after_end.add(sedStart+" "+sedEnd);
			   }else if(startDateStatus.equals(Value.AFTER.toString()) && endDateStatus.equals(Value.BEFORE.toString())) {
				   after_start_before_end.add(hatStart+" "+hatEnd);
			   }
		   }
		}
        System.out.println("Same Start And End :-> "+same_start_same_end);
        System.out.println("Same Start And After End :-> "+same_start_after_end);
        System.out.println("After Start And After End :-> "+after_start_after_end);
        System.out.println("Before Start And Same End :-> "+before_start_same_end);
        System.out.println("Same Start And Before End :-> "+same_start_before_end);
        System.out.println("Before Start And Before End :-> "+before_start_before_end);
        System.out.println("Before Start And After End :-> "+before_start_after_end);
        System.out.println("After Start And Before End :-> "+after_start_before_end);
	}

}
