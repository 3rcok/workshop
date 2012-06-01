/* Copyright (c) 2011 the authors listed at the following URL, and/or
the authors of referenced articles or incorporated external code:
http://en.literateprograms.org/Binary_search_tree_(Java)?action=history&offset=20080109051139

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

Retrieved from: http://en.literateprograms.org/Binary_search_tree_(Java)?oldid=11975
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

class Node<E extends Comparable<? super E>> {
	public Node<E> left;
	public Node<E> right;
	public final E value;
	Node(E value) {
		this.value = value;
	}
	Node(Node<E> node) {
		left = node.left;
		right = node.right;
		value = node.value;
	}
}
    
public class BinaryTree<E extends Comparable<? super E>> {
	Node<E> root;
	int size = 0;
	int i;
	@Test
	public void testTree() {
		
		BinaryTree<String> tree = new BinaryTree<String>();
		tree.add("Hanno");
		tree.add("Zacharias");
		tree.add("Berhard");
		assertEquals(new String[]{ "Berhard", "Hanno", "Zacharias" }, tree.toList().toArray(new String[3]));
		assertEquals(null, tree.get("Otto"));
		assertEquals("Hanno", tree.get("Hanno"));

	}
	
	public void add(E element) {
	    if (root == null && element != null) {
	        root = new Node<E>(element);
	        size++;
	    } else if (element != null) {
	        root = insert(root, element);
	    }
	}

	private Node<E> insert(Node<E> node, E value) {
		Node<E> result = new Node<E>(node);
		int compare = result.value.compareTo(value);
		
		if (compare == 0) {
		    return result;
		}

		
		if (compare > 0) {
		    if (result.left != null) {
		        result.left = insert(result.left, value);
		    } else {
		        result.left = new Node<E>(value);
		        size++;
		    }
		}

		
		else if (compare < 0) {
		    if (result.right != null) {
		        result.right = insert(result.right, value);
		    } else {
		        result.right = new Node<E>(value);
		        size++;
		    }
		}

		return result;
	}
	
	public E get(E key) {
	    if (root == null)
	        return null;

	    Node<E> node = root;
	    int compareResult;
	    while ((compareResult = node.value.compareTo(key)) != 0) {
	        if (compareResult > 0) {
	            if (node.left != null)
	                node = node.left;
	            else
	                return null;
	        } else {
	            if (node.right != null)
	                node = node.right;
	            else
	                return null;
	        }
	    }
	    return node.value;
	}

	
	public List<E> toList() {
	    List<E> result = new ArrayList<E>();
	    treeToList(root, result);
	    return result;
	}

	
	private void treeToList(Node<E> node, List<E> goal) {
	    if (node != null) {
	        treeToList(node.left, goal);
	        goal.add(node.value);
	        treeToList(node.right, goal);
	    }
	}

}

