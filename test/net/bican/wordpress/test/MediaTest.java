/*
 * 
 * Wordpress-java
 * https://github.com/canbican/wordpress-java/
 * 
 * Copyright 2012-2015 Can Bican <can@bican.net>
 * See the file 'COPYING' in the distribution for licensing terms.
 * 
 */
package net.bican.wordpress.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import net.bican.wordpress.MediaItem;
import net.bican.wordpress.MediaItemUploadResult;

@SuppressWarnings({ "javadoc", "static-method", "nls" })
public class MediaTest extends AbstractWordpressTest {
  private static final String TEST_IMAGE = "test.jpg";
  
  @Test
  public void testUploadFile() throws Exception {
    try (InputStream media = new FileInputStream(
        new File("test/" + TEST_IMAGE))) {
      String fileName = TEST_IMAGE;
      MediaItemUploadResult r = WP.uploadFile(media, fileName);
      assertNotNull(r);
      assertEquals(TEST_IMAGE, r.getFile());
      assertNotNull(r.getId());
      assertEquals("application/octet-stream", r.getType());
      assertNotNull(r.getUrl());
      WP.deletePost(r.getId()); // it seems that this is how you
                                // delete a file
    }
  }
  
  @Test
  public void testGetMediaItem() throws Exception {
    try (InputStream media = new FileInputStream(
        new File("test/" + TEST_IMAGE))) {
      String fileName = TEST_IMAGE;
      MediaItemUploadResult mediaUploaded = WP.uploadFile(media, fileName);
      MediaItem r = WP.getMediaItem(mediaUploaded.getId());
      assertNotNull(r);
      assertEquals(mediaUploaded.getId(), r.getAttachment_id());
      assertEquals("", r.getCaption());
      assertNotNull(r.getDate_created_gmt());
      assertEquals("", r.getDescription());
      assertNotNull(r.getLink());
      assertEquals(Integer.valueOf(0), r.getParent());
      assertNotNull(r.getThumbnail());
      assertEquals(TEST_IMAGE, r.getTitle());
      assertNull(r.getMetadata()); // it seems that this one does not get
                                   // updated via xmlrpc
      WP.deletePost(mediaUploaded.getId());
    }
  }
  
  @Test
  public void testGetMediaLibrary() throws Exception {
    List<MediaItem> r = WP.getMediaLibrary();
    assertNotNull(r);
    assertTrue(r.size() > 0);
  }
}
