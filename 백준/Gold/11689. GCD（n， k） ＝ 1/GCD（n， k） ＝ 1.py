import math
n = int(input())
answer = n

for i in range(2, int(math.sqrt(n)+1)):
    if n % i == 0:  # i가 소인수인지 확인
        answer -= answer / i   # i의 배수 개수만큼 삭제
        while n % i == 0:   # i 거듭제곱 삭제
            n /= i

if n > 1:
    answer -= answer / n

print(int(answer))