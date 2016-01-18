package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

public class BaseQueryCondsElementGenerator extends AbstractXmlElementGenerator {

	public BaseQueryCondsElementGenerator() {
		super();
	}

	@Override
	public void addElements(XmlElement parentElement) {
		// <sql id="queryConds">
		XmlElement answer = new XmlElement("sql");
		answer.addAttribute(new Attribute("id", introspectedTable.getBaseQueryCondsId()));
		// select <include refid="Base_Column_List"/> from AF72
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		if (stringHasValue(introspectedTable.getSelectByPrimaryKeyQueryId())) {
			sb.append('\'');
			sb.append(introspectedTable.getSelectByPrimaryKeyQueryId());
			sb.append("' as QUERYID,");
		}
		answer.addElement(new TextElement(sb.toString()));
		answer.addElement(getBaseColumnListElement());

		if (introspectedTable.hasBLOBColumns()) {
			answer.addElement(new TextElement(","));
			answer.addElement(getBlobColumnListElement());
		}
		sb.setLength(0);
		sb.append("from "); //$NON-NLS-1$
		sb.append(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
		answer.addElement(new TextElement(sb.toString()));

		XmlElement dynamicElement = new XmlElement("where");
		answer.addElement(dynamicElement);
		for (IntrospectedColumn introspectedColumn : introspectedTable.getNonPrimaryKeyColumns()) {
			XmlElement isNotNullElement = new XmlElement("if");
			sb.setLength(0);
			sb.append(introspectedColumn.getJavaProperty());
			sb.append(" != null and "); //$NON-NLS-1$
			sb.append(introspectedColumn.getJavaProperty());
			sb.append(" != \"\"");
			isNotNullElement.addAttribute(new Attribute("test", sb.toString())); //$NON-NLS-1$
			dynamicElement.addElement(isNotNullElement);

			sb.setLength(0);
			sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
			sb.append(" = "); //$NON-NLS-1$
			sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
			sb.append(',');

			isNotNullElement.addElement(new TextElement(sb.toString()));
		}
		parentElement.addElement(answer);
	}
}
