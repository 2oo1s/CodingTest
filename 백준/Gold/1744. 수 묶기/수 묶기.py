import sys
from queue import PriorityQueue

input = sys.stdin.readline

n = int(input())  # 수의 개수
posPq = PriorityQueue()
negPq = PriorityQueue()
zeroCnt = 0
oneCnt = 0
tot = 0

for i in range(n):
    data = int(input())
    if data < 0:
        negPq.put(data)
    elif data > 1:
        posPq.put(data * -1)  # for 내림차순 정렬
    elif data == 1:
        oneCnt += 1
    else:
        zeroCnt += 1

while posPq.qsize() > 1:
    d1 = posPq.get()
    d2 = posPq.get()
    tot += d1 * d2

if posPq.qsize() != 0:
    tot += posPq.get() * -1

while negPq.qsize() > 1:
    d1 = negPq.get()
    d2 = negPq.get()
    tot += d1 * d2

if negPq.qsize() != 0:
    if zeroCnt == 0:
        tot += negPq.get()

tot += oneCnt

print(tot)