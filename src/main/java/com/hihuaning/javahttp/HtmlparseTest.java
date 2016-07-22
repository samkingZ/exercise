package com.hihuaning.javahttp;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;


public class HtmlparseTest {
	public static void main(String[] args) throws ParserException{
		Parser parser = new Parser();
		parser.setEncoding(parser.getEncoding());
		parser.setURL("http://www.baidu.com");
		NodeFilter filter = new NodeClassFilter(LinkTag.class);
		NodeList list = (NodeList) parser.extractAllNodesThatMatch(filter);
		for(int i=0; i < list.size(); i++){
			LinkTag node =   (LinkTag) list.elementAt(i);
			 System.out.println(node.extractLink()); 
		}
	}
}
