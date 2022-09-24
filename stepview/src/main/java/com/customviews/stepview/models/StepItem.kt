package com.customviews.stepview.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class StepItem(
    val id: Int,
    val name: String,
    val description: String,
    val mark: String,
    val indicator: StepIndicator,
    val isVisibleSubStepIndicator: Boolean,
    val subSteps: List<SubStepItem>
)

data class SubStepItem(
    val name: String,
    val description: String,
    val mark: String
)

sealed class StepIndicator(
    open val contentColor: Color,
    open val backgroundColor: Color,
    open val lineColor: Color
) {
    data class Number(
        val value: String,
        override val contentColor: Color = Color.Unspecified,
        override val backgroundColor: Color = Color.Unspecified,
        override val lineColor: Color = Color.Unspecified
    ) : StepIndicator(contentColor, backgroundColor, lineColor)

    data class Icon(
        @DrawableRes val icon: Int,
        override val contentColor: Color = Color.Unspecified,
        override val backgroundColor: Color = Color.Unspecified,
        override val lineColor: Color = Color.Unspecified
    ) : StepIndicator(contentColor, backgroundColor, lineColor)
}