package com.koreait.dto;

import org.apache.ibatis.type.Alias;

@Alias("qna")
public class QnADTO {
	private int qno;
	private String title;
	private String content;
	private String wdate;
	private String writer;
	private String response;
	private int status;

	public QnADTO() {
	}

	public int getQno() {
		return qno;
	}

	public void setQno(int qno) {
		this.qno = qno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public String getWirter() {
		return writer;
	}

	public void setWirter(String writer) {
		this.writer = writer;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "QnADTO [qno=" + qno + ", title=" + title + ", content=" + content + ", wdate=" + wdate + ", writer="
				+ writer + ", response=" + response + ", status=" + status + "]";
	}
	
	
}
