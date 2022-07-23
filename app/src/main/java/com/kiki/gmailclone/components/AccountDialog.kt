package com.kiki.gmailclone.components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PersonAddAlt
import androidx.compose.material.icons.outlined.ManageAccounts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.kiki.gmailclone.R
import com.kiki.gmailclone.accountList
import com.kiki.gmailclone.model.Account

@Composable
fun AccountDialog(openDialog: MutableState<Boolean>){
    Dialog(onDismissRequest = { openDialog.value = false },
    properties = DialogProperties(dismissOnClickOutside = false)) {
        AccountDialogUI(openDialog = openDialog)
    }
}

@Composable
fun AccountDialogUI(modifier: Modifier = Modifier, openDialog: MutableState<Boolean>) {

    Card{
        Column(
            modifier
                .background(Color.White)
                .padding(bottom = 16.dp)
        ) {

            Row(
                modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){

                IconButton(
                    onClick = { openDialog.value = false}
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = ""
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "",
                    modifier
                        .size(30.dp)
                        .weight(2.0f)
                )
            }

            AccountItem(account = accountList[0])

            Row(
                modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Card(
                    modifier.requiredWidth(150.dp),
                    shape = RoundedCornerShape(50.dp),
                    border = BorderStroke(1.dp, color = Color.Gray)
                ) {
                    Text(
                        text = "Google Account",
                        modifier = Modifier.padding(8.dp),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier.width(10.dp))
            }

            Divider(modifier.padding(top = 16.dp))

            Column {
                AccountItem(accountList[1])
                AccountItem(accountList[2])
            }

            AddAccount(icon = Icons.Default.PersonAddAlt, title = "Add Another Account")
            AddAccount(icon = Icons.Outlined.ManageAccounts, title = "Manage Account on this device")

            Divider(modifier.padding(top = 16.dp, bottom = 16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "Privacy Policy")
                Card(
                    modifier = Modifier.padding(top = 10.dp).size(3.dp),
                    shape = CircleShape,
                    backgroundColor = Color.Black
                ) {}
                Text(text = "Teams Of Service")
            }

        }
    }
}

@Composable
fun AccountItem(account: Account) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp)
    ) {

        if (account.icon != null){
            Image(
                painter = painterResource(id = account.icon),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(color = Color.White)
            )
        } else {
            Card(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(40.dp)
                    .clip(CircleShape),
                backgroundColor = Color.LightGray
            ){
                Text(
                    text = account.userName[0].toString(),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

        Column(
            modifier = Modifier
                .weight(2.0f)
                .padding(start = 16.dp, bottom = 16.dp)
        ) {
            Text(text = account.userName, fontWeight = FontWeight.SemiBold)
            Text(text = account.email)
        }

        Text(text = "${account.unReadMails}+", modifier = Modifier.padding(end = 16.dp))
    }
}

@Composable
fun AddAccount(icon: ImageVector, title: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
    ) {
        IconButton(onClick = {}) {
            Icon(
                imageVector = icon,
                contentDescription = "",
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
        Text(
            text = title,
            fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(top = 8.dp, start = 8.dp)
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun AccountDialogPreview(){
}