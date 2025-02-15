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

/**
 * Represents the result of an uploadFile()
 * 
 * @author Can Bican
 */
public class MediaItemUploadResult extends XmlRpcMapped {
  Integer id;
  String file;
  String url;
  String type;
  
  /**
   * @return the id
   */
  public final Integer getId() {
    return this.id;
  }
  
  /**
   * @param id
   *          the id to set
   */
  public final void setId(final Integer id) {
    this.id = id;
  }
  
  /**
   * @return the file
   */
  public final String getFile() {
    return this.file;
  }
  
  /**
   * @param file
   *          the file to set
   */
  public final void setFile(final String file) {
    this.file = file;
  }
  
  /**
   * @return the url
   */
  public final String getUrl() {
    return this.url;
  }
  
  /**
   * @param url
   *          the url to set
   */
  public final void setUrl(final String url) {
    this.url = url;
  }
  
  /**
   * @return the type
   */
  public final String getType() {
    return this.type;
  }
  
  /**
   * @param type
   *          the type to set
   */
  public final void setType(final String type) {
    this.type = type;
  }
}
