package com.neusoft.ehr.comm;

public class PageUtil {
	//��1��ÿҳ��ʾ�ļ�¼����
	//��2���ܵļ�¼��
	//��3����ǰҳ��
	public static Page createPage(int everyPage,int totalCount,int currentPage)
	{
		everyPage = getEveryPage(everyPage);
		currentPage = getCurrentPage(currentPage);
		int totalPage = getTotalPage(everyPage,totalCount);
		int beginIndex = getBeginIndex(currentPage,everyPage);
		boolean hasPrePage = getHasPrePage(currentPage);
		boolean hasNextPage = getHasNextPage(totalPage,currentPage);
		return new  Page(everyPage,totalCount,totalPage,currentPage,
				beginIndex,hasPrePage, hasNextPage);
	}
	
	public static int getEveryPage(int everyPage)
	{
		return everyPage==0?10:everyPage;
	}
	public static int getCurrentPage(int currentPage)
	{
		return currentPage==0?1:currentPage;
	}
	public static int getTotalPage(int everyPage ,int totalCount)
	{
		int totalPage=0;
		if(totalCount!=0&&totalCount%everyPage==0)
		{
			totalPage=totalCount/everyPage;
		}
		else
			totalPage=totalCount/everyPage+1;
		return totalPage;
	}
	public static int getBeginIndex(int currentPage,int everyPage)
	{
		return (currentPage-1)*everyPage;
	}
	//�ж��ǲ�������һҳ��
	public static boolean getHasPrePage(int currentPage){
		return currentPage == 1?false: true;
	}
	//�ж��ǲ�������һҳ��
	public static boolean getHasNextPage(int totalPage,int currentPage){
		return currentPage == totalPage || totalPage == 0?false:true;
	}
}
