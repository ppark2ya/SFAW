package com.develop.sfaw.util;

public class PageUtil {

	private double totalRows;	// 총 게시물 개수
	private double viewRows;	// 한 페이지에 보여줄 게시물 개수
	private int totalPages;		// 총 페이지 수
	private int pagination;		// 하단 페이지 버튼 개수

	private PageUtil(PageBuilder builder) {
		this.totalRows = builder.totalRows;
		this.viewRows = builder.viewRows;
		this.totalPages = builder.totalPages;
		this.pagination = builder.pagination;
	}

	public static PageBuilder Builder() {
		return new PageBuilder();
	}

	public static class PageBuilder{
		private double totalRows;
		private double viewRows;
		private int totalPages;
		private int pagination;

		public PageBuilder() {}

		public PageBuilder(double viewRows, int pagination) {
			this.viewRows = viewRows;
			this.pagination = pagination;
		}

		public PageBuilder totalRows(double totalRows) {
			this.totalRows = totalRows;
			return this;
		}

		public PageBuilder viewRows(double viewRows) {
			this.viewRows = viewRows;
			return this;
		}

		public PageBuilder totalPages(int totalPages) {
			this.totalPages = totalPages;
			return this;
		}

		public PageBuilder pagination(int pagination) {
			this.pagination = pagination;
			return this;
		}

		public PageUtil build() {
			return new PageUtil(this);
		}
	}

}
