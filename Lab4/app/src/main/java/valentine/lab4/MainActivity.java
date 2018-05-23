package valentine.lab4;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoPlayer;
    MediaPlayer audioPlayer;
    RadioGroup group;
    int choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        choice = 0;

        videoPlayer = (VideoView) findViewById(R.id.videoPlayer);
        group = (RadioGroup) findViewById(R.id.group);

        audioPlayer = MediaPlayer.create(this, R.raw.storm);

        Uri myVideoUri= Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.kiev);
        videoPlayer.setVideoURI(myVideoUri);
        videoPlayer.setVisibility(View.GONE);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged (RadioGroup group, int checkedId) {
                if (checkedId == R.id.audio) {
                    choice = 0;
                    videoPlayer.stopPlayback();
                    videoPlayer.resume();
                    videoPlayer.setVisibility(View.GONE);
                } else if (checkedId == R.id.video) {
                    choice = 1;
                    audioPlayer.stop();
                    try {
                        audioPlayer.prepare();
                        audioPlayer.seekTo(0);
                    }
                    catch (Throwable t) {
                    }
                    videoPlayer.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void play(View view) {
        if(choice == 1) {
            videoPlayer.start();
        }
        else {
            audioPlayer.start();
        }
    }

    public void pause(View view) {
        if(choice == 1) {
            videoPlayer.pause();
        }
        else {
            audioPlayer.pause();
        }
    }

    public void stop(View view) {
        if(choice == 1) {
            videoPlayer.stopPlayback();
            videoPlayer.resume();
        }
        else {
            audioPlayer.stop();
            try {
                audioPlayer.prepare();
                audioPlayer.seekTo(0);
            }
            catch (Throwable t) {
            }
        }
    }
}

