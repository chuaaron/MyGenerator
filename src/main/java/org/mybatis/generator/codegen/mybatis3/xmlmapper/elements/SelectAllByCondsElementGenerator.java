package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

public class SelectAllByCondsElementGenerator extends AbstractXmlElementGenerator {

	public SelectAllByCondsElementGenerator() {
		super();
	}

	@Override
	public void addElements(XmlElement parentElement) {
		XmlElement answer = new XmlElement("select");
		answer.addAttribute(new Attribute("id", "selectAllByConds"));
		answer.addAttribute(new Attribute("parameterType", "map"));
		answer.addAttribute(new Attribute("resultMap", introspectedTable.getBaseResultMapId()));
		StringBuilder sb = new StringBuilder();
		sb.append("<include refid=\"" + introspectedTable.getBaseQueryCondsId() + "\"/>");
		answer.addElement(new TextElement(sb.toString()));
		parentElement.addElement(answer);
	}
}
