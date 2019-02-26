package com.xeathen.windchimeweather.view.activity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.xeathen.windchimeweather.R;
import com.xeathen.windchimeweather.bean.model.City;

import org.litepal.LitePal;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import interfaces.heweather.com.interfacesmodule.view.HeConfig;


public class MainActivity extends BaseActivity {

    @BindView(R.id.text_test)
    TextView textTest;

    @BindView(R.id.bt_to_search)
    Button toSearch;

//    @BindView(R.id.spn_cities_list)
//    Spinner citiesListSpn;

    @BindView(R.id.card_button)
    Button cardButton;

    private ArrayAdapter citiesListAdapter;

    public List<City> cityList;

    public List<String> cityNameList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        HeConfig.init("HE1807241619061769", "d8d9b6e2afde458e90d135b1bdf4e767"); //init,全局处理一次即可
        HeConfig.switchToFreeServerNode(); //切换至免费节点
        LitePal.getDatabase();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String currentCityId = prefs.getString("current_city_id", null);
//        LogUtil.i(TAG, currentCityId);
        if (currentCityId != null){
//            List<CityDB> cityDBS = LitePal.findAll(CityDB.class);
//            cityList = new ArrayList<>();
//            cityNameList = new ArrayList<>();
//            for (CityDB cityDB : cityDBS) {
//                City city = new City(cityDB.getName(), cityDB.getCityId(), cityDB.getAdminArea(), cityDB.getCountry());
//                cityList.add(city);
//                cityNameList.add(cityDB.getName());
//                //spinner设置默认选择
//                //记得改变spinner大小
////                LogUtil.i(TAG, cityDB.getName() + ", "+ cityDB.getCityId() + ","+cityDBS.size());
//            }
//            LogUtil.i(TAG, "current:" + currentCityId);
//            initCitiesListAdapter();
            Intent intent = new Intent(this, WeatherActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);


        }else{
            Intent intent = new Intent(this, SearchActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }




    }

    @OnClick(R.id.bt_to_search)
    public void toSearch() {
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        startActivity(intent);

    }

    @OnClick(R.id.card_button)
    public void toCard(){
        Intent intent = new Intent(this, CityActivity.class);
        startActivity(intent);
    }



    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }


}