/**
 *    Copyright 2006-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;

import java.util.Iterator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

/**
 * 
 * @author Jeff Butler
 * 
 */
public class BaseInsertColumnListElementGenerator extends AbstractXmlElementGenerator {

	public BaseInsertColumnListElementGenerator() {
		super();
	}

	@Override
	public void addElements(XmlElement parentElement) {
		XmlElement answer = new XmlElement("sql"); //$NON-NLS-1$

		answer.addAttribute(new Attribute("id", //$NON-NLS-1$
				"Base_Insert_Column_List"));

		context.getCommentGenerator().addComment(answer);
		StringBuilder sb = new StringBuilder();
		int i = 0;
		int length = introspectedTable.getAllColumns().size();
		for (IntrospectedColumn introspectedColumn : introspectedTable.getAllColumns()) {
			sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn, "item."));
			if (i < length - 1) {
				sb.append(',');
				i++;
			}
		}
		System.out.println(sb.toString());
		answer.addElement(new TextElement(sb.toString()));
		parentElement.addElement(answer);
	}
}
