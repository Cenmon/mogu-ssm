package com.mogu.solrj;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrjTest {
	@Test
	public void addDocument() throws Exception {
		//创建连接
		HttpSolrClient solrServer = new HttpSolrClient.Builder("http://192.168.23.129:8080/solr8/collection1").build();
		//创建文档对象
		SolrInputDocument solrInputDocument = new SolrInputDocument();
		solrInputDocument.addField("id", "my003");
		solrInputDocument.addField("item_title", "蓝牙耳机");
		solrInputDocument.addField("item_sell_point", "你值得拥有！");
		//把文档对象写入索引库
		solrServer.add(solrInputDocument);
		//提交
		solrServer.commit();
	}
	// 注：solr中修改即加入id相同的document
	
	@Test
	public void deleteDocument() throws Exception {
		HttpSolrClient httpSolrClient = new HttpSolrClient.Builder("http://192.168.23.129:8080/solr8/collection1").build();
		httpSolrClient.deleteById("my003");
		httpSolrClient.commit();
	}
	
	@Test
	public void selectDocument() throws Exception {
		HttpSolrClient httpSolrClient = new HttpSolrClient.Builder("http://192.168.23.129:8080/solr8/collection1").build();
		SolrQuery query = new SolrQuery();
		query.set("q","*:*");
		QueryResponse response = httpSolrClient.query(query);
		SolrDocumentList list = response.getResults();
		
		long cnt = list.getNumFound();
		System.out.println("查询结果数："+cnt);
		
		for(SolrDocument solrDocument:list) {
			System.out.println(solrDocument.get("id"));
			System.out.println(solrDocument.get("item_title"));
			System.out.println(solrDocument.get("item_sell_point"));
		}
	}
	
	public void reference() throws Exception {
		final String solrUrl = "http://192.168.23.129:8080/solr8/collection1";   
		HttpSolrClient solrServer = new HttpSolrClient.Builder(solrUrl).withConnectionTimeout(10000).withSocketTimeout(60000).build();         
		SolrQuery query = new SolrQuery();         
		query.setQuery("solrJ");         // 设置过滤条件         
		query.setFilterQueries("product_name:solrJ商品名称");         // 设置排序         
		query.setSort("id",SolrQuery.ORDER.desc);         // 设置分页信息         
		query.setStart(0);         query.setRows(10);         // 设置显得的域的列表         
		query.setFields("id", "title_ik", "content_ik","product_name");         // 设置默认搜索域         
		query.set("df", "product_name");         // 设置高亮         
		query.setHighlight(true);         
		query.addHighlightField("product_name");         
		query.setHighlightSimplePre("<em>");         
		query.setHighlightSimplePost("</em>");          // 调用server的查询方法，查询索引库         
		QueryResponse response = solrServer.query(query);          // 查询结果         
		SolrDocumentList results = response.getResults();          // 查询结果总数         
		long cnt = results.getNumFound();         
		System.out.println("查询结果总数:" + cnt);          
		for (SolrDocument solrDocument : results) {              
			System.out.println(solrDocument.get("id"));             //Highlighting 再通过id查询出数据,再从数据中获取属性,但默认返回的是一个list,那就取第一个             
			System.out.println( response.getHighlighting().get(solrDocument.get("id")).get("product_name").get(0));             System.out.println(solrDocument.get("title_ik"));             
			System.out.println(solrDocument.get("content_ik"));         
		}
	}
}
