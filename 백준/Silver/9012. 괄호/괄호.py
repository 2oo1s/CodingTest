import sys

input = sys.stdin.readline

t = int(input())

for i in range(t):
    st = str(input())
    s = list(st)
    sum=0
    for i in s:
        if i == '(':
            sum += 1
        elif i == ')':
            sum -= 1
        if sum < 0:
            print('NO')
            break
    if sum > 0:
        print('NO')
    elif sum == 0:
        print('YES')
