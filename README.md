# HW1 作業回答

## 1. 作業系統與 IDE
- 作業系統：Windows 10  
- IDE：Code::Blocks  

---

## 2. IDE 背後的編譯器
- 編譯器：MinGW GCC  
- 查詢方式：  
```bash
gcc --version
```
---
![第一題跟第二題](Q1andQ2.png)
## 3. Command Line 編譯與執行

### 程式碼
**main.c** & **sum.c**
```c
#include <stdio.h>
#include <stdlib.h>

int sum(int n);

int main(void){
    int sum1 = sum(10);
    printf("sum=%d\n", sum1);
    system("pause");
    return 1;
}

int sum(int n){
    int s = 0;
    int i;
    for (i = 1; i <= n; i++){
        s = s + i;
    }
    return s;
}
```
![第一題跟第二題](Q1andQ2.png)
