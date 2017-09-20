package com.example.thomas.smartbookmarksfernandes.Models;

import java.util.Date;

/**
 * Created by Thomas on 20/09/2017.
 */

public class Comment {
    private int bookId;
    private String bookTitle;
    private int pageNumber;
    private String comment;
    private Date date;

    public Comment() {}

    public Comment(int bookId, int pageNumber, String comment) {
        this.bookId = bookId;
        this.pageNumber = pageNumber;
        this.comment = comment;
    }

    public Comment(String bookTitle, String comment, Date date) {
        this.bookTitle = bookTitle;
        this.comment = comment;
        this.date = date;
    }

    //region Getters and Setters

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //endregion
}
