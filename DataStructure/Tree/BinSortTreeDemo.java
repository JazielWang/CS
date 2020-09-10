package com.Tree;

/**
 * @
 * @date 2020/9/7 - 16:59
 */
public class BinSortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinSortTree bst = new BinSortTree();
        // 将元素添加到 tree 中
        for (int value : arr) {
            bst.Add(new Knot(value));
        }
        System.out.println("中序遍历排序二叉树");
        bst.infixOrder();
        // 测试删除叶子节点
        bst.delKnot(7);
        System.out.println("the knot has be delete");
        bst.infixOrder();
    }
}

//创建二叉排序树
class BinSortTree {
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

class Knot {
    int value;
    Knot left;
    Knot right;

    // 返回右子树的高度
    public int rightHeight(){
        if (right == null){
            return 0;
        }
        return right.Height();
    }

    // 返回左子树的高度
    public int leftHeight(){
        if (left == null){
            return 0;
        }
        return left.Height();
    }

    // 返回 以该结点为根结点的树的高度
    public int Height() {
        return Math.max(left == null ? 0 : left.Height(), right == null ? 0 : right.Height()) + 1;
    }

    public Knot(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Knot{" +
                "value=" + value +
                '}';
    }

    /**
     * 寻找要删除节点的父节点
     *
     * @param value 要删除节点的值
     * @return 返回删除节点父节点
     */
    public Knot parentSearch(int value) {
        //如果当前结点就是要删除的结点的父结点，就返回
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            //如果查找的值小于当前结点的值, 并且当前结点的左子结点不为空
            if (this.value >= value && this.left != null) {
                return this.left.parentSearch(value);//向左子树递归查找
            } else if (this.value < value && this.right != null) {
                return this.right.parentSearch(value);//向右子树递归查找
            } else {
                return null;// 没有找到父结点
            }
        }
    }

    /**
     * function: 寻找要删除的节点
     *
     * @param value 希望删除的基点的值
     * @return 删除节点
     */
    public Knot search(int value) {
        if (this.value == value) {
            return this;
        } else if (this.value > value) {
            if (this.left != null) {
                return this.left.search(value);
            }
            return null;
        } else {
            if (this.right != null) {
                return this.right.search(value);
            }
            return null;
        }
    }

    //添加结点的方法
    //递归的形式添加结点，注意需要满足二叉排序树的要求
    public void Add(Knot knot) {
        if (knot == null) {
            System.out.println("the knot is empty, so ~~");
            return;
        }
        // 判断传入的结点的值，和当前子树的根结点的值关系
        if (this.value > knot.value) {
            if (this.left == null) {
                this.left = knot;
            } else {
                // 递归的向左子树添加
                this.left.Add(knot);
            }
        } else {// 添加的结点的值大于 当前结点的值
            if (this.right == null) {
                this.right = knot;
            } else {
                // 递归的向右子树添加
                this.right.Add(knot);
            }
        }

        //当添加完一个结点后，如果: (右子树的高度-左子树的高度) > 1 , 左旋转
        if ((rightHeight() - leftHeight()) > 1){
            //如果它的右子树的左子树的高度大于它的右子树的右子树的高度
            if (right != null && right.leftHeight() > right.leftHeight()){
                //先对右子结点进行右旋转
                right.rightRotate();
                //然后在对当前结点进行左旋转
                leftRotate();
            }else {
                //直接进行左旋转即可
                leftRotate();
            }
            // 如果没有 return 的话，程序会继续向下执行，可能会出大问题
            return;
        }
        //当添加完一个结点后，如果: (右子树的高度-左子树的高度) < 1 , 左旋转
        if ((leftHeight() - rightHeight()) > 1){
            //如果它的左子树的右子树高度大于它的左子树的高度
            if (left != null && left.rightHeight() > left.leftHeight()){
                //先对当前结点的左结点(左子树)->左旋转
                left.leftRotate();
                //再对当前结点进行右旋转
                rightRotate();
            }else {
                //直接进行右旋转即可
                rightRotate();
            }
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

    //左旋转方法
    private void leftRotate() {
        //创建新的结点，以当前根结点的值
        Knot newKnot = new Knot(value);
        //把新的结点的左子树设置成当前结点的左子树
        newKnot.left = left;
        //把新的结点的右子树设置成带你过去结点的右子树的左子树
        newKnot.right = right.left;
        //把当前结点的值替换成右子结点的值
        value = right.value;
        //把当前结点的右子树设置成当前结点右子树的右子树
        right = right.right;
        //把当前结点的左子树(左子结点)设置成新的结点
        left = newKnot;
    }

    //右旋转方法
    private void rightRotate(){
        Knot newKnot = new Knot(value);
        newKnot.right = right;
        newKnot.left = left.right;
        value = left.value;
        left = left.left;
        right = newKnot;
    }
}