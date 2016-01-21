package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

public class BatchInsertElementGenerator extends AbstractXmlElementGenerator {

	public BatchInsertElementGenerator() {
		super();
	}

	@Override
	public void addElements(XmlElement parentElement) {
		XmlElement answer = new XmlElement("insert");
		answer.addAttribute(new Attribute("id", "batchInsert"));
		FullyQualifiedJavaType parameterType;
		parameterType = introspectedTable.getRules().calculateAllFieldsClass();
		answer.addAttribute(new Attribute("parameterType", parameterType.getFullyQualifiedName()));
		StringBuilder sb = new StringBuilder();
		sb.append("insert into ");
		sb.append(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
		sb.append("(<include refid=\"" + introspectedTable.getBaseColumnListId() + "\"/>)");
		answer.addElement(new TextElement(sb.toString()));
		XmlElement foreachElement = new XmlElement("foreach");
		foreachElement.addAttribute(new Attribute("collection", "list"));
		foreachElement.addAttribute(new Attribute("index", "index"));
		foreachElement.addAttribute(new Attribute("item", "item"));
		foreachElement.addAttribute(new Attribute("open", "("));
		foreachElement.addAttribute(new Attribute("close", ")"));
		foreachElement.addAttribute(new Attribute("separator", "union all"));
		sb.setLength(0);
		sb.append("select <include refid=\"Base_Insert_Column_List\"/> from dual");
		foreachElement.addElement(new TextElement(sb.toString()));
		answer.addElement(foreachElement);
		parentElement.addElement(answer);
	}
}
