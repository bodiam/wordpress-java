package net.bican.wordpress.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import net.bican.wordpress.CustomField;
import net.bican.wordpress.Post;

@SuppressWarnings({ "static-method", "javadoc", "nls" })
public class CustomFieldTest extends AbstractWordpressTest {
  
  @Test
  public void testSetCustomFields() throws Exception {
    Post post = new Post();
    post.setPost_content("test content");
    post.setPost_title("test title");
    post.setPost_excerpt("test excerpt");
    List<CustomField> customFields = new ArrayList<>();
    CustomField cf1 = new CustomField();
    cf1.setKey("test key1");
    cf1.setValue("test value1");
    customFields.add(cf1);
    CustomField cf2 = new CustomField();
    cf2.setKey("test key");
    cf2.setValue("test value2");
    customFields.add(cf2);
    post.setCustom_fields(customFields);
    Integer postId = WP.newPost(post);
    Post newPost = WP.getPost(postId);
    assertNotNull(newPost);
    assertNotNull(newPost.getCustom_fields());
    assertEquals(2, newPost.getCustom_fields().size());
    WP.deletePost(postId);
  }
  
}
