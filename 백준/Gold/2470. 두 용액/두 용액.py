N = int(input())
arr = list(map(int, input().split()))
arr.sort()

s = 0
e = len(arr)-1
diff = abs(arr[s] + arr[e])
ans = [arr[s], arr[e]]

while s < e:
    left = arr[s]
    right = arr[e]

    if abs(left+right) < diff:
        diff = abs(left+right)
        ans = [left, right]
        if diff == 0:
            break
    if (left+right) < 0:
        s += 1
    else:
        e -= 1


print(ans[0], ans[1])
