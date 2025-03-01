package com.cristiancizmar.rickandmorty.presentation.features.home

import com.cristiancizmar.rickandmorty.MainDispatcherRule
import com.cristiancizmar.rickandmorty.domain.Character
import com.cristiancizmar.rickandmorty.domain.CharactersResponse
import com.cristiancizmar.rickandmorty.data.CharactersRepository
import com.cristiancizmar.rickandmorty.util.State
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {

    private var charactersRepository: CharactersRepository = mockk()
    private lateinit var viewModel: HomeViewModel

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private val characters1 = listOf(Character.getMockCharacter1())
    private val characters2 = listOf(Character.getMockCharacter2())

    private val response1 = CharactersResponse(characters1)
    private val response2 = CharactersResponse(characters2)

    @Test
    fun loadCharactersInit_success_charactersUpdated() = runTest {
        coEvery { charactersRepository.getCharacters() } returns response1

        viewModel = HomeViewModel(charactersRepository, dispatcherRule.dispatcher)
        dispatcherRule.dispatcher.scheduler.advanceUntilIdle()

        assertTrue(viewModel.state is State.Success)
        assertEquals(characters1, (viewModel.state as? State.Success)?.data)
    }

    @Test
    fun loadCharactersTwice_success_charactersUpdated() = runTest {
        coEvery { charactersRepository.getCharacters() } returns response1
        viewModel = HomeViewModel(charactersRepository, dispatcherRule.dispatcher)
        dispatcherRule.dispatcher.scheduler.advanceUntilIdle()
        coEvery { charactersRepository.getCharacters() } returns response2

        viewModel.onAction(HomeViewModel.HomeEvent.LoadCharacters)
        dispatcherRule.dispatcher.scheduler.advanceUntilIdle()

        assertTrue(viewModel.state is State.Success)
        assertEquals(characters2, (viewModel.state as? State.Success)?.data)
    }

    @Test
    fun loadCharactersInit_error_stateUpdated() = runTest {
        val exception = Exception()
        coEvery { charactersRepository.getCharacters() } throws exception

        viewModel = HomeViewModel(charactersRepository, dispatcherRule.dispatcher)
        dispatcherRule.dispatcher.scheduler.advanceUntilIdle()

        assertTrue(viewModel.state is State.Error)
        assertEquals(exception, (viewModel.state as? State.Error)?.throwable)
    }
}