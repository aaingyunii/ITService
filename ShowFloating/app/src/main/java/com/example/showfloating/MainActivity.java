package com.example.showfloating;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.showfloating.fragment.FloatingViewControlFragment;

public class MainActivity extends AppCompatActivity{

//    private Animation fab_open, fab_close;
//    private Boolean isFabOpen = false;
//    private FloatingActionButton fab;
//    private Boolean isPopupOpen = false;
//    private static final int ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE = 1;
//    private int numofM = 0;
//    private ArrayList<FloatingActionButton> floatList = new ArrayList();
//    private ArrayList<Integer> layoutlist = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
//        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);

//        fab = (FloatingActionButton) findViewById(R.id.fab);

//        //환경설정을통해서 floatList 내용 정하는 부분 구현(예: facebook 체크, kakao 체크), 메소드 만들어주기
//        //환경설정은 아이콘 꾹누르면 체크할 수 있도록
//        numofM = 3;
//        //최대 플롯버튼수는 정해두기 일단 list로 넣어두고 나중에 동적으로 변경
//        layoutlist.add(R.id.fab1);
//        layoutlist.add(R.id.fab2);
//        layoutlist.add(R.id.fab3);
//
//        for(int i =0;i< numofM; i++){
//            FloatingActionButton bt;
//            floatList.add((FloatingActionButton) findViewById(layoutlist.get(i)));
//            // 이미지랑 이름은 어플에서 가져와야 함.
//        }
//        //클릭 리스너 설정
//        fab.setOnClickListener(this);
//        for(int i =0;i< numofM; i++){
//            floatList.get(i).setOnClickListener(this);
//        }


        // create default notification channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            final String channelId = getString(R.string.default_floatingview_channel_id);
            final String channelName = getString(R.string.default_floatingview_channel_name);
            final NotificationChannel defaultChannel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_MIN);
            final NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            if (manager != null) {
                manager.createNotificationChannel(defaultChannel);
            }
        }

        if (savedInstanceState == null) {
            final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.container, FloatingViewControlFragment.newInstance());
            ft.commit();
        }
    }

//    @Override
//    public void onClick(View v) {
//        int id = v.getId();
//        switch (id) {
//            case R.id.fab:
//                anim();
//                Toast.makeText(this, "Floating Action Button", Toast.LENGTH_SHORT).show();
//                checkPermission();
//                break;
//            case R.id.fab1:
//                showPopup();
//                break;
//            case R.id.fab2:
//                showPopup();
//                break;
//            case R.id.fab3:
//                showPopup();
//                break;
//        }
//    }
//    public void anim() {
//
//        if (isFabOpen) {
//            for(int i=0;i<numofM;i++){
//                floatList.get(i).startAnimation(fab_close);
//                floatList.get(i).setClickable(false);
//            }
//
//            showPopup();
//
//            isFabOpen = false;
//        } else {
//
//            for(int i=0;i<numofM;i++){
//                floatList.get(i).startAnimation(fab_open);
//                floatList.get(i).setClickable(true);
//            }
//
//            isFabOpen = true;
//        }
//    }
//
//    //check permission
//    public void checkPermission(){
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {   // 마시멜로우 이상일 경우
//            if (!Settings.canDrawOverlays(this)) {              // 체크
//                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
//                        Uri.parse("package:" + getPackageName()));
//                startActivityForResult(intent, ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE);
//            }
//        }
//    }
//    //show popup window
//    public void showPopup(){
//        Intent intent = new Intent(MainActivity.this,PopupWindow.class);
//        //intent.putExtra("name",)
//        if(isPopupOpen == false){
//            startService(intent);
//            isPopupOpen = true;
//        }else{
//            stopService(new Intent(MainActivity.this,PopupWindow.class));
//            isPopupOpen = false;
//        }
//
//    }
//
//    @TargetApi(Build.VERSION_CODES.M)
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE) {
//            if (!Settings.canDrawOverlays(this)) {
//                // TODO 동의를 얻지 못했을 경우의 처리
//            }
//            else {
//                startService(new Intent(MainActivity.this, PopupWindow.class));
//            }
//        }
//    }

}

