target triple = "x86_64-pc-linux-gnu"

declare i32 @puts(ptr noundef) #1

define i32 @main() {
  call i32 @puts(ptr @lit1)
  ret i32 0
}

@lit1 = constant [6 x i8] c"aloha\00"