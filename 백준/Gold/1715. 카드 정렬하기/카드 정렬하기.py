import sys
from queue import PriorityQueue

input = sys.stdin.readline

n = int(input())  # 카드 묶음 수
pq = PriorityQueue()  # 카드 묶음 크기 저장
tot = 0

for i in range(n):
    data = int(input())
    pq.put(data)

d1 = 0
d2 = 0

while pq.qsize() > 1:
    d1 = pq.get()
    d2 = pq.get()
    temp = d1 + d2
    tot += temp
    pq.put(temp)

print(tot)
