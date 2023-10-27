package com.example.baselineprofiles_codelab.ui.contact

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.baselineprofiles_codelab.ui.components.JetsnackButton

@Composable
fun ContactList(
    contacts: List<Contact>,
    comparator: Comparator<Contact>,
    modifier: Modifier = Modifier
) {

    Box {
        val sortedContacts = remember(contacts, comparator) {
            contacts.sortedWith(comparator)
        }

        val listState = rememberLazyListState()

        LazyColumn(
            modifier,
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            state = listState
        ) {
            items(sortedContacts, key = { item -> item.id }) { contact ->
                ContactItem(contact = contact, sortedContacts.first {
                    it.name.first().lowercase() == contact.name.first().lowercase()
                }.id == contact.id)
            }
        }

        val showButton by remember {
            derivedStateOf { listState.firstVisibleItemIndex > 0 }
        }

        AnimatedVisibility(modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(16.dp), visible = showButton) {
            ScrollToTopButton()
        }
    }
}

@Composable
fun ScrollToTopButton(){
    Button(
        onClick = { /*TODO*/ },
    ) {
        Text(modifier = Modifier.padding(6.dp), text = "Scroll to Top")
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewContactList() {

    ContactList(
        contacts = listOf(
            Contact(1, "Aditya Pratama"),
            Contact(2, "Dian Sari"),
            Contact(3, "Fajar Setiawan"),
            Contact(4, "Ika Putri"),
            Contact(5, "Rizky Wijaya"),
            Contact(6, "Nita Cahaya"),
            Contact(7, "Agung Nugraha"),
            Contact(8, "Putra Ramadhan"),
            Contact(9, "Dewi Lestari"),
            Contact(10, "Budi Santoso"),
            Contact(11, "Siti Rahayu"),
            Contact(12, "Hadi Susanto"),
            Contact(13, "Maya Anggraini"),
            Contact(14, "Rizal Hidayat"),
            Contact(15, "Ningsih Wulandari"),
            Contact(16, "Agus Hermawan"),
            Contact(17, "Rina Novitasari"),
            Contact(18, "Arif Saputra"),
            Contact(19, "Mega Indah"),
            Contact(20, "Yoga Pradana"),
            Contact(21, "Sari Rahmawati"),
            Contact(22, "Bayu Perdana"),
            Contact(23, "Nurul Fajri"),
            Contact(24, "Doni Pratama"),
            Contact(25, "Sinta Wahyu"),
            Contact(26, "Dian Saputri"),
            Contact(27, "Rizki Rahman"),
            Contact(28, "Maya Purnama"),
            Contact(29, "Ari Saputra"),
            Contact(30, "Nita Astuti"),

            ),
        comparator = { contact, contact2 ->
            contact.name.compareTo(contact2.name)
        },
        modifier = Modifier.fillMaxSize()
    )
}

