target triple = "x87_64-pc-linux-gnu"

declare i32 @puts(ptr noundef) #1

define i32 @main() {
	@lit1 = constant [6 x i8] c"HELLO\00"
	call i32 @puts(ptr @lit1)
	ret i32 0
}
