package com.example.prototype;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class
youTubeFragment extends Fragment {

    List<youtubeVideos>myVideos;
    String API_KEY="AIzaSyCbga5PXf_4cCwwqFqMSCbbwepRa7xxzGs";
    String url="https://www.googleapis.com/youtube/v3/search?part=snippet&key=AIzaSyCbga5PXf_4cCwwqFqMSCbbwepRa7xxzGs&maxResults=50";
    String url1="https://www.googleapis.com/youtube/v3/videos?part=statistics&key=AIzaSyCbga5PXf_4cCwwqFqMSCbbwepRa7xxzGs";
    String videoID;
    String playlistid;
    String thumbnail;
    String videoTitle;
    String channelTitle;
    String type;
    View view;

    String vidIDList[]={ "p4dbonJ8BwE",
            "biapcfX2mG4",
            "dP7MlHyuifg",
            "jmUwuwo92vE",
            "nzDxiF8nLM8",
            "gQpltDnGt9E",
            "-cJ8kYA0xCA",
            "1oq7bhC0kK4"


    };
    String vidThumbNailLis[]={"https://i.ytimg.com/vi/p4dbonJ8BwE/hqdefault.jpg",
            "https://i.ytimg.com/vi/biapcfX2mG4/hqdefault.jpg",
            "https://i.ytimg.com/vi/dP7MlHyuifg/hqdefault.jpg",
            "https://i.ytimg.com/vi/jmUwuwo92vE/hqdefault.jpg",
            "https://i.ytimg.com/vi/nzDxiF8nLM8/hqdefault.jpg",
            "https://i.ytimg.com/vi/gQpltDnGt9E/hqdefault.jpg",
            "https://i.ytimg.com/vi/-cJ8kYA0xCA/hqdefault.jpg",
            "https://i.ytimg.com/vi/1oq7bhC0kK4/hqdefault.jpg",

    };
    String videoTitleList[]={"Current Electricity - One JEE Shot Revision|JEE Physics 2020",
            "JEE Mains Physics - Most Important and Easy Topic | Score atleast 60/120 in 1 month",
            "Dont Miss these Topics in JEE Mains Physics|Important Topics for JEE Mains 2020",
            "How to REALLY understand Physics (JEE/NEET) by Kalpit Veerwal",
            "Let Recap Physics - JEE 2021 | Suri Sir | JEE Physics",
            "NEET - JEE Complete Physics 2020 Crash Course",
            "KTG in ONE Shot | NEET, IIT JEE Physics | Shantanu sir | ATP STAR",
            "Revise Thermodynamics in 40 mins by Suri Sir | IIT JEE Physics"

    };
    String videoDescriptionlist[]={
            "JEE Physics | Current Electricity IIT JEE | Physics Current Electricity | JEE Main Physics | Current Electricity Class 12 IIT JEE | current electricity jee mains ...",
            "Instagram Handle :https://www.instagram.com/dhattarwalaman/ Facebook Page : https://www.facebook.com/dhattarwalaman/ Link to my MOM's cooking channel ...",
            "jee mains physics | important topics for jee mains 2020 |",
            "Guys, I have launched a short Crash course for JEE 2020. You can check it here - Guys the course is out now! Check it here ...",
            "Let's Recap Physics - JEE 2021 by Suri Sir to Crack JEE Main 2021 Exam by doing JEE Main Revision (JEE Revision). Learn more about JEE Main Physics (IIT ...",
            "Video का part-2 जरूर देखना जिसमें JEE & NEET का CompletePYQs है Link-https://youtu.be/8e1wyS1p3Og Chemistry Crash Course ...",
            "Download ATP STAR app now ⬇️   https://bit.ly/2kGp9En KTG in 1 Shot | NEET, JEE Physics | Shantanu sir | ATP STAR Our website is ...",
            "Revise Thermodynamics in 40 mins by Suri Sir | Thermodynamics IIT JEE Physics | JEE Main April 2020 | Laws of Thermodynamics | JEE Main Physics ...",

    };
    String videoChannelTitle[]={
            "Vedantu JEE",
            "Aman Dhattarwal",
            "Vedantu Math",
            "Kalpit Veerwal - AcadBoost",
            "Vedantu JEE",
            "Aakash krishna",
            "ATP STAR-JEE & NEET,KOTA",
            "Vedantu JEE",
    };


   String playListIDList[] ={
           "PLbu_fGT0MPsuUzCT6BZvto0hkcA3dEigi",
            "PLLoUziOB0bCSjRh8F8CJBBb51s2BnNwbt",
            "PLbu_fGT0MPstO4NmoeEBTNkYRZ0kPYFIV",
            "PLDrgDtCLUceaVG_nNhdGFfz6ryStEVl8-",
            "PLx2L6yjUEa7tcKjC7DW4cv2A0JpNQGZkj",
            "PLCtUyOrCJbxyVtZwB_2okutCfklqs9bCu",
            "PLleMhc2M61N8yoHKTPH-p9iSjTXmlrlpR",
            "PLk5kuyX3xzdY3sH11naVgw_RBuONQ03bq",
            "PLCtUyOrCJbxwuSNoilTnnpTt46UOmQCto",
            "PLCtUyOrCJbxyQGLeTILKCVsvgbHbEy8TQ",
            "PLCtUyOrCJbxzHYw13MJ9UfbKLHna7tb6g",
            "PL7rZUH8srnuMdHcuH1DEb7D19cpvBT00G"

    };
    String playListThumbNailList[]={"https://i.ytimg.com/vi/Ewx1bo3Vyzg/hqdefault.jpg",
            "https://i.ytimg.com/vi/FYE0YYuAyu0/hqdefault.jpg",
            "https://i.ytimg.com/vi/tFzuhoElDi4/hqdefault.jpg",
            "https://i.ytimg.com/vi/RKI4NYJd6Yc/hqdefault.jpg",
            "https://i.ytimg.com/vi/HCX6iduaNmM/hqdefault.jpg",
            "https://i.ytimg.com/vi/0VnBwN0erP0/hqdefault.jpg",
            "https://i.ytimg.com/vi/ZgqH47_kBQE/hqdefault.jpg",
            "https://i.ytimg.com/vi/N_QBqu28T9k/hqdefault.jpg",
            "https://i.ytimg.com/vi/Ng8s_dp-5hE/hqdefault.jpg",
            "https://i.ytimg.com/vi/RAa05vZh-AI/hqdefault.jpg",
            "https://i.ytimg.com/vi/HyNFGGzb4T4/hqdefault.jpg",
            "https://i.ytimg.com/vi/yPyfzKRoHEU/hqdefault.jpg",

    };
    String playListTitleList[]={"Physics - Class 11 |IIT JEE | Unacademy JEE",
            "JEE MAINS Crash Course 2020 - Physics",
            "Physics | Important Topics | JEE Mains 2020 | Jayant Nagda",
            "JEE MAIN 2020 Crash Course - Physics",
            "IIT JEE Physics by SSI sir,B.Tech.IIT Delhi,Ex. Resonance faculty Kota|NEET Physics",
            "Mechanics Sprint 2020 | JEE Main Physics | Anand Sir | JEE Mains 2020",
            "Jee physics Complete playlist",
            "Crash Course/Quick revision for JEE Main",
            "Physics Revision | JEE Sprint 2.0",
            "Electrostatics -Playlist|Class 12|JEE Physics 2020|Suri Sir",
            "JEE Physics (JEE Main Physics) - Playlist | Suri Sir|JEE Main 2020",
            "One shot Revision | IIT JEE NEET Physics playlist | ATP STAR | Shantanu Singh sir",

    };
    String playListVideoDescriptionList[]={"Class 11th Physics Complete playlist by Unacademy",
            "Jee mains 2020 crash course by doubtnut",
            "Physics Important topics by Jayant nagda Unacademy",
            "Jee main 2020 full playlist by Motion education",
            "A Physics guru and an IITian from IIT Delhi is ranked among the best faculties of Physics in KOTA not only because of his immense teaching experience and vast ...",
            "Mechanics Physics Sprint 2020 | JEE Physics | JEE Main Physics | Vedantu JEE | JEE Main 2020.",
            "Jee physics full playlist Prashant kumar",
            "Revision lectures in Hindi along with numerous solved problems.Very helpful for NEET/JEE Main aspirants. Please slowdown the playback speed if you find it ...",
            "Physics Jee Revision by vedantu",
            "Electrostatics IIT JEE Class 12 | JEE Main 2021 | JEEt Lo 2021 | JEE Physics | Vedantu JEE by your favorite Suri Sir, that will entirely change your perception ...",
            "A must-watch Playlist - JEE Physics | JEE Main Physics | JEE Sprint 2020 | JEE 2020 | IIT JEE | JEE Live | Vedantu JEE by Suri Sir, that will entirely change your ...",
            "Revision  IIT JEE NEET Physics playlist by Shantanu Singh sir"

    };


    String playlistChannelTitle[]={"Unacademy JEE","Doubtnut","Unacademy JEE","Motion Education Pvt. Ltd.","Nucleon Kota",
            "Vedantu JEE",
            "PRASHANT KUMAR",
            "JEE NEET Physics Kota",
            "Vedantu JEE",
            "Vedantu JEE",
            "Vedantu JEE",
            "ATP STAR-JEE & NEET,KOTA"

    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myVideos=new ArrayList<>();
        String keyword="Jee%20Physics";
        url=url+"&q="+keyword;



        view=inflater.inflate(R.layout.youtube_fragment,container,false);




//        RequestQueue requestQueue= Volley.newRequestQueue(view.getContext());
//        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
//                    JSONObject jsonObject=new JSONObject(response);
//                    JSONArray jsonArray=jsonObject.getJSONArray("items");
//                    for(int i=0;i<jsonArray.length();i++)
//                    {
//                        JSONObject itemParse=jsonArray.getJSONObject(i);
//                        JSONObject idObject=itemParse.getJSONObject("id");
//                        JSONObject snippetObject=itemParse.getJSONObject("snippet");
//                        JSONObject thumbnailObject=snippetObject.getJSONObject("thumbnails").getJSONObject("high");
//
//                      //  Log.i("TYPEEEEE",idObject.getString("kind"));
//
//                        if(idObject.getString("kind").equals("youtube#video"))
//                        {
//                            videoID=idObject.getString("videoId");
//                            thumbnail=thumbnailObject.getString("url");
//                            videoTitle=snippetObject.getString("title");
//                            channelTitle=snippetObject.getString("channelTitle");
//                            // youtubeVideosHelperClassList.add(new YoutubeVideosHelperClass(videoID,thumbnail,videoTitle,channelTitle));
////                            myVideos.add(new youtubeVideos(videoTitle,100000,R.drawable.engineering));
//
//                         //   myVideos.add(new youtubeVideos(videoTitle,100000,thumbnail,videoID,"video"));
//
//                           // Log.i("Video Information",videoID+"\n"+thumbnail+"\n"+videoTitle+"\n"+channelTitle+"\n");
//                        }
//                        else if(idObject.getString("kind").equals("youtube#playlist"))
//                        {
//                            playlistid=idObject.getString("playlistId");
//
//                            thumbnail=thumbnailObject.getString("url");
//                            videoTitle=snippetObject.getString("title");
//                            channelTitle=snippetObject.getString("channelTitle");
//                            //  youtubeVideosHelperClassList.add(new YoutubeVideosHelperClass(playlistid,thumbnail,videoTitle,channelTitle));
//
//                           // myVideos.add(new youtubeVideos(videoTitle,100000,thumbnail,playlistid,"playlist"));
//                            Log.i("Playlist Information",playlistid+"\n"+thumbnail+"\n"+videoTitle+"\n"+channelTitle+"\n");
//                        }
//
//
//
//                        Log.i("Youtube Information",videoID+"\n"+playlistid+"\n"+thumbnail+"\n"+videoTitle+"\n"+channelTitle+"\n");
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        requestQueue.add(stringRequest);
//
//        / myVideos.add(new youtubeVideos("Video1",100000,"https://i.ytimg.com/vi/gQpltDnGt9E/0.jpg","PLMC9KNkIncKtPzgY-5rmhvj7fax8fdxoj","playlist"));
//  //      myVideos.add(new youtubeVideos("Video2",100000,"https://i.ytimg.com/vi/_UBgzYnSJpQ/0.jpg","gQpltDnGt9E","video"));
////        myVideos.add(new youtubeVideos("Video2",200000,R.drawable.medicine,));
////        myVideos.add(new youtubeVideos("Video3",300000,R.drawable.architecture));
////        myVideos.add(new youtubeVideos("Video4",400000,R.drawable.ca_cpt));
////        myVideos.add(new youtubeVideos("Video5",500000,R.drawable.law));
////        myVideos.add(new youtubeVideos("Video6",600000,R.drawable.nda));
//
        for(int i=0;i<playListIDList.length;i++)
        {
            myVideos.add(new youtubeVideos(playListTitleList[i],playlistChannelTitle[i],playListThumbNailList[i],playListIDList[i],"playlist",playListVideoDescriptionList[i]));
        }

        for(int i=0;i<vidIDList.length;i++)
        {
            myVideos.add(new youtubeVideos(videoTitleList[i],videoChannelTitle[i],vidThumbNailLis[i],vidIDList[i],"video",videoDescriptionlist[i]));
        }


        RecyclerView recyclerView1=(RecyclerView)view.findViewById(R.id.YouTubeRecycler);
        RecyclerYoutubeAdapter recyclerYoutubeAdapter=new RecyclerYoutubeAdapter(myVideos);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView1.setAdapter(recyclerYoutubeAdapter);






        return view;
    }


}
