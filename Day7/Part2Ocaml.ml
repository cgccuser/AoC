let read_lines name : string list =
  let ic = open_in name in
  let try_read () =
    try Some (input_line ic) with End_of_file -> None in
  let rec loop acc = match try_read () with
    | Some s -> loop (s :: acc)
    | None -> close_in ic; List.rev acc in
  loop []

let dist a b = Int.abs (a - b)
let sum = List.fold_left (+) 0
let min = List.fold_left (fun a b -> if a < b then a else b) Int.max_int
let max = List.fold_left (fun a b -> if a > b then a else b) Int.min_int
let rec range a b = if a <= b then a :: range (a+1) b else []

let main _ =
  let (input :: _) = read_lines "input.txt" in
  let nums = List.map int_of_string (String.split_on_char ',' input) in
  let cost x = sum (List.map (fun d -> let n = dist d x in n * (n + 1) / 2) nums) in
  let min_cost = min (List.map cost (range (min nums) (max nums))) in
  print_string (string_of_int min_cost) ;
  print_string "\n";;

main ();;
