/*
 * 
 * Wordpress-java
 * https://github.com/canbican/wordpress-java/
 * 
 * Copyright 2012-2015 Can Bican <can@bican.net>
 * See the file 'COPYING' in the distribution for licensing terms.
 * 
 */
package net.bican.wordpress;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import net.bican.wordpress.exceptions.InvalidPostFormatException;
import net.bican.wordpress.util.FileParser;
import net.bican.wordpress.util.StringHeader;
import redstone.xmlrpc.XmlRpcStruct;

/**
 * A WordPress Comment object
 * 
 * @author Fred Potter
 */
public class Comment extends XmlRpcMapped implements StringHeader {
  
  Date date_created_gmt;
  
  Integer user_id;
  
  Integer comment_id;
  
  Integer parent;
  
  String status;
  
  String content;
  
  String link;
  
  Integer post_id;
  
  String post_title;
  
  String author;
  
  String author_url;
  
  String author_email;
  
  String author_ip;
  
  /**
   * @return the date_created_gmt
   */
  public Date getDate_created_gmt() {
    return this.date_created_gmt;
  }
  
  /**
   * @param dateCreatedGmt
   *          the date_created_gmt to set
   */
  public void setDate_created_gmt(final Date dateCreatedGmt) {
    this.date_created_gmt = dateCreatedGmt;
  }
  
  /**
   * @return the user_id
   */
  public Integer getUser_id() {
    return this.user_id;
  }
  
  /**
   * @param userId
   *          the user_id to set
   */
  public void setUser_id(final Integer userId) {
    this.user_id = userId;
  }
  
  /**
   * @return the comment_id
   */
  public Integer getComment_id() {
    return this.comment_id;
  }
  
  /**
   * @param commentId
   *          the comment_id to set
   */
  public void setComment_id(final Integer commentId) {
    this.comment_id = commentId;
  }
  
  /**
   * @return the parent
   */
  public Integer getParent() {
    return this.parent;
  }
  
  /**
   * @param parent
   *          the parent to set
   */
  public void setParent(final Integer parent) {
    this.parent = parent;
  }
  
  /**
   * @return the status
   */
  public String getStatus() {
    return this.status;
  }
  
  /**
   * @param status
   *          the status to set
   */
  public void setStatus(final String status) {
    this.status = status;
  }
  
  /**
   * @return the content
   */
  public String getContent() {
    return this.content;
  }
  
  /**
   * @param content
   *          the content to set
   */
  public void setContent(final String content) {
    this.content = content;
  }
  
  /**
   * @return the link
   */
  public String getLink() {
    return this.link;
  }
  
  /**
   * @param link
   *          the link to set
   */
  public void setLink(final String link) {
    this.link = link;
  }
  
  /**
   * @return the post_id
   */
  public Integer getPost_id() {
    return this.post_id;
  }
  
  /**
   * @param postId
   *          the post_id to set
   */
  public void setPost_id(final Integer postId) {
    this.post_id = postId;
  }
  
  /**
   * @return the post_title
   */
  public String getPost_title() {
    return this.post_title;
  }
  
  /**
   * @param postTitle
   *          the post_title to set
   */
  public void setPost_title(final String postTitle) {
    this.post_title = postTitle;
  }
  
  /**
   * @return the author
   */
  public String getAuthor() {
    return this.author;
  }
  
  /**
   * @param author
   *          the author to set
   */
  public void setAuthor(final String author) {
    this.author = author;
  }
  
  /**
   * @return the author_url
   */
  public String getAuthor_url() {
    return this.author_url;
  }
  
  /**
   * @param authorUrl
   *          the author_url to set
   */
  public void setAuthor_url(final String authorUrl) {
    this.author_url = authorUrl;
  }
  
  /**
   * @return the author_email
   */
  public String getAuthor_email() {
    return this.author_email;
  }
  
  /**
   * @param authorEmail
   *          the author_email to set
   */
  public void setAuthor_email(final String authorEmail) {
    this.author_email = authorEmail;
  }
  
  /**
   * @return the author_ip
   */
  public String getAuthor_ip() {
    return this.author_ip;
  }
  
  /**
   * @param authorIp
   *          the author_ip to set
   */
  public void setAuthor_ip(final String authorIp) {
    this.author_ip = authorIp;
  }
  
  /**
   * (non-Javadoc)
   * 
   * @see net.bican.wordpress.util.StringHeader#getStringHeader()
   */
  @Override
  @SuppressWarnings("nls")
  public String getStringHeader() {
    final String TAB = ":";
    return "Date Created GMT" + TAB + "User Id" + TAB + "Comment Id" + TAB
        + "Parent" + TAB + "Status" + TAB + "Content" + TAB + "Link" + TAB
        + "Post Id" + TAB + "Post Title" + TAB + "Author" + TAB + "Author URL "
        + TAB + "Author Email" + TAB + "Author IP";
  }
  
  /**
   * Creates a comment object from file
   * 
   * @param file
   *          input file
   * @return new Comment object
   * @throws FileNotFoundException
   *           when the file is absent
   * @throws IOException
   *           when the file cannot be read
   * @throws InvalidPostFormatException
   *           when the file format is invalid
   */
  public static Comment fromFile(final File file) throws FileNotFoundException,
      IOException, InvalidPostFormatException {
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      final XmlRpcStruct c = FileParser.parseFile(br);
      final Comment result = new Comment();
      result.fromXmlRpcStruct(c);
      return result;
    }
  }
}
