package com.example.pdfviewerfromasset

import android.graphics.Canvas
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_p_d_f__viewer.*
import java.io.File

class PDF_Viewer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p_d_f__viewer)

        if(intent != null)
        {
            val viewType = intent.getStringExtra("ViewType")

            if(!TextUtils.isEmpty(viewType) ||viewType != null)
            {
                if(viewType == "assets")
                {
                    PDF_View.fromAsset("GEU Back Paper.pdf")
                        .password(null)
                        .defaultPage(0)
                        .enableSwipe(true)
                        .swipeHorizontal(false)
                        .enableDoubletap(true)
                        .onDraw{canvas, pageWidth, pageHeight, displayedPage ->
                        //draw code
                        }.onDrawAll{canvas, pageWidth, pageHeight, displayedPage ->
                            //draw code
                        }
                        .onPageChange{page, pageCount ->  

                        }.onPageError{
                            page, t ->
                            Toast.makeText(this, "Error$page",Toast.LENGTH_LONG).show()
                            Log.d("ERROR",""+t.localizedMessage);
                        }
                        .onTap{false}
                        .onRender{
                            nbPages, pageWidth, pageHeight ->
                            PDF_View.fitToWidth()
                        }
                        .enableAnnotationRendering(true)
                        .invalidPageColor(Color.RED)
                        .load()

                }

            }
        }
    }
}