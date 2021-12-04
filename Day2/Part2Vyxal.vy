0→horiz 0→depth 0→aim
□ (
  ⌈ :
  h →dir
  t E
  ←dir `forward` ⁼ [
    :
    ←horiz + →horiz
    ←aim * ←depth + →depth
    | ←dir `up` = [ N ] ←aim + →aim
  ] ) ←horiz ←depth *
