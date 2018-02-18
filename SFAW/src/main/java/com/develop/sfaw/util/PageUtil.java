package com.develop.sfaw.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageUtil {

	private static final Logger log = LoggerFactory.getLogger(PageUtil.class);
	private int totalRows;	// 총 게시물 개수
	private int viewRows;	// 한 페이지에 보여줄 게시물 개수
	private int totalPages;		// 총 페이지 수
	private int pageDisplay;		// 하단 페이지 버튼 개수
	private int totalBlock;		// 총 블럭 수
	private int block;			// 현재 블럭
	private int currentPage;	// 현재 페이지
	private int firstPage;		// 현재 블럭에서 첫 번째 페이지
	private int lastPage;		// 현재 블럭에서 마지막 페이지
	private int prevPage;		// 현재 블럭에서 이전 페이지 번호
	private int nextPage;		// 현재 블럭에서 다음 페이지 번호

	private PageUtil(PageBuilder builder) {
		this.totalRows = builder.totalRows;
		this.viewRows = builder.viewRows;
		this.totalPages = builder.totalPages;
		this.pageDisplay = builder.pageDisplay;
		this.totalBlock = builder.totalBlock;
		this.block = builder.block;
		this.currentPage = builder.currentPage;
		this.firstPage = builder.firstPage;
		this.lastPage = builder.lastPage;
		this.prevPage = builder.prevPage;
		this.nextPage = builder.nextPage;
	}

	public static PageBuilder Builder() {
		return new PageBuilder();
	}

	public static class PageBuilder{
		private int totalRows;
		private int viewRows;
		private int totalPages;
		private int pageDisplay;
		private int totalBlock;
		private int block;
		private int currentPage;
		private int firstPage;
		private int lastPage;
		private int prevPage;
		private int nextPage;

		public PageBuilder() {}

		public PageBuilder(int viewRows, int pageDisplay) {
			this.viewRows = viewRows;
			this.pageDisplay = pageDisplay;
		}

		public PageBuilder totalRows(int totalRows) {
			this.totalRows = totalRows;
			return this;
		}

		public PageBuilder viewRows(int viewRows) {
			this.viewRows = viewRows;
			return this;
		}

		public PageBuilder totalPages() {
			totalPages = totalRows / viewRows;
			if(totalRows % viewRows != 0) {
				totalPages++;
			}
			return this;
		}

		public PageBuilder pageDisplay(int pageDisplay) {
			this.pageDisplay = pageDisplay;
			return this;
		}

		public PageBuilder totalBlock() {
			totalBlock = totalPages / pageDisplay;
			if(totalPages % pageDisplay != 0) {
				totalBlock++;
			}
			return this;
		}

		public PageBuilder block() {
			block = currentPage / pageDisplay;
			if(currentPage % pageDisplay != 0) {
				block++;
			}
			return this;
		}

		public PageBuilder currentPage(int currentPage) {
			this.currentPage = currentPage;
			return this;
		}

		public PageBuilder firstPage() {
			firstPage = (block - 1) * pageDisplay + 1;
			return this;
		}

		public PageBuilder lastPage() {
			lastPage = block * pageDisplay;
			if(block >= totalBlock) {
				lastPage = totalPages;
			}
			return this;
		}

		public PageBuilder prevPage() {
			prevPage = 0;
			if(block > 1) {
				prevPage = firstPage - 1;
			}
			return this;
		}

		public PageBuilder nextPage() {
			nextPage = 0;
			if(block < totalBlock) {
				nextPage = lastPage + 1;
			}
			return this;
		}

		public PageUtil build() {
			return new PageUtil(this);
		}
	}

	public int getTotalRows() {
		return totalRows;
	}

	public int getViewRows() {
		return viewRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getpageDisplay() {
		return pageDisplay;
	}

	public int getTotalBlock() {
		return totalBlock;
	}

	public int getBlock() {
		return block;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}


}
