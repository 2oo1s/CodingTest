import sys
input = sys.stdin.readline

n = int(input())
k = int(input())

s = 1
e = k

while s <= e:
    m = int((s + e) / 2)
    cnt = 0
    for i in range(1, n + 1):
        cnt += min(int(m / i), n)  # 한 행의 크기가 더 작을 수 있으므로
    if cnt < k:
        s = m + 1
    else:
        res = m
        e = m - 1

print(res)
