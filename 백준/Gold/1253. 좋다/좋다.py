import sys

input = sys.stdin.readline
n = int(input())
num = list(map(int, input().split()))
num.sort()
cnt = 0

for i in range(n):
    good = num[i]
    s = 0
    e = n-1
    while s < e:
        if num[s] + num[e] == good:
            if s != i and e != i:
                cnt += 1
                break
            elif s == i:
                s += 1
            elif e == i:
                e -= 1
        elif num[s]+num[e] < good:
            s += 1
        else:
            e -= 1
print(cnt)