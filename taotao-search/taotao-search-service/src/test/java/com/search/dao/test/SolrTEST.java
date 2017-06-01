package com.search.dao.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysql.fabric.xmlrpc.base.Array;

public class SolrTEST {

	@Test
	public void testSolr() throws SolrServerException {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-solr.xml");
		SolrServer bean = context.getBean(SolrServer.class);
		SolrQuery params = new SolrQuery();
		params.setQuery("*:*");
		QueryResponse response = bean.query(params);
		System.out.println(response);
	}

	
	@Test
	public void test3() {
		System.out.println(-123%10);
	
	}
	
	@Test
	public void test10() throws SolrServerException, Exception {
		// 第一步：创建一个SolrServer对象。
		SolrServer solrServer = new HttpSolrServer("http://192.168.25.154:8080/solr");
		// 第二步：调用SolrServer对象的根据id删除的方法。
		UpdateResponse deleteById = solrServer.deleteById("149354258593002");
		System.out.println(deleteById);
		// 第三步：提交。
		solrServer.commit();
	
	}
	
	
	@Test
	public void test() {
		int[] arr1 = { 1, 4, 7, 8, 10, 12 };
		int[] arr2 = { 2, 3, 7, 9 };
		int beforeArr = 0;
		int afterArr = 0;
		List<Integer> arrList = new ArrayList<>();
		int a = 0;
		int b = 0;
		if (a < arr1.length) {
			aa: for (int i = a; i < arr1.length; i++) {
				beforeArr = arr1[i];// 第一个元素
				if (b < arr2.length) {
					bb: for (int j = b; j < arr2.length; j++) {
						afterArr = arr2[j]; // 第二个元素
						if (beforeArr < afterArr) {
							arrList.add(beforeArr);
							a++;
							break bb;
						} else if (beforeArr > afterArr) {
							arrList.add(afterArr);
							b++;
						} else {
							arrList.add(beforeArr);
							arrList.add(afterArr);
							a++;
							b++;
							continue aa;
						}
					}
				} else {
					addArrRem(a,arr1,arrList);
				}

			}
		} else {
			addArrRem(b,arr2,arrList);
		}

		System.out.println(arrList);
		
	}
	
	public List<Integer> addArrRem(int num, int[] arr,List<Integer> arrList){
		for (int k = num; k < arr.length; k++) {
			arrList.add(arr[k]);
		}
		return arrList;
	}
	
	
	@Test
	public void tett(){
		int[] a = {1,2,3,4,5,6,7,8,9};
		int i = binarySearch(a,7);
		System.out.println(i);
	}
	public  int binarySearch(int[] destarray, int data) {
	    int low = 0;
	    int high = destarray.length - 1;
	 
	    while ((low <= high) && (low <= destarray.length - 1)
	            && (high <= destarray.length - 1)) {
	        int middle = (high + low) >> 1;
	        if (data == destarray[middle]) {
	            return middle;
	        } else if (data < destarray[middle]) {
	            high = middle - 1;
	        } else {
	            low = middle + 1;
	        }
	    }
	    return -1;
	}
	
	static String s;
	@Test
	public void testtt(){
		System.out.println("s="+s);
	}
	

	@Test
	public void tes5t() {
		int[] arr1 = { 1, 4, 7, 8, 10, 12 };
		
		int[] arr2 = { 2, 3, 7, 9 };
		if(!test6(arr1) || !test6(arr2)){
			System.out.println("数组有误!");
		}
		
		TreeSet<Integer> treeSet = new TreeSet<>();
		for (int e : arr1) {
			treeSet.add(e);
		}
		for (int e : arr2) {
			treeSet.add(e);
		}
		 
		 Object[] objs = treeSet.toArray();
		 int[] arr = new int[treeSet.size()];
		 for (int i = 0; i < objs.length; i++) {
			 arr[i] = (int) objs[i];
		 }
		 for (int i : arr) {
			System.out.print(i+"  ");
		}
		 
		 
		
	}
	

	
	public boolean test6(int[] arr) {
		
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]){
					return false;
				}
			}
		}
		
		return true;
	}
	
	@Test
	public void test8(){
		int[] arr1 = { 1,2, 4, 7, 8, 10, 12 };
		int[] arr2 = { 3, 7,11 ,12};
		int[] groupArr;
		if (arr1[arr1.length-1] < arr2[arr2.length-1]) {
			groupArr = test7(arr2,arr1);
		}else{
			groupArr = test7(arr1,arr2);
		}
		for (int i = 0; i < groupArr.length; i++) {
			System.out.print(groupArr[i] + " ");
		}
	}
	//先比较两个有序数组的最大值,大的是大数组,小的是小数组,一样的话随便哪个是大数组
	
	//遍历小数组嵌套大数组,当小数组的值大于大数组的值得时候,将大数组的值放入ArrayList中并且将大数组的替代索引加一继续内循环,
	//              当小数组的值小于大数组的值得时候,将小数组的值放入ArrayList中并且将小数组的替代索引加一跳过本次外循环
	//  循环全部结束,将大数组剩余的数全部添加list集合中
	//将list集合中的元素全部添加到新的数组中
	//返回该数组
	public int[] test7(int[] maxArr,int[] minArr) {
		List<Integer> list = new ArrayList<>();
		int index1 = 0;
		int index2 = 0;
	aa:	for (int i2 = index2; i2 < minArr.length; i2++) {
			for (int i = index1; i < maxArr.length; i++) {
				
				if(minArr[i2] > maxArr[i]){
					list.add(maxArr[i]);
					index1++;
				}else{
					list.add(minArr[i2]);
					index2++;
					continue aa;
				}
			}
		}
		
		for (int i = index1; i < maxArr.length; i++) {
			list.add( maxArr[i]);
		}
		
		int[] groupArr = new int[list.size()];
		for (int i = 0; i < groupArr.length; i++) {
			groupArr[i] = list.get(i);
		}
		
		return groupArr;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
