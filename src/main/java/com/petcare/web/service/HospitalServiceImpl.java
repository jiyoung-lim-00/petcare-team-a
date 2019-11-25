package com.petcare.web.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petcare.web.domain.Character;
import com.petcare.web.domain.Hospital;
import com.petcare.web.domain.HospitalVO;
import com.petcare.web.mapper.HospitalMapper;

@Service
public class HospitalServiceImpl implements HospitalService {
	@Autowired
	private HospitalMapper hospitalMapper;
	
	//병원 전체 리스트
	@Override
	public ArrayList<HospitalVO> list(){
		ArrayList<HospitalVO> result = hospitalMapper.listHospital();
		return result;
	};
	
	//병원 검색
	@Override
	public ArrayList<HospitalVO> search(String hospitalName){
		ArrayList<HospitalVO> result = hospitalMapper.searchHospital(hospitalName);
		return result;
	};
	
	//병원 보기
	@Override
	public HospitalVO view(String hospitalId) {
		HospitalVO result = hospitalMapper.viewHospital(hospitalId);
		return result;
	}

	//병원 회원가입
	@Transactional
	@Override
	public void register(Hospital hospital) {
		hospitalMapper.register(hospital);
	}
	
	//특성 삽입
	@Override
	public void codeInsert(Character character) {
		hospitalMapper.codeInsert(character);
	}

	@Override
	public int selectID(String id) {
		String hospitalId = hospitalMapper.selectID(id);
		if(hospitalId == null) {
			return 0;
		}else {
			return 1;
		}
	}

	@Override
	public int selectEmail(String email) {
		String hospitalEmail = hospitalMapper.selectEmail(email);
		if(hospitalEmail == null) {
			return 0;			
		}else {
			return 1;
		}
	}
	

}
