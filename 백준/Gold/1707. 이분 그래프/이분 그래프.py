import sys

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

k = int(input())    # 테스트 케이스 개수
isEven = True   # 이분그래프인지 확인


def DFS(v):
    global isEven
    visited[v] = True
    for i in A[v]:
        if not visited[i]:
            check[i]=(check[v]+1)%2
            DFS(i)
        elif check[v]==check[i]:
            isEven=False


for _ in range(k):
    v, e = map(int, input().split())    # 노드 개수, 에지 개수
    A = [[] for _ in range(v + 1)]  # ㅇ
    visited = [False]*(v+1)
    check = [0]*(v+1)
    isEven = True 

    for _ in range(e):
        start, end = map(int, input().split())
        A[start].append(end)
        A[end].append(start)

    for i in range(1, v+1):
        if isEven:
            DFS(i)
        else:
            break
    
    if isEven:
        print("YES")
    else:
        print("NO")