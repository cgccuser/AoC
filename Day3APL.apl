⎕IO←0
input←⍪''
)ed input ⍝ Paste input in and hit Escape
transpose←⍉input
mostcommon←.5<(+/'1'=transpose)÷(1⊃⍴transpose)
gamma←2⊥mostcommon
epsilon←2⊥~mostcommon
⎕←gamma×epsilon
