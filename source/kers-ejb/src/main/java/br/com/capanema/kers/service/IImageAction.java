/**
 * License Agreement.
 *
 *  JBoss RichFaces - Ajax4jsf Component Library
 *
 * Copyright (C) 2007  Exadel, Inc.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License version 2.1 as published by the Free Software Foundation.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301  USA
 */
package br.com.capanema.kers.service;

import java.util.List;

import javax.ejb.Local;

import br.com.capanema.kers.domain.Album;
import br.com.capanema.kers.domain.Comment;
import br.com.capanema.kers.domain.Image;
import br.com.capanema.kers.domain.MetaTag;
import br.com.capanema.kers.domain.User;

/**
 * Interface for manipulating with image entity
 *
 * @author Andrey Markhel
 */

@Local
public interface IImageAction {

	public void deleteImage(Image image) throws PhotoAlbumException;

	public void editImage(Image image, boolean metatagsChanged) throws PhotoAlbumException;

	public void addImage(Image image) throws PhotoAlbumException;
	
	public void deleteComment(Comment comment) throws PhotoAlbumException;
	
	public void addComment(Comment comment) throws PhotoAlbumException;

	public MetaTag getTagByName(String tag);

	public List<MetaTag> getPopularTags();

	public List<MetaTag> getTagsLikeString(String suggest);

	public boolean isImageWithThisPathExist(Album album, String path);
	
	public Long getCountIdenticalImages(Album album, String path);

	public List<Comment> findAllUserComments(User user);
	
	public void resetImage(Image imageo);

}