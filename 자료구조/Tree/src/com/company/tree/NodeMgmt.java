package com.company.tree;

public class NodeMgmt {
    // head
    public Node head = null;

    // BST에 데이터 넣기
    public boolean insertNode(int data) {
        // Node가 하나도 없을 떄
        if(this.head == null) {
            this.head = new Node(data);
        } else {
            // Node가 하나 이상 들어가 있을 떄
            Node findNode = this.head;
            while(true) {
                // 만약 들어온 데이터가 헤드보다 작다면 왼쪽으로 가야함
                if(data < findNode.value) {
                    // 근데 left노드가 있다면?
                    if(findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        // 만약 left노드가 없다면 만들어야지
                        findNode.left = new Node(data);
                        // 이제서야 break를 통해 빼져 나온다
                        break;
                    }
                } else {
                    // 만약 작다면
                    if(findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }
        return true;
    }

    // data를 바탕으로 이에 대한 노드를 찾는 것
    public Node search(int data) {
        // data가 하나도 없을 때
        if(this.head == null) {
            return null;
        } else {
            Node findNode = this.head;
            while(findNode != null) {
                if(findNode.value == data) {
                    // 만약 data가 같다면 찾은 노드를 반환한다.
                    return findNode;
                } else if(data < findNode.value) {
                    findNode = findNode.left;
                } else {
                    findNode = findNode.right;
                }
            }
            return null;
        }
    }

    public boolean delete(int value) {
        boolean searched = false;

        // 우리는 찾아야 할 Node와 그 Parent Node를 둘다 찾아야 한다.
        // 그래서 둘 다 head로 놓고 시작한다.
        Node currParentNode = this.head;
        Node currNode = this.head;

        // 코너 케이스1: Node가 하나도 없을 때
        if(this.head == null) {
            return false;
            // 코너 케이스2: Node가 단지 하나만 있고 해당 Node가 삭제할 Node일 때
        } else {
            if(this.head.value == value && this.head.left == null && this.head.right == null) {
                this.head = null;
                return true;
            }
            // 순회 해서 찾아보도록 하자
            while(currNode != null) {
                if(currNode.value == value) {
                    searched = true;
                    break;
                } else if(value < currNode.value){
                    currParentNode = currNode;
                    currNode = currNode.left;
                } else {
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }
            // 만약 찾지 못해서 searched 가 false인 경우
            if(searched == false) {
                return false;
            } else {
                // 결과적으로 searched가 true인 것들만
                // currNode에는 해당 데이터를 가지고 있는 Node
                // currParentNode에는 해당 데이터를 가지고 있는 Node의 Parent Node

                // 일단 currNode가 Leaf Node인 경우를 생각해 보면
                if(currNode.left == null && currNode.right == null) {
                    // currNode가 currParentNode보다 작은 경우
                    if(value < currParentNode.value) {
                        currParentNode.left = null;
                        // 안써줘도 되는데 명시적으로 처리하기 위해
                        currNode = null;
                    } else {
                        currParentNode.right = null;
                        // 이도 명시적으로 그냥 작성
                        currNode = null;
                    }
                    // currNode가 childNode를 하나만 가지고 있을 경우
                } else if(currNode.left != null && currNode.right == null) {
                    // Case1. 왼쪽에 ChildNode가 있을 경우
                    if(value < currParentNode.value) {
                        // 삭제할 값이 ParentNode 보다 작게 되면
                        currParentNode.left = currNode.left;
                        // 그냥 명시적으로 작성
                        currNode = null;
                    } else {
                        // 삭제할 값이 ParentNode 보다 크게 되면
                        currParentNode.right = currNode.left;
                        currNode = null;
                    }
                    return true;
                } else if(currNode.left == null && currNode.right != null) {
                    // Case2. 오른쪽에 ChildNode가 있을 경우
                    if(value < currParentNode.value) {
                        // 삭제할 값이 ParentNode 보다 크게 되면
                        currParentNode.left = currNode.right;
                        currNode = null;
                    } else {
                        currParentNode.right = currNode.right;
                        currNode = null;
                    }
                    return true;
                } else {
                    // Case 3
                    // ChildNode가 2개인 경우
                    // Case 3-1. 삭제할 Node가 paren Node의 왼쪽에 있을 떄
                    if(value < currParentNode.value) {
                        // 일단 가장 왼쪽으로 가야 한다
                        // 가장 작은 값을 가진 node를 change_node로
                        // 또한 change_node가 오른쪽에 자식을 갖고 있으면
                        // change_node의 왼쪽자식으로 이를 붙여줘야 하기 때문에
                        // change_node의 부모를 change_node_parent라고 해보자
                        Node changeNode = currNode.right;
                        Node changeParentNode = currNode.right;
                        // 순회를 시작한다
                        while(changeNode.left != null) {
                            changeParentNode = changeNode;
                            changeNode = changeNode.left;
                        }
                        // 여기까지 실행되었다는 뜻은 changeNode에는 삭제할 Node의 오른쪽 Node중에서
                        // 가장 작은 값을 지닌 Node가 들어가 있다는 뜻을 의미한다.
                        // 근데 만약 이의 오른쪽에 자식이 있다면?
                        if(changeNode.right != null) {
                            // changeparentNode의 왼쪽에 집어 넣는다.
                            changeParentNode.left = changeNode.right;
                        } else {
                            changeParentNode.left = null;
                        }

                        // changeNode의 오른쪽 node를 알맞는 위치로 변경
                        currParentNode.left = changeNode;

                        // ParentNode의 왼쪽 Child Node가 현재, changeNode이고,
                        // changeNode의 왼쪽/오른쪽 Child Node를 모두, 삭제할 currNode의
                        // 기존 왼쪽/오른쪽 Node로 변경ㄷ
                        changeNode.right = currNode.right;
                        changeNode.left = currNode.left;

                        // 명시적으로 처리 해준다.
                        currNode = null;
                    } else {
                        // Case 3-1. 삭제할 Node가 paren Node의 오른쪽에 있을 때
                        Node changeNode = currNode.right;
                        Node changeParentNode = currNode.right;

                        while(changeNode.left != null) {
                            changeParentNode = changeNode;
                            changeNode = changeNode.left;
                        }
                        // changeNode가 null전 까지 그리고 changeParentNode는 그 위까지

                        // 이제 오른쪽 자식 검사
                        // 있다면
                        if(changeNode.right != null) {
                            changeParentNode.left = changeNode.right;
                        } else {
                            changeParentNode.left = null;
                        }
                        currParentNode.right = changeNode;


                        // currNode.right가 changeNode인 경우 changeNode가 currNode자리로 올라 가면서
                        // 오른쪽에 다시 자신의 객체를 가리키는 상황이 될 수 있습니다.

                        if(currNode.right != changeNode) {
                            changeNode.right = currNode.right;
                        }
                        changeNode.left = currNode.left;

                        // 명시적으로 처리 해준다.
                        currNode = null;
                    }
                }
            }
            return true;
        }
    }
}

