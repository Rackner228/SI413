target triple = "x86_64-pc-linux-gnu"

declare i32 @puts(ptr noundef) #1

define i32 @main() {
  call i32 @puts(ptr @lit1)
@lit1758025996971 = constant [6 x i8] c"Hello\00"
  call i32 @puts(ptr @lit1758025996971)
  ret i32 0
}
