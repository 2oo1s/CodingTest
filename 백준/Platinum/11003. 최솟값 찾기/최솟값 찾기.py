from collections import deque

n, l = map(int, input().split())  # 데이터 개수, 범위 크기
num = list(map(int, input().split()))  # 입력 받은 n개의 data
q = deque()

for i in range(n):
    while q and q[-1][0] > num[i]:
        q.pop()
    q.append((num[i], i))
    if q[0][1] <= i - l:
        q.popleft()
    print(q[0][0], end=' ')
