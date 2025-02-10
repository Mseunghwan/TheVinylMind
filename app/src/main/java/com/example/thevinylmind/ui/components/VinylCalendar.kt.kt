package com.example.thevinylmind.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kizitonwose.calendar.compose.*
import com.kizitonwose.calendar.core.*
import java.time.*
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun VinylCalendar(
    selectedDate: LocalDate,
    onDateSelect: (LocalDate) -> Unit
) {
    val currentMonth = remember { YearMonth.now() }
    val startMonth = remember { currentMonth.minusMonths(12) }
    val endMonth = remember { currentMonth.plusMonths(12) }
    val firstDayOfWeek = remember { firstDayOfWeekFromLocale() }

    val state = rememberCalendarState(
        startMonth = startMonth,
        endMonth = endMonth,
        firstVisibleMonth = currentMonth,
        firstDayOfWeek = firstDayOfWeek
    )

    HorizontalCalendar(
        state = state,
        dayContent = { day ->
            Day(
                day = day,
                isSelected = selectedDate == day.date,
                onDateSelect = onDateSelect
            )
        },
        monthHeader = { month ->
            MonthHeader(
                daysOfWeek = month.weekDays.first().map { it.date.dayOfWeek }
            )
        }
    )
}

@Composable
private fun Day(
    day: CalendarDay,
    isSelected: Boolean,
    onDateSelect: (LocalDate) -> Unit
) {
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .padding(2.dp)
            .clip(CircleShape)
            .background(
                if (isSelected) MaterialTheme.colorScheme.primary
                else Color.Transparent
            )
            .clickable(
                enabled = day.position == DayPosition.MonthDate,
                onClick = { onDateSelect(day.date) }
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = day.date.dayOfMonth.toString(),
            color = when {
                isSelected -> MaterialTheme.colorScheme.onPrimary
                day.position == DayPosition.MonthDate -> MaterialTheme.colorScheme.onBackground
                else -> MaterialTheme.colorScheme.onBackground.copy(alpha = 0.3f)
            }
        )
    }
}


@Composable
private fun MonthHeader(daysOfWeek: List<DayOfWeek>) {
    Row(modifier = Modifier.fillMaxWidth()) {
        for (dayOfWeek in daysOfWeek) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 8.dp),
                text = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault()),
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}