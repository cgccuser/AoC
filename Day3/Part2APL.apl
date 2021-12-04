⎕IO←0
input←⍪''
)ed input ⍝ Paste input in and hit Escape
nummat←⍎¨¨↓input ⍝ Turn the input into a 2D nested array of booleans
⍝ Calculate the most common bits in a 2D (nested) array
mcb←{.5≤(+/1=⍉↑⍵)÷≢⍵}
 rating←{
     ⍝ ind is index of the bit
     ⍝ oxy is whether or not finding oxygen rating
     ⍝ If it does want oxygen rating, use 1, else 0
     ind oxy←⍺
     ⍝ Remaining numbers
     nums←⍵
     ⍝ The bits at index ind in each row
     bits←ind⊃¨nums
     ⍝ The value each bit should have
     want←2|(~oxy)+ind⊃mcb nums
     left←(bits=want)/nums
     1=≢left:⊃left ⋄
     (ind+1)oxy rating left
 }

oxyrating←0 1 rating nummat
c02rating←0 0 rating nummat
⎕←(2⊥oxyrating)×2⊥c02rating
