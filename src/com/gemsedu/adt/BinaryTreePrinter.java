package com.gemsedu.adt;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Print a binary tree
 * @author michal.kreuzman
 * Taken from http://stackoverflow.com/a/4973083
 *
 */
class BinaryTreePrinter {

    public static <T extends Comparable<?>> void printBinaryNode(BinaryNode<T> root) {
        int maxLevel = BinaryTreePrinter.maxLevel(root);

        printBinaryNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printBinaryNodeInternal(List<BinaryNode<T>> BinaryNodes, int level, int maxLevel) {
        if (BinaryNodes.isEmpty() || BinaryTreePrinter.isAllElementsNull(BinaryNodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BinaryTreePrinter.printWhitespaces(firstSpaces);

        List<BinaryNode<T>> newBinaryNodes = new ArrayList<BinaryNode<T>>();
        for (BinaryNode<T> BinaryNode : BinaryNodes) {
            if (BinaryNode != null) {
                System.out.print(BinaryNode.data);
                newBinaryNodes.add(BinaryNode.left);
                newBinaryNodes.add(BinaryNode.right);
            } else {
                newBinaryNodes.add(null);
                newBinaryNodes.add(null);
                System.out.print(" ");
            }

            BinaryTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < BinaryNodes.size(); j++) {
                BinaryTreePrinter.printWhitespaces(firstSpaces - i);
                if (BinaryNodes.get(j) == null) {
                    BinaryTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (BinaryNodes.get(j).left != null)
                    System.out.print("/");
                else
                    BinaryTreePrinter.printWhitespaces(1);

                BinaryTreePrinter.printWhitespaces(i + i - 1);

                if (BinaryNodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BinaryTreePrinter.printWhitespaces(1);

                BinaryTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printBinaryNodeInternal(newBinaryNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(BinaryNode<T> BinaryNode) {
        if (BinaryNode == null)
            return 0;

        return Math.max(BinaryTreePrinter.maxLevel(BinaryNode.left), BinaryTreePrinter.maxLevel(BinaryNode.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}