from collections import deque
import sys

sys.setrecursionlimit(10 ** 6)  # 재귀 최대 깊이 설정
input = sys.stdin.readline

n = int(input())
A = [[] for _ in range(n + 1)]  # 그래프를 인접 리스트로 저장
visited = [False] * (n + 1)  # 방문 기록 저장
d = [0] * (n + 1)

for _ in range(n):
    nodeData = list(map(int, input().split()))
    i = 0
    u = nodeData[i]
    i += 1  # 연결된 노드 정보
    while True:
        v = nodeData[i]
        if v == -1:
            break
        w = nodeData[i + 1]  # 가중치
        A[u].append((v, w))
        i += 2  # 다음 연결된 노드 정보


def BFS(v):
    queue = deque()
    queue.append(v)
    visited[v] = True
    while queue:
        now = queue.popleft()
        for i in A[now]:
            if not visited[i[0]]:
                visited[i[0]] = True
                queue.append(i[0])
                d[i[0]] = d[now] + i[1]


BFS(1)
dMaxIndex = d.index(max(d))

visited = [False] * (n + 1)
d = [0] * (n + 1)

BFS(dMaxIndex)
print(max(d))