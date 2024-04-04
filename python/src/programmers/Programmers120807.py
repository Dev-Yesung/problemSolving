def solution(num1, num2):
    return 1 if num1 == num2 else -1


def main():
    num1_list = [2, 11, 7]
    num2_list = [3, 11, 99]

    for idx in range(3):
        num1 = num1_list[idx]
        num2 = num2_list[idx]
        answer = solution(num1, num2)
        print(answer)


if __name__ == "__main__":
    main()
