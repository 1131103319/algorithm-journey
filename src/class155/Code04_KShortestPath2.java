package class155;

// k短路问题的最优解，C++版
// 测试链接 : https://www.luogu.com.cn/problem/P2483
// 如下实现是C++的版本，C++版本和java版本逻辑完全一样
// 提交如下代码，可以通过所有测试用例

//#include <bits/stdc++.h>
//
//using namespace std;
//
//const int MAXN = 50001;
//const int MAXM = 200001;
//const int MAXT = MAXN * 20;
//const int MAXH = 4200001;
//const double INF = 1e18;
//
//int n, m;
//double money;
//
//int headg[MAXN];
//int tog[MAXM];
//int nextg[MAXM];
//double weightg[MAXM];
//int cntg = 0;
//
//int headr[MAXN];
//int tor[MAXM];
//int nextr[MAXM];
//double weightr[MAXM];
//int cntr = 0;
//
//int start[MAXT];
//double cost[MAXT];
//int ls[MAXT];
//int rs[MAXT];
//int dist[MAXT];
//int cntt = 0;
//
//int rt[MAXN];
//
//int idx[MAXH];
//double val[MAXH];
//int cntd = 0;
//int heap[MAXH];
//int cnth = 0;
//
//bool vis[MAXN];
//int path[MAXN];
//double dis[MAXN];
//
//void addEdgeG(int u, int v, double w){
//    nextg[++cntg] = headg[u];
//    tog[cntg] = v;
//    weightg[cntg] = w;
//    headg[u] = cntg;
//}
//
//void addEdgeR(int u, int v, double w){
//    nextr[++cntr] = headr[u];
//    tor[cntr] = v;
//    weightr[cntr] = w;
//    headr[u] = cntr;
//}
//
//int init(int s, double v){
//    start[++cntt] = s;
//    cost[cntt] = v;
//    ls[cntt] = rs[cntt] = dist[cntt] = 0;
//    return cntt;
//}
//
//int clone(int i){
//    start[++cntt] = start[i];
//    cost[cntt] = cost[i];
//    ls[cntt] = ls[i];
//    rs[cntt] = rs[i];
//    dist[cntt] = dist[i];
//    return cntt;
//}
//
//int merge(int i, int j){
//    if(i == 0 || j == 0){
//        return i + j;
//    }
//    if(cost[i] > cost[j]){
//        swap(i, j);
//    }
//    int h = clone(i);
//    rs[h] = merge(rs[h], j);
//    if(dist[ls[h]] < dist[rs[h]]){
//        swap(ls[h], rs[h]);
//    }
//    dist[h] = dist[rs[h]] + 1;
//    return h;
//}
//
//void heapAdd(int i, double v){
//    idx[++cntd] = i;
//    val[cntd] = v;
//    heap[++cnth] = cntd;
//    int cur = cnth, father = cur / 2;
//    while(cur > 1 && val[heap[father]] > val[heap[cur]]){
//        swap(heap[father], heap[cur]);
//        cur = father;
//        father = cur / 2;
//    }
//}
//
//int heapPop(){
//    int ans = heap[1];
//    heap[1] = heap[cnth--];
//    int cur = 1, l = cur * 2, r = l + 1, best;
//    while(l <= cnth){
//        best = r <= cnth && val[heap[r]] < val[heap[l]] ? r : l;
//        best = val[heap[best]] < val[heap[cur]] ? best : cur;
//        if(best == cur) {
//            break;
//        }
//        swap(heap[best], heap[cur]);
//        cur = best;
//        l = cur * 2;
//        r = l + 1;
//    }
//    return ans;
//}
//
//bool heapEmpty(){
//    return cnth == 0;
//}
//
//void dijkstra(){
//    fill(dis, dis + MAXN, INF);
//    dis[n] = 0;
//    cntd = cnth = 0;
//    heapAdd(n, 0.0);
//    while(!heapEmpty()){
//        int h = heapPop();
//        int u = idx[h];
//        double w = val[h];
//        if(!vis[u]){
//            vis[u] = true;
//            for(int e = headr[u]; e != 0; e = nextr[e]){
//                int v = tor[e];
//                if(dis[v] > w + weightr[e]){
//                    dis[v] = w + weightr[e];
//                    path[v] = e;
//                    heapAdd(v, dis[v]);
//                }
//            }
//        }
//    }
//}
//
//void mergeRoad(){
//    cntd = cnth = 0;
//    for(int i = 1; i <= n; i++){
//        heapAdd(i, dis[i]);
//    }
//    dist[0] = -1;
//    while(!heapEmpty()){
//        int h = heapPop();
//        int u = idx[h];
//        for(int e = headg[u]; e != 0; e = nextg[e]){
//            if(e != path[u]){
//                rt[u] = merge(rt[u], init(tog[e], weightg[e] + dis[tog[e]] - dis[u]));
//            }
//        }
//        if(path[u] != 0){
//            rt[u] = merge(rt[u], rt[tog[path[u]]]);
//        }
//    }
//}
//
//int expand(){
//    int ans = 0;
//    money -= dis[1];
//    if(money >= 0){
//        ans++;
//        cntd = cnth = 0;
//        if(rt[1] != 0){
//            heapAdd(rt[1], cost[rt[1]]);
//        }
//        while(!heapEmpty()){
//            int h = heapPop();
//            int u = idx[h];
//            double w = val[h];
//            money -= w + dis[1];
//            if(money < 0){
//                break;
//            }
//            ans++;
//            if(ls[u] != 0){
//                heapAdd(ls[u], w - cost[u] + cost[ls[u]]);
//            }
//            if(rs[u] != 0){
//                heapAdd(rs[u], w - cost[u] + cost[rs[u]]);
//            }
//            if(start[u] != 0 && rt[start[u]] != 0){
//                heapAdd(rt[start[u]], w + cost[rt[start[u]]]);
//            }
//        }
//    }
//    return ans;
//}
//
//int main(){
//    ios::sync_with_stdio(false);
//    cin.tie(NULL);
//    cin >> n >> m >> money;
//    int u, v;
//    double w;
//    for(int i = 1; i <= m; i++){
//        cin >> u >> v >> w;
//        if(u != n){
//            addEdgeG(u, v, w);
//            addEdgeR(v, u, w);
//        }
//    }
//    dijkstra();
//    mergeRoad();
//    int ans = expand();
//    cout << ans << endl;
//    return 0;
//}