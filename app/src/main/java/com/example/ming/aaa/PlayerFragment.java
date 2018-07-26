package com.example.ming.aaa;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.pkmmte.view.CircularImageView;

/**
 * Created by caobotao on 16/1/4.
 */
public class PlayerFragment extends Fragment {

    private ImageView mPlayerImageview;
    private ImageView mPreviousImageview;
    private ImageView mNextImageview;
    private static final int PLAY = 1;// 定义播放状态
    private static final int PAUSE = 2;// 暂停状态
    private static final int NEXT = 3;// 定义播放状态
    private static final int PREVIOUS = 4;// 暂停状态
    private static final int STATE_PLAY = 1;// 播放状态设为1
    private static final int STATE_PAUSE = 2;// 播放状态设为2
    private int flag;// 标记
    private MediaPlayer mediaPlayer1;
    private SeekBar seek_bar;
    private TextView tv_total;
    private TextView tv_current;
    private Handler mHandler;

    // 当前播放的歌曲的索引
    private int currentMusicIndex;
    private int mPosition;//记录音频文件播放的位置


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1, container, false);

        CircularImageView circularImageView=(CircularImageView)view.findViewById(R.id.image);
        ImageView image=(ImageView)view.findViewById(R.id.programPlayHeaderBg);
        Bitmap bm= BitmapFactory.decodeResource(getResources(), R.mipmap.developer_fat);
        circularImageView.setImageBitmap(bm);
        image.setImageBitmap(bm);


        tv_total=(TextView)view.findViewById(R.id.programPlayEndTime);
        tv_current=(TextView)view.findViewById(R.id.programPlayCutTime);

        mPlayerImageview = (ImageView) view.findViewById(R.id.programPlayStart);
        flag=STATE_PAUSE;
        mPlayerImageview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (flag) {
                    case STATE_PLAY:
                        flag =STATE_PAUSE;
                        pause();
                        break;

                    case STATE_PAUSE:
                        flag =STATE_PLAY;
                        play();
                        break;
                }
            }
        });

        mPreviousImageview = (ImageView)view. findViewById(R.id.programPlayPrevious);
        mPreviousImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous();
            }
        });

        mNextImageview = (ImageView)view. findViewById(R.id.programPlayNext);
        mNextImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });

   //滚动条监听
        seek_bar=(SeekBar)view.findViewById(R.id.programPlayProgressBar);
        seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    if (fromUser){
                        tv_total.setText(progress+"%");
                          mediaPlayer1.seekTo(progress * 1000);
                    }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        return view;
    }
    /**
     * 播放音乐
     */
    public void play() {
        mPlayerImageview.setImageResource(R.mipmap.program_play_pause);
//        Intent intent = new Intent();
//        intent.setAction("com.app.media.MUSIC_SERVICE");
//        intent.putExtra("op", PLAY);// 向服务传递数据
//        startService(intent);
        mediaPlayer1 = MediaPlayer.create(getActivity(), R.raw.syst);
        mediaPlayer1.start();

        CircularImageView circularImageView=(CircularImageView)getView().findViewById(R.id.image);
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.img_animation);
        if (animation != null) {
            LinearInterpolator lin = new LinearInterpolator();//设置动画匀速运动
            animation.setInterpolator(lin);
            circularImageView.startAnimation(animation);
        }

    }

    /**
     * 暂停播放音乐
     */
    public void pause() {
        mPlayerImageview.setImageResource(R.mipmap.program_play_start);
//        Intent intent = new Intent();
//        intent.setAction("com.app.media.MUSIC_SERVICE");
//        intent.putExtra("op", PAUSE);
//        startService(intent);
//        mediaPlayer1.pause();
        mPosition = mediaPlayer1.getCurrentPosition();
        mediaPlayer1.pause();
        mediaPlayer1.seekTo(mPosition);
        CircularImageView circularImageView=(CircularImageView)getView().findViewById(R.id.image);
        circularImageView.clearAnimation();
    }
    /**
     *下一首
     */
    public void next() {
//        Intent intent = new Intent();
//        intent.setAction("com.app.media.MUSIC_SERVICE");
//        intent.putExtra("op",NEXT );
//        startService(intent);
//            currentMusicIndex++;
//            if (currentMusicIndex >= musics.size()) {
//                Toast.makeText(MainActivity.this, "已经是最后一首了", Toast.LENGTH_SHORT).show();
//                return;
//            } else {
//                pausePosition = 0;
//                play();
//            }
//        }

    }

    /**
     *上一首
     */
    public void previous() {
//        Intent intent = new Intent();
//        intent.setAction("com.app.media.MUSIC_SERVICE");
//        intent.putExtra("op",PREVIOUS );
//        startService(intent);
        //判断是否为第一首歌曲，若为第一首歌曲，则播放最后一首
//        if (rbtnPlaySingle.isChecked()) {
//            single();
//        } else {
//            //当前音乐播放位置--（上一曲）
//            currentMusicIndex--;
//            if (currentMusicIndex <= 0) {
//                Toast.makeText(MainActivity.this, "已经是第一首了", Toast.LENGTH_SHORT).show();
//                return;
//            } else {
//
//                //音乐进度置为0
//                pausePosition = 0;
//                //播放
//                play();
//            }
//        }

    }
}
