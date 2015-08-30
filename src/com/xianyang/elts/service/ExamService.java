package com.xianyang.elts.service;

import java.util.List;

import com.xianyang.elts.entity.ExamInfo;
import com.xianyang.elts.entity.QuestionInfo;
import com.xianyang.elts.entity.User;

/** 软件的核心功能: 登录, 开始(发卷), 交卷... */
public interface ExamService {
  User login(int id, String pwd) 
    throws IdOrPwdException;
  
  ExamInfo start();
  
  QuestionInfo getQuestion(int index);
 
  void saveUserAnswers(int index, 
      List<Integer> userAnswers);

  int examOver();

  int getScore();  
}
