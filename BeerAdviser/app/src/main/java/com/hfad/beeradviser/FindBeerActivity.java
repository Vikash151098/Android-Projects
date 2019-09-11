package com.hfad.beeradviser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends AppCompatActivity {
     BeerExpert expert=new BeerExpert();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }
    public void onClickFindBeer(View view)
    {
        TextView brands=(TextView)findViewById(R.id.brands);
        brands.setText("Gottle of geer");
        Spinner color=(Spinner)findViewById(R.id.color);
        String beertype=String.valueOf(color.getSelectedItem());
        brands.setText(beertype);

        List<String> brandslist=expert.getBrands(beertype);
        StringBuilder brandsformatted=new StringBuilder();
        for (String brand:brandslist)
        {
            brandsformatted.append(brand).append('\n');
            // display the beer
            brands.setText(brandsformatted);
        }
    }
}
