package ru.konohovalex.swwiki.core.ui.model

import androidx.annotation.StringRes
import ru.konohovalex.swwiki.core.ui.R

enum class GenderUiModel(@get:StringRes @param:StringRes val nameRes: Int) {
    MALE(nameRes = R.string.core_ui_gender_male),
    FEMALE(nameRes = R.string.core_ui_gender_female),
    HERMAPHRODITE(nameRes = R.string.core_ui_gender_hermaphrodite),
    UNAVAILABLE(nameRes = R.string.core_ui_gender_unavailable),
    NONE(nameRes = R.string.core_ui_gender_none);

    companion object {
        fun from(order: Int) = entries[order]
    }
}
