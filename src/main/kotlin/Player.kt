class Player(var _name:String,var _healthPoints:Int =100,
             val _isBlessed:Boolean,private val _isImmortal:Boolean){
    var name = _name
        get() = field.capitalize()
        private set(value) {
            field = value.trim() //trim刪除傳入值的前後空格
        }
    val karma = (Math.pow(Math.random(), (110 - _healthPoints) / 100.0) *20).toInt()//返回（random的（110-生命值/100）為幾次方(指數)的值）
    //Aura
    val auraColor = auraColor(karma)
    //Health Status
    val healthStatus = formatHealthStatus()
    //次建構函數
    constructor(name:String): this(name,
        _isBlessed = true,_isImmortal= false){
        if(name.toLowerCase() == "kar") _healthPoints = 40
    }
    //定義初始化區塊
    init {
        require(_healthPoints >0,{"healthPoints must be greater than zero."})
        require(name.isNotBlank(),{"Player must have a name."})
    }


    fun castFireball(numFireballs:Int =2)=
        println("一杯Fireball酒應運而生。(x$numFireballs)")

    fun formatHealthStatus()=
        when (_healthPoints) {
            100 -> "健康狀態極佳"
            in 90..99 -> "有一些小擦傷"
            in 75..89 -> if (_isBlessed) {
                "雖有一些傷口，但恢復很快"
            } else {
                "有一些傷口"
            }
            in 15..74 -> "嚴重受傷"
            //顯示玩家狀態
            else -> "情況不妙"
        }

    fun auraColor(
        karma: Int
    ): String =
        when (karma) {
            in (0..5) -> "紅色"
            in (6..10) -> "橘色"
            in (11..15) -> "紫色"
            in (16..20) -> "綠色"
            else -> "無光環"
        }
}
