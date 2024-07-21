package bintree;

public class AVL<T extends Comparable> extends BST {
    public AVL(T rootValue){
        super(rootValue);
    }

    public AVL(){
        super();
    }

    @Override
    public void insert(Comparable newValue){
        int leftSkew = 0;
        int rightSkew = 0;

        super.insert(newValue);
        BSTNode nodeInserted = super.getNodeWithValue(root, newValue);
        updateAugmentation(nodeInserted);
        BSTNode unbalancedNode = findLowestUnBalancedNode(nodeInserted);

        if(unbalancedNode != null){
            if(unbalancedNode.left != null){
                leftSkew = skew(unbalancedNode.left);
            }
            if(unbalancedNode.right != null){
                rightSkew = skew(unbalancedNode.right);
            }

            if(rightSkew == 1){
                rotateLeft(unbalancedNode);
            } else if(leftSkew == -1){
                rotateRight(unbalancedNode);
            } else if(rightSkew == -1){
                rotateRight(unbalancedNode.right);
                rotateLeft(unbalancedNode);
            } else if(leftSkew == 1){
                rotateLeft(unbalancedNode.left);
                rotateRight(unbalancedNode);
            }
        }
    }

    protected void rotateLeft(BSTNode nodeToRotate){
        BSTNode originalParent = nodeToRotate.parent;
        BSTNode rightChild = nodeToRotate.right;

        nodeToRotate.right = rightChild.left;
        if(nodeToRotate.right != null){
            nodeToRotate.right.parent = nodeToRotate;
        }

        rightChild.left = nodeToRotate;
        rightChild.left.parent = rightChild;

        if(originalParent == null){
            root = rightChild;
        } else {
            if(originalParent.left == nodeToRotate){
                originalParent.left = rightChild;
            } else {
                originalParent.right = rightChild;
            }
        }
        rightChild.parent = originalParent;
        updateAugmentation(nodeToRotate);
    }

    protected void rotateRight(BSTNode nodeToRotate){
        BSTNode originalParent = nodeToRotate.parent;
        BSTNode leftChild = nodeToRotate.left;

        nodeToRotate.left = leftChild.right;
        if(nodeToRotate.left != null){
            nodeToRotate.left.parent = nodeToRotate;
        }

        leftChild.right = nodeToRotate;
        leftChild.right.parent = leftChild;

        if(originalParent == null){
            root = leftChild;
        } else {
            if(originalParent.left == nodeToRotate){
                originalParent.left = leftChild;
            } else {
                originalParent.right = leftChild;
            }
        }
        leftChild.parent = originalParent;
        updateAugmentation(nodeToRotate);
    }

    private BSTNode findLowestUnBalancedNode(BSTNode currentNode){
        if(currentNode == null){
            return null;
        } else if(currentNode.isLeaf()){
            return findLowestUnBalancedNode(currentNode.parent);
        }

        int nodeSkew = skew(currentNode);
        if(Math.abs(nodeSkew) > 1){
            return currentNode;
        }
        return findLowestUnBalancedNode(currentNode.parent);
    }

    private void updateAugmentation(BSTNode startingNode){
        if(startingNode == null){
            return;
        }
        startingNode.height = height(startingNode);
        updateAugmentation(startingNode.parent);
    }

    private int skew(BSTNode node){
        int rightHeight = 0;
        int leftHeight = 0;

        if(node.right != null){
            rightHeight = 1 + height(node.right);
        }
        if(node.left != null){
            leftHeight = 1 + height(node.left);
        }
        return rightHeight - leftHeight;
    }

    public int height() {
        return height(root);
    }
    private int height(BSTNode node){
        if(node == null){
            return 0;
        }else if(node.isLeaf()){
            return 0;
        } else if(node.left == null){
            return 1 + node.right.height;
        } else if(node.right == null){
            return 1 + node.left.height;
        }
        return 1 + Math.max(node.left.height, node.right.height);
    }
}
