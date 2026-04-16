package ru.konohovalex.swwiki.core.ui.model

import androidx.annotation.StringRes
import ru.konohovalex.swwiki.core.ui.R

enum class GenderUiModel(@get:StringRes @param:StringRes val nameRes: Int) {
    MALE(nameRes = R.string.core_ui_gender_male),
    FEMALE(nameRes = R.string.core_ui_gender_female),
    UNDEFINED(nameRes = R.string.core_ui_gender_undefined);

    companion object {
        fun from(order: Int) = entries[order]
    }
}
