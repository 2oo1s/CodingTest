N, S = map(int, input().split())
arr = list(map(int, input().split()))
s, e = 0, 0
tot = arr[0]
ans = 100001

while True:
    if tot >= S:
        tot -= arr[s]
        ans = min(ans, e - s + 1)
        s += 1
    else:
        e += 1
        if e == N:
            break
        tot += arr[e]

if ans == 100001:
    print(0)
else:
    print(ans)
