
import java.util.*;

class Main7 {

    //Go Go Gorelians

    public static ArrayList<Integer>[] adj;
    public static Integer[] idArray;
    public static Integer[][] xyz;

    public static void main0(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            adj = (ArrayList<Integer>[]) (new ArrayList[n]);
            idArray = new Integer[n];
            xyz = new Integer[n][3];

            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < n; i++) {
                int ID = sc.nextInt();
                int X = sc.nextInt();
                int Y = sc.nextInt();
                int Z = sc.nextInt();

                if (i != 0) {
                    int closeId = closestId(X, Y, Z);
                    adj[i].add(closeId);
                    adj[Arrays.asList(idArray).indexOf(closeId)].add(ID);
                }
                adj[i].add(ID);
                xyz[i][0] = X;
                xyz[i][1] = Y;
                xyz[i][2] = Z;
                idArray[i] = ID;
            }

            while (!done()) {
                Stack<Object> toDelete = new Stack();
                for (int k = 0; k < adj.length; k++) {
                    if (adj[k].size() == 2) {
                        Object idToDelete = idArray[k];
                        toDelete.add(idToDelete);
                    }
                }
                while (!toDelete.isEmpty()) {
                    Object del = toDelete.pop();
                    int id = (Integer) del;
                    for (int m = 0; m < adj.length; m++) {
                        adj[m].remove(del);
                    }
                    adj[Arrays.asList(idArray).indexOf(id)] = new ArrayList<>();
                }
            }

            ArrayList<Integer> toPrint = new ArrayList();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < adj[i].size() && adj[i] != null; j++) {
                    if (!toPrint.contains(adj[i].get(j))) {
                        toPrint.add(adj[i].get(j));
                    }
                }
            }

            Collections.sort(toPrint);

            for (int i = 0; i < toPrint.size(); i++) {
                System.out.print(toPrint.get(i));
                if (i != toPrint.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static boolean done() {
        int numberLeft = 0;
        for (int i = 0; i < adj.length; i++) {
            if (adj[i].size() > 0) {
                numberLeft++;
            }
        }
        return numberLeft < 3;
    }

    public static double distance(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.sqrt(Math.pow((x2 - (x1)), 2) + Math.pow((y2 - (y1)), 2) + Math.pow((z2 - (z1)), 2));
    }

    public static Integer closestId(int x1, int y1, int z1) {
        Integer retId = -1;
        double minDistance = Double.MAX_VALUE;
        for (int i = 0; i < xyz.length && xyz[i][0] != null; i++) {
            double x2 = xyz[i][0];
            double y2 = xyz[i][1];
            double z2 = xyz[i][2];
            int id = idArray[i];
            double tempMinDistance = distance(x1, y1, z1, x2, y2, z2);
            if (tempMinDistance < minDistance) {
                minDistance = tempMinDistance;
                retId = id;
            }
        }
        return retId;
    }

    //Here we go(relians) again
    static final int INFINITY = 100000000;
    public static void main6(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        while (x != 0 || y != 0) {
            int w[][] = new int[(x + 1) * (y + 1) + 1][(x + 1) * (y + 1) + 1];
            int row = 1;
            for (int i = 1; i <= 2 * x + 1; i++) {
                if (i % 2 == 1) {
                    for (int j = 1; j <= y; j++) {
                        int tm = in.nextInt();
                        String tms = in.next();

                        switch (tms) {
                            case "*":
                                w[(row - 1) * (y + 1) + j][(row - 1) * (y + 1) + j + 1] = tm;
                                w[(row - 1) * (y + 1) + j + 1][(row - 1) * (y + 1) + j] = tm;
                                break;
                            case "< ":
                                w[(row - 1) * (y + 1) + j + 1][(row - 1) * (y + 1) + j] = tm;
                                break;
                            case ">":
                                w[(row - 1) * (y + 1) + j][(row - 1) * (y + 1) + j + 1] = tm;
                                break;
                        }
                    }
                    row++;
                } else {
                    for (int j = 1; j <= y + 1; j++) {
                        int tm = in.nextInt();
                        String tms = in.next();

                        switch (tms) {
                            case "*":
                                w[(row - 2) * (y + 1) + j][(row - 1) * (y + 1) + j] = tm;
                                w[(row - 1) * (y + 1) + j][(row - 2) * (y + 1) + j] = tm;
                                break;
                            case "^":
                                w[(row - 1) * (y + 1) + j][(row - 2) * (y + 1) + j] = tm;
                                break;
                            case "v":
                                w[(row - 2) * (y + 1) + j][(row - 1) * (y + 1) + j] = tm;
                                break;
                        }
                    }
                }
            }
            for (int p = 1; p <= (x + 1) * (y + 1); p++) {
                for (int q = 1; q <= (x + 1) * (y + 1); q++) {
                    if (w[p][q] > 0) {
                        w[p][q] = 2520 / w[p][q];
                    }else if (p != q) {
                        w[p][q] = INFINITY;
                    }
                }
            }

            dijkstra(w, (x + 1) * (y + 1));
            x = in.nextInt();
            y = in.nextInt();
        }
    }

    public static void dijkstra(int w[][], int v) {
        int length[] = new int[v + 1];
        PriorityQueue<Item> heap = new PriorityQueue(v, new ItemCompare());
        
        for (int i = 2; i <= v; i++) {
            length[i] = w[1][i];
            if (length[i] < INFINITY) {
                heap.add(new Item(1, i, w[1][i]));
            }
        }

        while (!heap.isEmpty()) {
            Item temp = heap.remove();
            for (int i = 1; i <= v; i++) {
                if (length[temp.ev] + w[temp.ev][i] < length[i]) {
                    length[i] = length[temp.ev] + w[temp.ev][i];
                    heap.add(new Item(temp.ev, i, length[i]));
                }
            }
        }
        if (length[v] < INFINITY) {
            System.out.println(length[v] + " blips");
        } else {
            System.out.println("Holiday");
        }
    }
}

class Item {
    public int sv,ev,w;
    Item(int sv, int ev, int w) {
        this.sv = sv;
        this.ev = ev;
        this.w = w;
    }
}

class ItemCompare implements Comparator< Item> {
    @Override
    public int compare(Item i1, Item i2) {
        return (i1.w - i2.w);
    }
}
