package com.hail.followthreerecom;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.hail.followthreerecom.base.BaseActivity;

import butterknife.BindView;
import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class GradeActivity extends BaseActivity {
    @BindView(R.id.rtb_rating)
    MaterialRatingBar mRtbRating;
    @BindView(R.id.btn_submit)
    Button mBtnSubmit;
    @BindView(R.id.tv_hint)
    TextView mTvHint;
    @Override
    public int getLayoutId() {
        return R.layout.activity_grade;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mRtbRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                if (rating > 0 && rating <= 1) {
                    mTvHint.setText("很差");
                } else if (rating > 1 && rating <= 2) {
                    mTvHint.setText("较差");
                } else if (rating > 2 && rating <= 3) {
                    mTvHint.setText("还行");
                } else if (rating > 3 && rating <= 4) {
                    mTvHint.setText("推荐");
                } else if (rating > 4 && rating <= 5) {
                    mTvHint.setText("力荐");
                }
            }
        });
        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating = mRtbRating.getRating();
                if (rating == 0) {
                    Toast.makeText(GradeActivity.this, "请填写评分", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "提交成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
