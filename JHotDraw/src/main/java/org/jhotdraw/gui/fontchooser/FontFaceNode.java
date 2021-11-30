/**
 * @(#)FontFaceNode.java  1.0  May 20, 2008
 *
 * Copyright (c) 2008 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */
package org.jhotdraw.gui.fontchooser;

import java.awt.Font;
import java.util.Collections;
import java.util.Enumeration;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 * A FontFaceNode is a MutableTreeNode which does not allow children.
 *
 * @author Werner Randelshofer
 * @version 1.0 May 20, 2008 Created.
 */
public class FontFaceNode implements MutableTreeNode, Comparable<FontFaceNode>, Cloneable {

    private FontFamilyNode parent;
    private Font typeface;
    private String name;

    public FontFaceNode(Font typeface) {
        this.typeface = typeface;
        this.name = beautifyName(typeface.getPSName());
    }

    protected String beautifyName(String name) {
        // 'Beautify' the name
        int p = name.lastIndexOf('-');
        name = name.toLowerCase();
        if (p != -1) {
            name = name.substring(p + 1);

            nameSpaceCaptializaiton(name);
        } else {

            nameSpaceCaptializaiton(name);
        }
        StringBuilder buf = new StringBuilder();
        char prev = name.charAt(0);
        buf.append(prev);
        for (int i = 1; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (prev != ' ' && prev != '-' &&
                    Character.isUpperCase(ch) && !Character.isUpperCase(prev) ||
                    Character.isDigit(ch) && !Character.isDigit(prev)) {
                buf.append(' ');
            }
            buf.append(ch);
            prev = ch;
        }
        name = buf.toString();
        return name;
    }

    public void nameSpaceCaptializaiton(String name){
        if(name.startsWith("bold") || name.startsWith("demi") || name.startsWith("semi") || name.startsWith("book") && name.length() != 4){
            String bold = name.substring(0, 4);
            name = name.substring(0,1).toUpperCase() + name.substring(1);

            String after = name.substring(4);
            after = after.substring(0,1).toUpperCase() + after.substring(1);

            name = bold + ' ' + after;
        } else {
            name = name.substring(0,1).toUpperCase() + name.substring(1);
        }
    }

    public void setName(String newValue) {
        this.name = newValue;
    }

    public String getName() {
        return name;
    }

    public Font getFont() {
        return typeface;
    }

    @Override
    public String toString() {
        return name;
    }

    public void insert(MutableTreeNode child, int index) {
        throw new UnsupportedOperationException("Not allowed.");
    }

    public void remove(int index) {
        throw new UnsupportedOperationException("Not allowed.");
    }

    public void remove(MutableTreeNode node) {
        throw new UnsupportedOperationException("Not allowed.");
    }

    public void setUserObject(Object object) {
        throw new UnsupportedOperationException("Not allowed.");
    }

    public void removeFromParent() {
        if (parent != null) {
            parent.remove(this);
        }
    }

    public void setParent(MutableTreeNode newParent) {
        this.parent = (FontFamilyNode) newParent;
    }

    public TreeNode getChildAt(int childIndex) {
        throw new IndexOutOfBoundsException("" + childIndex);
    }

    public int getChildCount() {
        return 0;
    }

    public TreeNode getParent() {
        return parent;
    }

    public int getIndex(TreeNode node) {
        return -1;
    }

    public boolean getAllowsChildren() {
        return false;
    }

    public boolean isLeaf() {
        return true;
    }

    @SuppressWarnings("unchecked")
    public Enumeration children() {
        return Collections.enumeration(Collections.EMPTY_LIST);
    }

    public int compareTo(FontFaceNode that) {
        return this.name.compareTo(that.name);
    }

    @Override
    public FontFaceNode clone() {
        FontFaceNode that;
        try {
            that = (FontFaceNode) super.clone();
        } catch (CloneNotSupportedException ex) {
            InternalError error = new InternalError("Clone failed");
            error.initCause(ex);
            throw error;
        }
        that.parent = null;
        return that;
    }

    public boolean isEditable() {
        return false;
    }
}
