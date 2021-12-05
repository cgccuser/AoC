def won(marks, r, c):
  """Take a boolean 5x5 matrix and check if it's got 5 Trues in a row in the given row or column"""
  return all(marks[r]) or all(row[c] for row in marks)

numbers = [int(n) for n in input().split(',')]
input()
boards = []
while True:
  boards.append([[int(x) for x in input().strip().split()] for _ in range(5)])
  try:
    input()
  except:
    break

# Make corresponding matrices with booleans for numbers that were called
markss = [[[False] * 5 for _ in range(5)] for _ in boards]

for num in numbers:
  for i in range(len(boards)):
    board = boards[i]
    marks = markss[i]
    for r in range(5):
      for c in range(5):
        if board[r][c] == num:
          marks[r][c] = True
          if won(marks, r, c):
            unmarked_sum = sum(board[i][j] for i in range(5) for j in range(5) if not marks[i][j])
            print(unmarked_sum * num)
            exit(0) # Bad but whatever
