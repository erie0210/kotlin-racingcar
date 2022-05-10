package stringCalculator

class Calculator() {

    /**
     *  Getter/ Setter: 모든 property에는 기본적으로 getter/setter 설정이 있다.
        var input: String = ""
            get() {
                return field
            }
            set(value){
                field = value
            }
     */

    // default: public final
    var input: String = ""

    fun calculate(): Int {
        val validator = Validator()
        validator.isValidInput(input)
        val inputList = changeStringToList(input)
        return operate(inputList)
    }

    private fun operate(inputList: List<String>): Int {
        var result: Int = inputList[0].toInt()
        for (i in 1..inputList.size - 1 step 2) {
            val oprend = inputList[i + 1].toInt()
            if (inputList[i] == "+") {
                result = add(result, oprend)
            } else if (inputList[i] == "-") {
                result = substrate(result, oprend)
            } else if (inputList[i] == "*") {
                result = multiple(result, oprend)
            } else {
                result = divide(result, oprend)
            }
        }
        return result
    }

    private fun changeStringToList(input: String): List<String> {
        return input.split(" ")
    }
}