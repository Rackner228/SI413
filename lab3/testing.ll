target triple = "x86_64-pc-linux-gnu"

declare i32 @puts(ptr noundef)
@lit1 = constant [6 x i8] c"HELLO\00"
@lit2 = constant [4 x i8] c"Pee\00"
@lit3 = constant [10 x i8] c"Minecraft\00"
define i32 @main() {
	call i32 @puts(ptr @lit1)

	call i32 @puts(ptr @lit2)

	call i32 @puts(ptr @lit3)

	ret i32 0
}
vm@
