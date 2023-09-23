package com.masai.project.implem;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.masai.project.entities.Batch;
import com.masai.project.entities.Course;
import com.masai.project.exception.*;
import com.masai.project.interfaces.BatchInterface;

public class BatchImpl implements BatchInterface{

	

	@Override
	public void updateBatch(int id,Batch update, Map<Integer, Course> courses,Map<Integer,Batch> batchLis)
			throws BatchNotFoundException, EmptyException, CourseNotFoundException {
		// TODO Auto-generated method stub
		
		if(courses != null && courses.size()>0) {

			int temp = 0;
			for(Map.Entry<Integer, Course> kv : courses.entrySet()) {
				if(kv.getValue().getCourse_name().contains(update.getCourseName())) {
					temp  = 1;
					List<Batch> blist = kv.getValue().getBatches();
					for(int i=0;i<blist.size();i++) {
						if(blist.get(i).getId() == id) {
							blist.set(i, update);
//							temp = 2;1
							System.out.println("Batch Updated Successfully...");
							break;
						}
					}
					break;
				}
			}
			
			if(temp==1) {
				int t = 0;
				for(Map.Entry<Integer, Batch> kvb : batchLis.entrySet()) {
					if(kvb.getValue().getId() == id) {
						
						batchLis.put(id, update);
						t = 1;
						break;
						
					}
				}
				if(t==0) {
					throw new BatchNotFoundException("Batch is not available for this GIVEN ID");
				}
			}
			
			if(temp==0) {
				throw new CourseNotFoundException("This course is not found");
			}
		}else {
			throw new EmptyException("Course is null or empty");
		}
		
	}

	@Override
	public void showAllBatches(Map<Integer, Batch> batches) throws EmptyException {
		// TODO Auto-generated method stub
		System.out.println(batches.size());
		if(batches != null && batches.size() >0) {
			for(Map.Entry<Integer, Batch> kv : batches.entrySet()) {
				System.out.println(kv.getValue());
			}
		}else {
			throw new EmptyException("Batch list is empty");
		}
		
	}



	
}
