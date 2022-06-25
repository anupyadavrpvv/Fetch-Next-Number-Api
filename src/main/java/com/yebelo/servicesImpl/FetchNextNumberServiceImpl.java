package com.yebelo.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yebelo.Repositories.FetchNextNumberRepository;
import com.yebelo.model.CategoryValueEntity;
import com.yebelo.services.FetchNextNumberService;

@Service
public class FetchNextNumberServiceImpl implements FetchNextNumberService{
	
	@Autowired
	private FetchNextNumberRepository repository;

	
	@Override
	public List<Integer> findValue(Integer categoryCode) {
		List<Integer> result= new ArrayList<>();
		Optional<CategoryValueEntity> cat= this.repository.findById(categoryCode);
		
		CategoryValueEntity catObj = cat.get();
		int value =  catObj.getValue();
		int newValue= fetchNextNumber(value);
		catObj.setValue(newValue);
		this.repository.save(catObj);
		result.add(value);
		result.add(newValue);
		return result;
	}
	
	public static int fetchNextNumber(int n){
        int digitSum= sumOfDigits(n);
        while(digitSum >9 ){
            digitSum = sumOfDigits(digitSum);
        }
        if(digitSum == 1){
            fetchNextNumber(n + 1);
        }
        return n + (10 - digitSum);
    }

    public static int sumOfDigits(int n){
        int sum=0;
        while(n != 0){
            sum += n%10;
            n = n/10;
        }
        return sum;
    }
	
}
