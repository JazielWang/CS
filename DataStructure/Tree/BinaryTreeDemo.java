package com.Tree;

/**
 * @
 * @date 2020/8/30 - 13:13
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        //先需要创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的结点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        //说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node4);
        node3.setRight(node5);
        binaryTree.setRoot(root);

        // 前、中、后序遍历
        /*binaryTree.preOrder();
        binaryTree.infixOrder();
        binaryTree.postOrder();*/

        int No = 5;

        /*//前序遍历
        //前序遍历的次数 ：5
        HeroNode hero = binaryTree.preSearch(No);
        if (hero != null) {
            System.out.println("the information is: "+hero);
        } else {
            System.out.println("the No." + No + " is not exist is this binary tree.");
        }*/

        //中序遍历
        //中序遍历的次数 ：5
        /*HeroNode hero = binaryTree.infixSearch(No);
        if (hero != null) {
            System.out.println("the information is: "+hero);
        } else {
            System.out.println("the No." + No + " is not exist is this binary tree.");
        }*/

        //后序遍历
        //后序遍历的次数 ：3
        /*HeroNode hero = binaryTree.postSearch(No);
        if (hero != null) {
            System.out.println("the information is: " + hero);
        } else {
            System.out.println("the No." + No + " is not exist is this binary tree.");
        }*/

        // 删除测试
        System.out.println("before delete");
        binaryTree.preOrder();
        binaryTree.delete(No);
        System.out.println("after delete");
        binaryTree.preOrder();
    }
}

//定义 BinaryTree 二叉树
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //删除结点
    public void delete(int No){
        if (root == null){
            System.out.println("this tree is empty, so it's nothing to delete.");
        }else {
            //如果只有一个root结点, 这里立即判断root是不是就是要删除结点
            if (root.getNo() == No){
                root = null;
            }else {
                //递归删除
                root.delete(No);
            }
        }
    }
    // 前序遍历
    public void preOrder() {
        if (root != null) {
            this.root.preOrder();
        } else {
            System.out.println("The binary tree is empty, so i can't traverse.");
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("The binary tree is empty, so i can't traverse.");
        }
    }

    // 后序遍历
    public void postOrder() {
        if (root != null) {
            this.root.postOrder();
        } else {
            System.out.println("The binary tree is empty, so i can't traverse.");
        }
    }

    // 前序遍历查找
    public HeroNode preSearch(int No) {
        if (root != null) {
            return root.preSearch(No);
        } else {
            return null;
        }
    }

    // 中序遍历查找
    public HeroNode infixSearch(int No) {
        if (root != null) {
            return root.infixSearch(No);
        } else {
            return null;
        }
    }

    // 后序遍历查找
    public HeroNode postSearch(int No) {
        if (root != null) {
            return root.postSearch(No);
        } else {
            return null;
        }
    }
}

// 创建 HeroNode 节点
class HeroNode {
    private int No;
    private String name;
    private HeroNode left;//默认null
    private HeroNode right;//默认null

    public HeroNode(int no, String name) {
        No = no;
        this.name = name;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "No=" + No +
                ", name='" + name + '\'' +
                '}';
    }

    //编写前序遍历的方法
    public void preOrder() {
        //先输出父结点
        System.out.println(this);
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //    后序遍历
    public void postOrder() {
        if (this.right != null) {
            this.right.postOrder();
        }
        if (this.left != null) {
            this.left.postOrder();
        }
        System.out.println(this);
    }

    // 前序遍历查找

    /**
     * @param No 需要查找的 No
     * @return 如果找到就返回 Hero，否则就返回 null
     */
    public HeroNode preSearch(int No) {
        System.out.println("plunge into tree");
        //比较当前结点是不是
        if (this.No == No) {
            return this;
        }
        //1.则判断当前结点的左子节点是否为空，如果不为空，则递归前序查找
        //2.如果左递归前序查找，找到结点，则返回
        HeroNode reshero = null;
        if (this.left != null) {
            reshero = this.left.preSearch(No);
        }
        if (reshero != null) {//说明我们左子树找到
            return reshero;
        }
        //1.左递归前序查找，找到结点，则返回，否继续判断，
        //2.当前的结点的右子节点是否为空，如果不空，则继续向右递归前序查找
        if (this.right != null) {
            reshero = this.right.preSearch(No);
        }
        return reshero;
    }

    //中序遍历查找
    public HeroNode infixSearch(int No) {
        HeroNode reshero = null;
        if (this.left != null) {
            reshero = this.left.infixSearch(No);
        }
        if (reshero != null) {
            return reshero;
        }
        System.out.println("plunge into tree");
        if (this.No == No) {
            return this;
        }
        if (this.right != null) {
            reshero = this.right.infixSearch(No);
        }
        return reshero;
    }

    // 后序遍历查找
    public HeroNode postSearch(int No) {
        HeroNode reshero = null;
        if (this.left != null) {
            reshero = this.left.postSearch(No);
        }
        if (reshero != null) {
            return reshero;
        }
        if (this.right != null) {
            reshero = this.right.postSearch(No);
        }
        if (reshero != null) {
            return reshero;
        }
        System.out.println("plunge into tree");
        if (this.No == No) {
            return this;
        }
        return reshero;
    }

    //递归删除结点
    //1.如果删除的节点是叶子节点，则删除该节点
    //2.如果删除的节点是非叶子节点，则删除该子树
    public void delete(int No) {
        //思路
		/*1. 因为我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断当前这个结点是不是需要删除结点.
        2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
        3. 如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
        4. 如果第2和第3步没有删除结点，那么我们就需要向左子树进行递归删除
        5.  如果第4步也没有删除结点，则应当向右子树进行递归删除.*/

        //1. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
        if (this.left != null && this.left.No == No){
            this.left = null;
        }
        //2.如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
        if (this.right != null && this.right.No == No){
            this.right = null;
        }
        //3.我们就需要向左子树进行递归删除
        if (this.left != null){
            this.left.delete(No);
        }
        //4.则应当向右子树进行递归删除
        if (this.right != null){
            this.right.delete(No);
        }
    }
}