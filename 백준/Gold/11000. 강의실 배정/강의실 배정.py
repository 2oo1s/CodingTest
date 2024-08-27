import heapq
import sys
input = sys.stdin.readline


N = int(input())
arr = []
heap = []

for i in range(N):
    s, e = map(int, input().split())
    arr.append([s, e])

# 시작시간순으로 정렬
arr.sort(key=lambda x: x[0])

# 첫번째 강의가 끝나는 시간 넣음
heapq.heappush(heap, arr[0][1])

for i in range(1, N):
    # 이어서 회의를 못하고, 새로운 강의실에서 회의를 진행해야할 때
    if heap[0] > arr[i][0]:
        heapq.heappush(heap, arr[i][1])
    # 이어서 회의가 가능할 때, 끝나는 시간 갱신
    else:
        heapq.heappop(heap)
        heapq.heappush(heap, arr[i][1])
print(len(heap))
