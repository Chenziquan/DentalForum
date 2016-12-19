package jqchen.dentalforum.data.source.remote;

import java.util.ArrayList;
import java.util.List;

import jqchen.dentalforum.base.SimpleCallBack;
import jqchen.dentalforum.data.bean.CommentBean;
import jqchen.dentalforum.data.bean.PostBean;
import jqchen.dentalforum.data.source.PostDetailDataSource;
import jqchen.dentalforum.util.StringUtil;

/**
 * Created by jqchen on 2016/12/19.
 * Use to
 */
public class RemotePostDetailDataSource implements PostDetailDataSource {
    @Override
    public void getPostDetail(int postId, PostDetailCallBack callBack) {
        PostBean postBean = new PostBean();
        postBean.setUimage("http://img4.imgtn.bdimg.com/it/u=2943284029,4029022735&fm=21&gp=0.jpg");
        postBean.setUname("陈军权");
        postBean.setUgroup("程序猿");
        postBean.setThem("资源帖");
        postBean.setCommentnum("11");
        postBean.setViewnum("22");
        postBean.setTitle("2017年，你的生活将享受这些“十惠”！");
        postBean.setContent("中央经济工作会议12月14日至16日在北京举行。中共中央总书记、国家主席、中央军委主席习近平，中共中央政治局常委、国务院总理李克强，中共中央政治局常委、全国人大常委会委员长张德江，中共中央政治局常委、全国政协主席俞正声，中共中央政治局常委、中央书记处书记刘云山，中共中央政治局常委、中央纪委书记王岐山，中共中央政治局常委、国务院副总理张高丽出席会议。");
        postBean.setTime("2016 12-19 10:26");
        List<String> list = new ArrayList<>();
        list.add("http://desk.fd.zol-img.com.cn/t_s960x600c5/g5/M00/01/0E/ChMkJlbKwaOIN8zJAAs5DadIS-IAALGbQPo5ngACzkl365.jpg");
        list.add("http://image101.360doc.com/DownloadImg/2016/10/2813/83246025_16.jpg");
        list.add("http://desk.fd.zol-img.com.cn/t_s960x600c5/g5/M00/02/03/ChMkJ1bKxpWIIp3vAAimMffVdTgAALHnQMKJY0ACKZJ164.jpg");
        postBean.setPictures(list);
        callBack.onSuccess(postBean);
    }

    @Override
    public void getComment(int postId, int page, int size, PostCommentCallBack commentCallBack) {
        List<CommentBean> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            CommentBean commentBean = new CommentBean();
            commentBean.setuImage("http://v1.qzone.cc/avatar/201503/06/18/27/54f981200879b698.jpg%21200x200.jpg");
            commentBean.setuName("人+" + i);
            commentBean.setuGroup("分组" + i);
            commentBean.setTime("时间" + i);
            commentBean.setContent("民之所望，政之所向。此次会议释放出的一系列政策讯息，直指民生关切。快随中国网一起来了解中央经济工作会议，看看你能从哪些方面感受到稳稳的民生政策实惠吧~" + i);
            List<CommentBean.ReplyBean> replyBeanList = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                CommentBean.ReplyBean replyBean = new CommentBean.ReplyBean();
                replyBean.setuName("回复" + i);
                replyBean.setuId("1");
                replyBean.setpId("0");
                replyBean.setpName("帖子" + i);
                replyBean.setContent("习近平在会上发表重要讲话，分析当前国内国际经济形势，总结2016年经济工作，阐明经济工作指导思想，部署2017年经济工作。李克强在讲话中阐述了明年宏观经济政策取向，对明年经济工作作出具体部署，并作总结讲话" + i);
                replyBeanList.add(replyBean);
            }
            commentBean.setReplyBeen(replyBeanList);
            list.add(commentBean);
        }
        commentCallBack.onGetComment(list);
    }

    @Override
    public void deleteComment(int postId, int commentId, List<CommentBean> list, int postition, SimpleCallBack callBack) {
        list.remove(postition);
        callBack.onSuccess();
    }

    @Override
    public void comment(int postId, String content, List<CommentBean> list, PostReplyCallBack callBack) {
        if (StringUtil.isEmpty(content)) {
            callBack.onContentNull();
            return;
        }
        CommentBean commentBean = new CommentBean();
        commentBean.setuImage("http://v1.qzone.cc/avatar/201503/06/18/27/54f981200879b698.jpg%21200x200.jpg");
        commentBean.setuName("人+");
        commentBean.setuGroup("分组");
        commentBean.setTime("时间");
        commentBean.setContent(content);
        List<CommentBean.ReplyBean> replyBeanList = new ArrayList<>();
        for (int j = 0; j < 4; j++) {
            CommentBean.ReplyBean replyBean = new CommentBean.ReplyBean();
            replyBean.setuName("回复");
            replyBean.setuId("1");
            replyBean.setpId("0");
            replyBean.setpName("帖子");
            replyBean.setContent("习近平在会上发表重要讲话，分析当前国内国际经济形势，总结2016年经济工作，阐明经济工作指导思想，部署2017年经济工作。李克强在讲话中阐述了明年宏观经济政策取向，对明年经济工作作出具体部署，并作总结讲话");
            replyBeanList.add(replyBean);
        }
        commentBean.setReplyBeen(replyBeanList);
        list.add(commentBean);
        callBack.onSuccess();
    }

    @Override
    public void reply(int postId, int commentId, String content, List<CommentBean> list, int position, PostReplyCallBack callBack) {
        if (StringUtil.isEmpty(content)) {
            callBack.onContentNull();
            return;
        }
        CommentBean.ReplyBean replyBean = new CommentBean.ReplyBean();
        replyBean.setuName("回复");
        replyBean.setuId("1");
        replyBean.setpId("0");
        replyBean.setpName("帖子");
        replyBean.setContent(content);
        list.get(position).getReplyBeen().add(replyBean);
        callBack.onSuccess();
    }


    @Override
    public void postLike(int postId, boolean isLike, SimpleCallBack callBack) {
        callBack.onSuccess();
    }
}
