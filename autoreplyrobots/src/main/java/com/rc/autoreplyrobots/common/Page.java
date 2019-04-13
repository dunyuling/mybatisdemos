package com.rc.autoreplyrobots.common;

/**
 * @ClassName Page
 * @Description 分页对应实体类
 * @Author liux
 * @Date 19-4-13 下午12:05
 * @Version 1.0
 */
public class Page {

    private int totalNumber;//总条数
    private int currentPage;//当前页码
    private int totalPage;//总页数

    private int pageNumber = Constant.PAGE_NUMBER;//每页显示条数
    private int dbIndex;//数据库中的limit参数，从第几条开始取
    private int dbNumber;//数据库中的limit参数，一共取多少条

    public Page() {
    }

    public Page(int totalNumber,int currentPage) {
        this.totalNumber = totalNumber;
        this.currentPage = currentPage;
    }

    /*
     * @Author liux
     * @Description 根据当前对象中属性值计算并设置相关属性值
     * @Date 19-4-13 下午12:30
     * @param
     * @return void
     **/
    public void config() {
        //计算总页数
        int totalPageTemp = this.totalNumber / this.pageNumber;
        int plus = (this.totalNumber % this.pageNumber) == 0 ? 0 : 1;
        totalPageTemp += plus;
        if (totalPageTemp == 0) {
            totalPageTemp = 1;
        }
        this.totalPage = totalPageTemp;

        //设置当前页
        //总页数小于当前页，应将当前页数置为总页数
        if (this.totalPage < this.currentPage) {
            this.currentPage = this.totalPage;
        }

        //当前页数小于1时，置为1
        if (this.currentPage < 1) {
            this.currentPage = 1;
        }

        //设置limit参数
        this.dbIndex = (this.currentPage - 1) * this.pageNumber;
        this.dbNumber = this.pageNumber;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

//    public void setPageNumber(int pageNumber) {
//        this.pageNumber = pageNumber;
//    }

    public int getDbIndex() {
        return dbIndex;
    }

    public void setDbIndex(int dbIndex) {
        this.dbIndex = dbIndex;
    }

    public int getDbNumber() {
        return dbNumber;
    }

    public void setDbNumber(int dbNumber) {
        this.dbNumber = dbNumber;
    }
}