public class BlockMap {
    private List<Deque<Integer>> map;
    private int count = 0;

    public BlockMap(int lineNum) {
        map = new ArrayList<Deque<Integer>>();
        for (int i =0; i < lineNum; i++) {
            map.add(new LinkedList<Integer>());
        }
    }

    public boolean onBlock(int onNum, int block) {
        Deque<Integer> line = map.get(onNum);

        if (line.peekLast() == null) {
            line.offerLast(block);
        } else if (line.peekLast() == block) {
            line.pollLast();
        } else {
            line.offerLast(block);
        }
        count++;
        if (line.size() >= 5) {
            return true;
        }
        return false;
    }

    public void showmap() {
        System.out.println("---------------------");
        for (Deque<Integer> dq : map) {
            for (int i : dq) {
                System.out.print(i+" ");
            }
            System.out.println("");
        }
        System.out.println("---------------------");
    }

    public int getCount() {
        return count;
    }
}