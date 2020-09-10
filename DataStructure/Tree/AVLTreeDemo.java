package com.Tree;

/**
 * @
 * @date 2020/9/8 - 16:46
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
//        int[] arr = {4, 3, 6, 5, 7, 8};
//        int[] arr = { 10, 12, 8, 9, 7, 6 };
        int[] arr = { 10, 11, 7, 6, 8, 9 };
        AVLTree avlt = new AVLTree();
        for (int value : arr) {
            avlt.Add(new Knot(value));
        }
        System.out.println("调整之后~~~");
        avlt.infixOrder();
        System.out.println("树的高度: " + avlt.toRoot().Height());
        System.out.println("左子树: " + avlt.toRoot().leftHeight());
        System.out.println("右子树: " + avlt.toRoot().rightHeight());
    }
}

class AVLTree {
    private Knot root;

    public Knot toRoot() {
        return root;
    }

    // 一个方法的实现是需要有一个对象调用方法的，而我们在最开始就是通过 root 实现调用；之后通过递归实现子节点的添加和遍历
    //添加结点的方法
    public void Add(Knot knot) {
        if (root == null) {
            root = knot;
        } else {
            root.Add(knot);
        }
    }

    //中序遍历
    public void infixOrder() {
        if (root == null) {
            System.out.println("the tree is empty");
        } else {
            root.infixOrder();
        }
    }

    // 寻找删除节点
    public Knot search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    // 寻找删除节点的父节点
    public Knot parentSearch(int value) {
        if (root == null) {
            return null;
        } else {
            return root.parentSearch(value);
        }
    }

    //编写方法:
    //1. 返回的 以node 为根结点的二叉排序树的最小结点的值
    //2. 删除 node 为根结点的二叉排序树的最小结点

    /**
     * @param knot 传入的结点(当做二叉排序树的根结点)
     * @return 返回的 以node 为根结点的二叉排序树的最小结点的值
     */
    public int delRight(Knot knot) {
        Knot temp = knot;
        //循环的查找左子节点，就会找到最小值
        while (temp.left != null) {
            temp = temp.left;
        }
        //这时 target就指向了最小结点
        //删除最小结点
        delKnot(temp.value);
        return temp.value;
    }

    // 删除叶子节点
    public void delKnot(int value) {
        if (root == null) {
            return;
        } else {
            //1.需求先去找到要删除的结点  targetNode
            Knot knot = search(value);
            //如果没有找到要删除的结点
            if (knot == null) {
                return;
            }
            //如果我们发现当前这颗二叉排序树只有一个结点
            if (root.left == null && root.right == null) {
                root = null;
            }
            //去找到targetNode的父结点
            Knot parentknot = parentSearch(value);
            // 删除叶子节点
            if (knot.left == null && knot.right == null) {
                //判断targetNode 是父结点的左子结点，还是右子结点
                if (parentknot.left != null && parentknot.left.value == value) {
                    parentknot.left = null;
                } else if (parentknot.right != null && parentknot.right.value == value) {
                    parentknot.right = null;
                }
            } else if (knot.left != null && knot.right != null) {// 删除有两个子节点的非叶子节点
                int i = delRight(knot.right);
                knot.value = i;

            } else {// 删除只有一个子节点的非叶子节点
                //如果要删除的结点有左子结点
                if (knot.left != null) {
                    if (parentknot != null) {
                        if (parentknot.left.value == value) {//如果 targetNode 是 parent 的左子结点
                            parentknot.left = knot.left;
                        } else { //targetNode 是 parent 的右子结点
                            parentknot.right = knot.left;
                        }
                    } else {
                        root = knot.left;
                    }
                } else {//如果要删除的结点有右子结点
                    if (parentknot != null) {
                        if (parentknot.left.value == value) {//如果 targetNode 是 parent 的左子结点
                            parentknot.left = knot.right;
                        } else {//如果 targetNode 是 parent 的右子结点
                            parentknot.right = knot.right;
                        }
                    } else {
                        root = knot.right;
                    }
                }
            }
        }
    }
}