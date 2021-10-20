package hello.servlet.domain.web.frontcontroller.v2.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.domain.web.frontcontroller.MyView;
import hello.servlet.domain.web.frontcontroller.v2.ControllerV2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Member member = new Member(request.getParameter("username"), Integer.parseInt(request.getParameter("age")));
        request.setAttribute("member", member);
        memberRepository.save(member);

        return new MyView("/WEB-INF/views/save.jsp");

    }
}
