package com.lab.DiaryAppBE.Diary.Entity;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lab.DiaryAppBE.Diary.DTO.DiaryDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "Diary")
public class DiaryEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date date;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "emotionId")
	private int emotionId;
	
	public DiaryEntity(DiaryDTO diaryDTO) 
	{
		this.date = diaryDTO.getDate();
		this.content = diaryDTO.getContent();
		this.emotionId = diaryDTO.getEmotionId();	
	}
}
