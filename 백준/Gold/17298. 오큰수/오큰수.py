import sys

input = sys.stdin.readline
n = int(input())  # 입력 받을 데이터 개수
num = list(map(int, input().split()))   # 입력 받은 n개의 데이터
stack = []
ans = [-1 for i in range(n)]

for i in range(n):
    while stack and num[stack[-1]] < num[i]:
        ans[stack.pop()] = num[i]
    stack.append(i)

for i in range(n):
    print(ans[i], end=' ')