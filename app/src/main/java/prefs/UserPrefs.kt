package prefs

const val NAME = "user_name"
class UserPrefs : PrefsDeligate() {
    var name by StringDeligate(NAME)
}