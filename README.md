# 🧮 Java 圖形化計算機（Calculator）

一個使用 **Java** 撰寫的計算機應用程式專案，採用 **UI 與運算邏輯分離** 的物件導向設計思路，並包含延伸或期末專題目錄（`FinalProject/`）。

---

## 🔍 專案分析

### 1. 系統定位與核心功能
從根目錄的類別命名與結構來看，這是一個典型的 Java 桌面/圖形介面計算機專案：
- **介面與邏輯解耦**：`CalculatorUI.java` 負責圖形使用者介面（GUI）元件配置與事件監聽，`CalculatorLogic.java` 負責算術運算與狀態處理，有助於維護與除錯。
- **一般計算機實作**：`NormalCalculator.java` 提供標準計算機功能與整合入口。
- **專題延伸目錄**：包含 `FinalProject/` 資料夾，可能存放進階功能版本、期末專題完整程式或相關專案檔案。

### 2. 專案結構摘要
- **核心 Java 原始碼**：`CalculatorUI.java`、`CalculatorLogic.java`、`NormalCalculator.java`
- **延伸 / 期末專題目錄**：`FinalProject/`
- **版本控管設定**：`.gitattributes`

### 3. 工程現況與改進建議
- **優點**：將 `CalculatorUI` 與 `CalculatorLogic` 拆開是良好的物件導向實踐，讓運算規則可以獨立於介面進行測試。
- **建議改進**：
  1. 補充支援的運算功能清單（例如四則運算、小數、正負號、清除/歸零、連續運算或特殊例外處理如除以零）。
  2. 說明 `FinalProject/` 與根目錄三個 `.java` 檔之間的關聯與主程式（`main` 方法）所在位置，方便編譯與執行。

---

## 🛠️ 編譯與執行說明

### 1. 環境需求
- Java Development Kit（JDK 8 或以上版本）

### 2. 編譯與執行（根目錄原始碼）
```bash
git clone https://github.com/anonymousouob/calculator.git
cd calculator

# 編譯 Java 檔案
javac *.java

# 執行包含 main 方法的類別（例如 NormalCalculator 或 CalculatorUI，依實際主類別為準）
java NormalCalculator
```
若要執行 `FinalProject/` 內的程式，請先切換至該目錄後再進行編譯與執行。
