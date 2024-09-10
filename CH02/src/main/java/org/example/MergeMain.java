package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MergeMain {

    static EntityManagerFactory enf = Persistence.createEntityManagerFactory("jpa");

    public static void main(String[] args) {
        Member member = createMember("memberA", "회원1", 20);
        System.out.println(member.getUsername());
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
