//Copyright 2011-2012 Lohika .  This file is part of ALP.
//
//    ALP is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    ALP is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with ALP.  If not, see <http://www.gnu.org/licenses/>.
package com.lohika.alp.log.elements;

import java.util.List;

import com.lohika.alp.log.elements.schema.Blockstyle;
import com.lohika.alp.log.elements.schema.Comment;
import com.lohika.alp.log.elements.schema.Link;
import com.lohika.alp.log.elements.schema.ObjectFactory;
import com.lohika.alp.log.elements.schema.Screenshot;
import com.lohika.alp.log.elements.schema.Textarea;


/**
 * The Class LogElementsFactoryJAXB.
 */
public class LogElementsFactoryJAXB implements LogElementsFactory {

	/** The Object factory. */
	protected ObjectFactory factory = new ObjectFactory();

	/* (non-Javadoc)
	 * @see com.lohika.alp.log.elements.LogElementsFactory#textArea(java.lang.String, java.lang.String)
	 */
	@Override
	public Object textArea(String name, String content) {
		Textarea textarea = factory.createTextarea();
		textarea.setName(name);
		textarea.setContent(content);
		return textarea;
	}

	/* (non-Javadoc)
	 * @see com.lohika.alp.log.elements.LogElementsFactory#link(java.lang.String)
	 */
	@Override
	public Object link(String url) {
		return link(url, null);
	}

	/* (non-Javadoc)
	 * @see com.lohika.alp.log.elements.LogElementsFactory#link(java.lang.String, java.lang.String)
	 */
	@Override
	public Object link(String url, String description) {
		Link link = factory.createLink();
		link.setUrl(url);
		link.setDescription(description);
		return link;
	}

	/* (non-Javadoc)
	 * @see com.lohika.alp.log.elements.LogElementsFactory#screenshot(java.lang.String, java.lang.String)
	 */
	@Override
	public Object screenshot(String url, String description) {
		Screenshot screenshot = factory.createScreenshot();
		screenshot.setUrl(url);
		screenshot.setDescription(description);
		return screenshot;
	}

	/* (non-Javadoc)
	 * @see com.lohika.alp.log.elements.LogElementsFactory#comment(java.lang.String)
	 */
	@Override
	public Object comment(String comment) {
		Comment simpleComment = factory.createComment();
		simpleComment.getContent().add(comment);
		simpleComment.setType(Blockstyle.DEFAULT);
		return simpleComment;
	}

	/* (non-Javadoc)
	 * @see com.lohika.alp.log.elements.LogElementsFactory#comment(java.lang.String, com.lohika.alp.log.elements.LogStyle)
	 */
	@Override
	public Object comment(String comment, LogStyle style) {
		Comment simpleComment = factory.createComment();
		simpleComment.getContent().add(comment);
		if (style == LogStyle.HIGHLIGHT)
			simpleComment.setType(Blockstyle.HIGHLIGHT);
		else
			simpleComment.setType(Blockstyle.DEFAULT);
		return simpleComment;
	}

	/* (non-Javadoc)
	 * @see com.lohika.alp.log.elements.LogElementsFactory#comment(java.util.List)
	 */
	@Override
	public Object comment(List<Object> comment) {
		Comment complexComment = factory.createComment();
		for (Object c : comment) {
			complexComment.getContent().add(c);
		}
		complexComment.setType(Blockstyle.DEFAULT);
		return complexComment;
	}

	/* (non-Javadoc)
	 * @see com.lohika.alp.log.elements.LogElementsFactory#comment(java.lang.Object[])
	 */
	@Override
	public Object comment(Object... comment) {
		Comment complexComment = factory.createComment();
		for (Object c : comment) {
			complexComment.getContent().add(c);
		}
		complexComment.setType(Blockstyle.DEFAULT);
		return complexComment;
	}

	/* (non-Javadoc)
	 * @see com.lohika.alp.log.elements.LogElementsFactory#comment(java.util.List, com.lohika.alp.log.elements.LogStyle)
	 */
	@Override
	public Object comment(List<Object> comment, LogStyle style) {
		Comment complexComment = factory.createComment();
		for (Object c : comment) {
			complexComment.getContent().add(c);
		}
		if (style == LogStyle.HIGHLIGHT)
			complexComment.setType(Blockstyle.HIGHLIGHT);
		else
			complexComment.setType(Blockstyle.DEFAULT);
		return complexComment;
	}

}
