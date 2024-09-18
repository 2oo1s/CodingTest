import sys
from collections import deque

input = sys.stdin.readline

n, m, k, x = map(int, input().split())  # 도시 개수, 도로 개수, 거리 정보, 출발도시 번호
A = [[]for _ in range(n+1)]  # 연결된 도시 정보 저장
visited = [-1] * (n + 1)    # 거리 정보 저장
answer = []

for i in range(m):
    s, e = map(int, input().split())
    A[s].append(e)


def BFS(v):
    queue = deque()
    queue.append(v)
    visited[v] += 1
    while queue:
        current = queue.popleft()
        for i in A[current]:
            if visited[i] == -1:
                visited[i] = visited[current] + 1   # 거리 계산
                queue.append(i)


BFS(x)

for i in range(n+1):
    if visited[i] == k:
        answer.append(i)

if not answer:
    print(-1)
else:
    answer.sort()
    for i in answer:
        print(i)
