package q2;

public class AVL {
    public int height(Root root) {
        if(root != null) {
            return root.getHeight();
        } else {
            return -1;
        }
    }

    public void updateHeight(Root root) {
        // root.updateHeight(max(height(root.getLeft()), height(root.getRight())));
    }
    
    public int balanceFactor(Root root) {
        return height(root.getRight()) - height(root.getLeft());
    }
}

class Root {
    private String value;

    private Root parent;
    private Root left;
    private Root right;

    private int height;
    private int size;

    public Root(String value) {
        this.value = value;
        parent = null; 
        left = null;
        right = null;
        height = 0;
    }

    public int getHeight() {
        return this.height;
    }

    public void updateHeight(int newHeight) {
        this.height = newHeight;
    }

    public Root getLeft() {
        return this.left;
    }

    public Root getRight() {
        return this.right;
    }
}
