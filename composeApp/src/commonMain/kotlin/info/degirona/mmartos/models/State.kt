package info.degirona.mmartos.models

sealed interface State {
    data object Cover : State
    data object Details : State
}
