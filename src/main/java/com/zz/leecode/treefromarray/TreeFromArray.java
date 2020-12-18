package com.zz.leecode.treefromarray;

/**
 * @author zzj
 * @className TreeFromArray
 * @description 根据一棵树的中序遍历与后序遍历构造二叉树。
 * @date 2020/9/25
 */
public class TreeFromArray {

    /**
     * 分析  根据后续遍历  根确定  （左子树的根结点（分割数组），右子树的根结点（分割数组））
     * 根据 中序遍历取到左右节点(左子树（找出左子树的长度）  右子树(右子树的长度))
     *
     * 做法：递归
     *
     * 缺点：浪费性能
     * @param inorder   中序遍历结果     左根右
     * @param postorder 后续遍历结果    左右根
     * @return
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {


        if(inorder.length == 0 || inorder.length != postorder.length){
            return null;
        }
        int rootVal = postorder[postorder.length - 1];
        TreeNode rootNode = new TreeNode(rootVal);
        int inorderIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                inorderIndex = i;
                break;
            }
        }

        //中序知道左右长度
        int leftLength = inorderIndex;
        int rightLength = inorder.length - leftLength - 1;
        if (leftLength != 0) {
            int[] leftInorder = new int[leftLength];
            int[] leftPostOrder = new int[leftLength];
            System.arraycopy(inorder, 0, leftInorder, 0, leftLength);
            System.arraycopy(postorder, 0, leftPostOrder, 0, leftLength);
            rootNode.left = buildTree(leftInorder, leftPostOrder);
        }
        if (rightLength != 0) {
            int[] rightInorder = new int[rightLength];
            int[] rightPostOrder = new int[rightLength];
            System.arraycopy(inorder, leftLength + 1, rightInorder, 0, rightLength);
            System.arraycopy(postorder, leftLength, rightPostOrder, 0, rightLength);
            rootNode.right = buildTree(rightInorder, rightPostOrder);
        }

        return rootNode;
    }

    public static void main(String[] args) {
        int a[] = {9, 3, 15, 20, 7};
        int b[] = {9, 15, 7, 20, 3};
        TreeNode treeNode = buildTree(a, b);
        System.out.println(treeNode);
    }




    // TODO 2.  不使用 拷贝 根据下标生成树

    public static TreeNode buildTree2(int[] inorder, int[] postorder) {


        if(inorder.length == 0 || inorder.length != postorder.length){
            return null;
        }
        int rootVal = postorder[postorder.length - 1];
        TreeNode rootNode = new TreeNode(rootVal);
        int inorderIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                inorderIndex = i;
                break;
            }
        }

        //中序知道左右长度
        int leftLength = inorderIndex;
        int rightLength = inorder.length - leftLength - 1;

        //生成左子树
        if (leftLength != 0) {
            int[] leftInorder = new int[leftLength];
            int[] leftPostOrder = new int[leftLength];
            System.arraycopy(inorder, 0, leftInorder, 0, leftLength);
            System.arraycopy(postorder, 0, leftPostOrder, 0, leftLength);
            rootNode.left = buildTree2(leftInorder, leftPostOrder);
        }

        //生成右子树
        if (rightLength != 0) {
            int[] rightInorder = new int[rightLength];
            int[] rightPostOrder = new int[rightLength];
            System.arraycopy(inorder, leftLength + 1, rightInorder, 0, rightLength);
            System.arraycopy(postorder, leftLength, rightPostOrder, 0, rightLength);
            rootNode.right = buildTree2(rightInorder, rightPostOrder);
        }

        return rootNode;
    }



}


