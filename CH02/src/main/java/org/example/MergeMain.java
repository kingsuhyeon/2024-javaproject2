package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MergeMain {

    static EntityManagerFactory enf = Persistence.createEntityManagerFactory("jpa");

    public static void main(String[] args) {
        Member member = createMember("memberC", "회원2", 30);
        System.out.println(member.getUsername());
        //준영속
        member.setUsername("memberB");

        mergeMember(member);
    }

    static void mergeMember(Member member) {
        EntityManager em = enf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // member는 준영속상태

        Member mergeMember = em.merge(member);
        tx.commit();

        System.out.println("member = "+member.getUsername());
        System.out.println("mergeMember = "+mergeMember.getUsername());
    }

    static Member createMember(String id, String username, Integer age) {

        EntityManager em = enf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Member member = new Member();
        member.setId(id);
        member.setUsername(username);
        member.setAge(age);

        em.persist(member);

        tx.commit();

        em.close();
        return member;
    }
}
