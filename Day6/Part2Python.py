with open("input.txt") as file:
  for line in file:
    fishies = [int(x) for x in line.split(",")]
    states = [0] * 9
    for fish in fishies:
      states[fish] += 1
    for _ in range(256):
      reproducers = states[0]
      for i in range(1, 9):
        states[i - 1] = states[i]
      states[6] += reproducers
      states[8] = reproducers
    print(sum(states))
    break