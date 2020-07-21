package com.ssafy.sub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.sub.dto.FeedDto;
import com.ssafy.sub.service.FeedService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
public class FeedController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private FeedService feedService;

	// 1. list 조회
	@ApiOperation(value = "feedList를 조회한다", response = FeedDto.class)
	@GetMapping(value = "/feed")
	public ResponseEntity<List<FeedDto>> feedList() {
		System.out.println("log - feedList");

		List<FeedDto> feedDtoList = feedService.feedList();
		
		return new ResponseEntity<List<FeedDto>>(feedDtoList, HttpStatus.OK);
	}

	// 2. list 검색 ( 기준이 애매해서 일단 비워둠 )
//	@ApiOperation(value = "feedList의 내용 중 일부를 검색한다", response = FeedDto.class)
//	@GetMapping(value = "/feed/search")
//	public ResponseEntity<List<FeedDto>> feedListSearch() {
//		System.out.println("log - feedListSearch");
//
//		List<FeedDto> feedDtoList = feedService.feedListSearch();
//		
//	return new ResponseEntity<List<FeedDto>>(feedDtoList, HttpStatus.OK);
//	}
	
	// 3. list 추가
	@ApiOperation(value = "feedList에 정보를 추가한다", response = String.class)
	@PostMapping(value = "/feed")
	public ResponseEntity<String> feedInsert() {
		System.out.println("log - feedInsert");

		int ret = feedService.feedInsert();
		
		if(ret == 0)
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
	// 4. list 상세
	@ApiOperation(value = "특정 feed를 조회한다", response = FeedDto.class)
	@GetMapping(value = "/feed/{id}")
	public ResponseEntity<FeedDto> feedDetail(@PathVariable int id) {
		System.out.println("log - feedDetail");

		FeedDto feedDto = feedService.feedDetail(id);
		
		return new ResponseEntity<FeedDto>(feedDto, HttpStatus.OK);
	}

	// 5. list 수정
	@ApiOperation(value = "feed의 정보를 수정한다", response = String.class)
	@PutMapping(value = "/feed/{id}")
	public ResponseEntity<String> feedUpdate(@PathVariable int id, @RequestBody FeedDto dto) {
		System.out.println("log - feedUpdate");

		int ret = feedService.feedUpdate(id, dto);
		
		if(ret == 0)
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
	// 6. list 삭제
	@ApiOperation(value = "feed의 정보를 삭제한다", response = String.class)
	@DeleteMapping(value = "/feed/{id}")
	public ResponseEntity<String> feedDelete(@PathVariable int id) {
		System.out.println("log - feedDelete");

		int ret = feedService.feedDelete(id);
		
		if(ret == 0)
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
}