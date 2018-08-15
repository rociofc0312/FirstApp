package com.example.rocio.firstapp.util;

import android.net.Uri;

import com.example.rocio.firstapp.R;
import com.example.rocio.firstapp.model.Server;

public class Servers {

    public Servers(){}

    public Server[] SERVERS = {
            James, Robert, Michael, William, Joseph, Charles, Matthew, Donald, Paul, Steve, Mary, Patricia, Jennifer, Elizabeth, Linda, Susan, Jessica,
            Sarah, Karen, Nancy, Carol
    };

    public static final Server James = new Server(Uri.parse("android.resource://com.example.rocio.firstapp/" + R.drawable.james).toString(),
            "James", "24", "4.5", "Connected");

    public static final Server Robert = new Server(Uri.parse("android.resource://com.example.rocio.firstapp/" + R.drawable.robert).toString(),
            "Robert", "24", "4.5", "Connected");

    public static final Server Michael = new Server(Uri.parse("android.resource://com.example.rocio.firstapp/" + R.drawable.michael).toString(),
            "Michael", "24", "4.5", "Connected");

    public static final Server William = new Server(Uri.parse("android.resource://com.example.rocio.firstapp/" + R.drawable.william).toString(),
            "William", "24", "4.5", "Connected");

    public static final Server Joseph = new Server(Uri.parse("android.resource://com.example.rocio.firstapp/" + R.drawable.joseph).toString(),
            "Joseph", "24", "4.5", "Connected");

    public static final Server Charles = new Server(Uri.parse("android.resource://com.example.rocio.firstapp/" + R.drawable.charles).toString(),
            "Charler", "24", "4.5", "Connected");

    public static final Server Matthew = new Server(Uri.parse("android.resource://com.example.rocio.firstapp/" + R.drawable.mattew).toString(),
            "Mathew", "24", "4.5", "Connected");

    public static final Server Donald = new Server(Uri.parse("android.resource://com.example.rocio.firstapp/" + R.drawable.donald).toString(),
            "Donald", "24", "4.5", "Connected");

    public static final Server Paul = new Server(Uri.parse("android.resource://com.example.rocio.firstapp/" + R.drawable.paul).toString(),
            "Paul", "24", "4.5", "Connected");

    public static final Server Steve = new Server(Uri.parse("android.resource://com.example.rocio.firstapp/" + R.drawable.steve).toString(),
            "Steve", "24", "4.5", "Connected");


    /*
            Females
     */
    public static final Server Mary = new Server(Uri.parse("android.resource://com.example.rocio.firstapp/" + R.drawable.mary).toString(),
            "Mary", "24", "4.5", "Connected");

    public static final Server Patricia = new Server(Uri.parse("android.resource://com.example.rocio.firstapp/" + R.drawable.patricia).toString(),
            "Patricia", "24", "4.5", "Connected");

    public static final Server Jennifer = new Server(Uri.parse("android.resource://com.example.rocio.firstapp/" + R.drawable.jennifer).toString(),
            "Jennifer", "24", "4.5", "Connected");

    public static final Server Elizabeth = new Server(Uri.parse("android.resource://com.example.rocio.firstapp/" + R.drawable.elizabeth).toString(),
            "Elizabeth", "24", "4.5", "Connected");

    public static final Server Linda = new Server(Uri.parse("android.resource://com.example.rocio.firstapp/" + R.drawable.linda).toString(),
            "Linda", "24", "4.5", "Connected");

    public static final Server Susan = new Server(Uri.parse("android.resource://com.example.rocio.firstapp/" + R.drawable.susan).toString(),
            "Susan", "24", "4.5", "Connected");

    public static final Server Jessica = new Server(Uri.parse("android.resource://com.example.rocio.firstapp/" + R.drawable.jessica).toString(),
            "Jessica", "24", "4.5", "Connected");

    public static final Server Sarah = new Server(Uri.parse("android.resource://com.example.rocio.firstapp/" + R.drawable.sarah).toString(),
            "Sarah", "24", "4.5", "Connected");

    public static final Server Karen = new Server(Uri.parse("android.resource://com.example.rocio.firstapp/" + R.drawable.karen).toString(),
            "Karen", "24", "4.5", "Connected");

    public static final Server Nancy = new Server(Uri.parse("android.resource://com.example.rocio.firstapp/" + R.drawable.nancy).toString(),
            "Nancy", "24", "4.5", "Connected");

    public static final Server Carol = new Server(Uri.parse("android.resource://com.example.rocio.firstapp/" + R.drawable.carol).toString(),
            "Carol", "24", "4.5", "Connected");
}
