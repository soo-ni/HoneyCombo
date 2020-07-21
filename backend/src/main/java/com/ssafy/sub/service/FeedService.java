package com.ssafy.sub.service;

import java.util.List;

import com.ssafy.sub.dto.FeedDto;

public interface FeedService {
	
	public List<FeedDto> feedList();

	// search가 빠짐 (기준 설정이 필요)

	public FeedDto feedDetail(int id);

	public int feedInsert();

	public int feedUpdate(int id, FeedDto dto);

	public int feedDelete(int id);}