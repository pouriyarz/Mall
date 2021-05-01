package com.texonapp.mall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;

import android.os.Bundle;
import android.view.View;

import com.texonapp.mall.databinding.ActivityMainBinding;
import com.texonapp.mall.main.AuctionFragment;
import com.texonapp.mall.main.CenterFragment;
import com.texonapp.mall.main.ConsignmentFragment;
import com.texonapp.mall.main.MallFragment;
import com.texonapp.mall.main.PanelFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//        navController = Navigation.findNavController(MainActivity.this , R.id.user_main_fragment);

        setFrag(MallFragment.newInstance());

        setupBottomNavigationView();

    }

    private void setupBottomNavigationView() {
        binding.navMall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFrag(MallFragment.newInstance());
                binding.mallImg.setImageResource(R.drawable.ic_orange_mall);
                binding.consImg.setImageResource(R.drawable.ic_consignment);
                binding.navCenterImg.setImageResource(R.drawable.ic_center);
                binding.auctionImg.setImageResource(R.drawable.ic_auction);
                binding.panelImg.setImageResource(R.drawable.ic_panel);
            }
        });

        binding.navConsignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFrag(ConsignmentFragment.newInstance());
                binding.mallImg.setImageResource(R.drawable.ic_mall);
                binding.consImg.setImageResource(R.drawable.ic_orange_consignment);
                binding.navCenterImg.setImageResource(R.drawable.ic_center);
                binding.auctionImg.setImageResource(R.drawable.ic_auction);
                binding.panelImg.setImageResource(R.drawable.ic_panel);
            }
        });

        binding.navCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFrag(CenterFragment.newInstance());
                binding.mallImg.setImageResource(R.drawable.ic_mall);
                binding.consImg.setImageResource(R.drawable.ic_consignment);
                binding.navCenterImg.setImageResource(R.drawable.ic_orange_center);
                binding.auctionImg.setImageResource(R.drawable.ic_auction);
                binding.panelImg.setImageResource(R.drawable.ic_panel);
            }
        });

        binding.navAuction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFrag(AuctionFragment.newInstance());
                binding.mallImg.setImageResource(R.drawable.ic_mall);
                binding.consImg.setImageResource(R.drawable.ic_consignment);
                binding.navCenterImg.setImageResource(R.drawable.ic_center);
                binding.auctionImg.setImageResource(R.drawable.ic_orange_auction);
                binding.panelImg.setImageResource(R.drawable.ic_panel);
            }
        });

        binding.navPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFrag(PanelFragment.newInstance());
                binding.mallImg.setImageResource(R.drawable.ic_mall);
                binding.consImg.setImageResource(R.drawable.ic_consignment);
                binding.navCenterImg.setImageResource(R.drawable.ic_center);
                binding.auctionImg.setImageResource(R.drawable.ic_auction);
                binding.panelImg.setImageResource(R.drawable.ic_orange_panel);
            }
        });
    }

    public void setFrag(Fragment selectedFragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_content, selectedFragment);
        transaction.setCustomAnimations(R.anim.slide_left_in, R.anim.slide_right_out);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.nav_center:

                break;
            case R.id.nav_auction:

                break;
            case R.id.nav_panel:
                break;
        }
    }
}