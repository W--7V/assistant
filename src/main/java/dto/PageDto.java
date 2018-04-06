package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageDto<E> implements Serializable {
	private static final long serialVersionUID = -6588503204376229169L;
	private int total;
	private List<E> rows = new ArrayList<E>();
	private int currentpage;
	private int totalPage;

	private int pageSize=50; 
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<E> getRows() {
		return rows;
	}
	public void setRows(List<E> rows) {
		this.rows = rows;
	}
	public void setPageSize(int size){
		this.pageSize = size;
	}
	public int getPageSize(){
		return this.pageSize;
	}
	public int getTotalPages(){
		int temp = (total+pageSize-1)/pageSize;
		return temp <= 0 ? 1 : temp;
	}
	public int getIndexPage(){
		return 1;
	}
	public int getLastPage(){
		return this.getTotalPages();
	}
	public int getPreviousPage(){
		if(this.currentpage <= 1){
			return 1;
		}else{
			return this.currentpage-1;
		}
	}
	public int getNextPage(){
		if(this.currentpage >= this.getTotalPages()){
			return this.getTotalPages();
		}else{
			return this.currentpage+1;
		}
	}
}
