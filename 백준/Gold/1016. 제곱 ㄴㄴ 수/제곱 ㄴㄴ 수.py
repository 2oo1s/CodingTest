import math

minV, maxV = map(int, input().split())
check = [False] * (maxV-minV+1)

for i in range(2, int(math.sqrt(maxV)+1)):
    pow = i*i
    s = int(minV/pow)
    if minV % pow != 0:
        s += 1
    for j in range(s, int(maxV/pow)+1):
        check[int((j*pow)-minV)]=True

cnt = 0

for i in range(0, maxV - minV +1):
    if not check[i]:
        cnt +=1

print(cnt)