n = int(input())
A = [[] for _ in range(n)]
visited = [False] * n
D = [0] * n
lcm = 1


def GCD(a, b):
    if b == 0:
        return a
    else:
        return GCD(b, a % b)


def DFS(v):
    visited[v] = True
    for i in A[v]:
        next = i[0]
        if not visited[next]:
            D[next] = D[v] * i[2] // i[1]   # a : b = p(=i[1]) : q(=i[2]) 
            DFS(next)


for i in range(n-1):
    a, b, p, q = map(int, input().split())
    A[a].append((b, p, q))
    A[b].append((a, q, p))
    lcm *= (p * q // GCD(p, q))

D[0] = lcm
DFS(0)
mgcd = D[0]

for i in range(1, n):
    mgcd = GCD(mgcd, D[i])

for i in range(n):
    print(int(D[i] // mgcd), end=' ')