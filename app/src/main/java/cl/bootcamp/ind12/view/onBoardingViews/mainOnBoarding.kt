package cl.bootcamp.ind12.view.onBoardingViews

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import cl.bootcamp.ind12.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState


@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainOnboarding(navController: NavController) {
    val items = ArrayList<PageData>()

    items.add(
        PageData(
            R.raw.page1, "Introducción al IMC", "Descubre qué es el Índice de Masa Corporal y cómo puede ayudarte a evaluar tu salud."
        )
    )
    items.add(
        PageData(
            R.raw.page2, "Cómo calcular tu IMC", "Aprende a calcular tu IMC usando tu peso y altura con una fórmula sencilla."
        )
    )
    items.add(
        PageData(
            R.raw.page3, "Interpretación del IMC", "Entiende lo que significan los valores de IMC y cómo se relacionan con tu bienestar."
        )
    )

    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0)

    OnBoardingPager(
        item = items,
        pagerState = pagerState,
        navController = navController
        )

}