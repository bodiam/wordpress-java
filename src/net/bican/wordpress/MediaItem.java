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

import java.util.Date;

/**
 * Class for an media item object for a blog
 * 
 * @author Can Bican
 */
public class MediaItem extends XmlRpcMapped {
  Integer attachment_id;
  Date date_created_gmt;
  Integer parent;
  String link;
  String title;
  String caption;
  String description;
  MediaItemMetadata metadata;
  String thumbnail;
  
  /**
   * @return the attachment_id
   */
  public final Integer getAttachment_id() {
    return this.attachment_id;
  }
  
  /**
   * @param attachment_id
   *          the attachment_id to set
   */
  public final void setAttachment_id(final Integer attachment_id) {
    this.attachment_id = attachment_id;
  }
  
  /**
   * @return the date_created_gmt
   */
  public final Date getDate_created_gmt() {
    return this.date_created_gmt;
  }
  
  /**
   * @param date_created_gmt
   *          the date_created_gmt to set
   */
  public final void setDate_created_gmt(final Date date_created_gmt) {
    this.date_created_gmt = date_created_gmt;
  }
  
  /**
   * @return the parent
   */
  public final Integer getParent() {
    return this.parent;
  }
  
  /**
   * @param parent
   *          the parent to set
   */
  public final void setParent(final Integer parent) {
    this.parent = parent;
  }
  
  /**
   * @return the link
   */
  public final String getLink() {
    return this.link;
  }
  
  /**
   * @param link
   *          the link to set
   */
  public final void setLink(final String link) {
    this.link = link;
  }
  
  /**
   * @return the title
   */
  public final String getTitle() {
    return this.title;
  }
  
  /**
   * @param title
   *          the title to set
   */
  public final void setTitle(final String title) {
    this.title = title;
  }
  
  /**
   * @return the caption
   */
  public final String getCaption() {
    return this.caption;
  }
  
  /**
   * @param caption
   *          the caption to set
   */
  public final void setCaption(final String caption) {
    this.caption = caption;
  }
  
  /**
   * @return the description
   */
  public final String getDescription() {
    return this.description;
  }
  
  /**
   * @param description
   *          the description to set
   */
  public final void setDescription(final String description) {
    this.description = description;
  }
  
  /**
   * @return the metadata
   */
  public final MediaItemMetadata getMetadata() {
    return this.metadata;
  }
  
  /**
   * @param metadata
   *          the metadata to set
   */
  public final void setMetadata(final MediaItemMetadata metadata) {
    this.metadata = metadata;
  }
  
  /**
   * @return the thumbnail
   */
  public final String getThumbnail() {
    return this.thumbnail;
  }
  
  /**
   * @param thumbnail
   *          the thumbnail to set
   */
  public final void setThumbnail(final String thumbnail) {
    this.thumbnail = thumbnail;
  }
}
