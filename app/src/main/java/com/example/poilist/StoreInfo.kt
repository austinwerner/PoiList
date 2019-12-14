package com.example.poilist

import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class StoreInfo : AppCompatActivity(), OnMapReadyCallback {

    var Location : LatLng = LatLng( 0.0, 0.0 )
    val ZOOM_LEVEL = 17f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_info)
        val data = intent.getSerializableExtra("data") as? Store

        if( data != null )
        {
            Location = LatLng( data.latitude, data.longitude )
        }

        // Setup map callback
        val mapFragment : SupportMapFragment? =
            supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        googleMap ?: return
        with(googleMap) {
            moveCamera(CameraUpdateFactory.newLatLngZoom(Location, ZOOM_LEVEL))
            addMarker(MarkerOptions().position(Location))
        }
    }
}
